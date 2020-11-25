package com.gisapartment.gisdevelop.utilities;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.ui.frame.DevelopProperties;
import com.gisapartment.gisdevelop.ui.frame.MainFrame;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceConnectionInfo;
import com.supermap.data.WorkspaceType;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.text.MessageFormat;

public class WorkspaceUtilities {

	public static final FileNameExtensionFilter FILE_NAME_EXTENSION_FILTER = new FileNameExtensionFilter(DevelopProperties.getProperty("String_SuperMapFileWorkspaceType"), "smwu", "sxwu");

	private WorkspaceUtilities() {

	}

	public static WorkspaceType getWorkspaceType(String workspaceFilePath) {
		WorkspaceType result = WorkspaceType.SMWU;
		if (workspaceFilePath != null) {
			String fileType = workspaceFilePath.substring(workspaceFilePath.indexOf(".") + 1);
			if ("sxwu".equalsIgnoreCase(fileType)) {
				result = WorkspaceType.SXWU;
			}
		}
		return result;
	}

	public static void saveAsWorkspace() {
		JFileChooser jFileChooser = new JFileChooser();
		//下面这句是去掉显示所有文件这个过滤器。
		jFileChooser.setAcceptAllFileFilterUsed(false);
		//设置一个文件筛选器
		jFileChooser.setFileFilter(WorkspaceUtilities.FILE_NAME_EXTENSION_FILTER);

		MainFrame mainFrame = Application.getApplication().getMainFrame();
		int result = jFileChooser.showSaveDialog(mainFrame);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jFileChooser.getSelectedFile();
			String workspaceFilePath = selectedFile.getAbsolutePath();
			WorkspaceConnectionInfo workspaceConnectionInfo = new WorkspaceConnectionInfo();
			workspaceConnectionInfo.setServer(workspaceFilePath);
			workspaceConnectionInfo.setType(WorkspaceUtilities.getWorkspaceType(workspaceFilePath));

			Workspace workspace = mainFrame.getWorkspaceComponentManager().getWorkspaceTree().getWorkspace();
			workspace.setCaption(selectedFile.getName());
			if (!workspace.saveAs(workspaceConnectionInfo)) {
				JOptionPane.showMessageDialog(mainFrame, DevelopProperties.getProperty("String_WorkspaceSaveAsFailed"));
			} else {
				JOptionPane.showMessageDialog(mainFrame, MessageFormat.format(DevelopProperties.getProperty("String_WorkspaceSaveAsSuccessfully"), workspaceFilePath));
				mainFrame.getWorkspaceComponentManager().getWorkspaceTree().repaint();
			}
		}
	}

}
