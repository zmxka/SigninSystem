package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import DBHelper.DBHelper;

/**
 * <p>Title: SigninDao<��p>
 * <p>Description: <��p>
 * @author gaocunzhi
 * @date 2019��1��6��
 */
public class SigninDao {
	/**
	 * <p>Title: signin<��p>
	 * <p>Description:  ǩ��<��p>
	 * @param userId �û�id
	 * @return
	 */
	public boolean signin(int userId) {
		
		Date date = new Date();
		String dateStr = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String tsStr = dateStr+" 00:00:00";
		ts = Timestamp.valueOf(tsStr);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement st = c.createStatement();
			String sql = "select * from attendInfo where userId ='"+ userId+"'order by time desc";
			ResultSet rs =  st.executeQuery(sql);
			if(rs.next()) {
				Timestamp ts1 = rs.getTimestamp("time");
				if(ts1.getYear()==date.getYear()&&
						ts1.getMonth()==date.getMonth()&&
						ts1.getDay()==date.getDay()) {
					return true;
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * <p>Title: sign<��p>
	 * <p>Description: <��p>
	 * @param userId �û�id
	 * @return �������
	 * @throws SQLException
	 */
	public String sign(int userId) throws SQLException {
		int f= leave(userId);
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		int attenType = 0;
		if(f==0) {
			if(time.getHours()<=8) {
				attenType = 1;
				//ǩ���ɹ�
			}else{
				attenType=0;
				//�ٵ�
			}
		}else if(f==1) {
			attenType = 2;
			//�Ѿ����
		}
		Connection c = DBHelper.getInstance().getConnection();
		String sql = "insert into attendInfo values(null,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, userId);
		ps.setInt(2,attenType);
		ps.setTimestamp(3, time);
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		DBHelper.closeConnection(c, ps, rs);
		if(f==0) {
			if(time.getHours()<=8) {
				return "ǩ���ɹ�";
				//ǩ���ɹ�
			}else{
				return "�ٵ�";
				//�ٵ�
			}
		}else if(f==1) {
			return "�Ѿ����";
			//�Ѿ����
		}
		return null;
	}
	
	/**
	 * <p>Title: leave<��p>
	 * <p>Description: �ж��Ƿ����<��p>
	 * @param userId �û�id
	 * @return �Ƿ����	
	 */
	public int leave(int userId) {
		
		Date date = new Date();
		String dateStr = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateStr = sdf.format(date);
			System.out.println(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String tsStr = dateStr+" 00:00:00";
		System.out.println(tsStr);
		try {
			ts = Timestamp.valueOf(tsStr);
			System.out.println(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement st = c.createStatement();
			String sql = "select * from leaveInfo where userId ='"+ userId+"'order by endTime desc";
			ResultSet rs =  st.executeQuery(sql);
			if(rs.next()) {
				if(ts.after(rs.getTimestamp("startTime"))&&ts.before(rs.getTimestamp("endTime"))) {
					return 1;  
				}
			};
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
