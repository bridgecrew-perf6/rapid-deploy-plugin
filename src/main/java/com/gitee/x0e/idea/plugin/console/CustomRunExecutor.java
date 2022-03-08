// package com.gitee.x0e.idea.plugin.console;
//
// import javax.swing.*;
//
// import org.jetbrains.annotations.NotNull;
//
// import com.intellij.execution.Executor;
// import com.intellij.execution.ExecutorRegistry;
// import com.intellij.util.IconUtil;
//
/// **
// * @author 渣码
// * @since 2022/3/8 20:06
// */
// public class CustomRunExecutor extends Executor {
//
// public static final String TOOL_WINDOW_ID = "tool window plugin";
//
// @Override
// public String getToolWindowId() {
// return TOOL_WINDOW_ID;
// }
//
// @Override
// public Icon getToolWindowIcon() {
// return IconUtil.ICON;
// }
//
// @NotNull
// @Override
// public Icon getIcon() {
// return IconUtil.ICON;
// }
//
// @Override
// public Icon getDisabledIcon() {
// return IconUtil.ICON;
// }
//
// @Override
// public String getDescription() {
// return TOOL_WINDOW_ID;
// }
//
// @NotNull
// @Override
// public String getActionName() {
// return TOOL_WINDOW_ID;
// }
//
// @NotNull
// @Override
// public String getId() {
// return StringConst.PLUGIN_ID;
// }
//
// @NotNull
// @Override
// public String getStartActionText() {
// return TOOL_WINDOW_ID;
// }
//
// @Override
// public String getContextActionId() {
// return "custom context action id";
// }
//
// @Override
// public String getHelpId() {
// return TOOL_WINDOW_ID;
// }
//
// public static Executor getRunExecutorInstance() {
// return ExecutorRegistry.getInstance().getExecutorById(StringConst.PLUGIN_ID);
// }
// }
