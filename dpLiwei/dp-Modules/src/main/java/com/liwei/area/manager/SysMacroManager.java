package com.liwei.area.manager;

import com.liwei.area.entity.SysMacroEntity;
import java.util.List;

/**
 *
 * 通用字典
 *
 *@file com.liwei.manager
 *@author liwei
 *@Date：下午6:33 下午6:33
*/
public interface SysMacroManager {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	int saveMacro(SysMacroEntity macro);
	
	SysMacroEntity getObjectById(Long id);
	
	int updateMacro(SysMacroEntity macro);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);

	List<SysMacroEntity> listMacroValue(String type);
	
}
