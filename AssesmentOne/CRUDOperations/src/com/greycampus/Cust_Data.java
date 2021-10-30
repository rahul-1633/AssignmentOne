package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cust_Data {

	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prepstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
			prepstmt = conn.prepareStatement("insert into customer_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			prepstmt.setInt(1, 1);
			prepstmt.setString(2, "Rahul");
			prepstmt.setString(3, "Sharma");
			prepstmt.setString(4, "Gali no:4");
			prepstmt.setString(5, "Panipat");
			prepstmt.setString(6, "Haryana");
			prepstmt.setInt(7, 132103);
			prepstmt.setString(8, "OnePlus Watch");
			prepstmt.setDate(9, getCurrentDate());
			prepstmt.setString(10, "Raj");
			prepstmt.setDate(11, getCurrentDate());
			prepstmt.setString(12, "Raman");

			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				prepstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

}