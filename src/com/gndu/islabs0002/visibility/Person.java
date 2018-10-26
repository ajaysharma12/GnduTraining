package com.gndu.islabs0002.visibility;

public class Person {
	
	String firstName;
	String lastName;
	
	private String getFullName(){
		return firstName+ lastName;
	}
}
