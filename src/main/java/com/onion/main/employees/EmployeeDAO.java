package com.onion.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.onion.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeeDAO {
	
	public ArrayList<Double> getAVG() throws Exception {
		Connection conn = DBConnection.getConnection();
		
		
		String sql = "SELECT AVG(SALARY) a, SUM(SALARY) b FROM EMPLOYEES";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		ArrayList<Double> result = new ArrayList<Double>();
 		
		rs.next();
		result.add(rs.getDouble("a"));
		result.add(rs.getDouble("b"));
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return result;

	}
	
	public ArrayList<EmployeeDTO> getList() throws Exception {
		ArrayList<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT EMPLOYEE_ID, LAST_NAME, FIRST_NAME, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			employeeDTOs.add(employeeDTO);
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return employeeDTOs;
		
	}
	
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		EmployeeDTO employeeDTO = null;
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, employee_id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return employeeDTO;
		
	}
	
	public ArrayList<EmployeeDTO> getDetail(String last_name) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		ArrayList<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "%" +last_name + "%");
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			employeeDTOs.add(employeeDTO);
			
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return employeeDTOs;
		
	}
	
	public int setData(EmployeeDTO employeeDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql;
		PreparedStatement ps;
		
		if(employeeDTO.getCommission_pct() == null) {
			sql = "INSERT INTO EMPLOYEES VALUES(EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, NULL, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeDTO.getFirst_name());
			ps.setString(2, employeeDTO.getLast_name());
			ps.setString(3, employeeDTO.getEmail());
			ps.setString(4, employeeDTO.getPhone_number());
			ps.setString(5, employeeDTO.getJob_id());
			ps.setInt(6, employeeDTO.getSalary());
			ps.setInt(7, employeeDTO.getManager_id());
			ps.setInt(8, employeeDTO.getDepartment_id());
		}
		else {
			sql = "INSERT INTO EMPLOYEES VALUES(EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeDTO.getFirst_name());
			ps.setString(2, employeeDTO.getLast_name());
			ps.setString(3, employeeDTO.getEmail());
			ps.setString(4, employeeDTO.getPhone_number());
			ps.setString(5, employeeDTO.getJob_id());
			ps.setInt(6, employeeDTO.getSalary());
			ps.setDouble(7, employeeDTO.getCommission_pct());
			ps.setInt(8, employeeDTO.getManager_id());
			ps.setInt(9, employeeDTO.getDepartment_id());
		}
		
	
		

		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		
		return result;
	}
	
	public int updateData(EmployeeDTO employeeDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, PHONE_NUMBER = ?, EMAIL = ?, SALARY = ?"
				+ "WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, employeeDTO.getFirst_name());
		ps.setString(2, employeeDTO.getLast_name());
		ps.setString(3, employeeDTO.getPhone_number());
		ps.setString(4, employeeDTO.getEmail());
		ps.setInt(5, employeeDTO.getSalary());
		ps.setInt(6, employeeDTO.getEmployee_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		System.out.println(result);
		
		return result;
	}
	
	public int deleteData(EmployeeDTO employeeDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, employeeDTO.getEmployee_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		
		return result;
	}
	

}
