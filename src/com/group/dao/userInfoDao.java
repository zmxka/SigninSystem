package com.group.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.group.entity.Attendance;
import com.group.entity.userInfo;

import DBHelper.DBHelper;

/**
 * <p>Title: userInfoDao<／p>
 * <p>Description: 展示用户信息<／p>
 * @author gaocunnzhi
 * @date 2019年1月6日
 */
public class userInfoDao {
	/**
	 * <p>Title: find<／p>
	 * <p>Description: 根据id找到用户<／p>
	 * @param userId 用户id
	 * @return
	 */
	public userInfo find(String userId) {
		userInfo uInfo = new userInfo();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement st = c.createStatement();
			String sql = "select * from userInfo where userId ='"+ userId+"'";
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()) {
				uInfo.setUserId(rs.getInt("userId"));
				uInfo.setName(rs.getString("name"));
				uInfo.setTelephoneNumber(rs.getString("telephoneNumber"));
				uInfo.setEmail(rs.getString("email"));
				uInfo.setCreditCard(rs.getString("creditCard"));
				if(rs.getInt("sex")==1) {
					uInfo.setSex(1);
				}else {
					uInfo.setSex(0);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uInfo;
		
	}
	/**
	 * <p>Title: change<／p>
	 * <p>Description: 修改用户信息<／p>
	 * @param p 电话号码
	 * @param e 邮箱地址
	 * @param userId 用户id
	 * @throws SQLException
	 */
	public void change(String p,String e,String userId) throws SQLException {
		Connection cs = DBHelper.getInstance().getConnection();
		Statement st = cs.createStatement();
		String sql = "UPDATE userInfo SET email ='"+e+"', telephoneNumber = '"+ p+"' WHERE userId ='"+userId+"'";
		boolean rs =  st.execute(sql);
	}
}
