package com.mythri.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils implements Serializable{
	private static final long serialVersionUID = 8012911099749560362L;
	static Connection con = null;
	public static void main(String[] args) {
		getConnection();
	}

	public static Connection getConnection() {
		// 1. Loading the Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			System.out.println("error  :" + e.getMessage());
		}
		return con;
	}

	public static int executeQuery(String sql) {
		int res = 0;
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			res = st.executeUpdate(sql);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return res;
	}

	public static ResultSet getResult(String sql) {
		ResultSet rs = null;
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeConnection() {
		// 1. Loading the Driver
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("error  :" + e.getMessage());
		}
	}
}
