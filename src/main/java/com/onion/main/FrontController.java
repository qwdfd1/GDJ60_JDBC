package com.onion.main;

import java.util.Scanner;

import com.onion.main.departments.DepartmentController;
import com.onion.main.employees.EmployeeController;
import com.onion.main.locations.LocationController;

public class FrontController {
	private Scanner sc;
	DepartmentController departmentController;
	LocationController locationController;
	EmployeeController employeeController;

	public FrontController() {
		sc = new Scanner(System.in);
		departmentController = new DepartmentController();
		locationController = new LocationController();
		employeeController = new EmployeeController();
	}
	
	public void start() throws Exception
	{
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서관리 2. 지역관리 3. 사원관리 4. 종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				departmentController.start();
				break;
				
			case 2:
				locationController.start();
				break;
				
			case 3:
				employeeController.start();
				break;
	
			default:
				System.out.println("프로그램을 종료합니다");
				check = false;
				break;
			}
			
			
		}
		
	}
	
}
