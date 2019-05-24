package com.group.entity;

import java.sql.Timestamp;

/**
 * <p>Title: LeaveEntity<£Øp>
 * <p>Description: «ÎºŸ–≈œ¢<£Øp>
 * @date 2018.11.20
 */
public class LeaveEntity {
	
	private Integer leaveId;
	private String userName;
	private String leaveType;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp recordTime;
	private String leaveContent;
	private String leaveResult;
	
	
	
	/**
	 * @return the leaveId
	 */
	public Integer getLeaveId() {
		return leaveId;
	}
	/**
	 * @param leaveId the leaveId to set
	 */
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the leaveType
	 */
	public String getLeaveType() {
		return leaveType;
	}
	/**
	 * @param leaveType the leaveType to set
	 */
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	 * @return the leaveResult
	 */
	public String getLeaveResult() {
		return leaveResult;
	}
	/**
	 * @param leaveResult the leaveResult to set
	 */
	public void setLeaveResult(String leaveResult) {
		this.leaveResult = leaveResult;
	}
	
}
