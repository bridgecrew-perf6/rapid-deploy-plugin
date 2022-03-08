package com.gitee.x0e.idea.plugin.tree;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author 渣码
 * @since 2022/3/8 18:53
 */
public class ListAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		new ListDialogWrapper().showAndGet();
	}
}
