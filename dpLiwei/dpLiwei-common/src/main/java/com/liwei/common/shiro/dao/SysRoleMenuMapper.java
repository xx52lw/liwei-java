package com.liwei.common.shiro.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.shiro.entity.SysRoleMenuEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 系统角色与菜单关系
 *
 *@file com.liwei.common.shiro.dao
 *@author liwei
 *@Date：下午5:34 下午5:34
*/
@MapperScan
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	int batchRemoveByMenuId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
	List<Long> listMenuId(Long id);
	
}
