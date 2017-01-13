package com.dashboard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dashboard.dao.EmployeeDao;
import com.dashboard.to.Account;
import com.dashboard.to.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public EmployeeDaoImpl() { }
	
	private DataSource datasource;

	public void setDatasource(DataSource dataSource) {
		this.datasource = dataSource;
	}

	@Override
	public void save(Employee employee) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, DEPARTMENT, ACCOUNT_ID, BALANCE) values (?,?,?,?,?)";
		Object[] args = new Object[] {employee.getId(), employee.getFirstName(), employee.getDepartment(),
										employee.getAccount().getAccountNo(), employee.getAccount().getBalance()};
		int result = jdbcTemplate.update(sql, args);
		if(result != 0){
			System.out.println("Employee with ID " + employee.getId() + " inserted!");
		} else {
			System.out.println("Employee with ID " + employee.getId() + " NOT inserted!");
		}
		
	}

	@Override
	public Employee getById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?;";
		Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(resultSet.getInt("ID"));
				emp.setFirstName(resultSet.getString("FIRST_NAME"));
				emp.setDepartment(resultSet.getString("DEPARTMENT"));
				Account account = new Account();
				account.setAccountNo(resultSet.getInt("ACCOUNT_ID"));
				account.setBalance(resultSet.getInt("BALANCE"));
				emp.setAccount(account);
				return emp;
			}			
		});
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "SELECT * FROM EMPLOYEE;";
		List<Employee> employees = new ArrayList<Employee>();
		List<Map<String, Object>> empRow = jdbcTemplate.queryForList(sql);
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
	public void update(Employee employee) {
		// TODO Make use of jdbcTemplate.update()		
	}

	@Override
	public void deleteById(int id) {
		// TODO Make use of jdbcTemplate.update()		
	}
}
