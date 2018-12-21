package com.liwei.common.cm.manager;

import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.SysLogEntity;

import java.util.List;

/**
 *
 * 系统日志
 *
 *@file common.manager
 *@author liwei
 *@Date：下午8:37 下午8:37
*/
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
