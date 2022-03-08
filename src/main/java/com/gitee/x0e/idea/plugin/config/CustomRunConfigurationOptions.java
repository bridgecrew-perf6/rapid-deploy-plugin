package com.gitee.x0e.idea.plugin.config;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

/**
 * @author 渣码
 * @since 2022/3/8 13:09
 */
public class CustomRunConfigurationOptions extends RunConfigurationOptions {

	private final StoredProperty<String> storedProperty = string("").provideDelegate(this, "scriptName");

	public String getScriptName() {
		return storedProperty.getValue(this);
	}

	public void setScriptName(String scriptName) {
		storedProperty.setValue(this, scriptName);
	}
}
