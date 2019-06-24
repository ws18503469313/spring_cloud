package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.UserApplication;
import com.spring.dao.UserDAO;
import com.spring.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {UserApplication.class})
public class TestDefauleValue {
	
	@Autowired
	private UserDAO userDao;
	@Test
	public void testInsertDefault() {
		User user = new User();
		user.setId(8L);
		user.setAddress("add");
		user.setEmail("email");
		user.setPassword("pswd");
		user.setUsername("un");
		userDao.saveAndFlush(user);
	}
}

