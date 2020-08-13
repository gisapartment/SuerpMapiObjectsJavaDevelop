package com.gisapartment.gisdevelop.ui.frame;

import com.gisapartment.gisdevelop.Application;
import com.gisapartment.gisdevelop.core.Function;
import com.gisapartment.gisdevelop.utilities.StringUtilities;
import com.gisapartment.gisdevelop.utilities.WorkEnvironmentUtilities;
import org.w3c.dom.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;

/**
 * @author GIS公寓
 * Copyright © GIS公寓(www.gisapartment.com)
 */
public class FunctionsComponentsManager extends JToolBar {

	private static final HashMap<String, Function> FUNCTIONS = new HashMap<String, Function>();

	public FunctionsComponentsManager() {
		initComponentsStatus();
	}

	private void initComponentsStatus() {
		setFloatable(false);
	}

	public void loadFunctions() {
		JMenuBar menuBar = new JMenuBar();
		File rootFile = new File("");
		File workEnvironment = new File(rootFile.getAbsolutePath() + "/" + "WorkEnvironment");
		for (File file : workEnvironment.listFiles()) {
			Document document = getDocument(file.getPath());
			Element documentElement = document.getDocumentElement();
			NodeList nodeList = documentElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeName().equals(WorkEnvironmentUtilities.TAG_BUTTON)) {
					JComponent jComponent = parseConfig(node);
					if (jComponent != null) {
						menuBar.add(jComponent);
					}
				}
			}
		}
		this.add(menuBar);
	}

	private Document getDocument(String path) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private JComponent parseConfig(Node node) {
		NamedNodeMap attributes = node.getAttributes();
		Node visible = attributes.getNamedItem(WorkEnvironmentUtilities.TAG_VISIBLE);
		if (visible == null || Boolean.parseBoolean(visible.getTextContent())) {
			NodeList childNodes = node.getChildNodes();
			JMenuItem parent = null;
			if (childNodes.getLength() > 0) {
				parent = new JMenu();
				for (int i = 0; i < childNodes.getLength(); i++) {
					if (childNodes.item(i).getNodeName().equals(WorkEnvironmentUtilities.TAG_BUTTON)) {
						JComponent jComponent = parseConfig(childNodes.item(i));
						if (jComponent != null) {
							parent.add(jComponent);
						}
					}
				}
			} else {
				parent = new JMenuItem();
			}
			Node label = attributes.getNamedItem(WorkEnvironmentUtilities.TAG_LABEL);
			if (label != null) {
				parent.setText(label.getTextContent());
			}
			Node tip = attributes.getNamedItem(WorkEnvironmentUtilities.TAG_TIP);
			if (tip != null) {
				parent.setToolTipText(tip.getTextContent());
			}
			final Node functionNode = attributes.getNamedItem(WorkEnvironmentUtilities.TAG_FUNCTION);
			Function function = null;
			if (functionNode != null && !StringUtilities.isNullOrEmpty(functionNode.getTextContent())) {
				try {
					if (FUNCTIONS.containsKey(functionNode.getTextContent())) {
						function = FUNCTIONS.get(functionNode.getTextContent());
					} else {
						Class functionClass = Class.forName(functionNode.getTextContent());
						Constructor declaredConstructor = functionClass.getDeclaredConstructor(JComponent.class);
						function = (Function) declaredConstructor.newInstance(parent);
						FUNCTIONS.put(functionNode.getTextContent(), function);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			final Function finalFunction = function;
			parent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (finalFunction == null) {
						JOptionPane.showMessageDialog(Application.getApplication().getMainFrame(), MessageFormat.format(DevelopProperties.getProperty("String_FunctionNotFound"), functionNode.getTextContent()));
					} else {
						finalFunction.doRun();
					}
				}
			});
			return parent;
		}
		return null;
	}

}
