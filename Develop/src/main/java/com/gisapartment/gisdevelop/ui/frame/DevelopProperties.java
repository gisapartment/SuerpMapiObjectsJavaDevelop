package com.gisapartment.gisdevelop.ui.frame;

import java.util.ResourceBundle;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class DevelopProperties {

	public static String getProperty(String key) {
		String result = null;
		try {
			result = ResourceBundle.getBundle("Develop").getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
