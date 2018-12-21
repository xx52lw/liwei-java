package com.liwei.common.cm.service.impl;

import com.liwei.common.cm.service.SysLogService;
import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.entity.SysLogEntity;
import com.liwei.common.cm.manager.SysLogManager;
import com.liwei.common.cm.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * 系统日志
 *
 *@file common.service.impl
 *@author liwei
 *@Date：下午8:36 下午8:36
*/
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogManager sysLogManager;
	
	@Override
	public Page<SysLogEntity> listLog(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysLogEntity> page = new Page<>(query);
		sysLogManager.listLog(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = sysLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}

}
