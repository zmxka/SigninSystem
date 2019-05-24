package com.group.dao;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.group.entity.LeaveType;

/**
 * <p>Title: CounterTag<／p>
 * <p>Description: 显示请假类型<／p>
 * @author gaocunzhi
 * @date 2019年1月6日
 */
public class CounterTag extends SimpleTagSupport {

	private static int counter = 1;

	public void doTag() throws JspException, IOException {
		HttpServletRequest request=(HttpServletRequest) ((PageContext)this.getJspContext()).getRequest();
		HttpSession session=((PageContext)this.getJspContext()).getSession();
		
		JspWriter out = getJspContext().getOut();
		String outPrint = "";
		ArrayList<LeaveType> leaveTypes = (ArrayList<LeaveType>) session.getAttribute("leavetypes");
		for (int i = 0; i < leaveTypes.size(); i++) {
			outPrint += "<input type='radio' name='leaveType' value="+leaveTypes.get(i).getLeaveid();
			outPrint +=">"+"&nbsp&nbsp"+leaveTypes.get(i).getLeaveType()+"&nbsp&nbsp&nbsp";
		}
		out.print(outPrint);
		
	}
}
