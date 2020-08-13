package com.gisapartment.gisdevelop.core;

import javax.swing.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public abstract class Function implements IFunction {

	private JComponent component;

	public Function(JComponent component) {
		this.component = component;
	}

	public final void doRun() {
		run();
	}

	protected abstract void run();

	public boolean enabled() {
		return true;
	}

	public boolean checked() {
		return true;
	}
}
