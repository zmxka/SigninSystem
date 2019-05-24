package com.group.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.dao.AttendenceInformationDAO;
import com.group.entity.AttendenceInformation;

import DBHelper.DBHelper;

/**
 * <p>Title: AttendenceInformationServlet<／p>
 * <p>Description: 签到信息<／p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
@WebServlet("/view/jsp/attinfo.do")
public class AttendenceInformationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");

		// 获取前台选择的起止时间，保存为字符串形式
		String startdate = (String) request.getParameter("startdate");
		String enddate = (String) request.getParameter("enddate");

		// 分页
		int start = 0;
		int count = 5;

		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}

		int next = start + count;
		int pre = start - count;

		int total = new AttendenceInformationDAO().getTotal(startdate, enddate);

		int last;
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;

		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;
		
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);

		// 查询数据库，并将结果保存到List里
		List<AttendenceInformation> attinfos = new AttendenceInformationDAO().list(startdate, enddate);

		request.setAttribute("attinfos", attinfos);
		request.getRequestDispatcher("/view/jsp/attendencerecords.jsp").forward(request, response);

	}

}
