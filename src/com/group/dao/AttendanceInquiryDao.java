package com.group.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.group.entity.Attendance;

import DBHelper.DBHelper;

/**
 * <p>Title: AttendanceInquiryDao<／p>
 * <p>Description: 所有签到信息<／p>
 * @author gaocunzhi
 * @date 2018.11.20
 */
public class AttendanceInquiryDao {
	/**
	 * <p>Title: show<／p>
	 * <p>Description: 返回该用户所有签到信息<／p>
	 * @param userId 用户名
	 * @return 该用户所有签到信息
	 */
	public ArrayList<Attendance> show(int userId) {
		ArrayList<Attendance> list = new ArrayList<Attendance>();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement st = c.createStatement();
			String sql = "select * from attendInfo where userId ='"+ userId+"'";
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()) {
				Attendance attendance = new Attendance();
				attendance.setAttendId(rs.getInt("attendId"));
				attendance.setAttendType(rs.getInt("attendType"));
				attendance.setTimestamp(rs.getTimestamp("time"));
				attendance.setUserId(userId);
				list.add(attendance);
			}
			return list;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}
