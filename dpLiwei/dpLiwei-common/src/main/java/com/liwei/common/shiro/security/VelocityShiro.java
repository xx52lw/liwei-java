package com.liwei.common.shiro.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 *
 * Shiro权限标签(Velocity版)
 *
 *@file com.liwei.common.shiro.security
 *@author liwei
 *@Date：下午5:20 下午5:20
*/
public class VelocityShiro {

	/**
	 * 是否拥有该权限
	 * @param permission  权限标识
	 * @return   true：是     false：否
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}

}
