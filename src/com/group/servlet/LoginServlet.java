package com.group.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group.dao.*;
import com.group.entity.*;
/**
 * 
 * <p>Title: LoginServlet<／p>
 * <p>Description: 验证用户身份<／p>
 * @author lisilin
 * @date 2018年11月20日
 */
public class LoginServlet extends HttpServlet {
	
	/* 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");

		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();

		String userName = "";
		String password = "";

		userName = request.getParameter("userName");
		password = request.getParameter("password");

		int flag = new LoginDAO().CheckList(userName, password);

		session.setAttribute("flag", flag);
		session.setAttribute("userName", userName);
		
		userInfo user = new LoginDAO().Check(userName);
		session.setAttribute("user", user);
		String userId =String.valueOf(user.getUserId());
		session.setAttribute("userId",userId);
		System.out.println(userId);
		out.print(flag);
		out.close();
	}

}
