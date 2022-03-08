package com.gitee.x0e.idea.plugin.config;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author 渣码
 * @since 2022/3/8 13:05
 */
public class RunConfigurationType implements ConfigurationType {

	static final String ID = "DemoRunConfiguration";

	@Override
	public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
		return "Deploy";
	}

	@Override
	public @Nls(capitalization = Nls.Capitalization.Sentence) String getConfigurationTypeDescription() {
		return "Deploy run configuration type";
	}

	@Override
	public Icon getIcon() {
		return AllIcons.General.Information;
	}

	@Override
	public @NotNull String getId() {
		return ID;
	}

	@Override
	public ConfigurationFactory[] getConfigurationFactories() {
		return new ConfigurationFactory[]{new RunConfigurationFactory(this)};
	}
}
