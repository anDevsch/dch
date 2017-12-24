package com.dch.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dch.bean.User;
import com.dch.dao.UserDao;
@Service  
@Transactional//ÊÂÎñ»Ø¹ö
public class UserService {
	@Resource
	private UserDao userDao;
	public User login(String username,String password)
	{
		return this.userDao.login(username, password);
	}
	public boolean addUser(User user)
	{
		return this.userDao.addUser(user);
	}
	public boolean updateUser(User user)
	{
		return this.userDao.updateUser(user);
	}
	public boolean mergeUser(User user)
	{
		return this.userDao.mergeUser(user);
	}
	public User getUserById(String id)
	{
		return this.userDao.getUserById(id);
	}
	public List<User> top7user()
	{
		return this.userDao.top7user();
	}
}
