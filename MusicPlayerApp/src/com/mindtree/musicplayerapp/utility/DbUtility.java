package com.mindtree.musicplayerapp.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.musicplayerapp.exception.db.DbConnection;
import com.mysql.jdbc.Connection;

public class DbUtility {
	Connection con;
	final String URL = "jdbc:mysql://localhost:3306/music";
	final String USERNAME = "root";
	final String PASSWORD = "Welcome123";

	public Connection getConnection() throws DbConnection {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DbConnection("Exception from database");
		}

		try {
			con = (Connection) DriverManager.getConnection(URL , USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new DbConnection("Exception from database");
		}

		return con;
	}
}
