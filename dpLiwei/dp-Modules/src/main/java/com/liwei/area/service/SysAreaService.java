package com.liwei.area.service;

import com.liwei.area.entity.SysAreaEntity;
import com.liwei.common.cm.entity.R;

import java.util.List;
import java.util.Map;

/**
 *
 * 行政区域
 *
 *@file com.liwei.service
 *@author liwei
 *@Date：下午6:31 下午6:31
*/
public interface SysAreaService {

	List<SysAreaEntity> listAreaByParentCode(String areaCode);
	
	R listAreaByParentCode(Map<String, Object> params);
	
	R saveArea(SysAreaEntity area);
	
	R getAreaById(Long areaId);
	
	R updateArea(SysAreaEntity area);
	
	R batchRemoveArea(Long[] id);
	
}
