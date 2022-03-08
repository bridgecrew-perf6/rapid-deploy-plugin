package com.gitee.x0e.idea.plugin.editor;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.project.Project;

/**
 * @author 渣码
 * @since 2022/3/8 19:29
 */
public class EditorHandlerIllustration extends AnAction {

	static {
		TypedAction instance = TypedAction.getInstance();
		instance.setupRawHandler(new CustomTypeHandler());
	}

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		EditorActionHandler editorActionHandler = EditorActionManager.getInstance()
				.getActionHandler(IdeActions.ACTION_EDITOR_CLONE_CARET_BELOW);
		editorActionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());
	}

	@Override
	public void update(@NotNull AnActionEvent e) {
		final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		final Project project = e.getProject();
		boolean menuAllowed = false;
		if (project != null) {
			menuAllowed = !editor.getCaretModel().getAllCarets().isEmpty();
		}
		e.getPresentation().setEnabledAndVisible(menuAllowed);

	}
}
