package com.gitee.x0e.idea.plugin.editor;

import org.jetbrains.annotations.NotNull;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

/**
 * @author 渣码
 * @since 2022/3/8 19:17
 */
public class EditorIllustrationAction extends AnAction {

	public EditorIllustrationAction() {
		super(AllIcons.General.Error);
	}

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		final Project project = e.getRequiredData(CommonDataKeys.PROJECT);
		final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		final Document document = editor.getDocument();

		// 获取选中文本起始索引和结束索引
		Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
		int start = primaryCaret.getSelectionStart();
		int end = primaryCaret.getSelectionEnd();

		// 执行文本替换
		WriteCommandAction.runWriteCommandAction(project, () -> document.replaceString(start, end, "editor_basics"));

		// 对替换后的文本移除选中效果
		primaryCaret.removeSelection();

	}

	@Override
	public void update(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		Editor editor = e.getData(CommonDataKeys.EDITOR);
		e.getPresentation()
				.setEnabledAndVisible(project != null && editor != null && editor.getSelectionModel().hasSelection());
	}
}
