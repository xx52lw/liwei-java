package com.liwei.common.shiro.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.constant.SystemConstant;
import com.liwei.common.cm.controller.AbstractController;
import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.entity.SysUserEntity;
import com.liwei.common.cm.validator.LengthValidator;
import com.liwei.common.cm.validator.NotNullValidator;
import com.liwei.common.shiro.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * 系统用户
 *
 *@file com.liwei.common.shiro.controller
 *@author liwei
 *@Date：下午5:38 下午5:38
*/
@RestController
@RequestMapping("/sys/user")
@Api(description = "系统用户")
public class SysUserController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @param params
	 * @return
	 */
	@SysLog(("用户列表"))
	@ApiOperation(value = "用户列表")
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public Page<SysUserEntity> list(@RequestBody Map<String, Object> params) {
		if(getUserId() != SystemConstant.SUPER_ADMIN) {
			params.put("userIdCreate", getUserId());
		}
		return sysUserService.listUser(params);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@SysLog(("获取登录的用户信息"))
	@ApiOperation(value = "获取登录的用户信息")
	@RequestMapping(value = "/info",method = RequestMethod.GET)
	public R info(){

		SysUserEntity user = getUser();
		return R.ok().put("user", user);
	}
	
	/**
	 * 用户权限
	 * @return
	 */
	@SysLog(("用户权限"))
	@ApiOperation(value = "用户权限")
	@RequestMapping(value = "/perms",method = RequestMethod.GET)
	public R listUserPerms() {
		return sysUserService.listUserPerms(getUserId());
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@SysLog("新增用户")
	@ApiOperation("新增用户")
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public R save(@RequestBody SysUserEntity user) {
		ComplexResult result = FluentValidator.checkAll()
				.on(user.getUsername(), new NotNullValidator("用户名"))
				.on(user.getPassword(), new LengthValidator(1, 5, "密码"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (result.isSuccess() != true) {
			return R.error(result.getErrors());
		}
		else {
			user.setUserId(getUserId());
			return sysUserService.saveUser(user);
		}
	}
	
	/**
	 * 根据id查询详情
	 * @param userId
	 * @return
	 */
	@SysLog("根据id查询详情")
	@ApiOperation("根据id查询详情")
	@RequestMapping(value = "/infoUser",method = RequestMethod.POST)
	public R getById(@RequestBody Long userId) {
		return sysUserService.getUserById(userId);
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@SysLog("修改用户")
	@ApiOperation("修改用户")
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public R update(@RequestBody SysUserEntity user) {
		return sysUserService.updateUser(user);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户")
	@ApiOperation("删除用户")
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public R batchRemove(@RequestBody Long[] id) {
		return sysUserService.batchRemove(id);
	}
	
	/**
	 * 用户修改密码
	 * @param pswd
	 * @param newPswd
	 * @return
	 */
	@SysLog("修改密码")
	@ApiOperation("修改密码")
	@RequestMapping(value = "/updatePswd",method = RequestMethod.POST)
	public R updatePswdByUser(String pswd, String newPswd) {
		SysUserEntity user = getUser();
		user.setPassword(pswd);//原密码
		user.setEmail(newPswd);//邮箱临时存储新密码
		return sysUserService.updatePswdByUser(user);
	}
	
	/**
	 * 启用账户
	 * @param id
	 * @return
	 */
	@SysLog("启用账户")
	@ApiOperation("启用用户")
	@RequestMapping(value = "/enable",method = RequestMethod.POST)
	public R updateUserEnable(@RequestBody Long[] id) {
		return sysUserService.updateUserEnable(id);
	}
	
	/**
	 * 禁用账户
	 * @param id
	 * @return
	 */
	@SysLog("禁用账户")
	@ApiOperation("禁用用户")
	@RequestMapping(value = "/disable",method = RequestMethod.POST)
	public R updateUserDisable(@RequestBody Long[] id) {
		return sysUserService.updateUserDisable(id);
	}
	
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	@SysLog("重置密码")
	@ApiOperation("重置密码")
	@RequestMapping(value = "/reset",method = RequestMethod.POST)
	public R updatePswd(@RequestBody SysUserEntity user) {
		return sysUserService.updatePswd(user);
	}
}
