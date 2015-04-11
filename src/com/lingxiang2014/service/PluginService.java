
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.plugin.StoragePlugin;

public interface PluginService {

	List<StoragePlugin> getStoragePlugins();

	List<StoragePlugin> getStoragePlugins(boolean isEnabled);

	StoragePlugin getStoragePlugin(String id);

}