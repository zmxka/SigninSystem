package com.group.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.dao.*;

/**
 * <p>
 * Title: addleavetypeServlet<��p>
 * <p>
 * Description: ����������<��p>
 * 
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebServlet("/view/jsp/addleavetype.do")
public class addleavetypeServlet extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ��url�л�ò���type
		String type = request.getParameter("type");

		// ִ��ɾ������
		leavetypeDAO op = new leavetypeDAO();
		op.addtype(type);

		// ��ת��loadleavetype.jsp
		response.sendRedirect("/SigninSystem/view/jsp/loadleavetype.jsp");

	}

}
