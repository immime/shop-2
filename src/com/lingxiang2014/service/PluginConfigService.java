
package com.lingxiang2014.service;

import com.lingxiang2014.entity.PluginConfig;

public interface PluginConfigService extends BaseService<PluginConfig, Long> {

	boolean pluginIdExists(String pluginId);

	PluginConfig findByPluginId(String pluginId);

}