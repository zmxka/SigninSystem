/**
 * 
 */
package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.security.MessageDigest;
import com.group.entity.userInfo;

import DBHelper.DBHelper;

/**
 * <p>
 * Title: UserDao<／p>
 * <p>
 * Description: 用户管理<／p>
 * 
 * @author zhoulei
 * @date 2018.11.20
 */
public class UserDao {
	
	/**
	 * <p>Title: usernum<／p>
	 * <p>Description: 返回用户数量<／p>
	 * @return 用户数量
	 */
	public int usernum() {

		int i = 0;
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from userInfo";
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				i++;
			}
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * <p>Title: allUser<／p>
	 * <p>Description: 返回分页后的用户列表<／p>
	 * @param page 页码
	 * @param limit 每页的数量
	 * @return 用户列表
	 */
	public List<userInfo> allUser(int page, int limit) {
		List<userInfo> userInfos = new ArrayList<userInfo>();
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from userInfo limit " + (page - 1) * limit + "," + limit;
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				userInfo userInfo = new userInfo();
				userInfo.setUserId(res.getInt("userId"));
				userInfo.setUserName(res.getString("userName"));
				userInfo.setPassWord(res.getString("password"));
				userInfo.setSex(res.getInt("sex"));
				userInfo.setName(res.getString("name"));
				userInfo.setTelephoneNumber(res.getString("telephoneNumber"));
				userInfo.setEmail(res.getString("email"));
				userInfo.setDepartmentId(res.getInt("departmentId"));
				userInfo.setType(res.getInt("type"));
				userInfo.setIDCard(res.getString("IDCard"));
				userInfo.setCreditCard(res.getString("creditCard"));
				userInfos.add(userInfo);
			}
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfos;
	}

	/**
	 * <p>Title: searvhUser<／p>
	 * <p>Description: 查找用户<／p>
	 * @param userId 用户名
	 * @return  用户列表
	 */
	public List<userInfo> searvhUser(int userId) {
		List<userInfo> userInfos = new ArrayList<userInfo>();
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from userInfo where userId  like '%" + userId+"%'";
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				userInfo userInfo = new userInfo();
				userInfo.setUserId(res.getInt("userId"));
				userInfo.setUserName(res.getString("userName"));
				userInfo.setPassWord(res.getString("password"));
				userInfo.setSex(res.getInt("sex"));
				userInfo.setName(res.getString("name"));
				userInfo.setTelephoneNumber(res.getString("telephoneNumber"));
				userInfo.setEmail(res.getString("email"));
				userInfo.setDepartmentId(res.getInt("departmentId"));
				userInfo.setType(res.getInt("type"));
				userInfo.setIDCard(res.getString("IDCard"));
				userInfo.setCreditCard(res.getString("creditCard"));
				userInfos.add(userInfo);
			}
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfos;
	}

	/**
	 * <p>Title: delUser<／p>
	 * <p>Description: <／p>
	 * @param index
	 * @return
	 */
	public int delUser(int index) {
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "DELETE FROM attendInfo WHERE userId = '" + index + "'";
			sta.executeUpdate(sql);
			sql = "DELETE FROM userInfo WHERE userId = '" + index + "'";
			sta.executeUpdate(sql);
			sta.close();
			con.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * <p>Title: addUser<／p>
	 * <p>Description: 添加用户<／p>
	 * @param userInfo 用户实体
	 * @return 成功标志
	 */
	public int addUser(userInfo userInfo) {
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from userInfo where userName='" + userInfo.getUserName() + "'";
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				sta.close();
				res.close();
				con.close();
				return 2;
			} else {
				sql = "INSERT INTO userInfo(userName, password, sex, name, telephoneNumber, email, departmentId, type, IDCard, creditCard) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement psta = con.prepareStatement(sql);
				psta.setString(1, userInfo.getUserName());
				psta.setString(2, userInfo.getPassWord());
				psta.setInt(3, userInfo.getSex());
				psta.setString(4, userInfo.getName());
				psta.setString(5, userInfo.getTelephoneNumber());
				psta.setString(6, userInfo.getEmail());
				psta.setInt(7, userInfo.getDepartmentId());
				psta.setInt(8, userInfo.getType());
				psta.setString(9, userInfo.getIDCard());
				psta.setString(10, userInfo.getCreditCard());
				psta.executeUpdate();
				psta.close();
				res.close();
				con.close();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * <p>Title: changeUser<／p>
	 * <p>Description: 修改用户<／p>
	 * @param change 用户ID
	 * @param userInfo 需要修改的用户
	 * @return 成功标志
	 */
	public int changeUser(int change, userInfo userInfo) {
		try {
			Connection con = DBHelper.getInstance().getConnection();
			String sql = "Update userInfo SET  password=? ,sex=? ,name=? ,telephoneNumber=? ,email=? ,departmentId=? ,type=? ,IDCard=? ,creditCard=? WHERE userId = ?";
			PreparedStatement psta = con.prepareStatement(sql);
			psta.setString(1, userInfo.getPassWord());
			psta.setInt(2, userInfo.getSex());
			psta.setString(3, userInfo.getName());
			psta.setString(4, userInfo.getTelephoneNumber());
			psta.setString(5, userInfo.getEmail());
			psta.setInt(6, userInfo.getDepartmentId());
			psta.setInt(7, userInfo.getType());
			psta.setString(8, userInfo.getIDCard());
			psta.setString(9, userInfo.getCreditCard());
			psta.setInt(10, change);
			psta.executeUpdate();
			psta.close();
			con.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 */

	public String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
