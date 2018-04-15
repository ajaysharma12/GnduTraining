package com.gndu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public Connection getConnection() {
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/gndudepartments?user=root&password=");
			System.out.println(connect.toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connect;
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int employeeId = resultSet.getInt("id");
            String employeeName = resultSet.getString("name");
            String employeeDept = resultSet.getString("dept");
            int employeeSalary = resultSet.getInt("Salary");
            System.out.println("Id: " + employeeId);
            System.out.println("Name: " + employeeName);
            System.out.println("Department: " + employeeDept);
            System.out.println("Salary: " + employeeSalary);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
	}

	public void readEmployees(Connection connect) {
		ResultSet resultSet = null;
		try {
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from gndudepartments.employee");
			writeResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatabaseConnection dc = new DatabaseConnection();
		Connection dbConnection = dc.getConnection();
		dc.readEmployees(dbConnection);
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
