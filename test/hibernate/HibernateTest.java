package hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationContext.xml" })
public class HibernateTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
