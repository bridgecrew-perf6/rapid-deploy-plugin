package com.gitee.x0e.idea.plugins.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;

/**
 * @author 渣码
 * @since 2022/3/7 18:53
 */
public class AddAction extends AnAction {

	/**
	 *
	 * @param
	 */
	@Override
	public void actionPerformed(AnActionEvent e) {
		NotificationGroup notificationGroup = new NotificationGroup("action_add", NotificationDisplayType.BALLOON,
				false);
		Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
		Notifications.Bus.notify(notification);

	}
}
