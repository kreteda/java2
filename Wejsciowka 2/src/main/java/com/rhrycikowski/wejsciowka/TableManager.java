package com.rhrycikowski.wejsciowka;

import java.util.ArrayList;
import java.util.List;

public class TableManager {
	public List<Table> tables = new ArrayList<Table>();

	public void addTable(Table table) {
		tables.add(table);
	}

	public void deleteTable(Table table) {
		tables.remove(table);
	}
}
