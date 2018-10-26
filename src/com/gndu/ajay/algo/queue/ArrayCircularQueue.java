package com.gndu.ajay.algo.queue;

import java.util.Arrays;

public class ArrayCircularQueue<Item> {

	public static final int DEFAULT_SIZE = 10;

	private int maxSize = DEFAULT_SIZE;
	private Item[] data;

	private int front = -1;
	private int rear = -1;
	private int currentSize = 0;

	@SuppressWarnings("unchecked")
	public ArrayCircularQueue() {
		data = (Item[]) new Object[DEFAULT_SIZE];
	}

	@SuppressWarnings("unchecked")
	public ArrayCircularQueue(int queueSize) {
		maxSize = queueSize;
		data = (Item[]) new Object[queueSize];
	}

	/**
	 * Check if Queue is empty.
	 */
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	/**
	 * Check if queue is full.
	 */
	public boolean isFull() {
		return (currentSize == maxSize);
	}

	/**
     * Enqueue elements to rear.
     */
	public void enqueue(Item item) throws Exception {
		if (isFull()) {
			throw new Exception("Circular Queue is full. Element cannot be added");
		} else {
			rear = (rear + 1) % data.length;
			data[rear] = item;
			currentSize++;

			if (front == -1) {
				front = rear;
			}
		}
	}

	/**
     * Dequeue element from Front.
     */
	public Object dequeue() throws Exception {
		Item deQueuedElement;
		if (isEmpty()) {
			throw new Exception("Circular Queue is empty. Element cannot be retrieved");
		} else {
			deQueuedElement = data[front];
			data[front] = null;
			front = (front + 1) % data.length;
			currentSize--;
		}
		return deQueuedElement;
	}

	@Override
	public String toString() {
		System.out.println("toString() method invoked");
		return "CircularQueue [" + Arrays.toString(this.data) + "]";
	}
}
