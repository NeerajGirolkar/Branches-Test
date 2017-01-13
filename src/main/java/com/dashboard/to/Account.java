package com.dashboard.to;

public class Account {
	private int accountNo;
	private int balance;
	
	public Account() { }
	
	public Account(int accountNo, int balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
