package com.gndu.thread;

public class Consumer implements Runnable {

	IceCream iceCream;

	// Producer producer;

	Consumer(IceCream iceCreamArg) {
		if (iceCreamArg != null)
			iceCream = iceCreamArg;
	}

	@Override
	public void run() {
		
		
		String threadName = Thread.currentThread().getName();
		System.out.println("~~~~~ Thread Name: " + threadName);
		synchronized (iceCream) {
			for(int i=0; i<10 ; i++){
				try {
					Thread.sleep(500);
					if (iceCream.getIceCreamType() == null) {
						System.out.println("~~~~~ No Ice Cream produced, so waiting on Ice Cream");
						iceCream.wait();
					}
					System.out.println("~~~~~ Consumer reading iceCream brand: " + iceCream.getIceCreamType());
					iceCream.setIceCreamType(null);
					iceCream.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
		
		
		// Iteration 2
//		String threadName = Thread.currentThread().getName();
//		System.out.println("~~~~~ Thread Name: " + threadName);
//		synchronized (iceCream) {
//			try {
//				Thread.sleep(500);
//				if (iceCream.getIceCreamType() == null) {
//					System.out.println("~~~~~ No Ice Cream produced, so waiting on Ice Cream");
//					iceCream.wait();
//				}
//				System.out.println("~~~~~ Consumer reading iceCream brand: " + iceCream.getIceCreamType());
//				iceCream.setIceCreamType(null);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
		
		
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
}
