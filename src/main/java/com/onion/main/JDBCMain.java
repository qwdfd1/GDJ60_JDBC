package com.onion.main;

import java.util.ArrayList;

import com.onion.main.departments.DepartmentController;
import com.onion.main.departments.DepartmentDAO;
import com.onion.main.departments.DepartmentDTO;
import com.onion.main.employees.EmployeeController;
import com.onion.main.locations.LocationController;
import com.onion.main.locations.LocationDAO;
import com.onion.main.locations.LocationDTO;
import com.onion.main.util.DBConnection;

public class JDBCMain {
	public static void main(String[] args) {
		System.out.println("Start");
		
//		DepartmentController departmentController = new DepartmentController();
//		try {
//			departmentController.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		LocationController locationController = new LocationController();
//		try {
//			locationController.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		EmployeeController employeeController = new EmployeeController();
		try {
			employeeController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Finish");
	}
}
