package com.gitee.x0e.idea.plugin.tree;

import javax.swing.*;

import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.components.JBList;

/**
 * @author 渣码
 * @since 2022/3/8 18:56
 */
public class ExtraButtonAction extends AnActionButton {
	private final JBList<Integer> list;

	private final DefaultListModel<Integer> model;

	public ExtraButtonAction(DefaultListModel<Integer> model, JBList<Integer> list) {
		// super("Extra", IconLoader.getIcon("/icons/edit.svg"));
		super("Extra", AllIcons.Actions.Edit);
		this.model = model;
		this.list = list;
	}

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		int index = list.getSelectedIndex();
		String newValue = Messages.showInputDialog(model.get(index) + "", "Edit", Messages.getInformationIcon());
		if (StringUtils.isNotBlank(newValue)) {
			model.add(index, Integer.valueOf(newValue));
		}
	}
}
