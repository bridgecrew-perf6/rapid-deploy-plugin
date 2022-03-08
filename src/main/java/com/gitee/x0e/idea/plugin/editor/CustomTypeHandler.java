package com.gitee.x0e.idea.plugin.editor;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;

/**
 * @author 渣码
 * @since 2022/3/8 19:31
 */
public class CustomTypeHandler implements TypedActionHandler {
	@Override
	public void execute(@NotNull Editor editor, char charTyped, @NotNull DataContext dataContext) {
		final Document document = editor.getDocument();
		final Project project = editor.getProject();
		Runnable runnable = () -> document.insertString(0, "test");
		WriteCommandAction.runWriteCommandAction(project, runnable);
	}
}
