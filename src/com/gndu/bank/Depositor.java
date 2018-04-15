package com.gndu.bank;

public class Depositor implements Runnable {

	Account depositAccount;

	public Depositor(Account account) {
		depositAccount = account;
	}

	public Account getDepositAccount() {
		return depositAccount;
	}

	public void setDepositAccount(Account depositAccount) {
		this.depositAccount = depositAccount;
	}

	public boolean deposit(int money) {
		depositAccount.addBalance(money);
		return true;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Thread Name: " + threadName);
		int money = 2000;

		// this.deposit(money);
		// System.out.println(threadName + " balance is: " +
		// depositAccount.getBalance());
		// depositAccount.notify();

		// this.deposit(money);
		// System.out.println(threadName + " balance is: " +
		// depositAccount.getBalance());
		// depositAccount.notify();

		synchronized (depositAccount) {
			this.deposit(money);
			System.out.println(threadName + " balance is: " + depositAccount.getBalance());
			// depositAccount.notify();
		}
	}

	// public static void main(String[] args) {
	//
	// Account studentAccount = new Account();
	// studentAccount.setName("Rishab");
	// studentAccount.setAddress("Gurdaspur");
	// studentAccount.setAccountType("Join Account");
	//
	// Depositor d = new Depositor(studentAccount);
	// d.run();
	//
	// System.out.println("printing balance: " + studentAccount.getBalance());
	// }

}
