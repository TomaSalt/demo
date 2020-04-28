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
		KurtiMenuFaila menu = new KurtiMenuFaila(lenteliu_duomenys);
		ArrayList<String> duomenys = menu.MenuFailui();
		irasomo_failo_vardas = "src/main/java/egzaminui/demo/Menu.java";
		pagr.setIrasomo_failo_var(irasomo_failo_vardas);
		RasymasFaile rasymas = new RasymasFaile(irasomo_failo_vardas);
		rasymas.iEilutes(duomenys);
		
		for(int i = 0; i < lenteliu_duomenys.size(); i++) {
					
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
				KurtiHtmlFaila htmlFailoDuomenys = new KurtiHtmlFaila(lenteliu_duomenys.get(i));
				duomenys = htmlFailoDuomenys.HtmlFailui();
				irasomo_failo_vardas = "src/main/resources/templates/" + lenteliu_duomenys.get(i).getLenteles_pav() + ".html";
				rasymas = new RasymasFaile(irasomo_failo_vardas);
				rasymas.iEilutes(duomenys);
			}
		SkaitymasIsFailo page_control_skaitymas = new SkaitymasIsFailo("src/PageController.java");
		ArrayList<String> duomenysPage = page_control_skaitymas.iMasyva();
		RasymasFaile2 rasymas2 = new RasymasFaile2("src/main/java/egzaminui/demo/PageController2.java");
		rasymas2.iEilutes(duomenysPage);
		((ClassPathXmlApplicationContext) context).close();
	
	}

}
