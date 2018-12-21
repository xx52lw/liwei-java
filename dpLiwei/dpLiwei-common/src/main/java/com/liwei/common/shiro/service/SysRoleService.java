package com.liwei.common.shiro.service;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.shiro.entity.SysRoleEntity;
import java.util.List;
import java.util.Map;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.service
 *@author liwei
 *@Date：下午5:21 下午5:21
*/
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);

	List<SysRoleEntity> listRole();
	
	R updateRoleAuthorization(SysRoleEntity role);
	
}
