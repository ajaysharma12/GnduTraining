package com.gndu.ajay.algo.stack;

public class StackNode<E> {
	
	private E value;
	private StackNode<E> next;
	
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public StackNode<E> getNext() {
		return next;
	}
	public void setNext(StackNode<E> next) {
		this.next = next;
	}
	
}
