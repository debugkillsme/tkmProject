package com.nju.service.impl;

import com.nju.dao.UserDao;
import com.nju.dao.impl.UserDaoImpl;
import com.nju.entity.User;
import com.nju.service.UserService;

public class UserServiceImpl implements UserService{
	
	//通过父类new子类
	UserDao userDao =new UserDaoImpl();
	
	public int getUserCount() {
		return userDao.getUserCount();
	}

	@Override
	public boolean login(String userName, String password) {
		User user=userDao.getUserByUserName(userName);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		
		return userDao.addUser(user)==1?true:false;
	}

	@Override
	public User getUserByUserName(String userName) {
		
		return userDao.getUserByUserName(userName);
	}
	

}
