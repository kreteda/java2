package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Person;

public class PersonManagerTest {
	
	
	PersonManager personManager = new PersonManager();
	
	private final static String NAME_1 = "Zenek";
	private final static int YOB_1 = 1945;
	
	private final static String NAME_2 = "Zdzich";
	private final static int YOB_2 = 1939;
	
	@Test
	public void checkConnection(){
		assertNotNull(personManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Person person = new Person(NAME_1, YOB_1);
		
		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));
		
		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);
		
		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());
		
	}
	
	@Test
	public void checkUpdate(){
		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		personRetrieved.setName(NAME_2);
		personRetrieved.setYob(YOB_2);


		assertEquals(1, personManager.updatePerson(personRetrieved));

		List<Person> per = personManager.getAllPersons();
		Person personRetrieved2 = per.get(0);

		assertEquals(NAME_2, personRetrieved2.getName());
		assertEquals(YOB_2, personRetrieved2.getYob());
	}
	
	@Test
	public void checkDelete() {
		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(1, personManager.deletePerson(personRetrieved));

	}
	
	@Test
	public void checkGetAllPersons() {
		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

	}

}
