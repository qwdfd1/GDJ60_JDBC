package com.onion.main.departments;

import java.util.ArrayList;

public class DepartmentView {

	public void view(String msg) {
		System.out.println(msg);
	}
	
	public void view (ArrayList<DepartmentDTO> departmentDTOs) {
		for (DepartmentDTO departmentDTO : departmentDTOs) {
			view(departmentDTO);
		}
	}
	
	public void view (DepartmentDTO departmentDTO) {
	
		System.out.print(departmentDTO.getDepartment_id() + "\t");
		System.out.print(departmentDTO.getDepartment_name() + "\t");
		System.out.print(departmentDTO.getManager_id() + "\t");
		System.out.println(departmentDTO.getLocation_id());
	}
}
