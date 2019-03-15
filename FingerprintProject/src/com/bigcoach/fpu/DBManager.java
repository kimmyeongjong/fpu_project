package com.bigcoach.fpu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	// declare
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?autoReconnect=true&amp;serverTimezone=UTC";
	
	private final String USER_NAME = "root";
	private final String PASSWORD = "1234";
			
	public DBManager() {
		Connection conn = null;
		Statement state = null;
		
		try {
			//Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것
			Class.forName(JDBC_DRIVER);
			// 접속
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("MySQL Connection");
			state = conn.createStatement();
			
			
		} catch(ClassNotFoundException e) {
			
		} catch(SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
