package com.gitee.x0e.idea.plugin.window;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

/**
 * @author 渣码
 * @since 2022/3/8 16:35
 */
public class CustomToolWindowFactory implements ToolWindowFactory {

	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
		CustomToolWindow myToolWindow = new CustomToolWindow(toolWindow);
		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		Content content = contentFactory.createContent(myToolWindow.getContent(), "For Example", false);
		toolWindow.getContentManager().addContent(content);
	}
}
