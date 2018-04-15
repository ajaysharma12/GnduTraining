package com.gndu.bank;

public class Transaction {

	public static void main(String[] args) {
		Account studentAccount = new Account();
		studentAccount.setName("Rishab");
		studentAccount.setAddress("Gurdaspur");
		studentAccount.setAccountType("Join Account");
		
		Depositor depositor = new Depositor(studentAccount);
		Student student = new Student(studentAccount);
		
		
		
		Thread studentThread = new Thread(student, "student 1");
		studentThread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread depositThread = new Thread(depositor, "depositor 1");
		depositThread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread depositThread2 = new Thread(depositor, "depositor 2");
		depositThread2.start();
		
		Thread depositThread3 = new Thread(depositor, "depositor 3");
		depositThread3.start();
		
		Thread depositThread4 = new Thread(depositor, "depositor 4");
		depositThread4.start();
//		
//		Thread depositThread5 = new Thread(depositor, "depositor 5");
//		depositThread5.start();
		
		System.out.println("printing balance: " + studentAccount.getBalance());
		
		
		
		
		System.out.println("printing balance after sleep: " + studentAccount.getBalance());

		
	}

}
