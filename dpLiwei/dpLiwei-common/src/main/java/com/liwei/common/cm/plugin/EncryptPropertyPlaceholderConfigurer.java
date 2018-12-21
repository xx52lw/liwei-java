package com.liwei.common.cm.plugin;

import com.liwei.common.cm.utils.AESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *
 * 支持加密配置文件插件
 *
 *@file common.plugin
 *@author liwei
 *@Date：下午8:35 下午8:35
*/
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
		"jdbc.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtil.aesDecode(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
