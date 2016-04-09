package com.wenhuaju.plugin;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 分页插件
 * 
 * @author ccf
 * @date 2016年3月30日
 *
 */
@Intercepts({@Signature(args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }, method = "query", type = Executor.class)})
public class PagerInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = ms.getBoundSql(parameter);
		String sql = boundSql.getSql();
		
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		
		String countSql = getCountSql(sql);
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	public void setProperties(Properties properties) {

	}
	
	/**
	 * 根据原Sql语句，获取对应的select count语句
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {
		return "select count(1) as total_count from (" + sql + ")";
	}
	

}
