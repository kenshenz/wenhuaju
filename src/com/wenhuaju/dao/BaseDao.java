package com.wenhuaju.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.type.IntegerType;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 基础Dao
 * @author ccf
 * @date 2016年3月16日
 *
 */
public abstract class BaseDao<T extends Serializable> extends HibernateDaoSupport{
	
	private T t;
	
	/**
	 * 根据主键获取实体
	 * @param id
	 * @return
	 */
	public T get(Serializable id) {
		return (T) super.getHibernateTemplate().get(t.getClass(), id);
	}
	
	/**
	 * 根据主键获取实体
	 * @param id
	 * @return
	 */
	public T load(Serializable id) {
		return (T) super.getHibernateTemplate().load(t.getClass(), id);
	}
	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public Serializable save(Object entity) {
		return super.getHibernateTemplate().save(entity);
	}
	
	/**
	 * 更新实体
	 * @param entity
	 */
	public void update(Object entity) {
		super.getHibernateTemplate().update(entity);
	}
	
	/**
	 * 保存或更新实体
	 * saveOrUpdate()性能不及save()或者update()
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		super.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 */
	public void delete(Object entity) {
		super.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 批量删除实体
	 * @param entities
	 */
	public void deleteAll(Collection<T> entities) {
		super.getHibernateTemplate().deleteAll(entities);
	}
	
	/**
	 * hql查询，返回数组
	 * @param hql
	 * @return
	 */
	public List<T> findByHQL(String hql) {
		return (List<T>) super.getHibernateTemplate().find(hql);
	}
	
	/**
	 * hql查询，返回数组
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<T> findByHQL(String hql, Object... values) {
		return (List<T>) super.getHibernateTemplate().find(hql, values);
	}
	
	/**
	 * sql查询，返回数组
	 * @param sql
	 * @return
	 */
	public List<T> findBySQL(String sql) {
		SQLQuery sqlQuery = super.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		return sqlQuery.list();
	}
	
	/**
	 * sql查询，返回数组
	 * @param sql
	 * @param values
	 * @return
	 */
	public List<T> findBySQL(String sql, Object... values) {
		SQLQuery sqlQuery = super.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		for (int i = 0, len = values.length; i < len; i++) {
			sqlQuery.setParameter(i, values[i]);
		}
		return sqlQuery.list();
	}
	
	/**
	 * hql分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param hql
	 * @param values
	 * @return Pager对象
	 */
	public Pager<T> findByPagerHQL(final int pageNo, final int pageSize, final String hql, final Object... values) {
		return super.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Pager<T>>() {

			public Pager<T> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				
				long count = findCount(hql);
				
				for (int i = 0, len = values.length; i < len; i++) {
					query.setParameter(i, values[i]);
				}
				
				int firstResult = (pageNo - 1) * pageSize;
				
				query.setFirstResult(firstResult)
				.setMaxResults(pageSize);
				
				return new Pager<T>(pageNo, pageSize, count, query.list());
			}
		});
	}
	
	/**
	 * sql分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param hql
	 * @param values
	 * @return Pager对象
	 */
	public Pager<T> findByPagerSQL(final int pageNo, final int pageSize, final String sql, final Object... values) {
		return super.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Pager<T>>() {

			public Pager<T> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				
				long count = findCount(sql);
				
				for (int i = 0, len = values.length; i < len; i++) {
					query.setParameter(i, values[i]);
				}
				
				int firstResult = (pageNo - 1) * pageSize;
				
				query.setFirstResult(firstResult)
				.setMaxResults(pageSize);
				
				return new Pager<T>(pageNo, pageSize, count, query.list());
			}
		});
	}
	
	/**
	 * 查询记录数
	 * @param sql
	 * @return
	 */
	public long findCount(String sql) {
		StringBuilder sqlSb = new StringBuilder(sql.trim().toLowerCase());
		//如果sql已select开始，则删除至from
		if (sqlSb.indexOf("select") == 0) {
			sqlSb.delete(0, sqlSb.indexOf("from"));
		}
		
		sqlSb.insert(0, "select count(1) as total ");
		
		return (Long) super.getHibernateTemplate().find(sqlSb.toString()).get(0);
	}
	
}
