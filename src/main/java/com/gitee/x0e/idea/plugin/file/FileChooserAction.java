package com.gitee.x0e.idea.plugin.file;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;

/**
 * @author 渣码
 * @since 2022/3/8 18:32
 */
public class FileChooserAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		/*
		 * 单文件
		 */

		// FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true,
		// true, true, true, true, false);
		// VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor,
		// e.getProject(), null);
		// if (virtualFile != null) {
		// Messages.showMessageDialog(virtualFile.getName(), "Get File Name",
		// Messages.getInformationIcon());
		// } else {
		// Messages.showMessageDialog("The file name is empty", "The File Name Is
		// Empty",
		// Messages.getInformationIcon());
		// }

		/*
		 * 多文件
		 */
		// FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true,
		// true, true, true, true, true);
		// VirtualFile toSelect =
		// LocalFileSystem.getInstance().findFileByPath(File.separator + "Users" +
		// File.separator
		// + "Administrator" + File.separator + "swagger-html" + File.separator);
		// FileChooser.chooseFiles(chooserDescriptor, null, toSelect, virtualFiles -> {
		// if (CollectionUtils.isNotEmpty(virtualFiles)) {
		// for (VirtualFile file : virtualFiles) {
		// Messages.showMessageDialog(file.getPath(), file.getName(),
		// Messages.getInformationIcon());
		// }
		// }
		// });

		/*
		 * 对话框文件选择器
		 */
		// new FileChooserDialogWrapper().showAndGet();

		/*
		 * 树形选择器 支持筛选及搜索
		 */
		TreeFileChooserFactory instance = TreeFileChooserFactory.getInstance(Objects.requireNonNull(e.getProject()));
		TreeFileChooser.PsiFileFilter fileFilter = file -> file.getName().endsWith(".java");
		TreeFileChooser javaFileChooser = instance.createFileChooser("java文件选择器", null, null, fileFilter);
		javaFileChooser.showDialog();
		PsiFile selectedFile = javaFileChooser.getSelectedFile();
		if (selectedFile != null) {
			Messages.showMessageDialog(selectedFile.getVirtualFile().getPath(), selectedFile.getVirtualFile().getName(),
					Messages.getInformationIcon());
		}
	}

}
