package com.offs.main;

import java.util.List;

import com.offs.main.pojo.Employee;
import com.offs.main.repository.EmployeeCRUDRepository;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		EmployeeCRUDRepository crudRepository = new EmployeeCRUDRepository();

//		Employee employee = new Employee(6, "Vikas", 1000);
//		boolean result = crudRepository.addNewEmployee(employee);
//		if (result) {
//			System.out.println("Employee recored inserted successfully");
//		} else {
//			System.out.println("Failed to add employee");
//		}

//		List<Employee> allEmployees = crudRepository.getAllEmployees();
//		for (Employee employee : allEmployees) {
//			System.out.println(employee);
//		}
//		System.out.println();
//		System.out.println();
//
////		System.out.println("Deleteing Employee");
////		
////		crudRepository.deleteEmployee(1);
//		Employee employeeUpdate = new Employee(2, "Dhruvil Shah", 2000);
//		crudRepository.updateEmployee(employeeUpdate);
//
//		System.out.println("After update");
//		System.out.println();
//		System.out.println();
//
//		allEmployees = crudRepository.getAllEmployees();
//		for (Employee employee : allEmployees) {
//			System.out.println(employee);
//		}

		Employee employee = crudRepository.getEmployeeByEmployeeId(3);
		System.out.println(employee);

	}
}
