package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas paleisti egzamino programą
 * 
 * @author Toma
 *
 */
@SpringBootApplication
public class DemoApplication {
	/**
	 * Pagrindinis programos veikimo metodas
	 * @param args programos paleidimo argumentai
	 */
	public static void main(String[] args) {
	
		SpringApplication.run(DemoApplication.class, args);

	}

}
