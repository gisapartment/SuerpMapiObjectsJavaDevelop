package com.gisapartment.gisdevelop.ui.frame;

import java.awt.*;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class GridBagConstraintsEasy extends GridBagConstraints {

	public GridBagConstraintsEasy(int gridX, int gridY) {
		this.gridx = gridX;
		this.gridy = gridY;
	}

	public GridBagConstraintsEasy(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
	}

	public GridBagConstraintsEasy setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	public GridBagConstraintsEasy setFill(int fill) {
		this.fill = fill;
		return this;
	}

	public GridBagConstraintsEasy setWeight(double weightX, double weightY) {
		this.weightx = weightX;
		this.weighty = weightY;
		return this;
	}

	public GridBagConstraintsEasy setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	public GridBagConstraintsEasy setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	public GridBagConstraintsEasy setIpad(int ipadX, int ipadY) {
		this.ipadx = ipadX;
		this.ipady = ipadY;
		return this;
	}


}
