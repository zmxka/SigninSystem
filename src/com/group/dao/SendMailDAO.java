package com.group.dao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.group.entity.*;

/**
 * <p>Title: SendMailDAO<��p>
 * <p>Description: �����ʼ�����֤�룩<��p>
 * @author lisilin
 * @date 2019��1��6��
 */
public class SendMailDAO {

	private Properties props;// ϵͳ����
	private Session mailSession;// �ʼ��Ự����
	private MimeMessage mimeMsg; // MIME�ʼ�����

	/**
	 * <p>Title: <��p>
	 * <p>Description: ���캯��<��p>
	 * @param SMTPHost SMTP����
	 * @param Port ����˿ں�
	 * @param MailUsername �����ַ
	 * @param MailPassword ��������
	 */
	public SendMailDAO(String SMTPHost, String Port, String MailUsername, String MailPassword) {
		Auth au = new Auth(MailUsername, MailPassword);
		System.out.println(au.getUsername());
		// ����ϵͳ����
		props = java.lang.System.getProperties(); // ���ϵͳ���Զ���
		props.put("mail.smtp.host", SMTPHost); // ����SMTP����
		props.put("mail.smtp.port", Port); // ���÷���˿ں�
		props.put("mail.smtp.auth", "true");// ͬʱͨ����֤
		// ����ʼ��Ự����
		mailSession = Session.getInstance(props, au);
		System.out.println(mailSession);
	}

	/**
	 * <p>Title: sendingMimeMail<��p>
	 * <p>Description: �����ʼ�<��p>
	 * @param MailFrom ������
	 * @param MailTo ������
	 * @param MailCopyTo ������
	 * @param MailBCopyTo ������
	 * @param MailSubject �ʼ�����
	 * @param MailBody �ʼ�����
	 * @return
	 */
	public boolean sendingMimeMail(String MailFrom, String MailTo, String MailCopyTo, String MailBCopyTo,
			String MailSubject, String MailBody) {
		try {
			// ����MIME�ʼ�����
			mimeMsg = new MimeMessage(mailSession);
			// ���÷�����
			mimeMsg.setFrom(new InternetAddress(MailFrom));
			System.out.println(MailFrom);
			// ����������
			if (MailTo != null) {
				mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailTo));
			}
			System.out.println(MailTo);
			// ���ó�����
			if (MailCopyTo != null) {
				mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(MailCopyTo));
			}
			// ���ð�����
			if (MailBCopyTo != null) {
				mimeMsg.setRecipients(javax.mail.Message.RecipientType.BCC, InternetAddress.parse(MailBCopyTo));
			}
			// �����ʼ�����
			mimeMsg.setSubject(MailSubject, "gb2312");
			// �����ʼ����ݣ����ʼ�body����ת��ΪHTML��ʽ
			mimeMsg.setContent(MailBody, "text/html;charset=gb2312");
			// mimeMsg.setDataHandler(new javax.activation.DataHandler(
			// new StringDataSource(MailBody, "text/html")));
			// �����ʼ�
			Transport.send(mimeMsg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}