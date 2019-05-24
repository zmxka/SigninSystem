package com.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.group.entity.LeaveEntity;
import com.group.util.DBHelper;



/**
 * <p>Title: LeaveEditDao<／p>
 * <p>Description: 请假类型编辑<／p>
 * @author zhoulei
 * @date 2019年1月6日
 */
public class LeaveEditDao {
	
	public int getTotal(){
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from leaveInfo";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}



			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public Integer update(LeaveEntity leave) {
		Integer flag = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Integer leaveResult = leaveResultStr2Int(leave.getLeaveResult());
			
			System.out.println(leaveResult);
			
			String sql = "update leaveInfo set result = ? where leaveId = ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			System.out.println(leave.getLeaveId());
			
			ps.setInt(1, leaveResult);
			ps.setInt(2, leave.getLeaveId());
			
			flag = ps.executeUpdate();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public List<LeaveEntity> getList(Integer start, Integer count){
		
		ArrayList<LeaveEntity> leaveList = new ArrayList<LeaveEntity>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from leaveInfo order by recordTime desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				LeaveEntity leave = new LeaveEntity();
				
				leave.setLeaveContent(rs.getString("leaveContent"));
				leave.setLeaveId(rs.getInt("leaveId"));
				
				leave.setEndTime(rs.getTimestamp("endTime"));
				leave.setStartTime(rs.getTimestamp("startTime"));
				leave.setRecordTime(rs.getTimestamp("recordTime"));
				
				Integer userId = rs.getInt("userId");
				String sqlUserLookUp = "select userName from userInfo where userId = ?";
				PreparedStatement psLookUpUser = c.prepareStatement(sqlUserLookUp);
				psLookUpUser.setInt(1, userId);
				ResultSet rsLookUpUser = psLookUpUser.executeQuery();
				if(rsLookUpUser.next()){
					leave.setUserName(rsLookUpUser.getString("userName"));
				}
				
				Integer leaveType = rs.getInt("leaveType");
				Integer leaveResult = rs.getInt("result");
				
				
				String sqlLeaveTypeLookUp = "select type from leavetype where leaveid = ?";
				PreparedStatement psLookUpLeaveType = c.prepareStatement(sqlLeaveTypeLookUp);
				psLookUpLeaveType.setInt(1, leaveType);
				ResultSet rsLookUpLeaveType = psLookUpLeaveType.executeQuery();
				if(rsLookUpLeaveType.next()){
					leave.setLeaveType(rsLookUpLeaveType.getString("type"));
				}
				
				leave.setLeaveResult(leaveResultInt2String(leaveResult));
				
				leaveList.add(leave);
				
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveList;
	}
	
	public Integer leaveResultStr2Int(String result){
		
		System.out.println(result);
		
		if(result.equals("已同意") ){
			return 1;
		}else if(result.equals("已拒绝")){
			return 2;
		}
		
		return -1;
	}
	
	public String leaveResultInt2String(Integer result){
		
		if(result == 0){
			return "未审核";
		}else if(result == 1){
			return "已同意";
		}
		else if(result == 2){
			return "已拒绝";
		}
		
		return "";
	}
	

	
}
 