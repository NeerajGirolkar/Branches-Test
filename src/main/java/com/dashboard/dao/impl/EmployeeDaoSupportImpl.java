package com.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dashboard.dao.EmployeeDao;
import com.dashboard.to.Account;
import com.dashboard.to.Employee;

public class EmployeeDaoSupportImpl extends JdbcDaoSupport implements EmployeeDao{

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM EMPLOYEE;";
		List<Employee> employees = new ArrayList<Employee>();
		List<Map<String, Object>> empRow = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> row : empRow){
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			employee.setFirstName(String.valueOf(row.get("FIRST_NAME")));
			employee.setDepartment(String.valueOf(row.get("DEPARTMENT")));
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(String.valueOf(row.get("ACCOUNT_ID"))));
			account.setBalance(Integer.parseInt(String.valueOf(row.get("BALANCE"))));
			employee.setAccount(account);
			employees.add(employee);
		}
		return employees;
	}
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
