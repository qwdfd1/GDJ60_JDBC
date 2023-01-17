package com.onion.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection() throws Exception {
		//1. id
		String userName = "hr";
		
		//2. pw
		String password = "hr";
		
		//3. url
		String url = "jdbc:oracle:thin:@192.168.1.79:1521/XEPDB1";
		
		//4. driver
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//로그인 성공 시 Connection 객체 생성
		Connection con = DriverManager.getConnection(url, userName, password);
		
		String sql = "SELECT * FROM LOCATIONS";
		
		//쿼리문 동기화
		PreparedStatement ps = con.prepareStatement(sql); 
		
		//쿼리 실행, 결과 객체에 담음
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(0) + "\t");
			System.out.print(rs.getString(1) + "\t");
//			System.out.print(rs.getInt("MANAGER_ID") + "\t");
//			System.out.println(rs.getInt("LOCATION_ID"));
			
		}
	}
}
