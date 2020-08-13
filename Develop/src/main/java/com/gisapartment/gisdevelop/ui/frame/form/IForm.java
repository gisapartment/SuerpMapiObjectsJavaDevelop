package com.gisapartment.gisdevelop.ui.frame.form;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public interface IForm {

	String getTitle();

	void setTitle(String title);

	boolean save();

	boolean isNeedSave();

	void setNeedSave(boolean needSave);

	boolean close();

	String getFormType();
}
