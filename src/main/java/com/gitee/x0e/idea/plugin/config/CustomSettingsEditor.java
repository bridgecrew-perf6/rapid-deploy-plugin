package com.gitee.x0e.idea.plugin.config;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;

/**
 * @author 渣码
 * @since 2022/3/8 13:26
 */
public class CustomSettingsEditor extends SettingsEditor<CustomRunConfiguration> {

	private JPanel jPanel;
	private LabeledComponent<TextFieldWithBrowseButton> labeledComponent;

	private JComboBox<String> language;
	private JComboBox<String> buildType;
	private JTextField uploadPath;
	private JTextField appUrl;
	private JTextField webhook;
	private JTable table1;

	@Override
	protected void resetEditorFrom(CustomRunConfiguration customRunConfiguration) {
		labeledComponent.getComponent().setText(customRunConfiguration.getScriptName());
	}

	@Override
	protected void applyEditorTo(@NotNull CustomRunConfiguration customRunConfiguration) {
		customRunConfiguration.setScriptName(labeledComponent.getComponent().getText());
	}

	@NotNull
	@Override
	protected JComponent createEditor() {
		return jPanel;
	}

	private void createUIComponents() {
		labeledComponent = new LabeledComponent<>();
		labeledComponent.setComponent(new TextFieldWithBrowseButton());
	}

}
