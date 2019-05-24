package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.group.dao.AttendanceInquiryDao;
import com.group.entity.Attendance;


/**
 * <p>Title: fenyeServlet<／p>
 * <p>Description: 查询每个分页内的内容<／p>
 * @author gaocunzhi
 * @date 2018.11.20
 */
@WebServlet("/fenyeServlet")
public class fenyeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fenyeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userId = Integer.valueOf((String)session.getAttribute("userId"));
		String c =  request.getParameter("current");
		System.out.println(c);
		int x = Integer.valueOf(c);
		System.out.println(x);
		AttendanceInquiryDao attendanceInquiryDao = new AttendanceInquiryDao();
		ArrayList<Attendance> list = attendanceInquiryDao.show(userId);
		response.setCharacterEncoding("UTF-8");
        //json在这里存放的是数组信息
       JSONObject json=new JSONObject();
       JSONArray array=new JSONArray();

       //两个数据
       JSONObject temp=null;
       try {
    	   
    	   for(int i=0,j=0;i<list.size();i++) {
    		   temp = new JSONObject();
    		   if(i==x) {
    			   temp.put("time", list.get(i).getTimestamp());
    			   temp.put("type", list.get(i).getAttendType());
    			   System.out.println(list.get(i).getTimestamp());
    			   array.put(j,temp);
    			   j++;
    		   }
    	   }    
           //添加到json中
           json.put("people", array);
       } catch (JSONException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

       //向前台的页面输出结果
       PrintWriter out=response.getWriter();
       out.println(json);
       out.close();
		
//		int total = list1.size();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
