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
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.group.dao.DepartmentDao;
import com.group.entity.DepartmentInfo;

/**
 * <p>
 * Title: DepartmentMaintain<／p>
 * <p>
 * Description: <／p>
 * 
 * @author zhoulei
 * @date 2018.11.20
 */
@WebServlet("/DepartmentMaintain")
public class DepartmentMaintain extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentMaintain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int deparmentNum = new DepartmentDao().allDepartment().size();
		List<DepartmentInfo> dList= new DepartmentDao().allDepartment();
		int sign1 = Integer.parseInt(request.getParameter("sign"));
		if(sign1==1) {
			response.setContentType("application/json;charset=utf-8");
			String json = JSONArray.toJSONString(new DepartmentDao().allDepartment());
			json = "{\"code\":0,\"msg\":\"\",\"count\":" + deparmentNum + ",\"data\":" + json + "}";
			out.println(json);
		}
		if(sign1==2) {
		response.setContentType("text/html;charset=utf-8");
		String json = "";
		int sign = 0; 
		int signLast = 0;
		int isFirst = 1;
		int lastPID = 0;
		int i = 0;
			for (DepartmentInfo departmentInfo : dList) {
				for (DepartmentInfo departmentInfo2 : dList) {
					if (departmentInfo.getDepartmentId()==departmentInfo2.getPreDpartmentId()) {
						sign = 1;
					}
				}
				if (sign == 1) {
					if (signLast == 0) {
						if (isFirst == 1) { //第一个节点
							json =json+"{text: \""+departmentInfo.getDepartmentName()+"\",nodes: [";
							signLast = sign;
							sign = 0;
							isFirst = 0;
						} else { //上一个节点无子节点
							if (departmentInfo.getPreDpartmentId() == lastPID) {
								System.out.println("当前节点"+departmentInfo.getPreDpartmentId());
								System.out.println(lastPID);
								System.out.println();
								json =json+"{text: \""+departmentInfo.getDepartmentName()+"\",nodes: [";
								signLast = sign;
								sign = 0;
							} else {
								
								json =json+"]},"+"{text: \""+departmentInfo.getDepartmentName()+"\",nodes: [";
								signLast = sign;
								sign = 0;
							}
							
						}
						
					} else { //当前有子节点
						json =json+"{text: \""+departmentInfo.getDepartmentName()+"\",nodes: [";
						signLast = sign;
						sign = 0;
					}	
				} else {//叶子节点
					json = json+"{ text: \""+departmentInfo.getDepartmentName()+"\"},";
					lastPID = departmentInfo.getPreDpartmentId();
					DepartmentInfo Dp = departmentInfo;
					signLast = sign;
				}
			}
			json = "["+json+"]}]}]";
			System.out.println(json);
			out.println(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int sign = Integer.parseInt(request.getParameter("sign"));
		if (sign == 1) {
			int index = Integer.parseInt(request.getParameter("index"));
			int res = new DepartmentDao().delDepartment(index);
			out.println(res);
		} else if (sign == 0) {
			int index = Integer.parseInt(request.getParameter("index"));
			String value = request.getParameter("value");
			DepartmentDao departmentDao = new DepartmentDao();
			departmentDao.rewDepartment(index, value);
		} else if (sign == 2) {
			String departmentName = request.getParameter("departmentName");
			if (departmentName == "" || request.getParameter("preDpartmentId") == "") {
				int res = 4;
				out.println(res);
			} else {
				int preDpartmentId = Integer.parseInt(request.getParameter("preDpartmentId"));
				int res = new DepartmentDao().addDepartment(preDpartmentId, departmentName);
				out.println(res);
			}

		}
	}

}
