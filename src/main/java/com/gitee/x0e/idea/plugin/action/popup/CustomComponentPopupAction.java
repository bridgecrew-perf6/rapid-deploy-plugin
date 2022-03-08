package com.gitee.x0e.idea.plugin.action.popup;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.*;

/**
 * 自定义弹出菜单样式
 *
 * @author 渣码
 * @since 2022/3/8 17:45
 */
public class CustomComponentPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {

		// 自定义popup样式
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JTextField textField = new JTextField();
		panel.add(textField, BorderLayout.NORTH);
		JButton button = new JButton("submit");
		panel.add(button, BorderLayout.CENTER);
		ComponentPopupBuilder componentPopupBuilder = JBPopupFactory.getInstance().createComponentPopupBuilder(panel,
				textField);
		JBPopup popup = componentPopupBuilder.createPopup();
		popup.setRequestFocus(true);
		popup.showInBestPositionFor(e.getDataContext());
	}

	/**
	 * 上下键选择事件，仅仅是改变，而不是按住回车之后的选择
	 *
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int firstIndex = e.getFirstIndex();
		int lastIndex = e.getLastIndex();
		boolean valueIsAdjusting = e.getValueIsAdjusting();
		System.out.println("firstIndex:" + firstIndex);
		System.out.println("lastIndex:" + lastIndex);
		System.out.println("valueIsAdjusting:" + valueIsAdjusting);

	}

	/**
	 * popup 关闭监听
	 */
	@Override
	public void onClosed(@NotNull LightweightWindowEvent event) {
		JBPopup jbPopup = event.asPopup();
		System.out.println("Close Popup");
		jbPopup.cancel();
	}
}
