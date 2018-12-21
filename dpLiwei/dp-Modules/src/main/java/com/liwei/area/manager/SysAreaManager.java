package com.liwei.area.manager;

import com.liwei.common.cm.entity.Query;
import com.liwei.area.entity.SysAreaEntity;
import java.util.List;

/**
 *
 * 行政区域
 *
 *@file com.liwei.manager
 *@author liwei
 *@Date：下午6:32 下午6:32
*/
public interface SysAreaManager {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int saveArea(SysAreaEntity area);
	
	SysAreaEntity getAreaById(Long areaId);
	
	int updateArea(SysAreaEntity area);
	
	int batchRemoveArea(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
