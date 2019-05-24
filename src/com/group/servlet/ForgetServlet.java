package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestableEvent;

import java.sql.*;
import DBHelper.DBHelper;
import sun.net.smtp.SmtpClient;
import sun.security.util.Password;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import com.group.dao.SendMailDAO;

/**
 * <p>Title: ForgetServlet<／p>
 * <p>Description:发送邮件，产生随机四位数 <／p>
 * @author lisilin
 * @date 2018年11月20日
 */
public class ForgetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public String msg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetServlet() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		String name = request.getParameter("userName");

		session.setAttribute("userName", name);

		String email = request.getParameter("email");

		PrintWriter out = response.getWriter();
		int flag = 2;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select email from userInfo where userName = '" + name + "'";
			ResultSet rs = s.executeQuery(sql);
			int x = 0;
			if (rs.next()) {
				String Email = rs.getString("email");
				System.out.println(Email);
				if (Email.equals(email)) {
					x = sendmail(email, name);
					if (x != 0) {
						msg = "邮件发送成功";
						System.out.println(msg);
						flag = x;
					} else {
						msg = "邮件发送失败";
						System.out.println(msg);
						flag = 0;
					}
					session.setAttribute("flag", flag);
				} else {
					request.setAttribute("flag", flag);
				}
			}
			DBHelper.closeConnection(c, s, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
		out.print(flag);
		response.getWriter().close();
	}

	/**
	 * <p>Title: sendmail<／p>
	 * <p>Description: 发送邮件<／p>
	 * @param mailto 需要发送到的用户的邮箱地址
	 * @param username 需要发送到的用户的用户名
	 * @return 0 ：发送失败 ； x ：发送成功且发送验证码为x
	 */
	public int sendmail(String mailto, String username) {

		String MailTo = mailto;
		String MailSubject = "Westlake International - Application Received";
		String MailBCopyTo = "";
		String MailCopyTo = "";
		int x = suijishu();
		String MailBody = "<p>biliosoft libirary,欢迎 " + username + " 使用我们的网页,<br />" + "<br />" + "您的验证码为:</p>" + x;
		String SMTPHost = "smtp.163.com";
		String Port = "25";
		String MailUsername = "17792939102@163.com";
		String MailPassword = "gao724299669";
		String MailFrom = "17792939102@163.com";
		if (SMTPHost == null || SMTPHost == "" || MailUsername == null || MailUsername == "" || MailPassword == null
				|| MailPassword == "" || MailFrom == null || MailFrom == "") {
			System.out.println("Servlet parameter Wrongs");
		}
		SendMailDAO send = new SendMailDAO(SMTPHost, Port, MailUsername, MailPassword);
		if (send.sendingMimeMail(MailFrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody)) {
			return x;
		} else {
			return 0;
		}
	}

	/**
	 * <p>Title: 随机数<／p>
	 * <p>Description: 生成四位随机数 <／p>
	 */
	public int suijishu() {

		int x = (int) ((Math.random() * 9 + 1) * 1000);
		return x;
	}
}
