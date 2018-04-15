package com.gndu.thread;

public class ThreadExample {
	
	public static void main(String []args){
		
		IceCream iceCream = new IceCream();
		
		Producer producer = new Producer(iceCream);
		Consumer consumer = new Consumer(iceCream);
		
		Thread producerThread = new Thread(producer);
		producerThread.setName("Ice-Cream Producer");
		Thread consumerThread = new Thread(consumer);
		consumerThread.setName("Ice-Cream Consumer");

		consumerThread.start();
		producerThread.start();
		
	}
	
}
