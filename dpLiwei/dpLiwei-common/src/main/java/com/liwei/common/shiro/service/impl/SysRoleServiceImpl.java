package com.liwei.common.shiro.service.impl;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.utils.CommonUtils;
import com.liwei.common.shiro.entity.SysRoleEntity;
import com.liwei.common.shiro.manager.SysRoleManager;
import com.liwei.common.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.service.impl
 *@author liwei
 *@Date：下午5:27 下午5:27
*/
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;

	@Override
	public Page<SysRoleEntity> listRole(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRoleEntity> page = new Page<>(query);
		sysRoleManager.listRole(page,query);
		return page;
	}

	@Override
	public R saveRole(SysRoleEntity role) {
		int i = sysRoleManager.saveRole(role);
		return CommonUtils.msg(i);
	}

	@Override
	public R getRoleById(Long id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return CommonUtils.msg(role);
	}

	@Override
	public R updateRole(SysRoleEntity role) {
		int count = sysRoleManager.updateRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysRoleManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public List<SysRoleEntity> listRole() {
		return sysRoleManager.listRole();
	}

	@Override
	public R updateRoleAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleAuthorization(role);
		return CommonUtils.msg(count);
	}
	
}
