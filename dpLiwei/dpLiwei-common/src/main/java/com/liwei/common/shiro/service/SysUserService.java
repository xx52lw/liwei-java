package com.liwei.common.shiro.service;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.entity.SysUserEntity;
import java.util.Map;

/**
 *
 * 系统用户
 *
 *@file com.liwei.common.shiro.service
 *@author liwei
 *@Date：下午5:21 下午5:21
*/
public interface SysUserService {

	Page<SysUserEntity> listUser(Map<String, Object> params);
	
	R saveUser(SysUserEntity user);
	
	R getUserById(Long userId);
	
	R updateUser(SysUserEntity user);
	
	R batchRemove(Long[] id);
	
	R listUserPerms(Long userId);
	
	R updatePswdByUser(SysUserEntity user);
	
	R updateUserEnable(Long[] id);
	
	R updateUserDisable(Long[] id);
	
	R updatePswd(SysUserEntity user);
	
}
