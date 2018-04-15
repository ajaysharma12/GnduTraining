/**
 * 
 */
package com.gndu.ajay;

import java.util.ArrayList;
import java.util.HashSet;

import com.gndu.ajay.collection.PersonList;
import com.gndu.sharma.Employee;

/**
 * @author ASharma5
 *
 */
public class HelloWorld {

	public static void main(String jsjjjs[]){
		System.out.println("Hello to the java world !!! afdadsdfs");
		
		HelloWorld w = new HelloWorld();
		w.printPerson();
		w.getPersonList();
		System.out.println("HelloWorld ends here");
		w.listExample();
	}
	
	
	
	/**
	 * This function prints the properties of Employee Class
	 */
	public void printPerson()
	{	
		
		Employee rishab = new Employee();
		rishab.setAge(20);
		rishab.setHeight(170);
		rishab.city = "gurdaspur";
		rishab.run();
		rishab.test();
	
	}
	
	
	public void getPersonList(){
		PersonList plist = new PersonList();
		ArrayList<Person> personArray = plist.createPersonList();
		
	}
	
	public void listExample(){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(1);
		intList.add(1);
		intList.add(1);
		
		HashSet<Integer> intSet = new HashSet<Integer>();
		intSet.add(1);
		intSet.add(1);
		intSet.add(1);
		intSet.add(1);
		intSet.add(1);
		
		
	}
	
	
//	public <T> void printArray( <T> arg1, <T> arg2 ){
//		return <T>;
//	}
}
