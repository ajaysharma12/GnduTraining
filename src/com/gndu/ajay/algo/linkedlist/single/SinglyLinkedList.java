package com.gndu.ajay.algo.linkedlist.single;

public class SinglyLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;

	public void add(E element) {
		Node<E> newNode = new Node<E>();
		newNode.setValue(element);
		System.out.println("Adding: " + element);
		/**
		 * check if the list is empty
		 */
		if (head == null) {
			// since there is only one element, both head and
			// tail points to the same object.
			head = newNode;
			tail = newNode;
		} else {
			// set current tail next link to new node
			// set tail as newly created node
			tail.setNext(newNode);			
			tail = newNode;
		}
	}

	public void addAfter(E element, E after) {
		Node<E> tmp = head;
		Node<E> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (true) {
			if (tmp == null) {
				break;
			}
			if (after.equals(tmp.getValue())) {
				// found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if (refNode != null) {
			// add element after the target node
			Node<E> newNode = new Node<E>();
			newNode.setValue(element);
			newNode.setNext(refNode.getNext());
			if (refNode == tail) {
				tail = newNode;
			}
			refNode.setNext(newNode);

		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void deleteFront() {

		if (head == null) {
			System.out.println("Underflow...");
		}
		Node<E> tmp = head;
		head = tmp.getNext();
		if (head == null) {
			tail = null;
		}
		System.out.println("Deleted: " + tmp.getValue());
	}

	public void deleteAfter(E after) {
		Node<E> tmp = head;
		Node<E> refNode = null;
		System.out.println("Deleting " + after + " Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (true) {
			if (tmp == null) {
				break;
			}
			if (tmp.compareTo(after) == 0) {
				// found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if (refNode != null) {
			tmp = refNode.getNext();
			refNode.setNext(tmp.getNext());
			if (refNode.getNext() == null) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmp.getValue());
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void traverse() {
		Node<E> tmp = head;
		while (true) {
			if (tmp == null) {
				break;
			}
			System.out.println(tmp.getValue());
			tmp = tmp.getNext();
		}
	}


}
