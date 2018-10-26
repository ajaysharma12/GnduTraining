package com.gndu.thread.icecream;

public class IceCreamTray {
	String iceCreamType;
	boolean softieAvailable = false;

	public boolean isSoftieAvailable() {
		return softieAvailable;
	}

	public void setSoftieAvailable(boolean softieAvailable) {
		this.softieAvailable = softieAvailable;
	}

	public String getIceCreamType() {
		return iceCreamType;
	}

	public void setIceCreamType(String iceCreamType) {
		this.iceCreamType = iceCreamType;
	}
}
