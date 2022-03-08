package com.gitee.x0e.idea.plugin.tab;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author 渣码
 * @since 2022/3/8 19:12
 */
public class JBTabAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		new JBTabDialogWrapper(e.getProject()).showAndGet();
	}
}
