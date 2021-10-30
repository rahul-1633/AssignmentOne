package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cust_Delete {

		public static void main(String[] args) {
			Connection conn = null;
			PreparedStatement prepstmt = null;
			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
				prepstmt = conn.prepareStatement("delete from customer_details where cid = 1 ");
				
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
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