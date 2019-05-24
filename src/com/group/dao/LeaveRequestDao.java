package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.group.entity.*;

import DBHelper.DBHelper;
/**
 * <p>Title: LeaveRequestDao<��p>
 * <p>Description: �������<��p>
 * @author zhoulei
 * @date 2019��1��6��
 */
public class LeaveRequestDao {
	
	/**
	 * <p>Title: add<��p>
	 * <p>Description: �ύ�������<��p>
	 * @param leaveRequest �������
	 * @throws SQLException
	 */
	public void add(LeaveRequest leaveRequest) throws SQLException {
		try {
			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into leaveInfo values(null,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, leaveRequest.getLeaveType());
			ps.setInt(2, leaveRequest.getUserId());
			ps.setTimestamp(3, leaveRequest.getRecordTime());
			ps.setTimestamp(4, leaveRequest.getStartTime());
			ps.setTimestamp(5, leaveRequest.getEndTime());
			ps.setString(6, leaveRequest.getLeaveContent());
			ps.setInt(7, leaveRequest.getResult());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			DBHelper.closeConnection(c, ps, rs);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
