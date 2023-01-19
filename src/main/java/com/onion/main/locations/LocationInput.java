package com.onion.main.locations;

import java.util.Scanner;

import com.onion.main.departments.DepartmentDTO;

public class LocationInput {
	private Scanner sc;
	
	
	public LocationInput() {
		sc = new Scanner(System.in);
	}


	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("주소 입력 : ");
		locationDTO.setStreet_address(sc.next());
		
		System.out.println("우편번호 입력 : ");
		locationDTO.setPostal_code(sc.next());
		
		System.out.println("도시이름 입력 : ");
		locationDTO.setCity(sc.next());
		
		System.out.println("주 이름 입력 : ");
		locationDTO.setState_province(sc.next());
		
		System.out.println("나라 이름 입력 : ex) KR, JP.. ");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
			
	}
	
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("삭제할 지역번호를 입력하세요");
		locationDTO.setLocation_id(sc.nextInt());
		
		return locationDTO;
	}
	
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("수정할 지역번호 입력 : ");
		locationDTO.setLocation_id(sc.nextInt());
		
		System.out.println("수정할 주소 입력 : ");
		locationDTO.setStreet_address(sc.next());
		
		System.out.println("수정할 우편번호 입력 : ");
		locationDTO.setPostal_code(sc.next());
		
		return locationDTO;
		
		
	}
}
