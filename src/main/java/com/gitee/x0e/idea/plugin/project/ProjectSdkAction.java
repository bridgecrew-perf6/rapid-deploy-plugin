package com.gitee.x0e.idea.plugin.project;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;

/**
 * @author 渣码
 * @since 2022/3/8 19:53
 */
public class ProjectSdkAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		if (project != null) {
			Sdk projectSdk = ProjectRootManager.getInstance(project).getProjectSdk();
			if (projectSdk != null) {
				String origProjectSdkName = projectSdk.getName();
				WriteCommandAction.runWriteCommandAction(project,
						() -> ProjectRootManager.getInstance(project).setProjectSdkName("newProjectSdkName", "java"));
				Messages.showInfoMessage("origProjectSdkName:" + origProjectSdkName, "Change Project SDK Name Success");
			} else {
				Messages.showInfoMessage("Unknown Project SDK", "Change Project SDK Name Fail");
			}
		} else {
			Messages.showInfoMessage("Unknown project", "Change Project SDK Name Fail");
		}
	}
}
