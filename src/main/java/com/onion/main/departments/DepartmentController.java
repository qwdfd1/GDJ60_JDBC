package com.onion.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	private ArrayList<DepartmentDTO> departmentDTOs;
	
	public DepartmentController() {
		this.sc = new Scanner(System.in);
		this.departmentDAO = new DepartmentDAO();
		this.departmentView = new DepartmentView();
		this.departmentInput = new DepartmentInput();
		this.departmentDTOs = new ArrayList<DepartmentDTO>();
	}

	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서 리스트 2. 부서상세정보 3.부서 추가 4. 부서 삭제 5. 부서 수정 6. 종료");
			int select = sc.nextInt();
			int result;
			DepartmentDTO departmentDTO = null;
			
			switch (select) {
			
			//부서 리스트
			case 1:
				try {
					departmentDTOs = departmentDAO.getList();
					departmentView.view(departmentDTOs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			//부서상세정보	
			case 2:
				System.out.println("부서 수정");
				select = sc.nextInt();
					departmentDTO = departmentDAO.getDetail(select);
					if(departmentDTO != null) {
						departmentView.view(departmentDTO);	
					}
					else {
						departmentView.view("해당하는 부서가 없습니다.");	
					}
					
				break;
				
			case 3:
				System.out.println("부서 추가");
				departmentDTO = departmentInput.setData();
				select = departmentDAO.setData(departmentDTO);
				if(select > 0) {
					departmentView.view("추가 성공");
				}
				else {
					departmentView.view("추가 실패");
				}
				break;
				
			case 4:
				System.out.println("부서 삭제");
				departmentDTO = departmentInput.deleteData();
				select = departmentDAO.deleteData(departmentDTO);
				if(select > 0) {
					departmentView.view("삭제 성공");
				}
				else {
					departmentView.view("삭제 실패");
				}
				
				break;
				
			case 5:
				departmentDTO = departmentInput.updateData();
				select = departmentDAO.updateData(departmentDTO);
				if(select > 0) {
					departmentView.view("수정 성공");
				}
				else {
					departmentView.view("수정 실패");
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
