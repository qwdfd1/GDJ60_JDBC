package com.onion.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.onion.main.util.DBConnection;

public class LocationDAO {
	

	public ArrayList<LocationDTO> getList() throws Exception {
		
		Connection conn = DBConnection.getConnection();
		
		ArrayList<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();

		//3. Query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		
		//4. QUERY문 미리 전송
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//5. 바인딩 변수 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			locationDTOs.add(locationDTO);
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return locationDTOs;
				
		
		
		//7. 연결 해제
	}
	
	public LocationDTO getDetail(int location_id) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		LocationDTO locationDTO = null;
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ? ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, location_id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
		}
		
		return locationDTO;
		
	}
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		ArrayList<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
		
		String sql = "SELECT  * FROM LOCATIONS WHERE STREET_ADDRESS LIKE '%||?||%'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, search);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));	
			
			locationDTOs.add(locationDTO);
		}
		
		DBConnection.disConnect(rs, ps, conn);
		
		return locationDTOs;
		
	}
	
	public int setData(LocationDTO locationDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
			
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID )\r\n"
	            + "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, locationDTO.getStreet_address());
		ps.setString(2, locationDTO.getPostal_code());
		ps.setString(3, locationDTO.getCity());
		ps.setString(4, locationDTO.getState_province());
		ps.setString(5, locationDTO.getCountry_id());
		
		int result = ps.executeUpdate();
		
		return result;
		
	}
	
	public int deleteData(LocationDTO locationDTO)throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, locationDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		
		return result;
	}
	
	public int updateData(LocationDTO locationDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS = ?, POSTAL_CODE = ? WHERE LOCATION_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, locationDTO.getStreet_address());
		ps.setString(2, locationDTO.getPostal_code());
		ps.setInt(3, locationDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnect(ps, conn);
		
		return result;
		
	}
	
}
