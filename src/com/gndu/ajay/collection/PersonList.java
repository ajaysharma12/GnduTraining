package com.gndu.ajay.collection;

import java.util.ArrayList;

import com.gndu.ajay.Person;

public class PersonList {
	public ArrayList<Person> createPersonList(){
		ArrayList<Person> personList = new ArrayList<Person>();
		
		Person p1 = new Person();
		p1.setName("Pratibha");
		Person p2 = new Person();
		p2.setName("Rishab");
		Person p3 = new Person();
		p3.setName("Pratibha");
		Person p4 = new Person();
		p4.setName("Pratibha");
		Person p5 = new Person();
		p5.setName("Pratibha");
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p5);
		
		
		return personList;
	}
}
