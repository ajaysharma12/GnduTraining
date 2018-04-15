package com.gndu.bank;

import java.util.Date;

public class Student implements Runnable {

	Account bankAccount;

	public Student(Account account) {
		bankAccount = account;
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * this function withdraw money from bank account
	 * 
	 * @param money
	 * @return
	 * @throws NotEnoughDollarException
	 */
	public boolean withdraw(int money) {

		String threadName = Thread.currentThread().getName();
		System.out.println("Thread Name: " + threadName);

		// for (int count = 0; count < 50; count++) {
		// try {
		// System.out.println("~~~~ withdraw attempt @ " + new Date());
		// if (bankAccount.getBalance() > money) {
		// bankAccount.withdraw(money);
		// System.out.println(threadName + " has withdrawn, new balance is: " +
		// this.bankAccount.getBalance());
		// }
		// else {
		// bankAccount.wait();
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

		synchronized (bankAccount) {

			for (int count = 0; count < 50; count++) {
				try {
					bankAccount.wait();
					System.out.println("~~~~ withdraw attempt @ " + new Date());
					if (bankAccount.getBalance() > money) {
						bankAccount.withdraw(money);
						System.out.println(
								threadName + " has withdrawn, new balance is: " + this.bankAccount.getBalance());
					} else {
						bankAccount.wait();
					}
				} catch (InterruptedException ex) {
					// stop the thread
					// log thread infomration in the database
				} catch(NotEnoughBalanceException ex){
					// SMS users about low balance
				}

			}
		}
		return true;
	}

	@Override
	public void run() {
		int money = 1000;
		this.withdraw(money);

	}

}
