package com.gitee.x0e.idea.plugin.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;

/**
 * @author 渣码
 * @since 2022/3/8 13:07
 */
public class RunConfigurationFactory extends ConfigurationFactory {

	protected RunConfigurationFactory(ConfigurationType type) {
		super(type);
	}

	@Override
	public @NotNull String getId() {
		return RunConfigurationType.ID;
	}

	@NotNull
	@Override
	public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
		return new CustomRunConfiguration(project, this, "Deploy");
	}

	@Nullable
	@Override
	public Class<? extends BaseState> getOptionsClass() {
		return CustomRunConfigurationOptions.class;
	}

}
