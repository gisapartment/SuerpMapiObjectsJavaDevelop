package com.gisapartment.gisdevelop.ui.frame.form;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FormFactory implements IFormFactory {

	@Override
	public IForm createForm(String formType, String title) {
		if (FormType.MAP.equals(formType)) {
			return new FormMap(title);
		}
		return null;
	}


}
