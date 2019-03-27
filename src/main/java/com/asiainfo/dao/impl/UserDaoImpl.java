package com.asiainfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asiainfo.dao.interfaces.IUserDao;
import com.asiainfo.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		
	}

	public List<User> getUserByName(String name) {
		return null;
	}

}
