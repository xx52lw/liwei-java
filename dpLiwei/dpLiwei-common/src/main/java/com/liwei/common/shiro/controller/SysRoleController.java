package com.liwei.common.shiro.controller;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.constant.SystemConstant;
import com.liwei.common.cm.controller.AbstractController;
import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.shiro.entity.SysRoleEntity;
import com.liwei.common.shiro.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * 系统角色
 *
 *@file com.liwei.common.shiro.controller
 *@author liwei
 *@Date：下午5:37 下午5:37
*/
@RestController
@Api(description = "系统角色")
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	@SysLog(("角色列表"))
	@ApiOperation(value = "角色列表")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<SysRoleEntity> list(@RequestBody Map<String, Object> params) {
		if (getUserId() != SystemConstant.SUPER_ADMIN) {
			params.put("userIdCreate", getUserId());
		}
		Page<SysRoleEntity> sysRoleEntityPage = sysRoleService.listRole(params);
		return sysRoleEntityPage;
	}
	
	/**
	 * 用户角色
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysRoleEntity> listRole() {
		return sysRoleService.listRole();
	}
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@SysLog("新增角色")
	@ApiOperation(value = "新增角色")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public R saveRole(@RequestBody SysRoleEntity role) {
		role.setUserIdCreate(getUserId());
		return sysRoleService.saveRole(role);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getRoleById(@RequestBody Long id) {
		return sysRoleService.getRoleById(id);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	public R updateRole(@RequestBody SysRoleEntity role) {
		return sysRoleService.updateRole(role);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	@SysLog("删除角色")
	@ApiOperation(value = "删除角色")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public R batchRemove(@RequestBody Long[] id) {
		return sysRoleService.batchRemove(id);
	}
	
	/**
	 * 分配权限
	 * @param role
	 * @return
	 */
	@SysLog("分配权限")
	@ApiOperation(value = "分配权限")
	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public R updateRoleAuthorization(@RequestBody SysRoleEntity role) {
		return sysRoleService.updateRoleAuthorization(role);
	}
	
}
