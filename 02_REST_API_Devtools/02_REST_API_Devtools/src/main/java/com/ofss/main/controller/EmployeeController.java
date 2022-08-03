package com.ofss.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.pojo.Employee;
import com.ofss.main.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("employeeapi")
public class EmployeeController {
	EmployeeRepository employeeRepository = new EmployeeRepository();

	@RequestMapping(value = "allemployees", method = RequestMethod.GET)
	public List<Employee> printAllEmployees() {
		List<Employee> allEmployees = employeeRepository.getAllEmployees();
		return allEmployees;
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public boolean addNewEmployee(@RequestBody Employee employee) {
		boolean result = employeeRepository.addNewEmployee(employee);
		return result;
	}

	@RequestMapping(value = "{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
		return employee;
	}
}
