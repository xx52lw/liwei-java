package com.dock.lwservice.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.dock.lwservice.model.UserReport;

import java.util.Map;

/**
 * <p>
 * 用户登记
 * </p>
 *
 * @author liwei
 * @since 2020-03-05
 */
public interface UserReportService extends IService<UserReport> {

    IPage<UserReport> selectByPage(Page page, Map<String, Object> cm);
}