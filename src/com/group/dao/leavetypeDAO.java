package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.group.entity.AttendenceInformation;
import com.group.entity.LeaveType;

import DBHelper.DBHelper;

public class leavetypeDAO {

	/**
	 * 查询leavetype表里的所有数据，并根据id升序排列
	 * 
	 * @return
	 */
	public List<LeaveType> list() {
		List<LeaveType> leavetypeinformation = new ArrayList<LeaveType>();

		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql = "select * from leavetype order by leaveid;";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				LeaveType leavetype = new LeaveType();
				leavetype.setLeaveid(rs.getInt("leaveid"));
				leavetype.setLeaveType(rs.getString("type"));
				leavetypeinformation.add(leavetype);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leavetypeinformation;
	}

	/**
	 * 根据id删除请假类型
	 * 
	 * @param id
	 */
	public void deletetype(String id) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from leavetype where leaveid = " + id;

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id和type修改请假类型
	 * 
	 * @param id
	 * @param type
	 */
	public void modifytype(String id, String type) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update leavetype set type= ? where leaveid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, id);

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据type添加请假类型
	 * 
	 * @param type
	 */
	public void addtype(String type) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "insert into leavetype values(null,?)";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, type);
			
			ps.execute();	

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
