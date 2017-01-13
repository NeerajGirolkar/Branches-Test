package com.dashboard.to;

public class Employee {
	private int id;
	private String firstName;
	private String department;
	private Account account;
	
	public Employee() { }
	
	public Employee(int id, String firstName, String department, Account account) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.department = department;
		this.account = account;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}