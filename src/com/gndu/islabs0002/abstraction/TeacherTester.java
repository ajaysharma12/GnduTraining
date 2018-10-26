package com.gndu.islabs0002.abstraction;

import java.util.ArrayList;
import java.util.Collections;

public class TeacherTester {
	public static void main(String argg[]){
		Teacher t1 = new Teacher();
		t1.setAge(10);
		t1.setFirstname("a");
		t1.setLastname("z");
		t1.setSalary(200);
		
		Teacher t2 = new Teacher();
		t2.setAge(11);
		t2.setFirstname("b");
		t2.setLastname("y");
		t2.setSalary(210);
		
		Teacher t3 = new Teacher();
		t3.setAge(9);
		t3.setFirstname("c");
		t3.setLastname("x");
		t3.setSalary(220);
		
		Teacher t4 = new Teacher();
		t4.setAge(20);
		t4.setFirstname("d");
		t4.setLastname("w");
		t4.setSalary(220);
		
		Teacher t5 = new Teacher();
		t5.setAge(15);
		t5.setFirstname("e");
		t5.setLastname("v");
		t5.setSalary(230);
		
		
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(t1);
		teacherList.add(t2);
		teacherList.add(t3);
		teacherList.add(t4);
		teacherList.add(t5);
		
		System.out.println("natural sort order");
		Collections.sort(teacherList);
		for(Teacher t : teacherList){
			System.out.println(t.firstname);
		}
		
		System.out.println("+++ comparator sort order");
		Collections.sort(teacherList, new TeacherSalaryComprator());
		for(Teacher t : teacherList){
			System.out.println(t.firstname);
		}
		
	}
}
