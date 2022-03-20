package com.nju.service;

import com.nju.entity.User;

/*
 * 本类负责User表相关的业务逻辑
 */
public interface UserService {
	int getUserCount();
	
	boolean login(String userName,String password);
	
	boolean register(User user);
	
	User getUserByUserName(String userName);
	

}
