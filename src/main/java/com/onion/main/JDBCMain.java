package com.onion.main;

import com.onion.main.util.DBConnection;

public class JDBCMain {
	public static void main(String[] args) {
		System.out.println("Start");
		
		DBConnection conn = new DBConnection();
		
		try {
			conn.getConnection();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		System.out.println("Finish");
	}
}
