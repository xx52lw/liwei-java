package com.liwei.common.shiro.manager;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.shiro.entity.SysRoleEntity;
import java.util.List;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.manager
 *@author liwei
 *@Date：下午5:23 下午5:23
*/
public interface SysRoleManager {

	List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search);
	
	int saveRole(SysRoleEntity role);
	
	SysRoleEntity getRoleById(Long id);
	
	int updateRole(SysRoleEntity role);
	
	int batchRemove(Long[] id);
	
	List<SysRoleEntity> listRole();
	
	int updateRoleAuthorization(SysRoleEntity role);
	
}
