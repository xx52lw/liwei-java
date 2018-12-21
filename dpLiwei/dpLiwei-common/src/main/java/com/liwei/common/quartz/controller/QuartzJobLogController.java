package com.liwei.common.quartz.controller;

import com.liwei.common.quartz.entity.QuartzJobLogEntity;
import com.liwei.common.quartz.service.QuartzJobLogService;
import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * 定时任务日志
 *
 *@file com.liwei.common.quartz.controller
 *@author liwei
 *@Date：下午5:16 下午5:16
*/
@RestController
@RequestMapping("/quartz/job/log")
public class QuartzJobLogController {
	@Autowired
	private QuartzJobLogService quartzJobLogService;
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<QuartzJobLogEntity> list(@RequestBody Map<String, Object> params) {
		return quartzJobLogService.listForPage(params);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务日志")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return quartzJobLogService.batchRemove(id);
	}
	
	/**
	 * 清空
	 * @return
	 */
	@SysLog("清空定时任务日志")
	@RequestMapping("/clear")
	public R batchRemoveAll() {
		return quartzJobLogService.batchRemoveAll();
	}
	
}
