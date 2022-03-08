package com.gitee.x0e.idea.plugin.action;

import com.gitee.x0e.idea.plugin.notify.NotifyKit;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;

/**
 * @author 渣码
 * @since 2022/3/7 18:53
 */
public class AddAction extends AnAction {

	public AddAction() {
		super("Add Host");
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(AnActionEvent e) {
		String str= "editor_basics 大萨达";
		DataContext dataContext = e.getDataContext();
		NotifyKit.Notice("testMsg", "showErrorHint", dataContext);
		NotifyKit.Notice("testMsg", "showQuestionHint", dataContext);
		NotifyKit.Notice("testMsg", "showInformationHint", dataContext);
		NotifyKit.Notice("testMsg", "notifications", dataContext);
		NotifyKit.Notice("testMsg", "dialog", dataContext);
	}
}
