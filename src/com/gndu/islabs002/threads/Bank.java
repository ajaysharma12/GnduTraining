package com.gndu.islabs002.threads;

public class Bank {
	
	public static void main(String args[]){
		
		// Creating Account.
		BankAccount bankAcc = new BankAccount();
		bankAcc.setName("Amritsar Account");
		bankAcc.setAccountId(2);
		bankAcc.setBalance(10);
		bankAcc.setAccountType("Joint");
		
		// Creating deposit customer
		DepositCustomer depositCust = new DepositCustomer(bankAcc);
		depositCust.setName("ddd1");
		
		WithDrawCustomer withdrawCust = new WithDrawCustomer(bankAcc);
		withdrawCust.setName("www1");
		WithDrawCustomer withdrawCust2 = new WithDrawCustomer(bankAcc);
		withdrawCust2.setName("www2");
		
		WithDrawCustomer withdrawCust3 = new WithDrawCustomer(bankAcc);
		withdrawCust3.setName("www3");
		
		DepositCustomer depositCust2 = new DepositCustomer(bankAcc);
		depositCust2.setName("ddd2");
		
		// Starting deposit customer
		depositCust.start();
		
		
		
		
		// Starting deposit customer
		withdrawCust.start();
		
		// Starting deposit customer2
		withdrawCust2.start();

		
		withdrawCust3.start();
		
		
		
		//Printing balance
		System.out.println("main printing 1 .. " + bankAcc.getBalance());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		depositCust2.start();
		
		System.out.println("main printing 2 .. " + bankAcc.getBalance());
		
	}

}
