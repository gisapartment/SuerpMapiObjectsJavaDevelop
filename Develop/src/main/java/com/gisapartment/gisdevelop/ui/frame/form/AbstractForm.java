package com.gisapartment.gisdevelop.ui.frame.form;

import javax.swing.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public abstract class AbstractForm extends JPanel implements IForm {

	protected String title = "";
	protected boolean needSave = true;

	public AbstractForm(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean isNeedSave() {
		return this.needSave;
	}

	@Override
	public void setNeedSave(boolean needSave) {
		this.needSave = needSave;
	}
}
