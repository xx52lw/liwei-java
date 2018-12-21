package com.liwei.common.quartz.service.impl;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.utils.CommonUtils;
import com.liwei.common.quartz.entity.QuartzJobLogEntity;
import com.liwei.common.quartz.manager.QuartzJobLogManager;
import com.liwei.common.quartz.service.QuartzJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * 定时任务日志
 *
 *@file com.liwei.common.quartz.service.impl
 *@author liwei
 *@Date：下午6:38 下午6:38
*/
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogManager quartzJobLogManager;
	
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<>(query);
		quartzJobLogManager.listForPage(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = quartzJobLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = quartzJobLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}
