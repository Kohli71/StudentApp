package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.nt.bo.StudentBO;

public class StudentDAO {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/student_form", "root", "root");
		} catch (Exception e) {
			System.out.println("Invalid Driver name or database details");
		}
		return connection;
	}

	public int save(StudentBO studentBO) {
		int status = 0;
		try {
			Connection connection = StudentDAO.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO student_result VALUES (?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, studentBO.getRollNumber());
			preparedStatement.setString(2, studentBO.getName());
			preparedStatement.setLong(3, studentBO.getTotal());
			preparedStatement.setDouble(4, studentBO.getAverage());
			preparedStatement.setString(5, studentBO.getResult());

			status = preparedStatement.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.out.println("Invalid data");
		}
		return status;
	}
}
