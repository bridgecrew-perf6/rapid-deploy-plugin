package com.gitee.x0e.idea.plugin.splitter;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author 渣码
 * @since 2022/3/8 19:08
 */
public class JBSplitterAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		new JBSplitterDialogWrapper().showAndGet();
	}
}
