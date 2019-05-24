package com.group.entity;

import java.sql.Timestamp;

/**
 * <p>Title: LeaveRequest<£Øp>
 * <p>Description: «ÎºŸ…Í«Î<£Øp>
 * @date 2018.11.20
 */
public class LeaveRequest {
	
	private int leaveId;
	private int leaveType;
	private int userId;
	private Timestamp recordTime;
	private Timestamp startTime;
	private Timestamp endTime;
	private String leaveContent;
	private int result;
	
	/**
	 * <p>Title: <£Øp>
	 * <p>Description: <£Øp>
	 */
	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the leaveId
	 */
	public int getLeaveId() {
		return leaveId;
	}

	/**
	 * @param leaveId the leaveId to set
	 */
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	/**
	 * @return the leaveType
	 */
	public int getLeaveType() {
		return leaveType;
	}

	/**
	 * @param leaveType the leaveType to set
	 */
	public void setLeaveType(int leaveType) {
		this.leaveType = leaveType;
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
	 * @return the recordTime
	 */
	public Timestamp getRecordTime() {
		return recordTime;
	}

	/**
	 * @param recordTime the recordTime to set
	 */
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the leaveContent
	 */
	public String getLeaveContent() {
		return leaveContent;
	}

	/**
	 * @param leaveContent the leaveContent to set
	 */
	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
	
	
	
}
