package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.ui.frame.DevelopProperties;
import com.gisapartment.gisdevelop.ui.frame.MainFrame;
import com.supermap.data.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.text.MessageFormat;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FunctionDatasourceOpenFile extends Function {

	private static final FileNameExtensionFilter FILE_NAME_EXTENSION_FILTER = new FileNameExtensionFilter(DevelopProperties.getProperty("String_SuperMapFileDatasourceType"), "udb", "udbx");

	public FunctionDatasourceOpenFile(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jFileChooser.setMultiSelectionEnabled(false);
		jFileChooser.setAcceptAllFileFilterUsed(false);
		jFileChooser.setFileFilter(FILE_NAME_EXTENSION_FILTER);

		MainFrame mainFrame = Application.getApplication().getMainFrame();
		int result = jFileChooser.showDialog(mainFrame, DevelopProperties.getProperty("String_OpenFile"));
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();

			Workspace workspace = mainFrame.getWorkspaceComponentManager().getWorkspaceTree().getWorkspace();
			Datasources datasources = workspace.getDatasources();
			for (int i = 0; i < datasources.getCount(); i++) {
				if (datasources.get(i).getConnectionInfo().getServer().equals(file.getPath())) {
					JOptionPane.showMessageDialog(mainFrame, MessageFormat.format(DevelopProperties.getProperty("String_OpenDatasourceFailedBecauseBeenOpend"), file.getPath()));
					return;
				}
			}

			String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
			String fileType = file.getName().replace(fileName + ".", "");
			DatasourceConnectionInfo datasourceConnectionInfo = new DatasourceConnectionInfo();
			datasourceConnectionInfo.setServer(file.getPath());
			datasourceConnectionInfo.setEngineType(fileType.equalsIgnoreCase("udb") ? EngineType.UDB : EngineType.UDBX);
			datasourceConnectionInfo.setAlias(fileName);
			Datasource datasource = datasources.open(datasourceConnectionInfo);
			if (datasource == null) {
				JOptionPane.showMessageDialog(mainFrame, MessageFormat.format(DevelopProperties.getProperty("String_OpenDatasourceFailed"), file.getPath()));
			}
		}
	}
}
