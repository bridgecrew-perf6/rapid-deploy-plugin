package com.gitee.x0e.idea.plugin.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;

/**
 * @author 渣码
 * @since 2022/3/8 13:11
 */
public class CustomRunConfiguration extends RunConfigurationBase<CustomRunConfigurationOptions> {

	protected CustomRunConfiguration(Project project, ConfigurationFactory factory, String name) {
		super(project, factory, name);
	}

	@NotNull
	@Override
	protected CustomRunConfigurationOptions getOptions() {
		return (CustomRunConfigurationOptions) super.getOptions();
	}

	public String getScriptName() {
		return getOptions().getScriptName();
	}

	public void setScriptName(String scriptName) {
		getOptions().setScriptName(scriptName);
	}

	@NotNull
	@Override
	public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
		return new CustomSettingsEditor();
	}

	@Override
	public void checkConfiguration() {
	}

	@Nullable
	@Override
	public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) {
		return new CommandLineState(executionEnvironment) {
			@NotNull
			@Override
			protected ProcessHandler startProcess() throws ExecutionException {
				GeneralCommandLine commandLine = new GeneralCommandLine(getOptions().getScriptName());
				OSProcessHandler processHandler = ProcessHandlerFactory.getInstance()
						.createColoredProcessHandler(commandLine);
				ProcessTerminatedListener.attach(processHandler);
				return processHandler;
			}
		};
	}

}
