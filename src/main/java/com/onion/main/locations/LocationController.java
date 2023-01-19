package com.onion.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	private ArrayList<LocationDTO> locationDTOs;
	
	
	
	public LocationController() {
		sc = new Scanner(System.in);
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		locationInput = new LocationInput();
		locationDTOs = new ArrayList<LocationDTO>();
	}

	public void start() throws Exception {
		boolean check = true;
			
		while(check) {
			System.out.println("1. 전체지역정보 2. 상세지역 정보 3. 주소 검색 4. 지역 추가 5. 지역 삭제  6. 지역 수정 7. 종료");
			int select = sc.nextInt();
			String add = "";
			LocationDTO locationDTO;
			
			switch (select) {
			
			//전체지역정보
			case 1:
					locationDTOs = locationDAO.getList();
					locationView.view(locationDTOs);
				break;
				
			//지역 상세정보	
			case 2:
				System.out.println("지역번호를 입력하세요");
				select = sc.nextInt();
				
					locationDTO = locationDAO.getDetail(select);
					if(locationDTO != null) {
						locationView.view(locationDTO);	
					}
					else {
						System.out.println("해당하는 지역이 없습니다");
					}
				break;
				
			// 주소 검색
			case 3:
				System.out.println("검색할 주소 입력");
				add = sc.next();
				locationDTOs = locationDAO.getFind(add);
				break;
				
			case 4:
				System.out.println("추가할 지역 입력");
				locationDTO = locationInput.setData();
				select = locationDAO.setData(locationDTO);
				if(select > 0) {
					locationView.view("추가 성공");
				}
				else {
					locationView.view("추가 실패");
				}
				break;
				
			case 5:
				System.out.println("삭제할 지역 입력");
				locationDTO = locationInput.deleteData();
				select = locationDAO.deleteData(locationDTO);
				if(select > 0) {
					locationView.view("삭제 성공");
				}
				else {
					locationView.view("삭제 실패");
				}
				break;
				
			case 6:
				System.out.println("수정할 지역 입력");
				locationDTO = locationInput.updateData();
				select = locationDAO.updateData(locationDTO);
				if(select > 0) {
					locationView.view("수정 성공");
				}
				else {
					locationView.view("수정 실패");
				}
				break;
				
			default:
				System.out.println("프로그램을 종료합니다");
				check = false;
				break;
			}
		}
		
		
	}
}
