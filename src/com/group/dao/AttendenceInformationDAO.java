package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.group.entity.AttendenceInformation;

import DBHelper.DBHelper;;

/**
 * <p>Title: AttendenceInformationDAO<／p>
 * <p>Description: <／p>
 * @author Zhangjianpeng
 * @date 2018.11.20
 */
public class AttendenceInformationDAO {

	/**
	 * 计算查询到的数据共有多少条
	 * 
	 * @param startdate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 * @return int
	 */
	public int getTotal(String startdate, String enddate) {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select count(*)" + "from attendInfo,userInfo " + "where attendInfo.time between ? AND ? "
					+ "AND attendInfo.userId=userInfo.userId;";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, startdate);
			ps.setString(2, enddate);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 查询在startdate和enddate区间内的数据，并将结果保存到一个List中
	 * 
	 * @param startdate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 * @return List<AttendenceInformation>
	 */

	public List<AttendenceInformation> list(String startdate, String enddate) {
		List<AttendenceInformation> attendenceinformation = new ArrayList<AttendenceInformation>();

		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql = "select departmentInfo.departmentName," + "userInfo.userId," + "userInfo.userName,"
					+ "attendInfo.time," + "attendInfo.attendType " + "from attendInfo,userInfo,departmentInfo "
					+ "where attendInfo.time between ? AND ? " + "AND attendInfo.userId=userInfo.userId "
					+ "AND userInfo.departmentId=departmentInfo.departmentId;";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, startdate);
			ps.setString(2, enddate);

			ResultSet rs = ps.executeQuery();
			int count = 0;

			while (rs.next()) {
				AttendenceInformation attinfo = new AttendenceInformation();
				attinfo.setId(++count);
				attinfo.setDepartmentname(rs.getString("departmentName"));
				attinfo.setStaffid(rs.getInt("userId"));
				attinfo.setStaffname(rs.getString("userName"));
				attinfo.setAttendtime(rs.getTimestamp("time"));
				attinfo.setAttendtype(rs.getInt("attendType"));
				attendenceinformation.add(attinfo);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attendenceinformation;
	}

}
