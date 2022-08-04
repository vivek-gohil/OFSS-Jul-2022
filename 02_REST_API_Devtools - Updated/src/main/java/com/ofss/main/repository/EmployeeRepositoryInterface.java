package com.ofss.main.repository;

import java.util.List;

import com.ofss.main.pojo.Employee;

public interface EmployeeRepositoryInterface {
	boolean addNewEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	boolean deleteEmployee(int employeeId);
	Employee getEmployee(int employeeId);
	List<Employee> getAllEmployees();
}
