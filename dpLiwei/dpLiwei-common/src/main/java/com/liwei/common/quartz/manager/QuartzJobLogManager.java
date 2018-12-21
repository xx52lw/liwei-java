package com.liwei.common.quartz.manager;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.quartz.entity.QuartzJobLogEntity;

import java.util.List;

/**
 *
 * 定时任务日志
 *
 *@file com.liwei.common.quartz.manager
 *@author liwei
 *@Date：下午4:54 下午4:54
*/
public interface QuartzJobLogManager {

	List<QuartzJobLogEntity> listForPage(Page<QuartzJobLogEntity> page, Query query);
	int saveQuartzJobLog(QuartzJobLogEntity log);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
