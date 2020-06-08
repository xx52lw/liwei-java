package com.liwei.area.controller;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.controller.AbstractController;
import com.liwei.common.cm.entity.R;
import com.liwei.area.entity.SysMacroEntity;
import com.liwei.area.service.SysMacroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 通用字典
 *
 *@file com.liwei.controller
 *@author liwei
 *@Date：下午6:36 下午6:36
*/
@RestController
@RequestMapping("/sys/macro")
public class SysMacroController extends AbstractController {

	@Autowired
	private SysMacroService sysMacroService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list")
	public List<SysMacroEntity> list() {
		return sysMacroService.listMacro();
	}
	
	/**
	 * 树形列表
	 * @return
	 */
	@RequestMapping(value = "/select")
	public List<SysMacroEntity> select() {
		return sysMacroService.listNotMacro();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping(value = "/save")
	public R save(@RequestBody SysMacroEntity macro) {
		return sysMacroService.saveMacro(macro);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/info")
	public R info(@RequestBody Long id) {
		return sysMacroService.getObjectById(id);
	}
	
	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	@SysLog("修改字典")
	@RequestMapping(value = "/update")
	public R update(@RequestBody SysMacroEntity macro) {
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 显示字典
	 * @param id
	 * @return
	 */
	@SysLog("显示字典")
	@RequestMapping(value = "/enable")
	public R updateStateShow(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(1);
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 隐藏字典
	 * @param id
	 * @return
	 */
	@SysLog("隐藏字典")
	@RequestMapping(value = "/disable")
	public R updateStateHide(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(0);
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping(value = "/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysMacroService.batchRemove(id);
	}

	/**
	 * 获取某个类型所有参数值，用于前台构建下拉框
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/value")
	public List<SysMacroEntity> listMacroValue(@RequestParam String value) {
		return sysMacroService.listMacroValue(value);
	}
	
}
