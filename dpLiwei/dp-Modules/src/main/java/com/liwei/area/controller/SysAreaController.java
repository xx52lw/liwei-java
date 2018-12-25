package com.liwei.area.controller;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.controller.AbstractController;
import com.liwei.common.cm.entity.R;
import com.liwei.area.entity.SysAreaEntity;
import com.liwei.area.service.SysAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 行政区域
 *
 *@file com.liwei.controller
 *@author liwei
 *@Date：下午6:37 下午6:37
*/
@RestController
@Api(description = "行政区域")
@RequestMapping(value = "/sys/area")
public class SysAreaController extends AbstractController {

	@Autowired
	private SysAreaService sysAreaService;
	
	/**
	 * 根据父级code查询子节点，子区域列表
	 * @param params
	 * @return
	 */
	@SysLog("根据父级code查询子节点，子区域列表")
	@ApiOperation(value = "根据父级code查询子节点，子区域列表")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public R list(@RequestBody Map<String, Object> params) {
		return sysAreaService.listAreaByParentCode(params);
	}
	
	/**
	 * 根据父级code查询子节点，树形目录
	 * @return
	 */
	@SysLog("根据父级code查询子节点，树形目录")
	@ApiOperation(value = "根据父级code查询子节点，树形目录")
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public List<SysAreaEntity> select(@RequestParam String areaCode) {
		return sysAreaService.listAreaByParentCode(areaCode);
	}
	
	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	@SysLog("新增区域")
	@ApiOperation(value = "新增区域")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public R save(@RequestBody SysAreaEntity area) {
		return sysAreaService.saveArea(area);
	}
	
	/**
	 * 查询详情
	 * @param areaId
	 * @return
	 */
	@SysLog("查询详情")
	@ApiOperation(value = "查询详情")
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public R info(@RequestBody Long areaId) {
		return sysAreaService.getAreaById(areaId);
	}
	
	/**
	 * 修改区域
	 * @param area
	 * @return
	 */
	@SysLog("修改区域")
	@ApiOperation(value = "修改区域")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public R update(@RequestBody SysAreaEntity area) {
		return sysAreaService.updateArea(area);
	}
	
	/**
	 * 删除区域
	 * @param id
	 * @return
	 */
	@SysLog("删除区域")
	@ApiOperation(value = "删除区域")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public R remove(@RequestBody Long[] id) {
		return sysAreaService.batchRemoveArea(id);
	}

}
