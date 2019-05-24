package com.group.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * <p>Title: leavetypeFilter<／p>
 * <p>Description: 一个过滤器，实现在访问页面之前先执行servlet，
 * 						再跳转到jsp Servlet Filter implementation class<／p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebFilter(filterName = "/leavetypeFilter", urlPatterns = "/view/jsp/loadleavetype.jsp")
public class leavetypeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public leavetypeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("showleavetype.do").forward(request, response);
		return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
