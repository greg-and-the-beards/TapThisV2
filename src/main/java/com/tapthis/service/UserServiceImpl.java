package com.tapthis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tapthis.dao.UserDAO;
import com.tapthis.entity.UserInfo;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserInfo getUserById(int userId) {
		UserInfo obj = userDAO.getUserById(userId);
		return obj;
	}	

	@Override
	public synchronized boolean addUser(UserInfo user) {
		userDAO.addUser(user);
		return true;
	}

	@Override
	public void updateUser(UserInfo user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}
}
