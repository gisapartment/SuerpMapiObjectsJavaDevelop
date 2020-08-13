package com.gisapartment.gisdevelop.ui.frame;

import com.supermap.ui.LayersTree;

import javax.swing.*;

public class LayersComponentManager extends JScrollPane {
	private LayersTree layersTree;

	public LayersComponentManager() {
		initComponents();
		initComponentsStatus();
		initResources();
	}

	private void initComponents() {
		this.layersTree = new LayersTree();
	}

	private void initComponentsStatus() {
		setViewportView(this.layersTree);
	}

	private void initResources() {
		setBorder(BorderFactory.createTitledBorder(DevelopProperties.getProperty("String_LayersComponent_Title")));
	}

}
