package com.wenhuaju;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wenhuaju.mapperinterface.XUserMapper;
import com.wenhuaju.po.XUser;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestService {
	
	@Autowired
	private XUserMapper xUserMapper;

	@Test
	public void testLoginEvent() {
		List<XUser> userList = xUserMapper.getXUserByUsernameAndPassword("admin", "admin");
		System.out.println(userList);
	}

	
}
