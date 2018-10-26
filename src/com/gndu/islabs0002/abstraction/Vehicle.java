package com.gndu.islabs0002.abstraction;

public abstract class Vehicle {
	
	final String color = "red";
	int yearOfMake = 2000;
	String type = "hatchback";

	abstract public int switchGears(int presentGear, String nextMove) throws GearException;
	
	
	String drive(){
		return "This vehicle can drive";
	}
	
	abstract public String whichHandDrive();
}
