/**
 * 
 */
package com.group.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.sql.*;
import com.group.entity.*;
import DBHelper.*;

/**
 * <p>Title: DepartmentDao<��p>
 * <p>Description: ���Ź���<��p>
 * @author zhoulei
 * @date 2018.11.20
 */
public class DepartmentDao {
	
	/**
	 * <p>Title: allDepartment<��p>
	 * <p>Description: �������в���<��p>
	 * @return ���в���
	 */
	public List<DepartmentInfo> allDepartment() {
		
		List<DepartmentInfo> departmentInfos = new ArrayList<DepartmentInfo>();
		List<DepartmentInfo> departmentInfos2 = new ArrayList<DepartmentInfo>();
			try {
				Connection con = DBHelper.getInstance().getConnection();
				Statement sta = con.createStatement();
				String sql = "select * from departmentInfo";
				ResultSet res = sta.executeQuery(sql);
				while(res.next()) {
					DepartmentInfo departmentInfo = new DepartmentInfo();
					departmentInfo.setDepartmentId(res.getInt("departmentId"));
					departmentInfo.setDepartmentName(res.getString("departmentName"));
					departmentInfo.setPreDpartmentId(res.getInt("preDepartmentId"));
					departmentInfos.add(departmentInfo);
				}
				Stack<DepartmentInfo> stack = new Stack<DepartmentInfo>();
				for (DepartmentInfo departmentInfo : departmentInfos) {
					if(departmentInfo.getPreDpartmentId()==0) {
						stack.push(departmentInfo);
					}
				}
				while(!stack.isEmpty()) {
					
					DepartmentInfo departInfo = stack.pop();
					for (DepartmentInfo dInfo : departmentInfos) {
						if (dInfo.getPreDpartmentId()==departInfo.getDepartmentId()) {
							stack.push(dInfo);
						}
					}
					departmentInfos2.add(departInfo);
				}
				res.close();
				sta.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return departmentInfos2;
	}
	/**
	 * <p>Title: delDepartment<��p>
	 * <p>Description: ɾ������<��p>
	 * @param index ɾ�����ŵ�ID
	 * @return ɾ���ɹ���־
	 */
	public int delDepartment(int index){
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from userInfo where departmentId='"+index+"'";
			ResultSet res = sta.executeQuery(sql);
			if (!res.next()) {
				sql = "DELETE FROM departmentInfo WHERE departmentId = '"+index+"'";
				sta.executeUpdate(sql);
				res.close();
				sta.close();
				con.close();
				return 1;
			}else {
				res.close();
				sta.close();
				con.close();
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * <p>Title: rewDepartment<��p>
	 * <p>Description: ���²���<��p>
	 * @param index ����ID
	 * @param value ������
	 */
	public void rewDepartment(int index,String value) {
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "UPDATE departmentInfo SET departmentName = '"+value+"' WHERE departmentId ='"+index+"'";
			sta.executeUpdate(sql);
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * <p>Title: addDepartment<��p>
	 * <p>Description: ��Ӳ���<��p>
	 * @param preDpartmentId ��Ӳ��ŵ�ID
	 * @param departmentName ��Ӳ��ŵ�����
	 * @return �ɹ��ı�־
	 */
	public int addDepartment(int preDpartmentId,String departmentName) {
		try {
			Connection con = DBHelper.getInstance().getConnection();
			Statement sta = con.createStatement();
			String sql = "select * from departmentInfo where departmentId='"+preDpartmentId+"'";
			ResultSet res = sta.executeQuery(sql);
			if (res.next()||preDpartmentId==0) {
				sql = "select * from departmentInfo where departmentName='"+departmentName+"'";
				res = sta.executeQuery(sql);
				if (res.next()) {
					return 3;
				}else{
					sql = "INSERT INTO departmentInfo(departmentName,preDepartmentId) VALUES(?, ?)";;
					PreparedStatement psta = con.prepareStatement(sql);
					psta.setString(1, departmentName);
					psta.setInt(2, preDpartmentId);
					psta.executeUpdate();
					psta.close();
					res.close();
					con.close();
					return 1;
					}
			} else {
				sta.close();
				res.close();
				con.close();
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
