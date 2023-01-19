package com.onion.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	
	public void view(LocationDTO locationDTO) {
		
		System.out.print(locationDTO.getLocation_id() + "\t");
		System.out.print(locationDTO.getStreet_address() + "\t");
		System.out.print(locationDTO.getPostal_code() + "\t");
		System.out.print(locationDTO.getCity() + "\t");
		System.out.print(locationDTO.getState_province() + "\t");
		System.out.println(locationDTO.getCountry_id());
	}
	
	public void view(ArrayList<LocationDTO> locationDTOs) {
		for (LocationDTO locationDTO : locationDTOs) {
			view(locationDTO);
		}
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
	
	
}
