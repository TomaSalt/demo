package egzaminui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		Pagrindinis pagr = (Pagrindinis) context.getBean("mainspring");
		pagr.Daryti();
		pagr.ILentele();
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
