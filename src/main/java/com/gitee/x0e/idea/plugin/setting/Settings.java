package com.gitee.x0e.idea.plugin.setting;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;

/**
 * @author 渣码
 * @since 2022/3/8 19:44
 */
@State(name = "Setting", storages = @Storage("setting.xml"))
public class Settings implements PersistentStateComponent<Settings> {
	private Map<String, String> settingMap;

	public Map<String, String> getSettingMap() {
		return settingMap;
	}

	public void setSettingMap(Map<String, String> settingMap) {
		this.settingMap = settingMap;
	}

	public static Settings getInstance() {

		return ServiceManager.getService(Settings.class);
	}

	public Settings() {
		init();
	}

	private void init() {
		settingMap = new HashMap<>();
	}

	@Nullable
	@Override
	public Settings getState() {
		return this;
	}

	/**
	 * 新的组件状态被加载时，调用该方法，如果IDE运行期间，保存数据的文件被从外部修改，则该方法会被再次调用
	 *
	 * @param state
	 */
	@Override
	public void loadState(@NotNull Settings state) {
		setSettingMap(state.getSettingMap());
	}
}
