package com.onion.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onion.main.departments.DepartmentDAO;
import com.onion.main.departments.DepartmentDTO;
import com.onion.main.locations.LocationDAO;
import com.onion.main.locations.LocationDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("departments")

	public void getDepartments(Model model) throws Exception {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		ArrayList<DepartmentDTO> departmentDTOs = departmentDAO.getList();
		
		model.addAttribute("list", departmentDTOs);

	}
	
	@RequestMapping("locations")
	public void getLocations() throws Exception {
		LocationDAO locationDAO = new LocationDAO();
		ArrayList<LocationDTO> locationDTOs = locationDAO.getList();
		
	}
	
}
