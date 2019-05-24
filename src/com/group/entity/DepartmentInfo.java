/**
 * 
 */
package com.group.entity;


/**
 * <p>Title: DepartmentInfo<／p>
 * <p>Description: 部门信息<／p>
 * @author zhoulei
 * @date 2018.11.20
 */
public class DepartmentInfo {
	
	private int  departmentId;
	private String  departmentName;
	private int  preDpartmentId;
	
	
	public DepartmentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * @return the preDpartmentId
	 */
	public int getPreDpartmentId() {
		return preDpartmentId;
	}
	/**
	 * @param preDpartmentId the preDpartmentId to set
	 */
	public void setPreDpartmentId(int preDpartmentId) {
		this.preDpartmentId = preDpartmentId;
	}
	
	
}
