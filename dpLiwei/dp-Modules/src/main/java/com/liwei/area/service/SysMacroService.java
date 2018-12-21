package com.liwei.area.service;

import com.liwei.area.entity.SysMacroEntity;
import com.liwei.common.cm.entity.R;

import java.util.List;

/**
 *
 * 通用字典
 *
 *@file com.liwei.service
 *@author liwei
 *@Date：下午6:31 下午6:31
*/
public interface SysMacroService {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	R saveMacro(SysMacroEntity macro);
	
	R getObjectById(Long id);
	
	R updateMacro(SysMacroEntity macro);
	
	R batchRemove(Long[] id);

	List<SysMacroEntity> listMacroValue(String type);
	
}
