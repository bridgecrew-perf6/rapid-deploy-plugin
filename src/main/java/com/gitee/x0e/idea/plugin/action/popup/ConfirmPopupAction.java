package com.gitee.x0e.idea.plugin.action.popup;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.*;

/**
 * 确认取消式弹出菜单
 *
 * @author 渣码
 * @since 2022/3/8 17:50
 */
public class ConfirmPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {

		// 确认类型popup，展示俩个选项，对应执行俩种操作，TODO 这里不知道为什么选中其中一个之后必定会先弹出no信息框
		ListPopup confirmation = JBPopupFactory.getInstance().createConfirmation("Confirm", "Yes", "No",
				() -> Messages.showMessageDialog("Yes", "Yes", Messages.getInformationIcon()),
				() -> Messages.showMessageDialog("No", "No", Messages.getInformationIcon()), 0);
		confirmation.showInBestPositionFor(e.getDataContext());

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
	 *
	 */
	@Override
	public void onClosed(@NotNull LightweightWindowEvent event) {
		JBPopup jbPopup = event.asPopup();
		System.out.println("Close Popup");
		jbPopup.cancel();
	}
}
