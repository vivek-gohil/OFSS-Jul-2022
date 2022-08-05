package com.ofss.main.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ofss.main.pojo.Employee;

public class EmployeeRepository {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

	public boolean addNewEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	public Employee getSingleEmployee(int employeeId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

	public boolean updateEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employeeFromTable = entityManager.find(Employee.class, employee.getEmployeeId());
		int flag = 0;
		if (employeeFromTable != null) {
			employeeFromTable.setName(employee.getName());
			employeeFromTable.setSalary(employee.getSalary());
			flag = 1;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		if (flag == 1)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(int employeeId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employeeFromTable = entityManager.find(Employee.class, employeeId);
		int flag = 0;
		if (employeeFromTable != null) {
			entityManager.remove(employeeFromTable);
			flag = 1;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		if (flag == 1)
			return true;
		else
			return false;
	}

	public List<Employee> getAllEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM employee_details e");
		List<Employee> employeeList = query.getResultList();

		return employeeList;
	}

}
