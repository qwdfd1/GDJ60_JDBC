package com.onion.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.prefs.PreferenceChangeEvent;

import com.onion.main.employees.EmployeeDTO;
import com.onion.main.locations.LocationDTO;
import com.onion.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class DepartmentDAO {
	
	//부서 리스트 받아오기
	public ArrayList<DepartmentDTO> getList() throws Exception {
		
		ArrayList<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>(); 
		
		Connection conn = DBConnection.getConnection();

		//3. Query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		//4. QUERY문 미리 전송
		PreparedStatement ps = conn.prepareStatement(sql);
		//5. 바인딩 변수 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
			departmentDTOs.add(departmentDTO);
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, ps, conn);
		
		return departmentDTOs;
		

	
	}

	//부서 상세정보 
	public DepartmentDTO getDetail(int department_id) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		DepartmentDTO departmentDTO = null;
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		// 쿼리문 미리 전송
		PreparedStatement ps = conn.prepareStatement(sql);
		
		// 바인딩 변수 값 대입
		ps.setInt(1, department_id);
		
		// 쿼리문 최종 전송 및 실행 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, ps, conn);
		
		return departmentDTO;
	}
	
	//부서 추가
	public int setData(DepartmentDTO departmentDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID , DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
	
		ps.setString(1, departmentDTO.getDepartment_name());
		ps.setInt(2, departmentDTO.getManager_id());
		ps.setInt(3, departmentDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	//부서 삭제
	public int deleteData(DepartmentDTO departmentDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, departmentDTO.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	//부서정보 수정
	public int updateData(DepartmentDTO departmentDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID = ?, LOCATION_ID =? "
				+ "WHERE DEPARTMENT_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, departmentDTO.getDepartment_name());
		ps.setInt(2, departmentDTO.getManager_id());
		ps.setInt(3, departmentDTO.getLocation_id());
		ps.setInt(4, departmentDTO.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		
		return result;
		
	}
	
	// 사원정보와 부서명 출력
	public DepartmentDTO getInfo() throws Exception {
		DepartmentDTO departmentDTO = null;
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D "
				+ "ON(E.DEPARTMENT_ID=D.DEPARTMENT_ID) "
				+ "WHERE E.EMPLOYEE_ID = 100";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			// 에러
//			departmentDTO.getEmployeeDTOs().get(0).setFirst_name(rs.getString("FIRST_NAME"));
			

			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			
//			null().add();
//			arraylist 객체 만들지 않으면 NUllPOINTER EXCEPTION
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
		
		return departmentDTO;
				
	}
	
	public void getInfos() throws Exception {
		
		Connection conn = DBConnection.getConnection();
		
		
		
		String sql = "SELECT e.FIRST_NAME , d.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES e"
				+ "	INNER JOIN"
				+ "	DEPARTMENTS d"
				+ "	USING (DEPARTMENT_ID) "
				+ "WHERE DEPARTMENT_ID = 30";
		
		
		PreparedStatement ps  = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
		
		while(rs.next()) {
			if (departmentDTO.getDepartment_name() == null) {
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
			
			
		}
		
	
	}
}
