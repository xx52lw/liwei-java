package com.liwei.common.shiro.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.shiro.entity.SysUserRoleEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 用户与角色关系
 *
 *@file com.liwei.common.shiro.dao
 *@author liwei
 *@Date：下午5:34 下午5:34
*/
@MapperScan
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	List<Long> listUserRoleId(Long userId);
	
	int batchRemoveByUserId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
