package com.gitee.x0e.idea.plugin.setting;

import javax.swing.*;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;

/**
 * @author 渣码
 * @since 2022/3/8 19:47
 */
public class SubSetting implements Configurable {
	private JPanel mainPanel;
	private JTextField testField;
	private JLabel label;

	public SubSetting() {
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getDisplayName() {
		return "Sub Setting";
	}

	@Nullable
	@Override
	public JComponent createComponent() {
		return mainPanel;
	}

	@Override
	public boolean isModified() {
		return false;
	}

	@Override
	public void apply() throws ConfigurationException {

	}
}
