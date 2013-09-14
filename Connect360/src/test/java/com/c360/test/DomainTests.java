package com.c360.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.c360.api.domain.contract.Contract;
import com.c360.api.domain.contract.ContractComponent;
import com.c360.api.domain.contract.ContractParty;
import com.c360.api.domain.event.Accumulator;
import com.c360.api.domain.location.ContactPoint;
import com.c360.api.domain.location.PhysicalAddress;
import com.c360.api.domain.party.Group;
import com.c360.api.domain.party.GroupMember;
import com.c360.api.domain.party.Organization;
import com.c360.api.domain.party.PartyRelationship;
import com.c360.api.domain.party.Person;
import com.c360.api.repository.ContractRepository;
import com.c360.api.repository.PartyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test-context.xml" })
@Transactional
public class DomainTests {

	@Autowired
	Neo4jOperations template;
	@Autowired
	PartyRepository partyRepository;
	@Autowired
	ContractRepository contractRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addPerson() {
		Person p1 = createPerson("John", "E", "Walsh", "M", "023212134");
		Person p2 = createPerson("Andrea", "M", "Walsh", "M", "242432137");
		
		template.save(p1);	
		template.save(p2);	
		
		PartyRelationship pr1 = new PartyRelationship(p1, p2, "SPOUSE");
		template.save(pr1);
		
		PartyRelationship pr2 = new PartyRelationship(p2, p1, "SPOUSE");
		template.save(pr2);
	
		addGroup();
	}

	private Person createPerson(String firstName, String middleName, String lastName, String gender, String ssn) {
		Person p = new Person();
		p.setPartyId( genUID() );
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setGender(gender);
		p.setSsn(ssn);
		return p;
	}
	
	private String genUID(){
		return new java.rmi.server.UID().toString();
	}
	
	@Test 
	public void addOrganization() {
		Organization o = new Organization();
		o.setPartyId( genUID() );
		o.setName("HealthNow");
		o.setTaxId("42423234");
		
		o = template.save(o);		
		
		assertTrue( null != o.getId() );
		
		PhysicalAddress pa = new PhysicalAddress();
		pa.setLine1("257 W Genesee St");
		pa.setCity("Buffalo");
		pa.setPostalCode("14202");
		pa.setState("NY");
		
		pa = template.save(pa);
		
		ContactPoint cp1 = new ContactPoint(o, pa, "MAILING");
		ContactPoint cp2 = new ContactPoint(o, pa, "LEGAL");
		
		template.save(cp1);
		template.save(cp2);
	}
	
	@Test
	public void addEmployment() {
		Organization o = partyRepository.findByTaxID("42423234");
		Person p = partyRepository.findBySSN("023212134");
		
		PartyRelationship pr1 = new PartyRelationship(o, p, "EMPLOYER");
		template.save(pr1);	
		
		PartyRelationship pr2 = new PartyRelationship(p, o, "EMPLOYEE");
		template.save(pr2);
	}
	
	@Test
	public void addPolicy() {
		
		Contract c = new Contract("Policy");
		c.setContractId("C12314432");
		c.setStartDate(new Date(System.currentTimeMillis()));
		
		ContractComponent cc1 = new ContractComponent(c, "Medical Coverage");
		ContractComponent cc2 = new ContractComponent(c, "Dental Coverage");
		ContractComponent cc3 = new ContractComponent(c, "Vision Coverage");
		ContractComponent cc4 = new ContractComponent(c, "Drug Coverage");
		ContractComponent cc5 = new ContractComponent(c, "Health Savings Account");
		
		c.getComponents().add(cc1);
		c.getComponents().add(cc2);
		c.getComponents().add(cc3);
		c.getComponents().add(cc4);
		c.getComponents().add(cc5);
		
		template.save(c);	
	}
	
	@Test
	public void addPolicyParties() {

		Contract c = contractRepository.findByContractId( "C12314432" );		
		Organization o = partyRepository.findByTaxID("42423234");
		Person p1 = partyRepository.findBySSN("023212134");
		Person p2 = partyRepository.findBySSN("242432137");
		
		ContractParty cp1 = new ContractParty(o, c, "POLICY ADMINISTRATOR");
		cp1.setStartDate(new Date(System.currentTimeMillis()));
		template.save(cp1);
		
		ContractParty cp2 = new ContractParty(p1, c, "POLICY HOLDER");
		cp2.setStartDate(new Date(System.currentTimeMillis()));
		template.save(cp2);				
		
		ContractParty cp3 = new ContractParty(p2, c, "POLICY MEMBER");
		cp3.setStartDate(new Date(System.currentTimeMillis()));
		template.save(cp3);
		
		Accumulator a1 = new Accumulator("Family Max OOP", p1, c, null,  new Double(8000.00) );
		Accumulator a2 = new Accumulator("Individual Max OOP", p1, c, null,  new Double(5000.00) );
		Accumulator a3 = new Accumulator("Individual Max OOP", p2, c, null,  new Double(5000.00) );
		
		template.save(a1);
		template.save(a2);
		template.save(a3);
		
		System.out.println("Contract " + c.getContractId() + " has " + c.getComponents().size() + " components");			
		
		for (ContractComponent cc : c.getComponents()) {
			System.out.println(cc.toString());
			if(cc.getComponentType().equals("Medical Coverage")){
				
				Accumulator a4 = new Accumulator("Family Medical Deductible", p1, c, cc,  new Double(1500.00) );
				Accumulator a5= new Accumulator("Individual Medical Deductible", p2, c, cc,  new Double(500.00) );
				
				template.save(a4);
				template.save(a5);
			}
		}		
	}

	public void addGroup() {
		Person p1 = partyRepository.findBySSN("023212134");
		Person p2 = partyRepository.findBySSN("242432137");
		
		Group g = new Group();
		g.setType("FAMILY");
		g.setStartDate(new Date(System.currentTimeMillis()));
		
		g = template.save(g);
		
		GroupMember gm1 = new GroupMember();
		gm1.setGroup(g);
		gm1.setParty(p1);
		gm1.setType("PARENT");
		
		GroupMember gm2 = new GroupMember();
		gm2.setGroup(g);
		gm2.setParty(p2);
		gm2.setType("PARENT");
		
		template.save(gm1);
		template.save(gm2);
	}
	

}
