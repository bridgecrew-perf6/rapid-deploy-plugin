package com.gitee.x0e.idea.plugin.project;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * @author 渣码
 * @since 2022/3/8 19:51
 */
public class GetContentSourceRootAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		assert project != null;
		VirtualFile[] virtualFiles = ProjectRootManager.getInstance(project).getContentSourceRoots();
		String sourceRoot = Arrays.stream(virtualFiles).map(VirtualFile::getUrl).collect(Collectors.joining("\n"));
		Messages.showInfoMessage("Source roots for project: " + project.getName() + " are " + sourceRoot,
				"Project Properties");
	}
}
