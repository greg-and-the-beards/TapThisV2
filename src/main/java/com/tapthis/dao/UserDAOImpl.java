package com.tapthis.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tapthis.entity.UserInfo;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public UserInfo getUserById(int userId) {
		return hibernateTemplate.get(UserInfo.class, userId);
	}

	@Override
	public boolean addUser(UserInfo user) {
		hibernateTemplate.save(user);
		return false;
	}

	@Override
	public void updateUser(UserInfo user) {
		UserInfo record = getUserById(user.getUserId());
		
		record.setUserName(user.getUserName());
		record.setFirstName(user.getFirstName());
		record.setLastName(user.getLastName());
		record.setEmail(user.getEmail());
		record.setPhone(user.getPhone());
		record.setPassword(user.getPassword());
		record.setDateOfBirth(user.getDateOfBirth());

		hibernateTemplate.update(record);
	}
	
	@Override
	public void deleteUser(int userId) {
		hibernateTemplate.delete(getUserById(userId));
	}
}
