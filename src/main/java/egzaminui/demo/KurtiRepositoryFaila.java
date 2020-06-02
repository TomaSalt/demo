package egzaminui.demo;

import java.util.ArrayList;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas kurti java Repository failą pagal duomenų bazės lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiRepositoryFaila {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiRepositoryFaila() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo duomenys
	 * @param lentele LenteleBeDuomenu klasės kintamasis duomenų bazės lentelei
	 */
	public KurtiRepositoryFaila(LenteleBeDuomenu lentele) {
		
		this.lentele = lentele;
		
	}
	/**
	 * Metodas grąžinti String sąrašo tipo kintamajį Repository failo kūrimui
	 * @return java_failui
	 */
	public ArrayList<String> repositoryFailui() {
		
		ArrayList<String> java_failui = new ArrayList<String>();
		java_failui.add("package egzaminui.demo;");
		java_failui.add("import java.util.List;");
		java_failui.add("import org.springframework.data.jpa.repository.Query;");
		java_failui.add("//import java.util.stream.*;");
		java_failui.add("//import org.springframework.data.repository.Repository;");
		java_failui.add("import org.springframework.data.repository.CrudRepository;");
		java_failui.add("//import org.springframework.data.repository.query.Param;");
		java_failui.add("/**");
		java_failui.add(" * Failas, skirtas " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "Repository java klasei, kuri papildo CrudRepository metodus pagal lentelės duomenis ir egzamino užduotį");
		java_failui.add(" *");
		java_failui.add(" * @author x");
		java_failui.add(" *");
		java_failui.add(" */");
		java_failui.add("public interface " + StringUtils.capitalize(lentele.getLenteles_pav()) + "Repository extends CrudRepository<" + StringUtils.capitalize(lentele.getLenteles_pav()) + ", Integer>{");
		java_failui.add("");
		java_failui.add("	//List<" + StringUtils.capitalize(lentele.getLenteles_pav()) + ">findBy" + StringUtils.capitalize(lentele.getStulpeliu_pav().get(1)) + "( " + lentele.getStulpeliu_tipai().get(1) + " " + lentele.getStulpeliu_pav().get(1) + " );");
		java_failui.add("	" + StringUtils.capitalize(lentele.getLenteles_pav()) + " findBy" + StringUtils.capitalize(lentele.getStulpeliu_pav().get(1)) + "(" + lentele.getStulpeliu_tipai().get(1) + " " + lentele.getStulpeliu_pav().get(1) + " );");
		java_failui.add("");
		String select_stulpeliu_pav = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			select_stulpeliu_pav += kablelis + this.lentele.getStulpeliu_pav().get(i);
			kablelis = ", ";
		}
		java_failui.add("	//@Query(value=\"SELECT " + select_stulpeliu_pav + " FROM " + lentele.getLenteles_pav() + " WHERE salyga=1\", nativeQuery = true)");
		java_failui.add("	//List<" + StringUtils.capitalize(lentele.getLenteles_pav()) + "> findAllQuery();");
		java_failui.add("}");
		return java_failui;
		
	}
}
