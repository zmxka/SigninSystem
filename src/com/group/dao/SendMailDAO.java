package com.group.dao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.group.entity.*;

/**
 * <p>Title: SendMailDAO<／p>
 * <p>Description: 发送邮件（验证码）<／p>
 * @author lisilin
 * @date 2019年1月6日
 */
public class SendMailDAO {

	private Properties props;// 系统属性
	private Session mailSession;// 邮件会话对象
	private MimeMessage mimeMsg; // MIME邮件对象

	/**
	 * <p>Title: <／p>
	 * <p>Description: 构造函数<／p>
	 * @param SMTPHost SMTP主机
	 * @param Port 服务端口号
	 * @param MailUsername 邮箱地址
	 * @param MailPassword 邮箱密码
	 */
	public SendMailDAO(String SMTPHost, String Port, String MailUsername, String MailPassword) {
		Auth au = new Auth(MailUsername, MailPassword);
		System.out.println(au.getUsername());
		// 设置系统属性
		props = java.lang.System.getProperties(); // 获得系统属性对象
		props.put("mail.smtp.host", SMTPHost); // 设置SMTP主机
		props.put("mail.smtp.port", Port); // 设置服务端口号
		props.put("mail.smtp.auth", "true");// 同时通过验证
		// 获得邮件会话对象
		mailSession = Session.getInstance(props, au);
		System.out.println(mailSession);
	}

	/**
	 * <p>Title: sendingMimeMail<／p>
	 * <p>Description: 发送邮件<／p>
	 * @param MailFrom 发信人
	 * @param MailTo 收信人
	 * @param MailCopyTo 抄送人
	 * @param MailBCopyTo 暗送人
	 * @param MailSubject 邮件主题
	 * @param MailBody 邮件内容
	 * @return
	 */
	public boolean sendingMimeMail(String MailFrom, String MailTo, String MailCopyTo, String MailBCopyTo,
			String MailSubject, String MailBody) {
		try {
			// 创建MIME邮件对象
			mimeMsg = new MimeMessage(mailSession);
			// 设置发信人
			mimeMsg.setFrom(new InternetAddress(MailFrom));
			System.out.println(MailFrom);
			// 设置收信人
			if (MailTo != null) {
				mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailTo));
			}
			System.out.println(MailTo);
			// 设置抄送人
			if (MailCopyTo != null) {
				mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(MailCopyTo));
			}
			// 设置暗送人
			if (MailBCopyTo != null) {
				mimeMsg.setRecipients(javax.mail.Message.RecipientType.BCC, InternetAddress.parse(MailBCopyTo));
			}
			// 设置邮件主题
			mimeMsg.setSubject(MailSubject, "gb2312");
			// 设置邮件内容，将邮件body部分转化为HTML格式
			mimeMsg.setContent(MailBody, "text/html;charset=gb2312");
			// mimeMsg.setDataHandler(new javax.activation.DataHandler(
			// new StringDataSource(MailBody, "text/html")));
			// 发送邮件
			Transport.send(mimeMsg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}