package com.gndu.thread;

public class IceCream {
	String iceCreamType;
	
	public synchronized String getIceCreamType() {
		return iceCreamType;
	}

	public synchronized void setIceCreamType(String iceCreamType) {
		this.iceCreamType = iceCreamType;
	}
	
}
