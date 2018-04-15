package com.gndu.thread;

public class Producer implements Runnable {

	IceCream iceCream;

	Producer(IceCream iceCreamArg) {
		if (iceCreamArg != null)
			iceCream = iceCreamArg;
	}

	public void run() {
		// producer will generate 10 ice creams at an interval of 2 seconds

		String threadName = Thread.currentThread().getName();
		System.out.println("Thread Name: " + threadName);
		for(int i =0; i< 10; i++){
			synchronized (iceCream) {
				try {
					Thread.sleep(2000);
					System.out.println("Producing ice cream brand of type " + "vanilla_" + i);
					iceCream.setIceCreamType("Brand " + "vanilla_" + i);
					iceCream.notify();
					iceCream.wait();
//					Thread.sleep(200);
					// notify();
					// notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

		// Iteration 1
		// String threadName = Thread.currentThread().getName();
		// System.out.println("Thread Name: " + threadName);
		// synchronized (iceCream) {
		// try {
		// Thread.sleep(2000);
		// System.out.println("Producing ice cream brand of type " + "vanilla");
		// iceCream.setIceCreamType("Brand " + "vanilla");
		// iceCream.notify();
		//// notify();
		//// notifyAll();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
	}
}
