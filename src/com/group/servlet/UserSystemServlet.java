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
 * <p>Title: UserSystemServlet<／p>
 * <p>Description: 跳转到用户系统<／p>
 * @author lisilin
 * @date 2018年11月20日
 */
public class UserSystemServlet extends HttpServlet{
	/* 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/jsp/user.jsp").forward(request, response);
	}
}
