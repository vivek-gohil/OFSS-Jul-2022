package com.ofss.main.service;

import java.util.List;

import com.ofss.main.pojo.Employee;

public interface EmployeeServiceInterface {
	boolean addNewEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(int employeeId);

	Employee getEmployee(int employeeId);

	List<Employee> getAllEmployees();
}
