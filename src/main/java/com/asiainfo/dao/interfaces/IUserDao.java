package com.asiainfo.dao.interfaces;

import java.util.List;

import com.asiainfo.entity.User;

public interface IUserDao {
	void save (User user);
	List<User> getUserByName(String name);
}
