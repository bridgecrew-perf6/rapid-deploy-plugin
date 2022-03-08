package com.gitee.x0e.idea.plugin.project;

import org.jetbrains.annotations.NotNull;

import com.intellij.ProjectTopics;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.roots.ModuleRootListener;

/**
 * @author 渣码
 * @since 2022/3/8 19:55
 */
public class ProjectStructureAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		if (project == null) {
			return;
		}
		project.getMessageBus().connect().subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootListener() {
			@Override
			public void rootsChanged(@NotNull ModuleRootEvent event) {
				System.out.println(event);
			}
		});
	}
}
