package com.gitee.x0e.idea.plugin.notify;

import java.util.Objects;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.ui.Messages;

/**
 * @author 渣码
 * @since 2022/3/8 18:16
 */
public class NotifyKit {

	/**
	 * default dialog
	 *
	 * @param msg
	 * @param type
	 * @param dataContext
	 */
	public static void Notice(String msg, String type, DataContext dataContext) {
		switch (type) {
			case "showErrorHint" :
				HintManager.getInstance().showErrorHint(
						Objects.requireNonNull(CommonDataKeys.EDITOR.getData(dataContext)), "Error message");
				break;
			case "showQuestionHint" :
				HintManager.getInstance().showQuestionHint(
						Objects.requireNonNull(CommonDataKeys.EDITOR.getData(dataContext)), "QuestionAction", 0, 0,
						() -> {
							Messages.showMessageDialog("Question", "Question", Messages.getInformationIcon());
							return true;
						});
				break;
			case "showInformationHint" :
				HintManager.getInstance().showInformationHint(
						Objects.requireNonNull(CommonDataKeys.EDITOR.getData(dataContext)), "Information");
				break;
			case "notifications" :
				NotificationGroup notificationGroup = new NotificationGroup("notificationGroup",
						NotificationDisplayType.BALLOON, true);
				Notification notification = notificationGroup.createNotification("notification",
						NotificationType.ERROR);
				Notifications.Bus.notify(notification);
				break;
			default :
				Messages.showMessageDialog(msg, "Dialog Notify", Messages.getInformationIcon());
				break;
		}
	}
}
