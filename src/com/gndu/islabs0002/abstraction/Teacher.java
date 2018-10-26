package com.gndu.islabs0002.abstraction;

public class Teacher implements Comparable<Teacher>, TeachAble{
	
	int age;
	int salary;
	String firstname;
	String lastname;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public int compareTo(Teacher teacher){
		if(this.age == teacher.age)
			return 0;
		else if(this.age > teacher.age)
			return 1;
		return -1;
	}
	
	@Override
	public boolean canTeach() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
