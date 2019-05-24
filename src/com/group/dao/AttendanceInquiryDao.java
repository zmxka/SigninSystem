package com.group.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.group.entity.Attendance;

import DBHelper.DBHelper;

/**
 * <p>Title: AttendanceInquiryDao<��p>
 * <p>Description: ����ǩ����Ϣ<��p>
 * @author gaocunzhi
 * @date 2018.11.20
 */
public class AttendanceInquiryDao {
	/**
	 * <p>Title: show<��p>
	 * <p>Description: ���ظ��û�����ǩ����Ϣ<��p>
	 * @param userId �û���
	 * @return ���û�����ǩ����Ϣ
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
