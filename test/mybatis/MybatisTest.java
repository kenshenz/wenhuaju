package mybatis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Test;

public class MybatisTest {


	@Test
	public void test() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		openSession.selectList(statement, parameter);

	}

}
