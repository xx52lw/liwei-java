package com.dock.lwservice.code.web;

import com.dock.lwservice.code.service.UserReportService;
import com.dock.lwservice.model.Node;
import enums.Constant;
import enums.IPageDto;
import com.dock.lwservice.model.UserReport;
import enums.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.core.metadata.IPage;


/**
 * <p>
 * 用户登记接口
 * </p>
 *
 * @author liwei
 * @since 2020-03-05
 */
@RestController
@RequestMapping(Constant.PLATFORM.APP +"/userReport")
@Api(value = "用户登记接口", description = "用户登记接口")
public class UserReportController {

	@Autowired
    private UserReportService userReportService;


	@ApiOperation(value = "分页查询用户登记",response= UserReport.class)
	@PostMapping(value = "/getDetail")
	public IPage<UserReport> getDetail(@RequestBody IPageDto param) {
		return userReportService.selectByPage(param.getPage(), param.getCm());
	}

	@ApiOperation(value = "分页查询用户登记",response=UserReport.class)
	@PostMapping(value = "/getByPage")
	public IPage<UserReport> query(@RequestBody IPageDto param) {
		return userReportService.selectByPage(param.getPage(), param.getCm());
	}

	@ApiOperation(value = "分页查询用户登记",response=UserReport.class)
	@PostMapping(value = "/test")
	public Result test(@RequestBody IPageDto param) {
		return Result.success("123");
	}

	public static void main(String[] args) {

		Node linkNode1 = new Node(1);
		Node linkNode2 = new Node(2);
		Node linkNode3 = new Node(3);
		Node linkNode4 = new Node(4);
		Node linkNode5 = new Node(5);

		linkNode1.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        linkNode3.setNext(linkNode4);
        linkNode4.setNext(linkNode5);


	}








}