package jooq;

import static org.junit.Assert.fail;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationContext.xml" })
public class JooqTest {

	@Autowired
	DSLContext create;

	@Test
	public void test() throws Exception {
		//org.jooq.util.GenerationTool.generate("/bin/codegenerate.xml");
		fail("Not yet implemented");
	}

}
