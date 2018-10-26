package com.gndu.islabs002.threads;

public class BankAccount {
	String name;
	int balance;
	int accountId;
	String accountType;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void deposit(int amount){
		this.balance += amount;
	}
	
	public int balanceCheck(){
		return this.balance;
	}
	
	public void withdrawal(int amount){
		this.balance -= amount;
	}
}
