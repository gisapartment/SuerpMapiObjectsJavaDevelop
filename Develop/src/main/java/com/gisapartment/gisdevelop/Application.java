package com.gisapartment.gisdevelop;

import com.gisapartment.gisdevelop.ui.frame.MainFrame;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class Application {

	private static Application application = null;

	private MainFrame mainFrame = null;

	private Application() {

	}

	public static Application getApplication() {
		if (application == null) {
			application = new Application();
		}
		return application;
	}

	public boolean startup() {
		try {
			dispose();
			this.mainFrame = new MainFrame();
			this.mainFrame.loadFunctions();
			this.mainFrame.setVisible(true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	private void dispose() {
		if (this.mainFrame != null) {
			this.mainFrame.dispose();
			this.mainFrame = null;
		}
	}
}
