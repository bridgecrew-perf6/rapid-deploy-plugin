package com.gitee.x0e.idea.plugin.setting;

import javax.swing.*;

import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;

/**
 * @author 渣码
 * @since 2022/3/8 19:46
 */
public class MainSetting implements Configurable, Configurable.Composite {
	private JTextField textField;
	private JLabel label;
	private JPanel mainPanel;

	private Settings settings = Settings.getInstance();

	public MainSetting() {
		init();
	}

	private void init() {
		this.settings = Settings.getInstance();
		textField.setText(settings.getSettingMap().get("mainSetting"));
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getDisplayName() {
		return "Main Setting";
	}

	/**
	 * 通过方法返回定义的子设置组件
	 *
	 */
	@Override
	public Configurable @NotNull [] getConfigurables() {
		Configurable[] configurables = new Configurable[1];
		configurables[0] = new SubSetting();
		return configurables;
	}

	@Nullable
	@Override
	public JComponent createComponent() {
		return mainPanel;
	}

	/**
	 * 设置apply按钮是否可用，数据修改时被调用
	 *
	 */
	@Override
	public boolean isModified() {
		String origSetting = settings.getSettingMap().get("mainSetting");
		String newSetting = textField.getText();
		return !StringUtils.equals(origSetting, newSetting);
	}

	/**
	 * 点击apply按钮后被调用
	 *
	 * @throws ConfigurationException
	 */
	@Override
	public void apply() throws ConfigurationException {
		settings.getSettingMap().put("mainSetting", textField.getText());
	}

	/**
	 * reset按钮被点击时触发
	 */
	@Override
	public void reset() {
		init();
	}
}
