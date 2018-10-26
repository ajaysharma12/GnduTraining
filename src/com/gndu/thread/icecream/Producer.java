package com.gndu.thread.icecream;

public class Producer implements Runnable {

	private IceCreamTray iceCreamTray;

	Producer(IceCreamTray iceCreamTrayArg) {
		if (iceCreamTrayArg != null)
			iceCreamTray = iceCreamTrayArg;
	}

	public void run() {

		String threadName = Thread.currentThread().getName();
		System.out.println("   @@@@@Producer@@@@@ Thread Name: " + threadName);
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				synchronized (iceCreamTray) {
					if (!iceCreamTray.isSoftieAvailable()) {
						System.out.println("  @@@@@Producer@@@@@ ++++ Producing ice cream brand of type " + "vanilla_" + i);
						iceCreamTray.setIceCreamType("Brand " + "vanilla_" + i);
						iceCreamTray.setSoftieAvailable(true);
						iceCreamTray.notify();
						iceCreamTray.wait();
					} else {
						System.out.println("  @@@@@Producer@@@@@ ---- Tray is full. No Ice Cream Produced ");
					}
				}
			} catch (InterruptedException e) {
				System.out.println("  @@@@@Producer@@@@@ ?????  Producer Run method InterruptedException");
				e.printStackTrace();

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
	
	public IceCreamTray getIceCreamTray() {
		return iceCreamTray;
	}

	public void setIceCreamTray(IceCreamTray iceCreamTray) {
		this.iceCreamTray = iceCreamTray;
	}
	
}
