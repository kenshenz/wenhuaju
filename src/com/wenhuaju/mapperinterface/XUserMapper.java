package com.wenhuaju.mapperinterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wenhuaju.po.XUser;

public interface XUserMapper {

	/**
	 * 根据用户名、密码获取用户列表
	 * @param username
	 * @param password
	 * @return
	 */
	List<XUser> getXUserByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
}
