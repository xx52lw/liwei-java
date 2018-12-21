package com.liwei.common.shiro.security;

import com.liwei.common.cm.entity.R;
import com.liwei.common.cm.utils.WebUtils;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * shiro ajax 认证
 *
 *@file com.liwei.common.shiro.security
 *@author liwei
 *@Date：下午5:19 下午5:19
*/
public class AjaxAuthenticationFilter extends AuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if(WebUtils.isAjax(httpReq)) {
			System.err.println("ajax 登录验证");
			HttpServletResponse httpRes = (HttpServletResponse) response;
			R r = R.error(401, "未登录");
			WebUtils.write(httpRes, r);
		}

		return false;
	}


	
}
