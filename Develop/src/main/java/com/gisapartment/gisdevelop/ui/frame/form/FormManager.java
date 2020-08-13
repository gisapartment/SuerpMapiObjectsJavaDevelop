package com.gisapartment.gisdevelop.ui.frame.form;

import com.gisapartment.gisdevelop.ui.frame.FormContainer;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FormManager {

	private FormContainer formContainer;
	private IFormFactory formFactory = new FormFactory();
	private ArrayList<IForm> forms = new ArrayList<IForm>();

	public FormManager(FormContainer formContainer) {
		this.formContainer = formContainer;
	}

	public void setFormFactory(IFormFactory formFactory) {
		this.formFactory = formFactory;
	}

	public IForm createForm(String formType, String title) {
		IForm form = this.formFactory.createForm(formType, title);
		this.formContainer.addTab(form.getTitle(), (Component) form);
		this.forms.add(form);
		return form;
	}

	public void removeForm(IForm form) {
		this.formContainer.remove((Component) form);
		this.forms.remove(form);
	}

	public IForm getActiveForm() {
		return (IForm) this.formContainer.getSelectedComponent();
	}

}
