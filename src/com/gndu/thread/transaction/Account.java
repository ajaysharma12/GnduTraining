package com.gndu.thread.transaction;

import java.math.BigDecimal;

public class Account {
	
	private String acccountName;
	private Integer accountNumber;
	private String accountAddress;
	private BigDecimal balance;

	public synchronized void withdraw(BigDecimal amount) {
		if(this.getBalance().compareTo(amount) >= 0){
			this.balance = this.getBalance().subtract(amount);	
		}else{
			System.out.println("account overdrawn!!");
		}
	}
	
	public synchronized void deposit(BigDecimal amount) {
		this.balance = this.getBalance().add(amount);
	}

	public String getAcccountName() {
		return acccountName;
	}

	public void setAcccountName(String acccountName) {
		this.acccountName = acccountName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAccountAddress() {
		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}
}
