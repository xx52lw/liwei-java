package com.liwei.area.service.impl;

import com.liwei.area.entity.SysAreaEntity;
import com.liwei.area.manager.SysAreaManager;
import com.liwei.area.service.SysAreaService;
import com.liwei.common.cm.constant.MsgConstant;
import com.liwei.common.cm.entity.Query;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 *
 * 行政区域
 *
 *@file com.liwei.service.impl
 *@author liwei
 *@Date：下午6:35 下午6:35
*/
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

	@Autowired
	private SysAreaManager sysAreaManager;

	@Override
	public R listAreaByParentCode(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysAreaEntity> sysAreaEntities = sysAreaManager.listAreaByParentCode(query);
		return  CommonUtils.msg(sysAreaEntities);
	}


	@Override
	public List<SysAreaEntity> listAreaByParentCode(String areaCode) {
		Query query = new Query();
		query.put("parentCode",areaCode);
		List<SysAreaEntity> areas = sysAreaManager.listAreaByParentCode(query);
		for (SysAreaEntity area : areas) {
			area.checkParent();
		}
		return areas;
	}

	@Override
	public R saveArea(SysAreaEntity area) {
		int count = sysAreaManager.saveArea(area);
		return CommonUtils.msg(count);
	}

	@Override
	public R getAreaById(Long areaId) {
		SysAreaEntity area = sysAreaManager.getAreaById(areaId);
		area.checkParentName();
		return CommonUtils.msg(area);
	}

	@Override
	public R updateArea(SysAreaEntity area) {
		int count = sysAreaManager.updateArea(area);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		boolean children = sysAreaManager.hasChildren(id);
		if(children) {
			return R.error(MsgConstant.MSG_HAS_CHILD);
		}
		int count = sysAreaManager.batchRemoveArea(id);
		return CommonUtils.msg(id, count);
	}


}
