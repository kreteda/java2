package com.rhrycikowski.wejsciowka;

import java.util.ArrayList;
import java.util.List;

public class TableManager {
	
	 
	public IMyList myList;
	
	public TableManager(IMyList myList){
		this.myList = myList;
	}
	
	public boolean addTable(Table table){
		return myList.addTable(table);
	}
	
	public boolean deleteTable(Table table){
		return myList.deleteTable(table);
	}
	
	public List<Table> getAllTables(){
		return myList.getAll();
	}
	
	public Table getByModel(String model){
		return myList.getByModel(model);
	}
	
	public Table getByCENA(int cena){
		return myList.getByCENA(cena);
	}
}
