package com.nju.service;

import com.nju.entity.User;

/*
 * ���ฺ��User����ص�ҵ���߼�
 */
public interface UserService {
	int getUserCount();
	
	boolean login(String userName,String password);
	
	boolean register(User user);
	
	User getUserByUserName(String userName);
	

}
