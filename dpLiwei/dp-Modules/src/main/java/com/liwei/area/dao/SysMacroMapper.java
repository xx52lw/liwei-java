package com.liwei.area.dao;

import com.liwei.area.entity.SysMacroEntity;
import com.liwei.common.cm.dao.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 *
 * 通用字典
 *
 *@file com.liwei.dao
 *@author liwei
 *@Date：下午6:28 下午6:28
*/
@MapperScan
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	List<SysMacroEntity> listNotMacro();
	
	int countMacroChildren(Long typeId);

	List<SysMacroEntity> listMacroValue(String type);
	
}
