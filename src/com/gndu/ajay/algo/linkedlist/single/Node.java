package com.gndu.ajay.algo.linkedlist.single;

public class Node<E> implements Comparable<E> {

	private E value;
	private Node<E> next;

	/* Constructor */
	public Node() {
		next = null;
		value = null;
	}

	/* Constructor */
	public Node(E data, Node<E> n) {
		next = n;
		value = data;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public int compareTo(E arg) {
		if (arg == this.value) {
			return 0;
		} else {
			return 1;
		}
	}

}
