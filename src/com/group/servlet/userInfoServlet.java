package com.group.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group.dao.userInfoDao;
import com.group.entity.userInfo;


/**
 * <p>Title: userInfoServlet<��p>
 * <p>Description: ��ȡ������Ϣ<��p>
 * @author gaocunzhi
 * @date 2018.11.20
 */
@WebServlet("/userInfoServlet")
public class userInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		System.out.println(userId);
		userInfoDao uDao = new userInfoDao();
		userInfo uInfo = uDao.find(userId);
		System.out.println(uInfo.getTelephoneNumber());
		request.setAttribute("uInfo", uInfo);
		String sex = null;
		if(uInfo.getSex()==1) {
			sex="��";
		}else {
			sex = "Ů";
		}
		request.setAttribute("sex", sex);
		request.getRequestDispatcher("/view/jsp/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println(phone);
		System.out.println("aaaaaaaaaa");//aaaaaaaa��������� ����û������û��aaaa��Ҳ�е���
		userInfoDao uDao = new userInfoDao();
		try {
			uDao.change(phone, email, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
		
	}

}
