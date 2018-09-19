package com.oa.service.impl;

import com.oa.base.BaseDaoImpl;
import com.oa.entity.User;
import com.oa.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	public User getByLoginNameAndPassword(String loginName, String password) {
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, DigestUtils.md5Hex(password))// 要使用MD5的摘要
				.uniqueResult();
	}

}
