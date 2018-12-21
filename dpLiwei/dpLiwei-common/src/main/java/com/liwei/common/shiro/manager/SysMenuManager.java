package com.liwei.common.shiro.manager;

import com.liwei.common.cm.entity.Query;
import com.liwei.common.shiro.entity.SysMenuEntity;
import java.util.List;

/**
 *
 * 系统菜单
 *
 *@file com.liwei.common.shiro.manager
 *@author liwei
 *@Date：下午5:23 下午5:23
*/
public interface SysMenuManager {
	
	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);
	
	List<SysMenuEntity> listMenu(Query search);
	
	List<SysMenuEntity> listNotButton();
	
	int saveMenu(SysMenuEntity menu);

	SysMenuEntity getMenuById(Long id);
	
	int updateMenu(SysMenuEntity menu);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
