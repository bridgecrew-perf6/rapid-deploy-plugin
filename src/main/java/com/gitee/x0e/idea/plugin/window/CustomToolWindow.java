package com.gitee.x0e.idea.plugin.window;

import javax.swing.*;

import com.gitee.x0e.idea.plugin.dialog.CustomDialogWrapper;
import com.intellij.openapi.wm.ToolWindow;

/**
 * 侧边工具栏
 *
 * @author 渣码
 * @since 2022/3/8 16:37
 */
public class CustomToolWindow {

	private JButton hideButton;

	private JButton dialogButton;

	private JPanel myToolWindowContent;

	public CustomToolWindow(ToolWindow toolWindow) {

		init();

		hideButton.addActionListener(e -> toolWindow.hide(null));
	}

	private void init() {
		dialogButton = new JButton("Trigger custom dialog");
		dialogButton.addActionListener(e -> {
			if (new CustomDialogWrapper().showAndGet()) {
				// 监听弹框消失，相当于show 和 getExitCode方法的结合
				System.out.println("show and get");
			}
		});

		hideButton = new JButton("Cancel");

		myToolWindowContent = new JPanel();
		myToolWindowContent.add(dialogButton);
		myToolWindowContent.add(hideButton);

	}

	public JPanel getContent() {
		return myToolWindowContent;
	}
}
