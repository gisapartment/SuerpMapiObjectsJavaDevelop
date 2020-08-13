package com.gisapartment.gisdevelop.ui.frame.form;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FormMap extends AbstractForm {

	public FormMap(String title) {
		super(title);
	}

	@Override
	public boolean save() {
		return false;
	}

	@Override
	public boolean close() {
		return false;
	}

	@Override
	public String getFormType() {
		return FormType.MAP;
	}
}
