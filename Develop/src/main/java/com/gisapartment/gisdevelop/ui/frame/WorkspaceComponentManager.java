package com.gisapartment.gisdevelop.ui.frame;

import com.supermap.ui.WorkspaceTree;

import javax.swing.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class WorkspaceComponentManager extends JScrollPane {

	private WorkspaceTree workspaceTree;

	public WorkspaceComponentManager() {
		initComponents();
		initComponentsStatus();
		initResources();
	}

	private void initComponents() {
		this.workspaceTree = new WorkspaceTree();
	}

	private void initComponentsStatus() {
		setViewportView(this.workspaceTree);
	}

	private void initResources() {
		setBorder(BorderFactory.createTitledBorder(DevelopProperties.getProperty("String_WorkspaceComponent_Title")));
	}

	public WorkspaceTree getWorkspaceTree() {
		return this.workspaceTree;
	}

}
