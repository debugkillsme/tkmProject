package com.nju.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnUtil {
	public static Connection getConn() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tkm", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//数据库   连接     池 
	//dbcp 使用的是  jndi 的连接方式    java  naming  and directory  
	//dbcp dbcp2    database  connection pool    druid   阿里提供的数据库连接池  
	//c3p0   
	//数据库连接池 提供的功能   
	//1.帮我们创建连接对象
	//2.提供这些连接对象的管理  开启连接  创建    销毁连接  关闭   事务的处理 
	//在服务器配置文件  Context.xml  配置连接池    
	//Resource标签   
	
	public  static  Connection  getConn2() {
		Connection conn=null;
		try {
			Context ctx=new InitialContext();
			DataSource ds=  (DataSource) ctx.lookup("java:comp/env/mypool");
			conn=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	} 
	
	
}
