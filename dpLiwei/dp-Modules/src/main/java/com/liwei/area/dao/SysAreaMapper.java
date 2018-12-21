package com.liwei.area.dao;

import com.liwei.area.entity.SysAreaEntity;
import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.cm.entity.Query;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 行政区域
 *
 *@file com.liwei.dao
 *@author liwei
 *@Date：下午6:28 下午6:28
*/
@MapperScan
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Long areaId);
	
}
