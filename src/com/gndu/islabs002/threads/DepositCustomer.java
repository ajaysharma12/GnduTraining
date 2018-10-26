package com.gndu.islabs002.threads;

public class DepositCustomer extends Thread {

	String name;
	BankAccount bankAccount;

	DepositCustomer(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void run() {
		System.out.println("deposit started !!");
		checkBalance();
		for (int i = 0; i < 5; i++) {
			// Thread.sleep(10000);
			depositMoney(100);
		}
	}

	public int checkBalance() {
		return this.bankAccount.getBalance();
	}

	public void depositMoney(int amount) {
		synchronized (this.bankAccount) {
			this.bankAccount.deposit(amount);
			System.out.println(this.getName() + " will notify as balance is: " + this.bankAccount.getBalance());
			this.bankAccount.notify();	
		}
	}
}
