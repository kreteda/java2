package com.rhrycikowski.wejsciowka;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rhrycikowski.wejsciowka.Table;
import com.rhrycikowski.wejsciowka.TableManager;

public class TableManagerTest {
	TableManager tableManager = new TableManager();
	private final static String PRODUCENT = "Agata Meble";
	private final static String PRODUCENT2 = "BRW";
	private final static String NAZWA = "super stolik";
	private final static String NAZWA2 = "Niezwykly stół";
	private final static int CENA = 1001;
	private final static int CENA2 = 350;

	@Test
	public void testAdd() {
		Table table = new Table(PRODUCENT, NAZWA, CENA);

		tableManager.addTable(table);

		assertEquals(1, tableManager.tables.size());
		assertEquals(table, tableManager.tables.get(0));
	}

	@Test
	public void testDelete() {
		Table table = new Table(PRODUCENT, NAZWA, CENA);
		Table table2 = new Table(PRODUCENT2, NAZWA2, CENA2);

		tableManager.addTable(table);
		tableManager.addTable(table2);
		tableManager.deleteTable(table);

		assertEquals(1, tableManager.tables.size());
	}

}
