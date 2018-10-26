package com.gndu.ajay.algo.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedCircularQueue<E>  implements Iterable<E>{
	private QueueNode<E> first; // beginning of queue
	private QueueNode<E> last; // end of queue
	private int size; // number of elements on queue

	/**
	 * Initializes an empty queue.
	 */
	public LinkedCircularQueue() {
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the item least recently added to this queue.
	 *
	 * @return the item least recently added to this queue
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	public E peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return first.getValue();
	}

	/**
	 * Adds the item to this queue.
	 *
	 * @param item
	 *            the item to add
	 */
	public void enqueue(E item) {
		QueueNode<E> oldlast = last;
		last = new QueueNode<E>();
		last.setValue(item);
		last.setNext(null);

		// check for the pointer of first
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.setNext(last);
		}
		last.setNext(first);
		size++;
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 *
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	public E dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		E item = null;
		if(size > 1){
			QueueNode<E> oldFirst = first; 
			item = oldFirst.getValue();
			last.setNext(first.getNext());
			first = first.getNext();
			oldFirst.setNext(null);
		}else if(size == 1){
			item = first.getValue();
			first = null;
			last = null;
		}
		size--;
		return item;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	public String toString() {
		System.out.println("toString() method invoked");
		StringBuilder s = new StringBuilder();
		int appendCount = 0;
		for (E item : this) {
			appendCount++;
			s.append(item);
			s.append(' ');
			if(appendCount == this.size){
				break;
			}
		}
		return s.toString();
	}

	/**
	 * Returns an iterator that iterates over the items in this queue in FIFO
	 * order.
	 *
	 * @return an iterator that iterates over the items in this queue in FIFO
	 *         order
	 */
	public Iterator<E> iterator() {
		return new QueueIterator<E>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class QueueIterator<Item> implements Iterator<Item> {
		private QueueNode<Item> current;

		public QueueIterator(QueueNode<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.getValue();
			current = current.getNext();
			return item;
		}
	}
}
