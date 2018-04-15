package com.gndu.ajay;

public class Person implements Testable {

	private int age;
	private String name;
	private int height;
	private int weight;
	protected String city;
	private Address addressAbohar;
	private Address addressAmritsar;
	private Occupation ocp1;
	
	public Person(int age, String name, int hieght, int weight, String city){
		this.age = age;
		height = hieght;
		this.weight = weight;
		this.name = name;
		this.city = city;
	}
	
	public Person(){
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	public void run(){
		System.out.println("Person is running !!");
	}
		
	public void test(){
		System.out.println("person is appearing for test");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
