package com.chaoxing.safe.safefilter.utils;

public class StringUtil {

	public static int parseInt(String str,int defaultValue) {
		if(isBlank(str)){
			return defaultValue;
		}
		try {
			return Integer.parseInt(str);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static String getNotNullString(String str) {
		if(str == null) {
			return "";
		}
		return str;
	}
	
	public static String getStringOrNull(String str) {
		if(str == null){
			return null;
		}
		if(str == "" || str.trim().length() == 0){
			return null;
		}
		return str;
	}
}
