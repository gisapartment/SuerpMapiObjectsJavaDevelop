package com.gisapartment.gisdevelop;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class Startup {
	public static void main(String[] args) {
		try {
			if (!Application.getApplication().startup()) {
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
