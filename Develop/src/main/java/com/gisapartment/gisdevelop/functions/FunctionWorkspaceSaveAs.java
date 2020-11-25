package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.utilities.WorkspaceUtilities;

import javax.swing.*;

public class FunctionWorkspaceSaveAs extends Function {

	public FunctionWorkspaceSaveAs(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		WorkspaceUtilities.saveAsWorkspace();
	}
}
