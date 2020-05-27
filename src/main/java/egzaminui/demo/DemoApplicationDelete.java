package egzaminui.demo;


import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * Failas, skirtas paleisti ir valdyti programą
 * 
 * @author Toma
 *
 */
@SpringBootApplication
public class DemoApplicationDelete {
	/**
	 * Pagrindinis programos veikimo metodas
	 */
	public static void main(String[] args) {
		/**
		 * Sukuria LenteleSuDuomenimis klasės sąrašo tipo kintamąjį lentelių duomenims
		 */
		ArrayList<LenteleSuDuomenimis> lent_su_duomenimis;
		/**
		 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį lentelių duomenims
		 */
		ArrayList<LenteleBeDuomenu> lent_be_duomenu;
		/**
		 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį ataskaitos lentelių duomenims
		 */
		ArrayList<LenteleBeDuomenu> ataskaitos_lent;
		/**
		 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį paieškos lentelių duomenims
		 */
		ArrayList<LenteleBeDuomenu> paieskos_lent;
		/**
		 * Sukuria String tipo kintamąjį įrašomo failo vardui
		 */
		String irasomo_failo_vardas;
		
		SpringApplication.run(DemoApplicationCreate.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		Pagrindinis pagr = (Pagrindinis) context.getBean("mainspring");
		//skaitomi duomenys ir suvedami į lenteles
		pagr.skaitytiIsFailo();		
		pagr.gautiLenteles();
		pagr.isvestiLentelesIKonsole();
		lent_su_duomenimis = pagr.getLenteles();
		lent_be_duomenu = pagr.getLenteles_be_duomenu();
		//skaitomi duomenys, reikalingi paieškai, ir suvedami į lenteles
		pagr.setSkaitomo_failo_var("src/egzaminui_ataskaita_is_html.csv");
		pagr.skaitytiIsFailo();
		pagr.gautiLenteles();
		paieskos_lent = pagr.getLenteles_be_duomenu();
		//skaitomi duomenys, reikalingi ataskaitai ir suvedami į lenteles
		pagr.setSkaitomo_failo_var("src/egzaminui_ataskaita_i_html.csv");
		pagr.skaitytiIsFailo();
		pagr.gautiLenteles();
		ataskaitos_lent = pagr.getLenteles_be_duomenu();
		ArrayList<String> failu_sarasas = new ArrayList<String>();
		failu_sarasas.add("main/java/egzaminui/demo/Menu.java");
		failu_sarasas.add("main/java/egzaminui/demo/PageController.java");
		
		// failų pavadinimų iš paieškos ir ataskaitos lentelių sąrašo ciklas
		for(int i = 0; i < ataskaitos_lent.size(); i++) {
			
			failu_sarasas.add("main/java/egzaminui/demo/" + StringUtils.capitalize(paieskos_lent.get(i).getLenteles_pav()) + ".java");
			failu_sarasas.add("main/java/egzaminui/demo/" + StringUtils.capitalize(ataskaitos_lent.get(i).getLenteles_pav()) + ".java");
			failu_sarasas.add("main/resources/templates/" + paieskos_lent.get(i).getLenteles_pav() + ".html");
		}
		// failų pavadinimų iš lentelių be duomenų ir su duomenimis sąrašo ciklas
		for(int i = 0; i < lent_be_duomenu.size(); i++) {
			
			failu_sarasas.add("main/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + ".java");
			failu_sarasas.add("main/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + "Repository.java");
			failu_sarasas.add("test/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + "RepositoryTest.java");
			failu_sarasas.add("main/resources/templates/" + lent_be_duomenu.get(i).getLenteles_pav() + ".html");

		}
		for(int i=0; i < failu_sarasas.size(); i++) {
			File file = new File("src/" + failu_sarasas.get(i));
			if (file.exists()){
			     file.delete();
			     System.out.println("Trinamas src/" + failu_sarasas.get(i));
			}
		}
		try{
			KurtiDuombaze db_trynimas = new KurtiDuombaze("demo", lent_su_duomenimis);
			db_trynimas.trinti();
		}catch(Exception e) {
			System.out.println("Can not delete the database...");
		}
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
