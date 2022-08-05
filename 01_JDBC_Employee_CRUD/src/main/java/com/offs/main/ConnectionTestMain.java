package com.offs.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTestMain {
	public static void main(String[] args) {

		String url = "jdbc:mysql://192.168.0.155:3306/ofssdb";
		String user = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is successfull with MySQL Database");
			connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println("Connection Failed");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

	}
}
