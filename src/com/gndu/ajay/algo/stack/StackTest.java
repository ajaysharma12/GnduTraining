package com.gndu.ajay.algo.stack;

import java.util.Iterator;

public class StackTest {

	/**
	 * 
	 * Unit tests the {@code Queue} data type.
	 *
	 * @param args the command-line arguments
	 * 
	 */
	public static void main(String[] args) {
		testLinkedStack();
		testArrayStack();
	}
	
	private static void testLinkedStack(){
		LinkedStack<String> linkedStack = new LinkedStack<String>();
		linkedStack.push("hello 1");
		linkedStack.push("hello 2");
		linkedStack.push("hello 3");
		linkedStack.push("hello 4");
		linkedStack.push("hello 5");

		System.out.println(linkedStack.toString());
		System.out.println(linkedStack.size());

		System.out.println("first pop: " + linkedStack.pop());
		System.out.println("Second pop: " + linkedStack.pop());
		
		linkedStack.push("hello 6");

		System.out.println(linkedStack.toString());

		Iterator<String> stackItr = linkedStack.iterator();
		while (stackItr.hasNext()) {
			System.out.println(stackItr.next());
		}
	}
	
	
	private static void testArrayStack() {
		ArrayStack stackArr = new ArrayStack(10);
		stackArr.pop();
		System.out.println("=================");
		System.out.println(stackArr.toString());
		stackArr.push(10);
		stackArr.push(30);
		stackArr.push(50);
		stackArr.push(40);
		System.out.println("=================");
		System.out.println(stackArr.toString());
		stackArr.pop();
		stackArr.pop();
		stackArr.pop();
		System.out.println("=================");
		System.out.println(stackArr.toString());
	}
	
}
