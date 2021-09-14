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
	
	//���ݿ�   ����     �� 
	//dbcp ʹ�õ���  jndi �����ӷ�ʽ    java  naming  and directory  
	//dbcp dbcp2    database  connection pool    druid   �����ṩ�����ݿ����ӳ�  
	//c3p0   
	//���ݿ����ӳ� �ṩ�Ĺ���   
	//1.�����Ǵ������Ӷ���
	//2.�ṩ��Щ���Ӷ���Ĺ���  ��������  ����    ��������  �ر�   ����Ĵ��� 
	//�ڷ����������ļ�  Context.xml  �������ӳ�    
	//Resource��ǩ   
	
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
