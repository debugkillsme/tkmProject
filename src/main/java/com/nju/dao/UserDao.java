package com.nju.dao;

import com.nju.entity.User;

/*
 * ����ӿ�ֻ����ǰUser�����ɾ�Ĳ�
 * �ӿ��еĳ��󷽷�������ʽ
 * ����+����+��������
 * getUserByName()
 */
public interface UserDao {
	//��ȡuser�������ݵ�������;
	int getUserCount();
	//��д���ܱ����ȴ�dao�㿪ʼд
	//dao��ĳ��󷽷�
	
	User getUserByUserName(String userName);
	int addUser(User user);
}
