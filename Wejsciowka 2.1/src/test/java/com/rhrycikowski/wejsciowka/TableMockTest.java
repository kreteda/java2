package com.rhrycikowski.wejsciowka;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rhrycikowski.wejsciowka.IMyList;
import com.rhrycikowski.wejsciowka.Table;
import com.rhrycikowski.wejsciowka.TableManager;

public class TableMockTest {

	private static final int CENA = 1001;
	private static final String MODEL = "Stolik niesamowity 01";
	private static final String PRODUCENT = "Agata Meble";
	
	private TableManager tableManager;
	private IMyList mock;
	private Table table = new Table(PRODUCENT, MODEL, CENA);
	private List<Table> tables;
	
	@Before
	public void setUp() {
		mock = createMock(IMyList.class);
		tableManager = new TableManager(mock);
	}

	@Test
	public void checkAdding() {
		expect(mock.addTable(table)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(tableManager.addTable(table));
		verify(mock);
	}
	
	@Test
	public void checkRemove() {
		expect(mock.deleteTable(table)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(tableManager.deleteTable(table));
		verify(mock);
	}

	@Test
	public void checkGetAll() {
		expect(mock.getAll()).andReturn(tables);
		replay(mock);
		assertEquals(tables, tableManager.getAllTables());
		verify(mock);
	}
	
	@Test
	public void checkGetByModel() {
		expect(mock.getByModel(MODEL)).andReturn(table);
		replay(mock);
		assertEquals(table, tableManager.getByModel(MODEL));
		verify(mock);
	}
	
	@Test
	public void checkGetByCENA() {
		expect(mock.getByCENA(CENA)).andReturn(table);
		replay(mock);
		assertEquals(table, tableManager.getByCENA(CENA));
		verify(mock);
	}
}
