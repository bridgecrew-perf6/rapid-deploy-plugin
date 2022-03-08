package com.gitee.x0e.idea.plugin.action.group;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gitee.x0e.idea.plugin.action.AddAction;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author 渣码
 * @since 2022/3/8 11:15
 */
public class AddActionGroup extends ActionGroup {
	@Override
	public AnAction @NotNull [] getChildren(@Nullable AnActionEvent e) {
		return new AnAction[]{new AddAction()};
	}
}
