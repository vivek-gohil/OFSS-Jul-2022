package com.ofss.main.repository;

import java.util.ArrayList;
import java.util.List;

import com.ofss.main.pojo.Employee;

public class EmployeeRepository {
	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeRepository() {
		Employee employee1 = new Employee(101, "Vivek Gohil", 1000);
		Employee employee2 = new Employee(102, "Samarth Patil", 1000);
		Employee employee3 = new Employee(103, "Trupti Acharekar", 1000);

		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);

	}

	public boolean addNewEmployee(Employee employee) {
		boolean result = employeeList.add(employee);
		return result;
	}

	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}
}
