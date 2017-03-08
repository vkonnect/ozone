package com.vkonnect.ozone.utils;

public class StringUtils {
	public static String isEmpty(String value) {
		if(isBlank(value)) {
			return "";
		} else { 
			return value.trim();
		}
	}
	
	public static boolean isBlank(String value) {
		if(value == null || value == "" || value == " " || value == "null") {
			return true;
		} else if(value != null && value.trim().length() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBlank(Object value) {
		if(value == null || value == "" || value == " " || value == "null") {
			return true;
		} else if(value != null && value.toString().trim().length() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBlank(StringBuffer value) {
		if(value == null) {
			return true;
		} else if(value != null && value.length() == 0){
			return true;
		} else {
			return false;
		}
	}
	public static boolean isBlank(String[] value) {
		if(value == null) {
			return true;
		} else if(value != null && value.length == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isInteger(String value) {
		try {
			if(!StringUtils.isBlank(value) && value.trim().length() > 0) {
				Integer.parseInt(value.trim());
			}
			if(StringUtils.isBlank(value))
				return false;
		} catch (NumberFormatException nfex) {
			return false;
		}
		return true;
	}
	
	public static boolean isInteger(Object value) {
		try {
			if(!StringUtils.isBlank(value)) {
				Integer.parseInt(value.toString());
			}
			if(StringUtils.isBlank(value))
				return false;
		} catch (NumberFormatException nfex) {
			return false;
		}
		return true;
	}
	
	public static String replaceSingleQuote(String value) {
		if(!isBlank(value)) {
			value = value.replaceAll("\'", "");
		}
		return value;
	}
}
