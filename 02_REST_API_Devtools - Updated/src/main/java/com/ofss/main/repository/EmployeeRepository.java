package com.ofss.main.repository;

import java.util.ArrayList;
import java.util.List;

import com.ofss.main.pojo.Employee;

public class EmployeeRepository implements EmployeeRepositoryInterface {
	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeRepository() {
		Employee employee1 = new Employee(101, "Vivek Gohil", 1000);
		Employee employee2 = new Employee(102, "Samarth Patil", 1000);
		Employee employee3 = new Employee(103, "Trupti Acharekar", 1000);

		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);

	}

	@Override
	public boolean addNewEmployee(Employee employee) {
		boolean result = employeeList.add(employee);
		return result;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		for (Employee e : employeeList) {
			if (e.getEmployeeId() == employee.getEmployeeId()) {
				e.setName(employee.getName());
				e.setSalary(employee.getSalary());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}
