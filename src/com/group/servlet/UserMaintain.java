package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.group.dao.DepartmentDao;
import com.group.dao.UserDao;
import com.group.entity.userInfo;

import sun.security.provider.MD5;

/**
 * Servlet implementation class UserMaintain
 */
/**
 * <p>Title: UserMaintain<／p>
 * <p>Description: 用户信息<／p>
 * @author Gaocunzhi
 * @date 2018.11.20
 */
@WebServlet("/UserMaintain")
public class UserMaintain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMaintain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		int limit = Integer.parseInt(request.getParameter("limit"));
		int page = Integer.parseInt(request.getParameter("page"));
		int sign = Integer.parseInt(request.getParameter("sign"));
		PrintWriter out = response.getWriter();
		if (sign==3) {
			String id = request.getParameter("userId");
			if (id=="") {
				List<userInfo> userInfos = new UserDao().allUser(page,limit);
				int usernum = new UserDao().usernum();
				String json = JSONArray.toJSONString(userInfos); 
				json = "{\"code\":0,\"msg\":\"\",\"count\":"+usernum+",\"data\":"+json+"}";
				out.println(json);
			} else {
				int userId = Integer.parseInt(id);
				List<userInfo> userInfos = new UserDao().searvhUser(userId);
				String json = JSONArray.toJSONString(userInfos); 
				json = "{\"code\":0,\"msg\":\"\",\"count\":1,\"data\":"+json+"}";
				out.println(json);
			}
		}else if (sign==1) {
			List<userInfo> userInfos = new UserDao().allUser(page,limit);
			int usernum = new UserDao().usernum();
			String json = JSONArray.toJSONString(userInfos); 
			json = "{\"code\":0,\"msg\":\"\",\"count\":"+usernum+",\"data\":"+json+"}";
			System.out.println(json);
			out.println(json);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();	
		int sign = Integer.parseInt(request.getParameter("sign"));
		if(sign==1) {
			int index = Integer.parseInt(request.getParameter("index"));
			int res = new UserDao().delUser(index);
			out.println(res);
		}else if (sign==2) {
			 String	userName = request.getParameter("userName");
			 String	passWord = request.getParameter("passWord");
			 passWord = new UserDao().getMD5(passWord);
			 System.out.println(passWord);
			 int	sex = Integer.parseInt(request.getParameter("sex"));;
			 String	name = request.getParameter("name");
			 String	telePhoneNumber = request.getParameter("telePhoneNumber");
			 String	email = request.getParameter("email");
			 int	departmentId = Integer.parseInt(request.getParameter("departmentId"));
			 int	type = Integer.parseInt(request.getParameter("type"));
			 String	idCard = request.getParameter("idCard");
			 String	creditCard = request.getParameter("creditCard");
			 String change = request.getParameter("hidden");
			 if (userName==""||passWord==""||name==""||telePhoneNumber==""||email==""||idCard==""||creditCard==""||telePhoneNumber.length()!=11||idCard.length()!=18) { 
				out.println(-1);
			} else if(change=="") {
				userInfo userInfo = new userInfo(userName, passWord, sex, name, telePhoneNumber, email, departmentId, type, idCard, creditCard);
				 int res = new UserDao().addUser(userInfo);
				 out.println(res);
			}else if (change!="") {
				userInfo userInfo = new userInfo(userName, passWord, sex, name, telePhoneNumber, email, departmentId, type, idCard, creditCard);
				int Change = Integer.parseInt(change);
				int res = new UserDao().changeUser(Change, userInfo);
				out.println(res);
			}
			 
		}
	}

}
