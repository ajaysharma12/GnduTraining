package com.gndu.ajay.algo.linkedlist.single;

public class CircularSinglyLinkedList<E> {
	protected Node<E> start;
	protected Node<E> end;
	public int size;

	/* Constructor */
	public CircularSinglyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of the list */
	public int getSize() {
		return size;
	}

	/* Function to insert element at the begining */
	public void insertAtStart(E val) {
		Node<E> nptr = new Node<E>(val, null);
		nptr.setNext(start);
		if (start == null) {
			start = nptr;
			nptr.setNext(start);
			end = start;
		} else {
			end.setNext(nptr);
			start = nptr;
		}
		size++;
	}

	/* Function to insert element at end */
	public void insertAtEnd(E val) {
		Node<E> nptr = new Node<E>(val, null);
		nptr.setNext(start);
		if (start == null) {
			start = nptr;
			nptr.setNext(start);
			end = start;
		} else {
			end.setNext(nptr);
			end = nptr;
		}
		size++;
	}

	/* Function to insert element at position */
	public void insertAtPos(E val, int pos) {
		Node<E> nptr = new Node<E>(val, null);
		Node<E> ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node<E> tmp = ptr.getNext();
				ptr.setNext(nptr);
				nptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		size++;
	}

	/* Function to delete element at position */
	public void deleteAtPos(int pos) {
		if (size == 1 && pos == 1) {
			start = null;
			end = null;
			size = 0;
			return;
		}
		if (pos == 1) {
			start = start.getNext();
			end.setNext(start);
			size--;
			return;
		}
		if (pos == size) {
			Node<E> s = start;
			Node<E> t = start;
			while (s != end) {
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(start);
			size--;
			return;
		}
		Node<E> ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node<E> tmp = ptr.getNext();
				tmp = tmp.getNext();
				ptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		size--;
	}

	/* Function to display contents */
	public void display() {
		System.out.print("\nCircular Singly Linked List = ");
		Node<E> ptr = start;
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == start) {
			System.out.print(start.getValue() + "->" + ptr.getValue() + "\n");
			return;
		}
		System.out.print(start.getValue() + "->");
		ptr = start.getNext();
		while (ptr.getNext() != start) {
			System.out.print(ptr.getValue() + "->");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getValue() + "->");
		ptr = ptr.getNext();
		System.out.print(ptr.getValue() + "\n");
	}
}
