package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Chair {
	
	private int id;
	private String model;	
	private int yop;
	
	public boolean hasId(){
		return id > 0;
	}
	public Chair() {
	}	
	private Person owner;
	
	public Chair(String model, int yop) {
		this.model = model;
		this.yop = yop;
	}
	
	public Chair(String model, int yop, Person owner) {
		this.model = model;
		this.yop = yop;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}