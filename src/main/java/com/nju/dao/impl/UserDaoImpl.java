package com.nju.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nju.dao.*;
import com.nju.entity.User;
import com.nju.util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public int getUserCount() {
		String sql = "select count(1) from user";
		ResultSet rs= this.getDataByAny(sql);
		int count=0;
		try {
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
		
		
	}

	@Override
	public User getUserByUserName(String userName) {
		String sql ="select * from user where username=?";
		ResultSet rs=this.getDataByAny(sql, userName);
		User user=null;
		try {
			while(rs.next()) {
				user=new User();
				user.setuId(rs.getInt("uid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		String sql="insert into user(username,password) values(?,?)";
		
		return this.modifyData(sql,user.getUserName(),user.getPassword());
	}
	
}
