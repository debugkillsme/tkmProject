package com.nju.dao;

import com.nju.entity.User;

/*
 * 这个接口只负责当前User表的增删改查
 * 接口中的抽象方法命名格式
 * 动作+对象+根据条件
 * getUserByName()
 */
public interface UserDao {
	//获取user表中数据的总条数;
	int getUserCount();
	//编写功能必须先从dao层开始写
	//dao层的抽象方法
	
	User getUserByUserName(String userName);
	int addUser(User user);
}
