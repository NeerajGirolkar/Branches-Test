package com.dashboard.dao;

import java.util.List;

import com.dashboard.to.Employee;

public interface EmployeeDao {
	
	public void save(Employee employee);
	
	public Employee getById(int id);
	
	public List<Employee> getAllEmployees();
	
	public void update(Employee employee);
	
	public void deleteById(int id);
	
}
