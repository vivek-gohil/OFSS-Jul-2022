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
import com.ofss.main.repository.EmployeeRepositoryInterface;
import com.ofss.main.service.EmployeeService;
import com.ofss.main.service.EmployeeServiceInterface;

@CrossOrigin("*")
@RestController
@RequestMapping("employeeapi")
public class EmployeeController {
	EmployeeServiceInterface employeeServiceInterface = new EmployeeService();

	@RequestMapping(value = "allemployees", method = RequestMethod.GET)
	public List<Employee> printAllEmployees() {
		List<Employee> allEmployees = employeeServiceInterface.getAllEmployees();
		return allEmployees;
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public boolean addNewEmployee(@RequestBody Employee employee) {
		boolean result = employeeServiceInterface.addNewEmployee(employee);
		return result;
	}

	@RequestMapping(value = "{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeServiceInterface.getEmployee(employeeId);
		return employee;
	}

	@RequestMapping(value = "{employeeId}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int employeeId) {
		boolean result = employeeServiceInterface.deleteEmployee(employeeId);
		return result;
	}

	// update the name and salary by employeeId
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public boolean updateEmployee(@RequestBody Employee employee) {
		boolean result = employeeServiceInterface.updateEmployee(employee);
		return result;
	}

}
