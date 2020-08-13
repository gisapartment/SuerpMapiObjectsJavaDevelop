package com.gisapartment.gisdevelop.ui.frame;

import com.gisapartment.gisdevelop.ui.frame.form.FormManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class MainFrame extends JFrame {

	private JSplitPane splitPaneMain;
	private JSplitPane splitPaneLeft;
	private FunctionsComponentsManager functionsComponentsManager;
	private WorkspaceComponentManager workspaceComponentManager;
	private LayersComponentManager layersComponentManager;
	private FormContainer formContainer;
	private FormManager formManager;

	public MainFrame() {
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		initComponentsStatus();
		initLayout();
		initResources();
	}

	private void initComponents() {
		this.splitPaneMain = new JSplitPane();
		this.splitPaneLeft = new JSplitPane();
		this.functionsComponentsManager = new FunctionsComponentsManager();
		this.workspaceComponentManager = new WorkspaceComponentManager();
		this.layersComponentManager = new LayersComponentManager();
		this.formContainer = new FormContainer();
		this.formManager = new FormManager(this.formContainer);
	}

	private void initComponentsStatus() {
		this.splitPaneLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.splitPaneLeft.setLeftComponent(this.workspaceComponentManager);
		this.splitPaneLeft.setRightComponent(this.layersComponentManager);

		this.splitPaneMain.setDividerLocation(0.5);
		this.splitPaneMain.setLeftComponent(this.splitPaneLeft);
		this.splitPaneMain.setRightComponent(this.formContainer);
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		add(this.functionsComponentsManager, new GridBagConstraintsEasy(0, 0, 1, 1).setAnchor(GridBagConstraints.WEST).setWeight(0, 0));
		add(this.splitPaneMain, new GridBagConstraintsEasy(0, 1, 1, 10).setFill(GridBagConstraints.BOTH).setAnchor(GridBagConstraints.CENTER).setWeight(1, 1));
	}

	private void initResources() {
		setTitle(DevelopProperties.getProperty("String_MainFrame_Title"));
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			this.splitPaneLeft.setDividerLocation(0.7);
			this.splitPaneMain.setDividerLocation(0.3);
		}
	}

	public void loadFunctions() {
		this.functionsComponentsManager.loadFunctions();
	}

	public FormManager getFormManager() {
		return formManager;
	}

	public WorkspaceComponentManager getWorkspaceComponentManager() {
		return this.workspaceComponentManager;
	}
}
