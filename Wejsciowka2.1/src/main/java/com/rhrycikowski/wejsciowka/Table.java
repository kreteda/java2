package com.rhrycikowski.wejsciowka;

public class Table {
	static String producent;
	static String model;
	static int cena;
	

	
	public Table(String producent, String model, int cena){
		this.producent = producent;
		this.model = model;
		this.cena = cena;
	}
	
	public int getcena(){
		return Table.cena;
	}
	
	public void setcena(int cena){
		this.cena = cena;
	}
	
	public String getproducent(){
		return this.producent;
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
