package com.group.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * <p>Title: Logout<��p>
 * <p>Description: �������session��Ϣ���ǳ�ϵͳ<��p>
 * @author lisilin
 * @date 2018��11��20��
 */

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    session.removeAttribute("userName");
	    session.removeAttribute("flag");
	    session.removeAttribute("user");
	    
	    response.sendRedirect("view/jsp/Login.jsp");

	}
}
