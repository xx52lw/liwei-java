package com.liwei.common.shiro.controller;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.controller.AbstractController;
import com.liwei.common.cm.entity.R;
import com.liwei.common.shiro.entity.SysMenuEntity;
import com.liwei.common.shiro.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * 系统菜单controller
 *
 *@file com.liwei.common.shiro.controller
 *@author liwei
 *@Date：下午5:37 下午5:37
*/
@RestController
@RequestMapping("/sys/menu")
@Api(description = "系统菜单controller")
public class SysMenuController extends AbstractController {

	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 用户菜单
	 * @return
	 */
	@RequestMapping("/user")
	public R user(){
		return sysMenuService.listUserMenu(getUserId());
	}
	
	/**
	 * 菜单列表
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "菜单列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<SysMenuEntity> listMenu(@RequestParam Map<String, Object> params) {
		List<SysMenuEntity> listMenu = sysMenuService.listMenu(params);
		return listMenu;
	}
	
	/**
	 * 选择菜单(添加、修改)
	 * @return
	 */
	@RequestMapping("/select")
	public R select() {
		return sysMenuService.listNotButton();
	}
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	@SysLog("新增菜单")
	@RequestMapping("/save")
	public R save(@RequestBody SysMenuEntity menu) {
		return sysMenuService.saveMenu(menu);
	}

	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysMenuService.getMenuById(id);
	}
	
	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 */
	@SysLog("修改菜单")
	@RequestMapping("/update")
	public R update(@RequestBody SysMenuEntity menu) {
		return sysMenuService.updateMenu(menu);
	}
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	@SysLog("删除菜单")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysMenuService.batchRemove(id);
	}
	
}
