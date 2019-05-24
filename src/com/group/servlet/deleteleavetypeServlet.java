package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.dao.*;
import com.group.entity.*;

import DBHelper.DBHelper;

/**
 * <p>Title: deleteleavetypeServlet<／p>
 * <p>Description: 删除请假类型<／p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebServlet("/view/jsp/deleteleavetype.do")
public class deleteleavetypeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		//从url中获取参数id
		String id = request.getParameter("id");
		
		// 执行删除操作
		leavetypeDAO op = new leavetypeDAO();
		op.deletetype(id);

		// 跳转到loadleavetype.jsp
		response.sendRedirect("/SigninSystem/view/jsp/loadleavetype.jsp");
	}

}
