package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	
		ArrayList<LenteleSuDuomenimis> lenteliu_duomenys;
		LenteleBeDuomenu ataskaitos_lent;
		LenteleBeDuomenu paieskos_lent;
		String irasomo_failo_vardas;
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		Pagrindinis pagr = (Pagrindinis) context.getBean("mainspring");
		pagr.SkaitytiIsFailo();
		pagr.SudarytiLenteles();
		pagr.IsvestiLentelesIKonsole();
		lenteliu_duomenys = pagr.getLenteles();
		pagr.setSkaitomo_failo_var("src/egzaminui_ataskaita_is_html.csv");
		pagr.SkaitytiIsFailo();
		pagr.SudarytiAtaskaitosLentele();
		paieskos_lent = pagr.getLentele();
		/*pagr.setSkaitomo_failo_var("src/egzaminui_ataskaita_i_html.csv");
		pagr.SkaitytiIsFailo();
		pagr.SudarytiAtaskaitosLentele();
		ataskaitos_lent = pagr.getLentele();
		KurtiMenuFaila menu = new KurtiMenuFaila(lenteliu_duomenys, ataskaitos_lent);
		ArrayList<String> duomenys = menu.MenuFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/Menu.java";
		pagr.setIrasomo_failo_var(irasomo_failo_vardas);
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		KurtiPageControllerFaila pageControllerFailoDuomenys = new KurtiPageControllerFaila(lenteliu_duomenys, paieskos_lent);
		duomenys = pageControllerFailoDuomenys.JavaFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/PageController.java";
		rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		KurtiDuombaze db_kurimas = new KurtiDuombaze("demo", lenteliu_duomenys);
		db_kurimas.Kurti();*/
		KurtiSqlUzklausai javaPaieskosDuomenys = new KurtiSqlUzklausai(paieskos_lent);
		ArrayList<String> duomenys = javaPaieskosDuomenys.JavaFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(paieskos_lent.getLenteles_pav()) + ".java";
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		/*for(int i = 0; i < lenteliu_duomenys.size(); i++) {

				KurtiJavaFaila javaFailoDuomenys = new KurtiJavaFaila(lenteliu_duomenys.get(i));
				duomenys = javaFailoDuomenys.JavaFailui();
				irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lenteliu_duomenys.get(i).getLenteles_pav()) + ".java";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
				KurtiRepositoryFaila repositoryFailoDuomenys = new KurtiRepositoryFaila(lenteliu_duomenys.get(i));
				duomenys = repositoryFailoDuomenys.RepositoryFailui();
				irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lenteliu_duomenys.get(i).getLenteles_pav()) + "Repository.java";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
				KurtiRepositoryTest repositoryTestDuomenys = new KurtiRepositoryTest(lenteliu_duomenys.get(i));
				duomenys = repositoryTestDuomenys.RepositoryTest();
				irasomo_failo_vardas = "src/test/java/egzaminui/demo/" + StringUtils.capitalize(lenteliu_duomenys.get(i).getLenteles_pav()) + "RepositoryTest.java";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
				KurtiHtmlFaila htmlFailoDuomenys = new KurtiHtmlFaila(lenteliu_duomenys.get(i));
				duomenys = htmlFailoDuomenys.HtmlFailui();
				irasomo_failo_vardas = "src/main/resources/templates/" + lenteliu_duomenys.get(i).getLenteles_pav() + ".html";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
			}*/
		//Jei reikia dar sukurti kokiu nors failu
		/*SkaitymasIsFailo java_sql = new SkaitymasIsFailo("src/main/java/egzaminui/demo/SqlUzklausai.java");
		ArrayList<String> duomenys = java_sql.iMasyva();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/KurtiSqlUzklausai.java";
		RasymasFaile2 rasymas2 = new RasymasFaile2(irasomo_failo_vardas);
		rasymas2.iEilutes(duomenys);*/
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
