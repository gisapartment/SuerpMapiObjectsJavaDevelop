package com.gisapartment.gisdevelop.utilities;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class StringUtilities {

	private StringUtilities() {

	}

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
}
