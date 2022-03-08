package com.gitee.x0e.idea.plugin.file;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.*;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * @author 渣码
 * @since 2022/3/8 18:44
 */
public class FileChooserDialogWrapper extends DialogWrapper {
	private TextFieldWithBrowseButton textFieldWithBrowseButton;

	private JTextField fileTextFiled;

	public FileChooserDialogWrapper() {
		super(true);
		init();
		setTitle("File Selection Dialog");
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel() {

		JPanel panel = new JPanel();
		textFieldWithBrowseButton = new TextFieldWithBrowseButton();
		fileTextFiled = new JTextField();
		FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, true, true, true, true, true);
		TextBrowseFolderListener listener = new TextBrowseFolderListener(chooserDescriptor);
		textFieldWithBrowseButton.addBrowseFolderListener(listener);
		textFieldWithBrowseButton.setText(File.separator + "Users" + File.separator + "Administrator");
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(400, 40));
		panel.add(textFieldWithBrowseButton, BorderLayout.CENTER);

		return panel;
	}

	@Nullable
	@Override
	protected ValidationInfo doValidate() {
		String filePath = textFieldWithBrowseButton.getText();
		VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(filePath);
		if (virtualFile != null) {
			Messages.showMessageDialog(virtualFile.getPath(), virtualFile.getName(), Messages.getInformationIcon());
		}
		return null;
	}
}
