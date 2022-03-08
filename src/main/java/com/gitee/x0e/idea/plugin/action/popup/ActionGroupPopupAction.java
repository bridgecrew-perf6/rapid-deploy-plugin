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
 *
 * 普通的弹出菜单
 *
 * @author 渣码
 * @since 2022/3/8 17:13
 */
public class ActionGroupPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		// 单选，action被选中可以触发对应的actionPerformed方法
		DefaultActionGroup actionGroup = (DefaultActionGroup) ActionManager.getInstance().getAction("popupGroup");
		ListPopup listPopup = JBPopupFactory.getInstance().createActionGroupPopup("Popup", actionGroup,
				e.getDataContext(), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false);
		listPopup.showInFocusCenter();
		listPopup.addListSelectionListener(this);
		listPopup.addListener(this);

	}

	/**
	 * 值改变事件监听，通过上下键选择时，可以通过getFirstIndex获取第一个选择的元素的索引，通过getLastIndex可以获取最后一个选择的元素的索引
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
	 * popup 监听弹出菜单关闭动作
	 */
	@Override
	public void onClosed(@NotNull LightweightWindowEvent event) {
		JBPopup jbPopup = event.asPopup();
		System.out.println("Close the popup");
		jbPopup.cancel();
	}
}
