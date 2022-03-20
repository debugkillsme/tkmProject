package com.nju.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
	//增删改的必要条件  
		//sql语句
		//需要一些位置的条件   其实就是增删改条件  
		public int modifyData(String sql,Object... obj) {
			conn=ConnUtil.getConn();
			int result=0;
			
			try {
				ps=conn.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
				result=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
			
		}
		
		public ResultSet getDataByAny(String sql,Object... obj) {
			Connection conn=ConnUtil.getConn();
			try {
				ps= conn.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
				rs=ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		public void closeResource() {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
