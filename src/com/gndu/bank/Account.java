package com.gndu.bank;

public class Account {
	String name;
	String accountType;
	int balance = 0;
	String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int addBalance(int money){
		balance = balance + money;
		return balance;
	}
	
	public int withdraw(int money) throws NotEnoughBalanceException{
		if(balance > money){
			balance = balance - money;
		}else{
			throw new NotEnoughBalanceException("Balance is low!!");
		}
		return balance;
	}
	
}
