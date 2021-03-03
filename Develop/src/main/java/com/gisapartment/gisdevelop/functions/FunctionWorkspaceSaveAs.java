package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.utilities.WorkspaceUtilities;

import javax.swing.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FunctionWorkspaceSaveAs extends Function {

	public FunctionWorkspaceSaveAs(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		WorkspaceUtilities.saveAsWorkspace();
	}
}
