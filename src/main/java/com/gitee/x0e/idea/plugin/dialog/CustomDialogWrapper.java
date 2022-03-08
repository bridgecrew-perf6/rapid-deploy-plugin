package com.gitee.x0e.idea.plugin.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;

/**
 * 对话框
 *
 * @author 渣码
 * @since 2022/3/8 16:49
 */
public class CustomDialogWrapper extends DialogWrapper {
	private JTextField inputTextField;

	private CustomOKAction okAction;
	private DialogWrapperExitAction exitAction;

	public CustomDialogWrapper() {
		super(true);
		init();
		setTitle("Custom Dialog");
	}
	/**
	 * 校验数据
	 *
	 * @return 通过必须返回null，不通过返回一个 ValidationInfo 信息
	 */
	@Nullable
	@Override
	protected ValidationInfo doValidate() {
		String text = inputTextField.getText();
		if (StringUtils.isNotBlank(text)) {
			return null;
		} else {
			return new ValidationInfo("Check failed");
		}
	}
	/**
	 * 创建视图
	 *
	 */
	@Nullable
	@Override
	protected JComponent createCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("Custom Dialog");
		label.setPreferredSize(new Dimension(100, 100));
		panel.add(label, BorderLayout.CENTER);
		inputTextField = new JTextField();
		panel.add(inputTextField, BorderLayout.NORTH);
		return panel;

	}

	/**
	 * 覆盖默认的ok/cancel按钮
	 *
	 */
	@Override
	protected Action @NotNull [] createActions() {
		exitAction = new DialogWrapperExitAction("Custom Cancel button", CANCEL_EXIT_CODE);
		okAction = new CustomOKAction();
		// 设置默认的焦点按钮
		okAction.putValue(DialogWrapper.DEFAULT_ACTION, true);
		return new Action[]{okAction, exitAction};
	}

	/**
	 * 自定义 ok Action
	 */
	protected class CustomOKAction extends DialogWrapperAction {

		protected CustomOKAction() {
			super("Custom OK button");
		}

		@Override
		protected void doAction(ActionEvent e) {
			// 点击ok的时候进行数据校验
			ValidationInfo validationInfo = doValidate();
			if (validationInfo != null) {
				Messages.showMessageDialog(validationInfo.message, "Check Failed", Messages.getInformationIcon());
			} else {
				close(CANCEL_EXIT_CODE);
			}
		}
	}
}
