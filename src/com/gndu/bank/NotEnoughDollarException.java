package com.gndu.bank;

public class NotEnoughDollarException extends NotEnoughBalanceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughDollarException(String message) {
        super(message);
    }	
}
