package com.gitee.x0e.idea.plugin.action.popup;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @author 渣码
 * @since 2022/3/8 18:05
 */
public class SubAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Messages.showMessageDialog("Nest", "Nest", Messages.getInformationIcon());
	}
}
