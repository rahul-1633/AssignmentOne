package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cust_Update {

	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
			prepareStatement = connection.prepareStatement("update customer_details set street = ?, updated_by = ? , updated_on = ? where cid = ?");
			prepareStatement.setString(1, "Gali no: 44");
			prepareStatement.setString(2, "Siddharth");
			prepareStatement.setDate(3, getCurrentDate());
			prepareStatement.setInt(4, 1);
			prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
