package egzaminui.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas ištrinti egzamino programą
 * 
 * @author Toma
 *
 */
@SpringBootApplication
public class HideTracksApplication {
	/**
	 * Pėdsakų slėpimo programos metodas
	 * @param args kūrimo programos trynimo argumentai
	 */
	public static void main(String[] args) {
		/**
		 * Sukuria String klasės sąrašo tipo kintamąjį trinamų failų sąrašui
		 */
		ArrayList<String> trinamu_failu_sar;
		/**
		 * Sukuria String tipo kintamąjį skaitomo failo vardui
		 */
		SpringApplication.run(HideTracksApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		Pagrindinis pagr = (Pagrindinis) context.getBean("mainspring");
		//skaitomi duomenys, reikalingi failų trynimui ir sudedami į sąrašą
		pagr.setSkaitomo_failo_var("src/trinamu_failu_sarasas.txt");
		pagr.skaitytiIsFailo();
		trinamu_failu_sar = pagr.getNuskaityti_duomenys();
		//trinami failai pagal sąrašą
		for(int i=0; i < trinamu_failu_sar.size(); i++) {
			File file = new File(trinamu_failu_sar.get(i));
			if (file.exists()){
			     file.delete();
			     System.out.println("Trinamas src/" + trinamu_failu_sar.get(i));
			}
		}
		((ClassPathXmlApplicationContext) context).close();
	
	}
}