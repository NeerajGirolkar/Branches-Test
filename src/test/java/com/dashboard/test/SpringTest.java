package com.dashboard.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dashboard.dao.EmployeeDao;
import com.dashboard.to.Account;
import com.dashboard.to.Employee;

public class SpringTest {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		EmployeeDao empDao = context.getBean("employeeDAO", EmployeeDao.class);
		
		Employee emp = new Employee();
		emp.setId(3);
		emp.setFirstName("Brandon");
		emp.setDepartment("Development");
		Account acc = new Account();
		acc.setAccountNo(321);
		acc.setBalance(50000);
		emp.setAccount(acc);
		empDao.save(emp);
		System.out.println(empDao.getAllEmployees().size());
		System.out.println(empDao.getById(2).getFirstName());
		

		EmployeeDao empDaoSupport = context.getBean("employeeDAOSupport", EmployeeDao.class);

		System.out.println(empDaoSupport.getAllEmployees().size());
	}
}
