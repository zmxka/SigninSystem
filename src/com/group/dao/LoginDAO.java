package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.group.entity.*;
import DBHelper.DBHelper;

/**
 * <p>Title: LoginDAO</p>
 * <p>Description: 验证用户身份，修改密码等</p>
 * @author lisilin
 * @date 2018年11月20日
 */
public class LoginDAO {

	/**
	 * <p>Title: CheckList<／p>
	 * <p>Description: 验证用户身份<／p>
	 * @param name 用户名
	 * @param pass 用户密码
	 * @return 0为没id，1为密码不对，2为密码正确且是用户，3为密码正确且是管理员
	 */
	public int CheckList(String name, String pass) {

		int flag = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();

			String sql = "select password , type from userInfo where userName = '" + name + "'";
			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String pas = rs.getString("password");
				int typ = rs.getInt("type");
				if (pas.equals(pass)) {
					if (typ == 1)
						flag = 2;
					if (typ == 0)
						flag = 3;
				} else
					flag = 1;
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	// GET user
	/**
	 * <p>Title: Check</p>
	 * <p>Description: 根据用户名找用户</p>
	 * @param userName 用户名
	 * @return 用户
	 */
	public userInfo Check(String userName) {

		userInfo user = new userInfo();
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();

			String sql = "select * from userInfo where userName = '" + userName + "'";
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {

				int userId = rs.getInt("userId");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String name = rs.getString("name");
				String telephoneNumber = rs.getString("telephoneNumber");
				String email = rs.getString("email");
				int departmentId = rs.getInt("departmentId");
				int type = rs.getInt("type");
				String IDCard = rs.getString("IDCard");
				String creditCard = rs.getString("creditCard");

				user = new userInfo(userId, userName, password, sex, name, telephoneNumber, email, departmentId, type,
						IDCard, creditCard);
				;
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * <p>Title: update</p>
	 * <p>Description: 修改密码至数据库</p>
	 * @param userName 需要修改密码的用户的用户名
	 * @param password 新密码
	 * @return 修改成功
	 */
	public boolean update(String userName, String password) {

		try {
			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update userInfo set password = ? where userName = ?";
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, password);
			ps.setString(2, userName);

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
