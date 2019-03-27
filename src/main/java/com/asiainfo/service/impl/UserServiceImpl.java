package com.asiainfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.MyTransactional1;
import com.asiainfo.MyTransactional2;
import com.asiainfo.dao.interfaces.IUserDao;
import com.asiainfo.entity.User;
import com.asiainfo.service.interfaces.IUserService;

@Service
@Transactional(readOnly=true) // 对整个类的public方法生效。@Transactional这个注解没有显式地声明注解属性是因为它包含了许多默认的属性，这些默认的属性可以适用于大多数场合，如果不需要使用默认的属性要在后面对相应属性进行赋值
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Transactional(readOnly=false)	// 方法上面使用该注解则只对该方法生效同时会覆盖类定义处的@Transactional属性值，本例的readOnly=false属性值覆盖类定义处的readOnly=true
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional("tx1")
	public List<User> getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	
	@Transactional(value="tx2")
	public void update(User user) {}

	@MyTransactional1
	public void get1() {}
	
	@MyTransactional2
	public void get2() {}
}
