package com.onion.main.departments;

import java.util.Scanner;

public class DepartmentInput {
	private Scanner sc;
	
	
	
	public DepartmentInput() {
		sc = new Scanner(System.in);
	}



	public DepartmentDTO updateData() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("수정할 부서 번호 입력 : ");
		departmentDTO.setDepartment_id(sc.nextInt());
		
		System.out.println("수정할 부서 이름 입력 : ");
		departmentDTO.setDepartment_name(sc.next());
		
		System.out.println("수정할 매니저 번호 입력 : ");
		departmentDTO.setManager_id(sc.nextInt());
		
		System.out.println("수정할 지역 번호 입력 : ");
		departmentDTO.setLocation_id(sc.nextInt());
		
		return departmentDTO;
		
	}
	
	public DepartmentDTO setData() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("부서명 입력");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("매니저 번호 입력");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.println("지역번호 입력");
		departmentDTO.setLocation_id(sc.nextInt());
		
		//입력 받은걸 여기서 쓸건 아니니까 리턴해서 결과값 돌려주기
		return departmentDTO;
	}
	
	public DepartmentDTO deleteData() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("삭제할 부서번호 입력");
		departmentDTO.setDepartment_id(sc.nextInt());
		
		return departmentDTO;
	}
}
