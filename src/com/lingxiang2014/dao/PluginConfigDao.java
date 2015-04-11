
package com.lingxiang2014.dao;

import com.lingxiang2014.entity.PluginConfig;

public interface PluginConfigDao extends BaseDao<PluginConfig, Long> {

	boolean pluginIdExists(String pluginId);

	PluginConfig findByPluginId(String pluginId);

}