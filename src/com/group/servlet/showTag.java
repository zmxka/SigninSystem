package com.group.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import com.group.entity.AttendenceInformation;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * <p>Title: showTag<／p>
 * <p>Description: 前端显示<／p>
 * @author zhangjianpeng
 * @date 2018.11.20
 */
public class showTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		try {
			// 输出流
			JspWriter out = getJspContext().getOut();

			// 获取request
			HttpServletRequest request = (HttpServletRequest) ((PageContext)this.getJspContext()).getRequest();;

			List<AttendenceInformation> attinfo = null;
			attinfo = (List<AttendenceInformation>) request.getAttribute("attinfos");

			if (attinfo != null) {//向前台输出
				for (int i = 0; i < attinfo.size(); i++) {
					out.println("<tr>");
					out.println("<td class='text-center' style='width: 140px; padding:.75rem 0 !important;'>"
							+ attinfo.get(i).getId() + "</td>");
					out.println("<td>" + attinfo.get(i).getDepartmentname() + "</td>");
					out.println("<td>" + attinfo.get(i).getStaffid() + "</td>");
					out.println("<td>" + attinfo.get(i).getStaffname() + "</td>");
					out.println("<td>" + attinfo.get(i).getAttendtime() + "</td>");
					out.println("<td>" + attinfo.get(i).getAttendtype() + "</td>");
					out.println("</tr>");
				}
			}
		} catch (java.io.IOException e) {
			throw new JspException(e.getMessage());
		}
	}
}