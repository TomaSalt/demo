package egzaminui.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//@RunWith(SpringRunner.class)
/*@Suite.SuiteClasses({
    Lentele1RepositoryTest.class,
    Lentele2RepositoryTest.class,
    Lentele3RepositoryTest.class,
    Lentele4RepositoryTest.class
})*/
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
