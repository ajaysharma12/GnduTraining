package com.gndu.ajay.algo.linkedlist.doubly;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	/**
	 * returns the size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * return whether the list is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * adds element at the starting of the linked list
	 * 
	 * @param element
	 */
	public void addFirst(E element) {
		Node<E> tmp = new Node<E>(element, head, null);
		if (head != null) {
			// head.prev = tmp;
			head.setPrev(tmp);
		}
		head = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * adds element at the end of the linked list
	 * 
	 * @param element
	 */
	public void addLast(E element) {

		Node<E> tmp = new Node<E>(element, null, tail);
		if (tail != null) {
			// tail.next = tmp;
			tail.setNext(tmp);
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * this method walks forward through the linked list
	 */
	public void iterateForward() {

		System.out.println("iterating forward..");
		Node<E> tmp = head;
		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}

	/**
	 * this method walks backward through the linked list
	 */
	public void iterateBackward() {

		System.out.println("iterating backword..");
		Node<E> tmp = tail;
		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getPrev();
		}
	}

	/**
	 * this method removes element from the start of the linked list
	 * 
	 * @return
	 */
	public E removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		Node<E> tmp = head;
		head = head.getNext();
		head.setPrev(null);
		size--;
		System.out.println("deleted: " + tmp.getData());
		return tmp.getData();
	}

	/**
	 * this method removes element from the end of the linked list
	 * 
	 * @return
	 */
	public E removeLast() {
		if (size == 0)
			throw new NoSuchElementException();
		Node<E> tmp = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		System.out.println("deleted: " + tmp.getData());
		return tmp.getData();
	}

	@Override
	public Iterator<E> iterator() {
		return new DoublyListIterator<E>(head);
	}

	private class DoublyListIterator<Item> implements Iterator<Item> {

		private Node<Item> current;

		public DoublyListIterator(Node<Item> head) {
			current = head;
		}

		@Override
		public boolean hasNext() {
			if (current != null)
				return true;
			return false;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item value = current.getData();
			current = current.getNext();
			return value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
