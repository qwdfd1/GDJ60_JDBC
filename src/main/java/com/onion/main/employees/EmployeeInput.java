package com.onion.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	
	private Scanner sc;

	public EmployeeInput() {
		sc = new Scanner(System.in);
	}
	
	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("성을 입력하세요");
		employeeDTO.setLast_name(sc.next());
		
		System.out.println("이름을 입력하세요");
		employeeDTO.setFirst_name(sc.next());
		
		System.out.println("이메일을 입력하세요");
		employeeDTO.setEmail(sc.next());
		
		System.out.println("핻드폰 번호를 입력하세요. -도 입력");
		employeeDTO.setPhone_number(sc.next());
		
		System.out.println("날짜를 입력하세요 ex)2023-11-11 : ");
		employeeDTO.setHire_date(sc.next()); 
		
		System.out.println("직군을 입력하세요.");
		employeeDTO.setJob_id(sc.next());
		
		System.out.println("월급을 입력하세요");
		employeeDTO.setSalary(sc.nextInt());
		
		System.out.println("추가수당이 있을경우 입력해주세요. 없으면 0으로 입력");
		Double commission_pct = sc.nextDouble();
		if(commission_pct == 0.0) {
			commission_pct = null;
		}
		
		employeeDTO.setCommission_pct(commission_pct);
		
		System.out.println("상사 번호를 입력해주세요");
		employeeDTO.setManager_id(sc.nextInt());
		
		System.out.println("부서 번호를 입력해주세요.(10단위)    ---> ex) 10, 20, 30...");
		employeeDTO.setDepartment_id(sc.nextInt());
		
		
		
		return employeeDTO;
		
	}
	
	public EmployeeDTO deleteData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("삭제할 사원의 사원번호를 입력하세요");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		
		return employeeDTO;
		
		
	}
	
	public EmployeeDTO updateData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("수정할 사원의 사원번호를 입력하세요");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		System.out.println("사원의 수정할 성을 입력하세요");
		employeeDTO.setLast_name(sc.next());

		System.out.println("사원의 수정할 이름을 입력하세요");
		employeeDTO.setFirst_name(sc.next());
		
		System.out.println("사원의 수정할 핸드폰 번호를 입력하세요");
		employeeDTO.setPhone_number(sc.next());
		
		System.out.println("사원의 수정할 이메일을 입력하세요");
		employeeDTO.setEmail(sc.next());
		
		System.out.println("사원의 수정할 월급을 입력하세요");
		employeeDTO.setSalary(sc.nextInt());
		
		return employeeDTO;
	}
	
	
}
