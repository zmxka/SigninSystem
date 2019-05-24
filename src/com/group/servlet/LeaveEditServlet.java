package com.group.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.dao.LeaveEditDao;
import com.group.entity.LeaveEntity;



/**
 * <p>Title: LeaveEditServlet<／p>
 * <p>Description: 处理请假<／p>
 * @author pangchangsong
 * @date 2018.11.20
 */
public class LeaveEditServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveEditServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LeaveEditDao leaveEditDao = new LeaveEditDao();
		
		int start = 0;
		int count = 20;
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}
		int next = start + count;
		int pre = start - count;
		int total = leaveEditDao.getTotal();
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
		
		List<LeaveEntity> list = leaveEditDao.getList(start, count);
		
		request.setAttribute("leaveList", list);
		request.getRequestDispatcher("LeaveEdit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LeaveEditDao leaveEditDao = new LeaveEditDao();
		
		Integer leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String result = request.getParameter("result");
		

		LeaveEntity leave = new LeaveEntity();
		leave.setLeaveId(leaveId);
		leave.setLeaveResult(result);
		
		System.out.println(result);
		
		int flag = leaveEditDao.update(leave);
		
		response.getWriter().print(flag);
		
	}

}
