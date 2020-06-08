package com.dock.lwservice.code.service.impl;

import com.dock.lwservice.code.mapper.UserReportMapper;
import com.dock.lwservice.code.service.UserReportService;

import base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import com.dock.lwservice.model.UserReport;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 用户登记  服务实现类
 * </p>
 *
 * @author liwei
 * @since 2020-03-05
 */
@Slf4j
@Service
public class UserReportServiceImpl extends BaseServiceImpl<UserReportMapper, UserReport> implements UserReportService {

    @Resource
    private UserReportMapper userReportMapper;

    @Override
    public IPage<UserReport> selectByPage(Page page, Map<String, Object> cm) {

        return userReportMapper.selectByPage(page, cm);
    }
}