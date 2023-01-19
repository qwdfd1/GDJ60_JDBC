package com.onion.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	Scanner sc;
	EmployeeDAO employeeDAO;
	ArrayList<EmployeeDTO> employeeDTOs;
	EmployeeView employeeView;
	EmployeeInput employeeInput;
	EmployeeDTO employeeDTO;
	
	
	
	
	public EmployeeController() {
		sc = new Scanner(System.in);
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		employeeInput = new EmployeeInput();
		employeeDTOs = null;

	}
	
	

	public void start() throws Exception {
		
		boolean check = true;
		System.out.println("메뉴를 골라주세요");
		
		while(check) {
			System.out.println("1. 사원정보 리스트 2. 개별 사원정보 3.사원검색 4.사원정보 추가 5. 사원정보 수정 6. 사원정보 삭제 7. 종료");
			int select = sc.nextInt();
			employeeDTO = null;
			
			switch (select) {
			case 1:
				employeeDTOs = employeeDAO.getList();
				employeeView.listView(employeeDTOs);
//				employeeDAO.getAVG();
				break;
				
			case 2:
				System.out.println("검색을 원하는 사원의 번호를 입력하세요");
				select = sc.nextInt();
				employeeDTO = employeeDAO.getDetail(select);
				
				if(employeeDTO != null) {
					employeeView.view(employeeDTO);;
				}
				else {
					employeeView.view("일치하는 사원이 없습니다.");
				}
				break;
			case 3:
				System.out.println("검색을 원하는 사원의 성을 입력하세요");
				String name = sc.next();
				
				employeeDTOs = employeeDAO.getDetail(name);
				
				if(employeeDTOs.size() != 0) {
					employeeView.view(employeeDTOs);	
				}
				else {
					employeeView.view("일치하는 사원이 없습니다");
				}
				break;
			case 4:
				System.out.println("사원정보 추가");
				employeeDTO = employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if(select > 0) {
					employeeView.view("추가 성공");
				}
				else {
					employeeView.view("추가 실패");	
				}
				break;
			case 5:
				System.out.println("사원정보 수정");
				employeeDTO = employeeInput.updateData();
				select = employeeDAO.updateData(employeeDTO);
				if(select > 0) {
					employeeView.view("수정 성공");
				}
				else {
					employeeView.view("수정 실패");	
				}
				
				break;
				
			case 6:
				System.out.println("사원정보 삭제");
				employeeDTO = employeeInput.deleteData();
				select = employeeDAO.deleteData(employeeDTO);
				if(select > 0) {
					employeeView.view("삭제 성공");
				}
				else {
					employeeView.view("삭제 실패");	
				}
				break;
			

			default:
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
		}
		
		
		
		
	}
}
