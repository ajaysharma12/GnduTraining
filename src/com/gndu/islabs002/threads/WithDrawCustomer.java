package com.gndu.islabs002.threads;

public class WithDrawCustomer extends Thread {

	String name;
	BankAccount bankAccount;

	WithDrawCustomer(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void run() {
		System.out.println("withdraw started !!");
		checkBalance();
		for (int i = 0; i < 10; i++) {
			// Thread.sleep(10000);
			withdrawMoney(100);
		}
	}

	public int checkBalance() {
		return this.bankAccount.getBalance();
	}

	public void withdrawMoney(int amount) {
		synchronized (this.bankAccount) {
			try {
				while(true){
					if (this.bankAccount.getBalance() < amount){
						System.out.println(this.getName() + " is waiting! because balance is: "+ this.bankAccount.getBalance());
						bankAccount.wait();
					}else{
						break;
					}
				}				
				System.out.println(this.getName() + " will withdraw as balance is " + this.bankAccount.getBalance());
				this.bankAccount.withdrawal(amount);
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}

		
	}

	//

}
