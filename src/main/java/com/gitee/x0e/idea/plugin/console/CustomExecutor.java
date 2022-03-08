// package com.gitee.x0e.idea.plugin.console;
//
// import javax.swing.*;
//
// import org.jetbrains.annotations.NotNull;
// import org.jetbrains.annotations.Nullable;
//
// import com.intellij.execution.DefaultExecutionResult;
// import com.intellij.execution.ExecutionException;
// import com.intellij.execution.ExecutionManager;
// import com.intellij.execution.Executor;
// import com.intellij.execution.configurations.RunProfile;
// import com.intellij.execution.configurations.RunProfileState;
// import com.intellij.execution.filters.TextConsoleBuilder;
// import com.intellij.execution.filters.TextConsoleBuilderFactory;
// import com.intellij.execution.runners.ExecutionEnvironment;
// import com.intellij.execution.ui.ConsoleView;
// import com.intellij.execution.ui.RunContentDescriptor;
// import com.intellij.execution.ui.RunnerLayoutUi;
// import com.intellij.icons.AllIcons;
// import com.intellij.openapi.Disposable;
// import com.intellij.openapi.project.Project;
// import com.intellij.openapi.util.Disposer;
// import com.intellij.ui.content.Content;
//
/// **
// * @author 渣码
// * @since 2022/3/8 20:05
// */
// public class CustomExecutor implements Disposable {
//
// private ConsoleView consoleView = null;
//
// private Project project = null;
//
// public CustomExecutor(@NotNull Project project) {
// this.project = project;
// this.consoleView = createConsoleView(project);
// }
//
// private ConsoleView createConsoleView(Project project) {
// TextConsoleBuilder consoleBuilder =
// TextConsoleBuilderFactory.getInstance().createBuilder(project);
// ConsoleView console = consoleBuilder.getConsole();
// return console;
// }
//
// @Override
// public void dispose() {
// Disposer.dispose(this);
// }
//
// public void run() {
// if (project.isDisposed()) {
// return;
// }
//
// Executor executor = CustomRunExecutor.getRunExecutorInstance();
// if (executor == null) {
// return;
// }
//
// final RunnerLayoutUi.Factory factory =
// RunnerLayoutUi.Factory.getInstance(project);
// RunnerLayoutUi layoutUi = factory.create("runnerId", "runnerTitle",
// "sessionName", project);
// final JPanel consolePanel = createConsolePanel(consoleView);
//
// RunContentDescriptor descriptor = new RunContentDescriptor(new RunProfile() {
// @Nullable
// @Override
// public RunProfileState getState(@NotNull Executor executor, @NotNull
// ExecutionEnvironment environment)
// throws ExecutionException {
// return null;
// }
//
// @NotNull
// @Override
// public String getName() {
// return "name";
// }
//
// @Nullable
// @Override
// public Icon getIcon() {
// return null;
// }
// }, new DefaultExecutionResult(), layoutUi);
// descriptor.setExecutionId(System.nanoTime());
//
// final Content content = layoutUi.createContent("contentId", consolePanel,
// "displayName",
// AllIcons.Debugger.Console, consolePanel);
// content.setCloseable(false);
// layoutUi.addContent(content);
//
// Disposer.register(descriptor, this);
//
// Disposer.register(content, consoleView);
//
// ExecutionManager.getInstance(project).getContentManager().showRunContent(executor,
// descriptor);
// }
// }
