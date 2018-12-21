package com.liwei.common.cm.aspect;

import com.liwei.common.cm.annotation.SysLog;
import com.liwei.common.cm.entity.SysLogEntity;
import com.liwei.common.cm.entity.SysUserEntity;
import com.liwei.common.cm.manager.SysLogManager;
import com.liwei.common.cm.utils.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 *
 * 系统日志，切面处理类
 *
 *@file common.aspect
 *@author liwei
 *@Date：下午8:39 下午8:39
*/
@Aspect
@Component
public class SysLogAspect {
	
	@Autowired
	private SysLogManager sysLogManager;
	@Pointcut("@annotation(com.liwei.common.cm.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		SysUserEntity currUser = ShiroUtils.getUserEntity();
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		//保存日志
		saveSysLog(point, time, currUser);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time, SysUserEntity userEntity) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述
			sysLog.setOperation(syslog.value());
		}
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = JSONUtils.beanToJson(args[0]);
			sysLog.setParams(params);
		}catch (Exception e){

		}
		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IpUtils.getIpAddr(request));
		//用户名
		SysUserEntity currUser = ShiroUtils.getUserEntity();
		if(CommonUtils.isNullOrEmpty(currUser)) {
			// 方法执行后，当前用户为空，使用方法执行前获取用户，登出操作
			sysLog.setUserId(userEntity.getUserId());
			sysLog.setUsername(userEntity.getUsername());
		} else {
			// 方法执行后，当前用户不为空，使用方法执行后用户，登录操作
			sysLog.setUserId(currUser.getUserId());
			sysLog.setUsername(currUser.getUsername());
		}
		sysLog.setTime(time);
		//保存系统日志
		sysLogManager.saveLog(sysLog);
	}
	
}
