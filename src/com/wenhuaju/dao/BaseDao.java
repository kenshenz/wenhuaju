package com.wenhuaju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础Dao
 * @author ccf
 * @date 2016年3月16日
 *
 */
public abstract class BaseDao extends SqlSessionDaoSupport {
	
	/**
	 * 注入MyBatis的Sql Sesion Tempalte实例
	 */
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public static void main(String[] args) {
		SqlSessionTemplate sqlSessionTemplate;
		
	}

}
