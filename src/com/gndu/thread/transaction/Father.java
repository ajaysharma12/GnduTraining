package com.gndu.thread.transaction;

import java.math.BigDecimal;

public class Father extends Thread {
	
	private Account collegeBankAccount;

	public Father(String threadName, Account account) {
		super(threadName);
		this.collegeBankAccount = account;
	}

	@Override
	public void run() {
		System.out.println("Father - START " + Thread.currentThread().getName());
		try {
			Thread.sleep(20000);
			for(int i = 0; i<1; i++){
				System.out.println(" ++++++ Father is about to deposit");
				deposit();	
				System.out.println(" ++++++ Father completes the deposit and the balance is: " + collegeBankAccount.getBalance());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread - END " + Thread.currentThread().getName());
	}

	private  void deposit() throws InterruptedException {
		Thread.sleep(5000);
		synchronized(collegeBankAccount){
			collegeBankAccount.deposit(BigDecimal.TEN);
			collegeBankAccount.notifyAll();
		}
	}
	
}
