package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.group.entity.LeaveEntity;
import com.group.util.DBHelper;

/**
 * Servlet implementation class ApprovalResults
 */
@WebServlet("/ApprovalResults")
public class ApprovalResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		ArrayList<LeaveEntity> leaveList = new ArrayList<LeaveEntity>();
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from leaveInfo where userId ="+userId+" order by recordTime desc";
			System.out.println(sql);
			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				LeaveEntity leave = new LeaveEntity();
				leave.setLeaveContent(rs.getString("leaveContent"));
				leave.setLeaveId(rs.getInt("leaveId"));
				
				leave.setEndTime(rs.getTimestamp("endTime"));
				leave.setStartTime(rs.getTimestamp("startTime"));
				leave.setRecordTime(rs.getTimestamp("recordTime"));
				
				String sqlUserLookUp = "select userName from userInfo where userId = ?";
				PreparedStatement psLookUpUser = c.prepareStatement(sqlUserLookUp);
				
				
				Integer leaveType = rs.getInt("leaveType");
				Integer leaveResult = rs.getInt("result");
				
				leave.setLeaveResult(leaveResultInt2String(leaveResult));
				leaveList.add(leave);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
        //json在这里存放的是数组信息
       JSONObject json=new JSONObject();


       //两个数据
       JSONObject temp=null;
    		   temp = new JSONObject();
    		   try {
				temp.put("recordTime", leaveList.get(0).getRecordTime());
				temp.put("startTime", leaveList.get(0).getStartTime());
	    		temp.put("endTime", leaveList.get(0).getEndTime());
	    		temp.put("result", leaveList.get(0).getLeaveResult());
	    		
	    		//添加到json中
	            json.put("leave", temp);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

       //向前台的页面输出结果
       PrintWriter out=response.getWriter();
       out.println(json);
       out.close();
		
	}

	public String leaveResultInt2String(Integer result){
		
		if(result == 0){
			return "未审核";
		}else if(result == 1){
			return "已同意";
		}
		else if(result == 2){
			return "已拒绝";
		}
		
		return "";
	}

}
