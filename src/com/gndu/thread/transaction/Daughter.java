package com.gndu.thread.transaction;

import java.math.BigDecimal;

public class Daughter extends Thread {
	
	private Account collegeBankAccount;
	
	public Daughter(String threadName, Account account) {
        super(threadName);
        this.collegeBankAccount = account;
    }
	
	@Override
    public void run() {
        System.out.println("Daughter - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            for(int i = 0; i<5; i++){
				System.out.println(" ---------- Daughter starts withdrawing");
	            withdraw();	
				System.out.println(" ---------- Daughter completes the withdraw and account balance is: " + collegeBankAccount.getBalance());
			}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }

    private void withdraw() throws InterruptedException {
        Thread.sleep(2000);
        int amountToBeWithDrawn = 30;
        synchronized(collegeBankAccount){
            while(true){
            	System.out.println("--- daughter found account balance: " + collegeBankAccount.getBalance());
            	if(collegeBankAccount.getBalance().intValue() < amountToBeWithDrawn){
            		System.out.println("---- low account balance.. daughter waiting !");
            		collegeBankAccount.wait();
                }else{
                	System.out.println("---- daughter withdrawing ");
                	collegeBankAccount.withdraw(new BigDecimal(amountToBeWithDrawn));
                	break;
                }
            }
        }
    }
}
