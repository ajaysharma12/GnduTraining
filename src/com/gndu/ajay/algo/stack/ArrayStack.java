package com.gndu.ajay.algo.stack;

import java.util.Arrays;

public class ArrayStack {

	private int size;
	private int arr[];
	private int top;
 
	ArrayStack(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
 
	public void push(int pushedElement) {
		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
			System.out.println("Pushed element:" + pushedElement);
		} else {
			System.out.println("Stack is full !");
		}
	}
 
	public int pop() {
		if (!isEmpty()) {
			int returnedTop = top;
			top--;
			int popElement = arr[returnedTop];
			System.out.println("Popped element :" + popElement);
			arr[returnedTop] = 0;
			return popElement;
		} else {
			System.out.println("Stack is empty !");
			return -1;
		}
	}
 
	public int peek() {
		return arr[top];
	}
 
	public boolean isEmpty() {
		return (top == -1);
	}
 
	public boolean isFull() {
		return ((size - 1) == top);
	}
 
	public String toString() {
		return Arrays.toString(this.arr);
	}
	
}