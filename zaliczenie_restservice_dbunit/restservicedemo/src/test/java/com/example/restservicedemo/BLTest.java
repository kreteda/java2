package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Chair;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.ChairManager;
import com.example.restservicedemo.service.PersonManager;

public class BLTest {
	private static Person p1;
	private static Person p2;
	private static Person p3;
	private static Chair c1;
	private static Chair c2;
	private static Chair c3;
	
	 ChairManager cm = new ChairManager();
	 PersonManager pm = new PersonManager();
	@BeforeClass
	public static void setUp() {
		p1 = new Person("Kowalski", 1980);
		p2 = new Person("Nowak", 1985);
		p3 = new Person("Kowal", 1950);
		c1 = new Chair("Nowyjork", 1999);
		c2 = new Chair("Metaloo", 2016);
		c3 = new Chair("PanTadeusz", 2010);	
	}
	@Before
	@After
	public void cleanTables() {
		cm.clearChairs();
		pm.clearPersons();
	}
	@Test
	public void addPerson() {
		assertEquals(1, pm.addPerson(p1));
		
	}	
	@Test
	public void getAllPersons() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);

		List<Person> persons = new ArrayList<>();

		persons = pm.getAllPersons();

		assertEquals(3, persons.size());
		assertNotEquals(persons.get(0), persons.get(1));
		assertNotEquals(persons.get(1), persons.get(2));

		assertEquals(p1.getFirstName(), persons.get(0).getFirstName());
		assertEquals(p2.getFirstName(), persons.get(1).getFirstName());
		assertEquals(p3.getFirstName(), persons.get(2).getFirstName());
	}
	@Test
	public void getPersonByFirstName() {
		pm.addPerson(p1);
		Person answer = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer.hasId());
		assertEquals(p1.getFirstName(), answer.getFirstName());
		assertEquals(p1.getYob(), answer.getYob());
	}
	@Test
	public void getPersonById() {
		pm.addPerson(p1);
		Person answer2 = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer2.hasId());

		Person answer = pm.getPerson(answer2.getId());

		assertEquals(p1.getFirstName(), answer.getFirstName());
		assertEquals(p1.getYob(), answer.getYob());
	}	
	@Test
	public void deletePerson() {
		pm.addPerson(p1);
		Person answer2 = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer2.hasId());

		Person answer = pm.getPerson(answer2.getId());

		List<Person> persons;
		persons = pm.getAllPersons();
		assertEquals(1, persons.size());

		pm.removePerson(answer.getId());
		persons = pm.getAllPersons();
		assertEquals(0, persons.size());

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		persons = pm.getAllPersons();
		assertEquals(3, persons.size());

		answer = pm.getPersonFromFirstName(p1.getFirstName());
		pm.removePerson(answer.getId());
		persons = pm.getAllPersons();
		assertEquals(2, persons.size());
	}
	@Test
	public void addChair() {
		assertEquals(1, cm.addChair(c1));
	}

	@Test
	public void getAllChairs() {

		cm.addChair(c1);
		cm.addChair(c2);
		cm.addChair(c3);

		List<Chair> chairs;

		chairs = cm.getAllChairs();

		assertEquals(3, chairs.size());
		assertNotEquals(chairs.get(0), chairs.get(1));
		assertNotEquals(chairs.get(1), chairs.get(2));

		assertEquals(c1.getModel(), chairs.get(0).getModel());
		assertEquals(c2.getModel(), chairs.get(1).getModel());
		assertEquals(c3.getModel(), chairs.get(2).getModel());
	}
	@Test
	public void getPersonsWithChairs() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		cm.addChair(c1);
		cm.addChair(c2);

		
		List<Person> persons = pm.getAllPersons();

		List<Chair> chairs = cm.getAllChairs();
		
		assertEquals(1, cm.sellChair(chairs.get(0), persons.get(0)));

		Chair answer2 = cm.getChairWithOwner(chairs.get(0));
		
		
		cm.sellChair(chairs.get(0), persons.get(0));
		cm.sellChair(chairs.get(1), persons.get(1));
		
		//assertEquals(1, cm.sellChair(chairs.get(0), persons.get(0)));
		//assertEquals(1, cm.sellChair(chairs.get(1), persons.get(1)));

		Map<Person, List<Chair>> answer = pm.getPersonWithChair();

		assertTrue(answer.size() == 2);
	}	
	
	@Test
	public void sellChairAndGetChairWithOwner() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		cm.addChair(c1);
		cm.addChair(c2);

		List<Person> persons = pm.getAllPersons();
		assertEquals(true, persons.get(0).hasId());
		assertEquals(true, persons.get(1).hasId());
		assertEquals(true, persons.get(2).hasId());

		List<Chair> chairs = cm.getAllChairs();
		assertEquals(true, chairs.get(0).hasId());
		assertEquals(true, chairs.get(1).hasId());


		assertEquals(1, cm.sellChair(chairs.get(0), persons.get(0)));

		Chair answer = cm.getChairWithOwner(chairs.get(0));

		assertEquals(persons.get(0).getFirstName(), answer.getOwner().getFirstName());
		assertEquals(persons.get(0).getYob(), answer.getOwner().getYob());

	}	

}
