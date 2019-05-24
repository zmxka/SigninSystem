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
 * <p>Title: modifyleavetypeServlet<��p>
 * <p>Description: �޸��������<��p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebServlet("/view/jsp/modifyleavetype.do")
public class modifyleavetypeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		// ��url�л�ò���id��type
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		// ִ��ɾ������
		leavetypeDAO op = new leavetypeDAO();
		op.modifytype(id, type);

		// ��ת��loadleavetype.jsp
		response.sendRedirect("/SigninSystem/view/jsp/loadleavetype.jsp");

	}

}
