package com.liwei.common.cm.dao;

import com.liwei.common.cm.entity.SysLogEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 *
 * 系统日志
 *
 *@file common.dao
 *@author liwei
 *@Date：下午8:38 下午8:38
*/
@MapperScan
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}
