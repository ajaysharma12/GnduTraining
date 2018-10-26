package com.gndu.ajay.algo.queue;

import java.util.Arrays;

public class ArrayQueue {

	public static final int DEFAULT_SIZE = 10;

	private Object data[];

	private int index;

	public ArrayQueue() {
		data = new Object[DEFAULT_SIZE];
	}

	public ArrayQueue(int queueSize) {
		data = new Object[queueSize];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void enqueue(Object obj) throws Exception {
		if (index == DEFAULT_SIZE - 1) {
			throw new Exception("Queue is full. Dequeue some objects");
		}
		this.data[index] = obj;
		this.index++;
	}

	public Object dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");
		Object obj = this.data[0];
		for (int i = 0; i < this.index - 1; i++) {
			data[i] = data[i + 1];
		}
		this.index--;
		return obj;
	}

	public String toString() {
		return Arrays.toString(this.data);
	}
}