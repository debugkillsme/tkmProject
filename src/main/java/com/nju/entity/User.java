package com.nju.entity;
/*
 * ��Ӧ���ݿ��б��User
 */
public class User {
	private int uId;
	private String userName;
	private String password;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
	}
	public User(String userName,String password) {
		this.uId=888;
		this.userName=userName;
		this.password=password;
	}
	public User(int uId, String userName, String password) {
		this.uId = uId;
		this.userName = userName;
		this.password = password;
	}
	@Override//���ڴ�ӡ
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
