package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.group.dao.SigninDao;

/**
 * <p>Title: SigninServlet<／p>
 * <p>Description: 签到<／p>
 * @date 2018.11.20
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
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
		String flag = null;
		SigninDao signinDao = new SigninDao();
		System.out.println(userId);
		boolean b = signinDao.signin(userId);
		System.out.println(b);
		if(b) {
			request.setAttribute("flag", "签到成功");
			flag = "今天已经签到";
		}else {
			try {
				flag=signinDao.sign(userId);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.setContentType("application/text; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(flag);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
