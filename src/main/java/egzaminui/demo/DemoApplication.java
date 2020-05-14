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
	
		ArrayList<Lentele> lenteliu_duomenys;
		String irasomo_failo_vardas;
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		Pagrindinis pagr = (Pagrindinis) context.getBean("mainspring");
		pagr.SkaitytiIsFailo();
		pagr.SudarytiLenteles();
		pagr.IsvestiLentelesIKonsole();
		lenteliu_duomenys = pagr.getLenteles();
		/*KurtiMenuFaila menu = new KurtiMenuFaila(lenteliu_duomenys);
		ArrayList<String> duomenys = menu.MenuFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/Menu.java";
		pagr.setIrasomo_failo_var(irasomo_failo_vardas);
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		KurtiPageControllerFaila pageControllerFailoDuomenys = new KurtiPageControllerFaila(lenteliu_duomenys);
		ArrayList<String> duomenys = pageControllerFailoDuomenys.JavaFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/PageController.java";
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);*/
		KurtiDuombaze db_kurimas = new KurtiDuombaze("demo");
		db_kurimas.Kurti();
		
		for(int i = 0; i < lenteliu_duomenys.size(); i++) {
				KurtiSqlLentele sql_lentele = new KurtiSqlLentele(lenteliu_duomenys.get(i));
				sql_lentele.Vykdyti();
				/*KurtiJavaFaila javaFailoDuomenys = new KurtiJavaFaila(lenteliu_duomenys.get(i));
				duomenys = javaFailoDuomenys.JavaFailui();
				irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lenteliu_duomenys.get(i).getLenteles_pav()) + ".java";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
				KurtiRepositoryFaila repositoryFailoDuomenys = new KurtiRepositoryFaila(lenteliu_duomenys.get(i));
				duomenys = repositoryFailoDuomenys.RepositoryFailui();
				irasomo_failo_vardas = "src/main/java/egzaminui/demo/" + StringUtils.capitalize(lenteliu_duomenys.get(i).getLenteles_pav()) + "Repository.java";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
				KurtiHtmlFaila htmlFailoDuomenys = new KurtiHtmlFaila(lenteliu_duomenys.get(i));
				duomenys = htmlFailoDuomenys.HtmlFailui();
				irasomo_failo_vardas = "src/main/resources/templates/" + lenteliu_duomenys.get(i).getLenteles_pav() + ".html";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);*/
			}
		/*SkaitymasIsFailo sql_uzklausu_java = new SkaitymasIsFailo("src/main/java/egzaminui/demo/TopProduktaiPagalMedz.java");
		ArrayList<String> duomenys = sql_uzklausu_java.iMasyva();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/KurtiSlqUzklausoms.java";
		RasymasFaile2 rasymas2 = new RasymasFaile2(irasomo_failo_vardas);
		rasymas2.iEilutes(duomenys);*/
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
