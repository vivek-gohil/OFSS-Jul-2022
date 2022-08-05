package com.ofss.main;

import com.ofss.main.pojo.Employee;
import com.ofss.main.repository.EmployeeRepository;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();

//		Employee employee = new Employee(7, "Chaitanya Shukla", 1000);
//		employeeRepository.addNewEmployee(employee);
//		System.out.println("Check your table!!");

//		Employee employee = employeeRepository.getSingleEmployee(2);
//		System.out.println(employee);

//		Employee employee = new Employee(7, "Chaitanya", 2500);
//		boolean result = employeeRepository.updateEmployee(employee);
//		if (result)
//			System.out.println("Updated successfully");
//		else
//			System.out.println("Failed to update");
//
//		boolean result = employeeRepository.deleteEmployee(7);
//		if (result)
//			System.out.println("Deleted successfully");
//		else
//			System.out.println("Failed to Delete");

		for (Employee employee : employeeRepository.getAllEmployees()) {
			System.out.println(employee);
		}

	}
}
