package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group.dao.LeaveRequestDao;
import com.group.entity.LeaveRequest;
import com.group.entity.LeaveType;
import DBHelper.DBHelper;

/**
 * <p>Title: LeaveRequestServlet<／p>
 * <p>Description: 请假申请<／p>
 * @author gaocunzhi
 * @date 2018.11.20
 */
@WebServlet("/LeaveRequestServlet")
public class LeaveRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<LeaveType> leaveTypes = new ArrayList<LeaveType>();
		LeaveType leaveType = null;
		Connection c;
		try {
			c = DBHelper.getInstance().getConnection();
			Statement st = c.createStatement();
			String sql = "select *from leavetype";
			ResultSet rSet = st.executeQuery(sql);
			while(rSet.next()) {
				leaveType = new LeaveType();
				leaveType.setLeaveid(rSet.getInt("leaveid"));
				leaveType.setLeaveType(rSet.getString("type"));
				leaveTypes.add(leaveType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("leavetypes", leaveTypes);
		session.setAttribute("leavetypes", leaveTypes);
		request.getRequestDispatcher("view/jsp/LeaveRequest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//输入获取
				String startTime = request.getParameter("startTime");
				String endTime = request.getParameter("endTime");
				startTime  +=" 00:00:00";
				endTime  +=" 00:00:00";
				System.out.println(startTime);
				Timestamp startDate = new Timestamp(System.currentTimeMillis());  
				Timestamp endDate = new Timestamp(System.currentTimeMillis());
				try {  
		            startDate = Timestamp.valueOf(startTime);  
		            endDate = Timestamp.valueOf(endTime);
		 
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
				String leaveType = request.getParameter("leaveType");
				String message = request.getParameter("message");
				Date date = new Date();
				Timestamp recordTime = new Timestamp(date.getTime());
				HttpSession session = request.getSession();
				int userId  = Integer.valueOf((String)session.getAttribute("userId")) ;
				
				//对象建立
				LeaveRequest leaveRequest = new LeaveRequest();
				leaveRequest.setEndTime(endDate);
				leaveRequest.setLeaveContent(message);
				leaveRequest.setLeaveType(Integer.valueOf(leaveType));
				leaveRequest.setRecordTime(recordTime);
				leaveRequest.setStartTime(startDate);
				leaveRequest.setUserId(userId);
				leaveRequest.setResult(0);
				//处理
				LeaveRequestDao leaveRequestDao = new LeaveRequestDao();
				try {
					leaveRequestDao.add(leaveRequest);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				PrintWriter out = response.getWriter();
				out.print("<p>submit successfully</p>");
				
	}

}
