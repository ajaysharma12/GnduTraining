package com.gndu.islabs0002.abstraction;

public class MinimumGearException extends GearException {

	@Override
	public String getMessage() {
		return "This is minimum gear, Back operation is not allowed";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5439176911678859495L;

}
