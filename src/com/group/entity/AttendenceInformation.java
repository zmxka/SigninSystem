package com.group.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
/**
 * <p>Title: Attendance<／p>
 * <p>Description: 签到信息<／p>
 * @date 2018.11.20
 */
public class AttendenceInformation {
	/**
	 * @param id
	 *            序号
	 * @param departmentname
	 *            部门id
	 * @param staffid
	 *            员工id
	 * @param staffname
	 *            员工姓名
	 * @param attendtime
	 *            签到时间
	 * @param attendtype
	 *            签到类型(如已签到，迟到，缺勤等)
	 */
	private int id;
	private String departmentname;
	private int staffid;
	private String staffname;
	private Timestamp attendtime;
	private int attendtype;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the departmentname
	 */
	public String getDepartmentname() {
		return departmentname;
	}

	/**
	 * @param departmentname
	 *            the departmentname to set
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	/**
	 * @return the staffid
	 */
	public int getStaffid() {
		return staffid;
	}

	/**
	 * @param staffid
	 *            the staffid to set
	 */
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	/**
	 * @return the staffname
	 */
	public String getStaffname() {
		return staffname;
	}

	/**
	 * @param staffname
	 *            the staffname to set
	 */
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	/**
	 * @return the attendtime
	 */
	public Timestamp getAttendtime() {
		return attendtime;
	}

	/**
	 * @param attendtime
	 *            the attendtime to set
	 */
	public void setAttendtime(Timestamp attendtime) {
		this.attendtime = attendtime;
	}

	/**
	 * @return the attendtype
	 */
	public int getAttendtype() {
		return attendtype;
	}

	/**
	 * @param attendtype
	 *            the attendtype to set
	 */
	public void setAttendtype(int attendtype) {
		this.attendtype = attendtype;
	}
}
