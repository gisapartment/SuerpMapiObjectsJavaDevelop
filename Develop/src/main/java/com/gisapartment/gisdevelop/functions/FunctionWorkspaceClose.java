package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.core.Function;
import com.supermap.data.Workspace;

import javax.swing.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FunctionWorkspaceClose extends Function {

	public FunctionWorkspaceClose(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		Workspace workspace = Application.getApplication().getMainFrame().getWorkspaceComponentManager().getWorkspaceTree().getWorkspace();
		workspace.close();
		Application.getApplication().getMainFrame().getWorkspaceComponentManager().getWorkspaceTree().repaint();
	}
}
