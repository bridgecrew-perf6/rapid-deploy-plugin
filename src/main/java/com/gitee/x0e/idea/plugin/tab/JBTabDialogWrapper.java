package com.gitee.x0e.idea.plugin.tab;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.tabs.JBTabs;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;

/**
 * @author 渣码
 * @since 2022/3/8 19:12
 */
public class JBTabDialogWrapper extends DialogWrapper {

	private JBTabs tabs;

	private Project project;

	public JBTabDialogWrapper(Project project) {
		super(true);
		this.project = project;
		init();
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel() {
		tabs = new JBTabsImpl(project);
		JPanel firstTabPanel = new JPanel();
		firstTabPanel.add(new JLabel("First Tab"));
		TabInfo firstTabInfo = new TabInfo(firstTabPanel);
		firstTabInfo.setText("First Tab");

		tabs.addTab(firstTabInfo);

		JPanel secondTabPanel = new JPanel();
		secondTabPanel.add(new JLabel("Second Tab"));
		TabInfo secondTabInfo = new TabInfo(secondTabPanel);
		secondTabInfo.setText("Second Tab");

		tabs.addTab(secondTabInfo);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(tabs.getComponent(), BorderLayout.CENTER);
		return panel;
	}
}
