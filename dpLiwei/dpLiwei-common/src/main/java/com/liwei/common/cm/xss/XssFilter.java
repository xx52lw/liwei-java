package com.liwei.common.cm.xss;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * XSS过滤
 *
 *@file common.xss
 *@author liwei
 *@Date：下午8:30 下午8:30
*/
public class XssFilter implements Filter {

	private List<String> urlExclusion = new ArrayList<>();

	@Override
	public void init(FilterConfig config) {
		String urlExclusionStr = config.getInitParameter("urlExclusion");
		if (StringUtils.isNotBlank(urlExclusionStr)) {
			String[] urlExclusions = urlExclusionStr.split(",");
			for (String url : urlExclusions) {
				if (StringUtils.isNotBlank(url)) {
					urlExclusion.add(url);
				}
			}
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String servletPath = httpServletRequest.getServletPath();
		if (!urlExclusion.isEmpty() && urlExclusion.contains(servletPath)) {
			chain.doFilter(request, response);
		} else {
			chain.doFilter(new XssHttpServletRequestWrapper(httpServletRequest), response);
		}
	}

	@Override
	public void destroy() { }

}