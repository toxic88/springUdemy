package com.toxic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEntryPoint {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		System.out.println("Connecting to databse!");
		
		try {
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection has been created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
