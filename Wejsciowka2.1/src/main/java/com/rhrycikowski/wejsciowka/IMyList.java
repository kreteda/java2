package com.rhrycikowski.wejsciowka;

import java.util.List;

public interface IMyList {
	
	public List<Table> getAll();
	public Table getByModel(String model);
	public Table getByCENA(int cena);
	boolean deleteTable(Table table);
	boolean addTable(Table table);
	
}
