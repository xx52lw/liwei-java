package com.liwei.common.shiro.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.SysUserEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 系统用户dao
 *
 *@file com.liwei.common.shiro.dao
 *@author liwei
 *@Date：下午5:32 下午5:32
*/
@MapperScan
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePswd(SysUserEntity user);
	
}
