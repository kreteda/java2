package com.rhrycikowski.wejsciowka;

public class Table {
	static String producent;
	static String model;
	static int cena;
	
	public Table(){
		
	}
	
	public Table(String producent, String model, int cena){
		Table.producent = producent;
		Table.model = model;
		Table.cena = cena;
	}
	
	public int getcena(){
		return Table.cena;
	}
	
	public void setcena(int cena){
		Table.cena = cena;
	}
	
	public String getproducent(){
		return Table.producent;
	}
	
	public void setproducent(String producent){
		this.producent = producent;
	}
	
	public String getmodel(){
		return this.model;
	}
	
	public void setmodel(String model){
		this.model = model;
	}
}
