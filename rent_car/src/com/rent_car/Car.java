package com.rent_car;

public class Car {
	private String name;
	private int price;
	private int manload;
	private int thingload;	
	
	public void setManload(int manload) {
		this.manload = manload;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setThingload(int thingload) {
		this.thingload = thingload;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getManload() {
		return manload;
	}
	public int getThingload() {
		return thingload;
	}
	
}
