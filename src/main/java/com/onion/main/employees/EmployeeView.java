package com.onion.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	public void listView(ArrayList<EmployeeDTO> employeeDTOs) {
		System.out.println("사원\t번호\t성\t이름\t직군\t부서번호");
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			System.out.print(employeeDTO.getEmployee_id() + "\t");
			System.out.print(employeeDTO.getLast_name() + "\t");
			System.out.print(employeeDTO.getFirst_name() + "\t");
			System.out.print(employeeDTO.getJob_id() + "\t");
			System.out.println(employeeDTO.getDepartment_id());
		}
		
	}
	
	public void view(EmployeeDTO employeeDTO) {
		System.out.print(employeeDTO.getEmployee_id() + "\t");
		System.out.print(employeeDTO.getFirst_name() + "\t");
		System.out.print(employeeDTO.getLast_name() + "\t");
		System.out.print(employeeDTO.getEmail() + "\t");
		System.out.print(employeeDTO.getPhone_number() + "\t");
		System.out.print(employeeDTO.getHire_date() + "\t");
		System.out.print(employeeDTO.getJob_id() + "\t");
		System.out.print(employeeDTO.getSalary() + "\t");
		System.out.print(employeeDTO.getCommission_pct() + "\t");
		System.out.print(employeeDTO.getManager_id() + "\t");
		System.out.println(employeeDTO.getDepartment_id() + "\t");
	}
	
	public void view(ArrayList<EmployeeDTO> employeeDTOs) {
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			view(employeeDTO);
		}
	}
	
	
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
