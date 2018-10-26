package com.gndu.thread.icecream;

public class Consumer implements Runnable {

	private IceCreamTray iceCreamTray;

	// Producer producer;

	Consumer(IceCreamTray iceCreamTrayArg) {
		if (iceCreamTrayArg != null)
			iceCreamTray = iceCreamTrayArg;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("~~~Consumer~~~ Thread Name: " + threadName);

		// for(int i=0; i<10 ; i++){
		while (true) {
			try {
				Thread.sleep(500);
				if (!iceCreamTray.isSoftieAvailable()) {
					System.out.println(" ~~~Consumer~~~ ----- No Ice Cream available, Looking at Tray!! ");
				}
			} catch (InterruptedException e1) {
				System.out.println(" ~~~Consumer~~~ ????? Consumer Run method InterruptedException");
				e1.printStackTrace();
			}
			if (iceCreamTray.isSoftieAvailable()) {
				synchronized (iceCreamTray) {
					System.out.println(" ~~~Consumer~~~ +++++ Consuming iceCream brand: " + iceCreamTray.getIceCreamType());
					iceCreamTray.setIceCreamType(null);
					iceCreamTray.setSoftieAvailable(false);
					iceCreamTray.notify();
				}
			}
		}

		// Iteration 2
		// String threadName = Thread.currentThread().getName();
		// System.out.println("~~~~~ Thread Name: " + threadName);
		// synchronized (iceCream) {
		// try {
		// Thread.sleep(500);
		// if (iceCream.getIceCreamType() == null) {
		// System.out.println("~~~~~ No Ice Cream produced, so waiting on Ice
		// Cream");
		// iceCream.wait();
		// }
		// System.out.println("~~~~~ Consumer reading iceCream brand: " +
		// iceCream.getIceCreamType());
		// iceCream.setIceCreamType(null);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }

		// Iteration 1
		// for(int i = 0; i < 10; i++){
		// try {
		// Thread.sleep(500);
		// System.out.println("+++++++++++++ Thread Name: " + threadName);
		// System.out.println("+++++++++++++ Consumer reading iceCream brand: "
		// + ice.getIceCreamType());
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
