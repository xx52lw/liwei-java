package com.liwei.common.shiro.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.shiro.entity.SysRoleEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.dao
 *@author liwei
 *@Date：下午5:34 下午5:34
*/
@MapperScan
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Long userId);
	
}
