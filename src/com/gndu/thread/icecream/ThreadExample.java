package com.gndu.thread.icecream;

public class ThreadExample {
	
	public static void main(String []args){
		
		IceCreamTray iceCreamTray = new IceCreamTray();
		
		Producer producer = new Producer(iceCreamTray);
		Consumer consumer = new Consumer(iceCreamTray);
		
		System.out.println(" Producer started  ");
		Thread producerThread = new Thread(producer);
		producerThread.setName(" Ice-Cream Producer ");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(" Consumer started  ");
		Thread consumerThread = new Thread(consumer);
		consumerThread.setName(" Ice-Cream Consumer ");

		consumerThread.start();
		producerThread.start();
		
	}
	
}
