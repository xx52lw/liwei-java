package com.liwei.common.quartz.service;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.quartz.entity.QuartzJobLogEntity;


import java.util.Map;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月21日 上午11:17:26
 */
public interface QuartzJobLogService {

	Page<QuartzJobLogEntity> listForPage(Map<String, Object> params);

	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
