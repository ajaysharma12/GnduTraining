package com.gndu.ajay.algo.linkedlist.doubly;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularDoubleLinkedList<Item> implements Iterable<Item> {
	protected Node<Item> start;
	protected Node<Item> end;
	public int size;

	/* Constructor */
	public CircularDoubleLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert element at begining */
	public void insertAtStart(Item val) {
		Node<Item> nptr = new Node<Item>(val, null, null);
		if (start == null) {
			nptr.setNext(nptr);
			nptr.setPrev(nptr);
			start = nptr;
			end = start;
		} else {
			nptr.setPrev(end);
			end.setNext(nptr);
			start.setPrev(nptr);
			nptr.setNext(start);
			start = nptr;
		}
		size++;
	}

	/* Function to insert element at end */
	public void insertAtEnd(Item val) {
		Node<Item> nptr = new Node<Item>(val, null, null);
		if (start == null) {
			nptr.setNext(nptr);
			nptr.setPrev(nptr);
			start = nptr;
			end = start;
		} else {
			nptr.setPrev(end);
			end.setNext(nptr);
			start.setPrev(nptr);
			nptr.setNext(start);
			end = nptr;
		}
		size++;
	}

	/* Function to insert element at position */
	public void insertAtPos(Item val, int pos) {
		Node<Item> nptr = new Node<Item>(val, null, null);
		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		Node<Item> ptr = start;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node<Item> tmp = ptr.getNext();
				ptr.setNext(nptr);
				nptr.setPrev(ptr);
				nptr.setNext(tmp);
				tmp.setPrev(nptr);
			}
			ptr = ptr.getNext();
		}
		size++;
	}

	/* Function to delete node at position */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			if (size == 1) {
				start = null;
				end = null;
				size = 0;
				return;
			}
			start = start.getNext();
			start.setPrev(end);
			end.setNext(start);
			size--;
			return;
		}
		if (pos == size) {
			end = end.getPrev();
			end.setNext(start);
			start.setPrev(end);
			size--;
		}
		Node<Item> ptr = start.getNext();
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node<Item> p = ptr.getPrev();
				Node<Item> n = ptr.getNext();

				p.setNext(n);
				n.setPrev(p);
				size--;
				return;
			}
			ptr = ptr.getNext();
		}
	}

	/* Function to display status of list */
	public void display() {
		System.out.print("\nCircular Doubly Linked List = ");
		Node<Item> ptr = start;
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == start) {
			System.out.print(start.getData() + " <-> " + ptr.getData() + "\n");
			return;
		}
		System.out.print(start.getData() + " <-> ");
		ptr = start.getNext();
		while (ptr.getNext() != start) {
			System.out.print(ptr.getData() + " <-> ");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData() + " <-> ");
		ptr = ptr.getNext();
		System.out.print(ptr.getData() + "\n");
	}

	@Override
	public Iterator<Item> iterator() {
		return new CircularDLLIterator<Item>(start);
	}

	private class CircularDLLIterator<E> implements Iterator<E> {

		Node<E> current;

		public CircularDLLIterator(Node<E> head) {
			current = head;
		}

		@Override
		public boolean hasNext() {
			if (current != null)
				return true;
			return false;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E value = current.getData();
			current = current.getNext();
			return value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
