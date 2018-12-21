package com.liwei.common.cm.controller;

import com.liwei.common.cm.entity.SysUserEntity;
import com.liwei.common.cm.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Controller公共组件
 *
 *@file common.controller
 *@author liwei
 *@Date：下午8:40 下午8:40
*/
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	
}
