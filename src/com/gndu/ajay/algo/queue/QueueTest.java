package com.gndu.ajay.algo.queue;

import java.util.Iterator;

public class QueueTest {

	/**
	 * 
	 * Unit tests the {@code Queue} data type.
	 *
	 * @param args
	 *            the command-line arguments
	 * 
	 */
	public static void main(String[] args) {
		testLinkedQueue();
		testArrayQueue();
		testArrayCircularQueue();
		testLinkedCircularQueue();
	}

	private static void testLinkedQueue() {
		LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
		linkedQueue.enqueue("hello1");
		linkedQueue.enqueue("hello2");
		linkedQueue.enqueue("hello3");
		linkedQueue.enqueue("hello4");
		linkedQueue.enqueue("hello5");

		System.out.println(linkedQueue.toString());
		System.out.println(linkedQueue.size());

		System.out.println("first dequeue: " + linkedQueue.dequeue());
		System.out.println("Second dequeue: " + linkedQueue.dequeue());

		System.out.println(linkedQueue.toString());

		Iterator<String> queueItr = linkedQueue.iterator();
		while (queueItr.hasNext()) {
			System.out.println(queueItr.next());
		}
	}

	private static void testArrayQueue() {
		ArrayQueue queue = new ArrayQueue();
		try {
			queue.enqueue("1");
			System.out.println(queue.dequeue());

			queue.enqueue("2");
			queue.enqueue("3");
			queue.enqueue("4");
			System.out.println(queue.dequeue());

			queue.enqueue("5");
			queue.enqueue("6");
			System.out.println(queue.toString());
			// queue.enqueue("7");
			// queue.enqueue("8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testArrayCircularQueue() {
		ArrayCircularQueue<Integer> circularQueue = new ArrayCircularQueue<Integer>(8);
		try {
			circularQueue.enqueue(15);
			circularQueue.enqueue(16);
			circularQueue.enqueue(17);
			circularQueue.enqueue(18);
			circularQueue.enqueue(19);
			circularQueue.enqueue(20);
			circularQueue.enqueue(21);
			circularQueue.enqueue(22);

			System.out.println("Full Circular Queue" + circularQueue);

			System.out.print("Dequeued following element from circular Queue ");
			System.out.println(circularQueue.dequeue() + " ");
			circularQueue.enqueue(23);
			System.out.println("After enqueueing circular queue with element having value 23");
			System.out.println(circularQueue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private static void testLinkedCircularQueue(){
		LinkedCircularQueue<Integer> linkedCircularQueue = new LinkedCircularQueue<Integer>();
		try {
			linkedCircularQueue.enqueue(15);
			linkedCircularQueue.enqueue(16);
			linkedCircularQueue.enqueue(17);
			linkedCircularQueue.enqueue(18);
			linkedCircularQueue.enqueue(19);
			linkedCircularQueue.enqueue(20);
			linkedCircularQueue.enqueue(21);
			linkedCircularQueue.enqueue(22);

			System.out.println("Full Circular Queue" + linkedCircularQueue);

			System.out.print("Dequeued following element from circular Queue ");
			System.out.println(linkedCircularQueue.dequeue() + " ");
			linkedCircularQueue.enqueue(23);
			System.out.println("After enqueueing circular queue with element having value 23");
			System.out.println(linkedCircularQueue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
