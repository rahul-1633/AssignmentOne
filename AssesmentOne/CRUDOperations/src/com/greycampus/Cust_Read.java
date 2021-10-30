package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cust_Read {
	public ArrayList<Cust_Details> getAllData() {

		Connection connection = null;
		Statement createStatement = null;
		ResultSet resultSet = null;
		ArrayList<Cust_Details> customerList = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
			createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery("select * from customer_details");
			customerList = new ArrayList<Cust_Details>();
			while (resultSet.next()) {

				Cust_Details cust_data = new Cust_Details();

				cust_data.setCid(resultSet.getInt("cid"));
				cust_data.setFristname(resultSet.getString("firtname"));
				cust_data.setLastname(resultSet.getString("lastname"));
				cust_data.setStreet(resultSet.getString("street"));
				cust_data.setCity(resultSet.getString("city"));
				cust_data.setState(resultSet.getString("state"));
				cust_data.setZipcode(resultSet.getInt("zipcode"));
				cust_data.setProdut_name(resultSet.getString("product_name"));
				cust_data.setCreated_on(resultSet.getDate("created_on"));
				cust_data.setCreated_by(resultSet.getString("created_by"));
				cust_data.setUpdated_on(resultSet.getDate("updated_on"));
				cust_data.setUpdated_by(resultSet.getString("updated_by"));
			
				customerList.add(cust_data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				createStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
			try {
				resultSet.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return customerList;
	}
}