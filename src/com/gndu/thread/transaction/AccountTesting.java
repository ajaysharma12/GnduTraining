package com.gndu.thread.transaction;

import java.math.BigDecimal;

public class AccountTesting {
	
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setAcccountName("Deepika");
		account.setAccountAddress("Mohali");
		account.setAccountNumber(new Integer("010"));
		account.setBalance(new BigDecimal("050"));
		
		Father father = new Father("Father Sachin ",  account);
		Daughter daughter = new Daughter("Daughter Deepika ",  account);

		father.start();
		daughter.start();

	}
	
}
