package com.liwei.common.quartz.controller;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.entity.Page;
import com.liwei.common.cm.entity.R;
import com.liwei.common.quartz.entity.QuartzJobEntity;
import com.liwei.common.quartz.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * 定时任务
 *
 *@file com.liwei.common.quartz.controller
 *@author liwei
 *@Date：下午5:16 下午5:16
*/
@RestController
@RequestMapping("/quartz/job")
public class QuartzJobController {

	@Autowired
	private QuartzJobService quartzJobService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<QuartzJobEntity> list(@RequestBody Map<String, Object> params) {
		return quartzJobService.list(params);
	}

	/**
	 * 新增任务
	 * @param job
	 * @return
	 */
	@SysLog("新增定时任务")
	@RequestMapping("/save")
	public R save(@RequestBody QuartzJobEntity job) {
		return quartzJobService.saveQuartzJob(job);
	}

	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return quartzJobService.getQuartzJobById(id);
	}
	
	/**
	 * 修改任务
	 * @param job
	 * @return
	 */
	@SysLog("修改定时任务")
	@RequestMapping("/update")
	public R update(@RequestBody QuartzJobEntity job) {
		return quartzJobService.updateQuartzJob(job);
	}
	
	/**
	 * 删除定时任务
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return quartzJobService.batchRemoveQuartzJob(id);
	}
	
	/**
	 * 立即运行
	 * @param id
	 * @return
	 */
	@SysLog("立即运行定时任务")
	@RequestMapping("/run")
	public R run(@RequestBody Long[] id) {
		return quartzJobService.run(id);
	}
	
	/**
	 * 暂停任务
	 * @param id
	 * @return
	 */
	@SysLog("暂停定时运行")
	@RequestMapping("/disable")
	public R pause(@RequestBody Long[] id) {
		return quartzJobService.pause(id);
	}
	
	/**
	 * 启用任务
	 * @param id
	 * @return
	 */
	@SysLog("启用定时任务")
	@RequestMapping("/enable")
	public R resume(@RequestBody Long[] id) {
		return quartzJobService.resume(id);
	}


}
