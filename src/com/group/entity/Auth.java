package com.group.entity;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * <p>Title: Auth<／p>
 * <p>Description: 邮件授权<／p>
 * @date 2018年11月28日
 */
public class Auth extends Authenticator {

	private String username = "";
	private String password = "";

	/**
	 * <p>Title: <／p>
	 * <p>Description: <／p>
	 * @param username
	 * @param password
	 */
	public Auth(String username, String password) {
		this.username = username;
		this.password = password;
	}
	/**
	 * <p>Title: getUsername<／p>
	 * <p>Description: <／p>
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * <p>Title: setUsername<／p>
	 * <p>Description: <／p>
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/* 
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	} 
}
