package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.utilities.WorkspaceUtilities;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceType;

import javax.swing.*;

public class FunctionWorkspaceSave extends Function {

	public FunctionWorkspaceSave(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		Workspace workspace = Application.getApplication().getMainFrame().getWorkspaceComponentManager().getWorkspaceTree().getWorkspace();
		if (workspace.getType() == WorkspaceType.DEFAULT) {
			WorkspaceUtilities.saveAsWorkspace();
		} else {
			workspace.save();
		}
	}
}
