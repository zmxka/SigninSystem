package com.group.servlet;

import java.io.IOException;
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
 * <p>Title: showleavetypeServlet<��p>
 * <p>Description: ��ʾ�������<��p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebServlet("/view/jsp/showleavetype.do")
public class showleavetypeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ѯ���ݿ⣬����������浽List��
		List<LeaveType> leaveytpeinfos = new leavetypeDAO().list();

		request.setAttribute("leaveytpeinfos", leaveytpeinfos);

		request.getRequestDispatcher("/view/jsp/leavetype.jsp").forward(request, response);

	}

}
