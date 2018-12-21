package com.liwei.common.quartz.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.quartz.entity.QuartzJobLogEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 *
 * 定时任务日志
 *
 *@file com.liwei.common.quartz.dao
 *@author liwei
 *@Date：下午4:51 下午4:51
*/
@MapperScan
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	int batchRemoveAll();
	
}
