package com.gitee.x0e.idea.plugin.action.popup;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.popup.*;

/**
 * 子菜单式弹出菜单
 *
 * @author 渣码
 * @since 2022/3/8 18:03
 */
public class SubGroupPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		// 嵌套action
		DefaultActionGroup actionGroup = (DefaultActionGroup) ActionManager.getInstance().getAction("subOuterGroup");
		ListPopup listPopup = JBPopupFactory.getInstance().createActionGroupPopup("SubOuterGroup", actionGroup,
				e.getDataContext(), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false);
		listPopup.showInFocusCenter();
		listPopup.addListSelectionListener(this);
		listPopup.addListener(this);

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
