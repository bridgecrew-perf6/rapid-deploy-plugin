package com.gitee.x0e.idea.plugin.console;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author 渣码
 * @since 2022/3/8 20:04
 */
public class ConsoleViewAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		CustomExecutor executor = new CustomExecutor(e.getProject());
		executor.run();
	}
}
