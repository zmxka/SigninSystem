package com.group.entity;

import java.sql.Timestamp;

/**
 * <p>Title: Attendance<／p>
 * <p>Description: 签到类型<／p>
 * @date 2018.11.20
 */
public class Attendance {
	private int attendId;
	private int userId;
	private int attendType;
	private Timestamp timestamp;
	
	

	/**
	 * <p>Title: <／p>
	 * <p>Description: 构造函数<／p>
	 */
	
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the attendId
	 */
	public int getAttendId() {
		return attendId;
	}

	/**
	 * @param attendId the attendId to set
	 */
	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the attendType
	 */
	public int getAttendType() {
		return attendType;
	}

	/**
	 * @param attendType the attendType to set
	 */
	public void setAttendType(int attendType) {
		this.attendType = attendType;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
}
