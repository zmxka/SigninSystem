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
 * <p>Title: ModifyServlet<／p>
 * <p>Description: 修改密码<／p>
 * @author lisilin
 * @date 2018年11月28日
 */
public class ModifyServlet extends HttpServlet {
	
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

		String password = "";
		String userName = "";

		password = request.getParameter("newPassword");

		userName = (String) session.getAttribute("userName");

		boolean flag2 = new LoginDAO().update(userName, password);

		out.print(flag2);
		out.close();
	}

}
