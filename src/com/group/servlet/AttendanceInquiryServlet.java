package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.group.dao.AttendanceInquiryDao;
import com.group.entity.Attendance;

/**
 * <p>
 * Title: AttendanceInquiryServlet<／p>
 * <p>
 * Description: 获取个人签到信息<／p>
 * 
 * @author gaocunzhi
 * @date 2018.11.20
 */
@WebServlet("/AttendanceInquiryServlet")
public class AttendanceInquiryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ArrayList<Attendance> list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceInquiryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userId = Integer.valueOf(request.getParameter("userId"));
		AttendanceInquiryDao attendanceInquiryDao = new AttendanceInquiryDao();
		list = attendanceInquiryDao.show(userId);
		session.setAttribute("list", list);
		System.out.println(list.get(0).getUserId());
		;
		int total = list.size();
		request.setAttribute("total", total);
		response.setContentType("application/text; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(total);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		startTime += " 00:00:00";
		endTime += " 00:00:00";
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = new Timestamp(System.currentTimeMillis());
		try {
			ts2 = Timestamp.valueOf(endTime);
			System.out.println(ts2);
			ts1 = Timestamp.valueOf(startTime);
			System.out.println(ts1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Attendance> newlist = new ArrayList<Attendance>();
		for (Attendance a : list) {
			if (a.getTimestamp().after(ts1) && a.getTimestamp().before(ts2)) {
				newlist.add(a);
			}
		}
		System.out.println(newlist.get(0).getAttendId());
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();

		// 涓や釜鏁版嵁
		JSONObject temp = null;
		try {

			for (int i = 0, j = 0; i < newlist.size(); i++) {
				temp = new JSONObject();
				temp.put("time", newlist.get(i).getTimestamp());
				temp.put("type", newlist.get(i).getAttendType());
				System.out.println(newlist.get(i).getTimestamp());
				array.put(j, temp);
				j++;
			}

			// 娣诲姞鍒癹son涓�
			json.put("newlist", array);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 鍚戝墠鍙扮殑椤甸潰杈撳嚭缁撴灉
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();

	}

}
