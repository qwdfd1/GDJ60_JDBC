package com.onion.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception {
		
		//1.접속 정보 준비
		// (1). id
		String userName = "hr";
		
		// (2). pw
		String password = "hr";
		
		// (3). url
//		String url = "jdbc:oracle:thin:@ip:port/ServiceName";
//		String url = "jdbc:oracle:thin:@ip:port/SID";
		String url = "jdbc:oracle:thin:@192.168.1.123:1521/XEPDB1";
		
		// (4). 드라이버 가져오기
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//2. db 연결 성공 시 Connection 객체 생성
		Connection conn = DriverManager.getConnection(url, userName, password);
		
		return conn;
	
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		rs.close();
		ps.close();
		conn.close();
	}
	
	public static void disConnect(PreparedStatement ps, Connection conn) throws Exception {
		ps.close();
		conn.close();
	}
}
