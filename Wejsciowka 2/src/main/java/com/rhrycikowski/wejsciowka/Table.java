package com.rhrycikowski.wejsciowka;

public class Table {
	String producent;
	String nazwa;
	int cena;

	public Table() {

	}

	public Table(String producent, String nazwa, int cena) {
		this.producent = producent;
		this.nazwa = nazwa;
		this.cena = cena;
	}

	public int getcena() {
		return this.cena;
	}

	public void setcena(int cena) {
		this.cena = cena;
	}

	public String getproducent() {
		return this.producent;
	}

	public void setproducent(String producent) {
		this.producent = producent;
	}

	public String getnazwa() {
		return this.nazwa;
	}

	public void setnazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
