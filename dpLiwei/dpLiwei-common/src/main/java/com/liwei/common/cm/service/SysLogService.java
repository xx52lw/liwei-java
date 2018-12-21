package com.liwei.common.cm.service;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.entity.SysLogEntity;

import java.util.Map;

/**
 *
 * 系统日志
 *
 *@file common.service
 *@author liwei
 *@Date：下午8:35 下午8:35
*/
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
