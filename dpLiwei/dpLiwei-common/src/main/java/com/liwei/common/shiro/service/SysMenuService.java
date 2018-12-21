package com.liwei.common.shiro.service;

import com.liwei.common.cm.entity.R;
import com.liwei.common.shiro.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 *
 * 系统菜单
 *
 *@file com.liwei.common.shiro.service
 *@author liwei
 *@Date：下午5:20 下午5:20
*/
public interface SysMenuService {

	R listUserMenu(Long userId);
	
	List<SysMenuEntity> listMenu(Map<String, Object> params);
	
	R listNotButton();
	
	R saveMenu(SysMenuEntity menu);

	R getMenuById(Long id);
	
	R updateMenu(SysMenuEntity menu);
	
	R batchRemove(Long[] id);

}
