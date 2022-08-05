package com.offs.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.offs.main.pojo.Employee;

public class EmployeeCRUDRepository {
	private String driverClass = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String url = "jdbc:mysql://192.168.0.155:3306/ofssdb";
	private String password = "root";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private String INSERT_NEW_EMPLOYEE = "INSERT INTO employee_details VALUES(?,?,?)";
	private String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details";
	private String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id = ?";
	private String UPDATE_EMPLOYEE = "UPDATE employee_details SET name = ? , salary = ? WHERE employee_id = ?";
	private String SELECT_ONE_EMPLOYEE = "SELECT * FROM employee_details WHERE employee_id = ?";

	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(SELECT_ONE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);
			
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int employeeIdTemp = resultSet.getInt("employee_id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");

				Employee employee = new Employee(employeeIdTemp, name, salary);
				return employee;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean updateEmployee(Employee employee) {
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());
			preparedStatement.setInt(3, employee.getEmployeeId());

			int count = preparedStatement.executeUpdate();

			if (count > 0)
				return true;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteEmployee(int employeeId) {
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);

			int count = preparedStatement.executeUpdate();

			if (count > 0)
				return true;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	public List<Employee> getAllEmployees() {
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			resultSet = preparedStatement.executeQuery();

			List<Employee> employeeList = new ArrayList<Employee>();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");

				Employee employee = new Employee(employeeId, name, salary);
				employeeList.add(employee);
			}

			return employeeList;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean addNewEmployee(Employee employee) {

		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());

			int count = preparedStatement.executeUpdate();

			if (count > 0)
				return true;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
