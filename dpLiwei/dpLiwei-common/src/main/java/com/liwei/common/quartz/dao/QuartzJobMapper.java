package com.liwei.common.quartz.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.quartz.entity.QuartzJobEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 *
 * 定时任务
 *
 *@file com.liwei.common.quartz.dao
 *@author liwei
 *@Date：下午4:47 下午4:47
*/
@MapperScan
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
