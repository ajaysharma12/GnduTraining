package com.gndu.sharma;

import com.gndu.ajay.Person;

public class Employee extends Person {

	public Employee() {
		super();
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public void run() {
		System.out.println("Employee is running !!");
	}

	public void run(String laps) {
		System.out.println("total laps ran so far is " + laps);
	}
}
