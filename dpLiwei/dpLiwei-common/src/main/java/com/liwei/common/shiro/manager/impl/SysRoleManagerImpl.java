package com.liwei.common.shiro.manager.impl;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.shiro.dao.SysRoleMapper;
import com.liwei.common.shiro.dao.SysRoleMenuMapper;
import com.liwei.common.shiro.dao.SysUserRoleMapper;
import com.liwei.common.shiro.entity.SysRoleEntity;
import com.liwei.common.shiro.manager.SysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.manager.impl
 *@author liwei
 *@Date：下午5:30 下午5:30
*/
@Component("sysRoleManager")
public class SysRoleManagerImpl implements SysRoleManager {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search) {
		return sysRoleMapper.listForPage(page, search);
	}

	@Override
	public int saveRole(SysRoleEntity role) {
		return sysRoleMapper.save(role);
	}

	@Override
	public SysRoleEntity getRoleById(Long id) {
		SysRoleEntity role = sysRoleMapper.getObjectById(id);
		List<Long> menuId = sysRoleMenuMapper.listMenuId(id);
		role.setMenuIdList(menuId);
		return role;
	}

	@Override
	public int updateRole(SysRoleEntity role) {
		return sysRoleMapper.update(role);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysRoleMapper.batchRemove(id);
		sysUserRoleMapper.batchRemoveByRoleId(id);
		sysRoleMenuMapper.batchRemoveByRoleId(id);
		return count;
	}

	@Override
	public List<SysRoleEntity> listRole() {
		return sysRoleMapper.list();
	}

	@Override
	public int updateRoleAuthorization(SysRoleEntity role) {
		Long roleId = role.getRoleId();
		int count = sysRoleMenuMapper.remove(roleId);
		Query query = new Query();
		query.put("roleId", roleId);
		List<Long> menuId = role.getMenuIdList();
		if(menuId.size() > 0) {
			query.put("menuIdList", role.getMenuIdList());
			count = sysRoleMenuMapper.save(query);
		}
		return count;
	}
	
}
