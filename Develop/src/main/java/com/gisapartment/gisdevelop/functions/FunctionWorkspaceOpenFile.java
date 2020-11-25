package com.gisapartment.gisdevelop.functions;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.ui.frame.DevelopProperties;
import com.gisapartment.gisdevelop.ui.frame.MainFrame;
import com.gisapartment.gisdevelop.utilities.WorkspaceUtilities;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceConnectionInfo;

import javax.swing.*;
import java.io.File;
import java.text.MessageFormat;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FunctionWorkspaceOpenFile extends Function {

	public FunctionWorkspaceOpenFile(JComponent component) {
		super(component);
	}

	@Override
	protected void run() {
		JFileChooser jFileChooser = new JFileChooser();
		// 设置只打开文件
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// 设置不允许多选
		jFileChooser.setMultiSelectionEnabled(false);
		//下面这句是去掉显示所有文件这个过滤器。
		jFileChooser.setAcceptAllFileFilterUsed(false);
		//设置一个文件筛选器
		jFileChooser.setFileFilter(WorkspaceUtilities.FILE_NAME_EXTENSION_FILTER);

		MainFrame mainFrame = Application.getApplication().getMainFrame();
		int result = jFileChooser.showDialog(mainFrame, DevelopProperties.getProperty("String_OpenFile"));
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			WorkspaceConnectionInfo workspaceConnectionInfo = new WorkspaceConnectionInfo(file.getPath());
			Workspace workspace = mainFrame.getWorkspaceComponentManager().getWorkspaceTree().getWorkspace();
			boolean isOpened = workspace.open(workspaceConnectionInfo);
			if (!isOpened) {
				JOptionPane.showMessageDialog(mainFrame, MessageFormat.format(DevelopProperties.getProperty("String_OpenWorkspaceFailed"), file.getPath()));
			}
		}
	}
}
