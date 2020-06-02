package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas sukurti egzamino programą
 * 
 * @author Toma
 *
 */
@SpringBootApplication
public class DemoApplicationCreate {
	/**
	 * Pagrindinis programos veikimo metodas
	 * @param args programos kūrimo argumentai
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
		//kuriamas menu failas
		KurtiMenuFaila menu = new KurtiMenuFaila(lent_be_duomenu, paieskos_lent);
		ArrayList<String> duomenys = menu.menuFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/Menu.java";
		pagr.setIrasomo_failo_var(irasomo_failo_vardas);
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		//kuriamas pageController failas
		KurtiPageControllerFaila pageControllerFailoDuomenys = new KurtiPageControllerFaila(lent_be_duomenu, paieskos_lent, ataskaitos_lent);
		duomenys = pageControllerFailoDuomenys.javaFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/PageController.java";
		rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		//kuriama duomenų bazė
		KurtiDuombaze db_kurimas = new KurtiDuombaze("demo", lent_su_duomenimis);
		db_kurimas.kurti();
		// failų, kuriamų iš paieškos ir ataskaitos lentelių ciklas
		for(int i = 0; i < ataskaitos_lent.size(); i++) {
			//kuriamas paieškos klasės java failas
			KurtiPaieskosFaila java_paieska = new KurtiPaieskosFaila(paieskos_lent.get(i), ataskaitos_lent.get(i));
			duomenys = java_paieska.javaFailui();
			irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(paieskos_lent.get(i).getLenteles_pav()) + ".java";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
			//kuriamas ataskaitos klasės java failas
			KurtiJavaFaila java_ataskaita = new KurtiJavaFaila(ataskaitos_lent.get(i));
			duomenys = java_ataskaita.javaFailui();
			irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(ataskaitos_lent.get(i).getLenteles_pav()) + ".java";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
			//kuriamas paieškos html failas
			KurtiHtmlPaieskaiFaila html_paieskai = new KurtiHtmlPaieskaiFaila(paieskos_lent.get(i), ataskaitos_lent.get(i));
			duomenys = html_paieskai.htmlFailui();
			irasomo_failo_vardas = "src/main/resources/templates/" + paieskos_lent.get(i).getLenteles_pav() + ".html";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
		}
		// failų, kuriamų iš lentelių be duomenų ir su duomenimos ciklas
		for(int i = 0; i < lent_be_duomenu.size(); i++) {
			//kuriamas lentelės klasės java failas
			KurtiJavaFaila javaFailoDuomenys = new KurtiJavaFaila(lent_be_duomenu.get(i));
			duomenys = javaFailoDuomenys.javaFailui();
			irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + ".java";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
			//kuriamas lentelės Repository klasės java failas
			KurtiRepositoryFaila repositoryFailoDuomenys = new KurtiRepositoryFaila(lent_be_duomenu.get(i));
			duomenys = repositoryFailoDuomenys.repositoryFailui();
			irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + "Repository.java";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
			//kuriamas lentelės Repository Test klasės java failas
			KurtiRepositoryTest repositoryTestDuomenys = new KurtiRepositoryTest(lent_su_duomenimis.get(i));
			duomenys = repositoryTestDuomenys.repositoryTest();
			irasomo_failo_vardas = "src/test/java/egzaminui/demo/" + StringUtils.capitalize(lent_be_duomenu.get(i).getLenteles_pav()) + "RepositoryTest.java";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
			//kuriamas lentelės klasės html failas
			KurtiHtmlFaila htmlFailoDuomenys = new KurtiHtmlFaila(lent_be_duomenu.get(i));
			duomenys = htmlFailoDuomenys.htmlFailui();
			irasomo_failo_vardas = "src/main/resources/templates/" + lent_be_duomenu.get(i).getLenteles_pav() + ".html";
			rasymas = new RasymasFaile(irasomo_failo_vardas);
			rasymas.iEilutes(duomenys);
		}
		//Jei reikia dar sukurti kokiu nors failu
		/*SkaitymasIsFailo java_sql = new SkaitymasIsFailo("src/main/java/egzaminui/demo/SqlUzklausai.java");
		duomenys = java_sql.iMasyva();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/KurtiSqlUzklausai.java";
		RasymasFaile2 rasymas2 = new RasymasFaile2(irasomo_failo_vardas);
		rasymas2.iEilutes(duomenys);*/
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
