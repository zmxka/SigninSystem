
package com.group.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.group.dao.LoginDAO;
import com.group.entity.userInfo;

/**
 * 
 * <p>Title: GetFilter<��p>
 * <p>Description: ��δ��¼ʱ����������get��������¼ҳ�� <��p>
 * @author lisilin
 * @date 2018��11��20��
 */

public class GetFilter implements Filter {

	private FilterConfig config = null;

	/* 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	/* 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpres = (HttpServletResponse) response;
		
		// ��ȡ��Ҫ��ת����ҳ��·��
		String redirectPath = httpreq.getContextPath() + config.getInitParameter("redirectPath");
		// ͨ��get��������ҳ��ʱ���Զ���ת����ҳLogin.jsp
		if (httpreq.getMethod().equalsIgnoreCase("get")) {

			String currentUri = httpreq.getRequestURI();
			int i = 0;
			if(httpreq.getSession().getAttribute("flag")!=null) {
				if((int)httpreq.getSession().getAttribute("flag") == 2 
					|| (int)httpreq.getSession().getAttribute("flag") == 3 ) {
					 i = 1 ;
				 }
			}
			if ( i == 1 || redirectPath.equals(currentUri)|| currentUri.indexOf(".png") != -1 || currentUri.indexOf(".jpg") != -1 || currentUri.indexOf(".css") != -1 || currentUri.indexOf(".js") != -1) {
				chain.doFilter(request, response);
			} else {
				httpres.sendRedirect("/SigninSystem/view/jsp/Login.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/* 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.config = null;

	}

}
