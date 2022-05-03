package com.endavel.eventsdava.validations;

public class EventsValidations {
	
	public static boolean isValidId(String id) {
		return id.matches("^([0-9a-f]{8}+[-])+([0-9a-f]{4}+[-])+([0-9a-f]{4}+[-])+([0-9a-f]{4}+[-])+([0-9a-f]{12})");
		}
	
	public boolean isValidName(String name) {
		if (!name.isBlank() && name.matches("^[-a-zA-Z]{2,}")) { 
			return true; 
		}
		return false;
	}
	
	public boolean isValidType(String type) {
		if (!type.isBlank()) { 
			return true; 
		}
		return false;
	}
	
	public boolean isValidLocation(String location) {
		if (!location.isBlank()) { 
			return true; 
		}
		return false;
	}
	
	public boolean isValidDescription(String description) {
		if (!description.isBlank()) { 
			return true; 
		}
		return false;
	}
	
}
