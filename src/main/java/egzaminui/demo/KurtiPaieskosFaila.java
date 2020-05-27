package egzaminui.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas kuriamo Java failo duomenims įvesti pagal ataskaitos ir paieškos lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiPaieskosFaila {
	/**
	 * @param lenteles LenteleBeDuomenu klasės kintamasis duomenims iš Html gauti
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * @param lentele2 LenteleBeDuomenu klasės kintamasis duomenims iš duombazės gauti
	 */
	private LenteleBeDuomenu lentele2;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiPaieskosFaila() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo kintamieji, reikalingi paimti duomenis iš Html ir iš duomenų bazės
	 */
	public KurtiPaieskosFaila(LenteleBeDuomenu lentele_is_html, LenteleBeDuomenu lentele_i_html) {
		
		this.lentele = lentele_is_html;
		this.lentele2 = lentele_i_html;
	}
	/**
	 * Metodas grąžinti String sąrašo tipo kintamajį java failo kūrimui
	 * @return java_failui
	 */
	public ArrayList<String> javaFailui() {

		ArrayList<String> java_failui = new ArrayList<String>();
		java_failui.add("package egzaminui.demo;");
		java_failui.add("");
		java_failui.add("import java.util.List;");
		java_failui.add("import javax.persistence.*;");
		java_failui.add("import org.hibernate.Session;");
		java_failui.add("");
		java_failui.add("/**");
		java_failui.add(" * Failas, skirtas sukurti sql uzklausa ir pasiimti duomenis is duomenu bazes");
		java_failui.add(" * ");
		java_failui.add(" * @author Toma");
		java_failui.add(" *");
		java_failui.add(" */");
		java_failui.add("");
		java_failui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " {");
		java_failui.add("	/**");
		java_failui.add("	 * @param em Session klasės kintamasis sukurti sesijai į duombazę");
		java_failui.add("	 */");
		java_failui.add("	protected Session em;	");
		java_failui.add("	");
		java_failui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " (  Session em  ) {");
		java_failui.add("		  ");
		java_failui.add("		this.em = em;");
		java_failui.add("	}	");
		java_failui.add("");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas grąžinti " + StringUtils.capitalize(this.lentele2.getLenteles_pav()) + " sąrašo tipo kintamajį sudarytą įvykdžius sql uzklausą duombazėje");
		java_failui.add("	 * @return (List<Ataskaita>) query.getResultList()");
		java_failui.add("	 */");
		java_failui.add("");
		String duomenu_eilute = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++) {
			duomenu_eilute += kablelis + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i);
			kablelis = ", ";
		}
		java_failui.add("	public List<" + StringUtils.capitalize(this.lentele2.getLenteles_pav()) + "> ataskaitosLentele ( " + duomenu_eilute + " ) {");
		java_failui.add("	  ");
		java_failui.add("		String where = \"WHERE \"");
		java_failui.add("				+ 	\"`lenteles_pavadinimas`.`" + this.lentele.getStulpeliu_pav().get(0) + "`=\" + " + this.lentele.getStulpeliu_pav().get(0) + ";");
		java_failui.add("		int checkbox = 0;");
		java_failui.add("		//if (" + this.lentele.getStulpeliu_pav().get(1) + " == 1 && " + this.lentele.getStulpeliu_pav().get(2) + " == 0) {");
		java_failui.add("		  ");
		java_failui.add("		//	checkbox = 1;");
		java_failui.add("		//	where += \" AND `lenteles_pav`.`lenteles_stulp`= \" + checkbox;");
		java_failui.add("		  ");
		java_failui.add("		//}");
		java_failui.add("		if (" + this.lentele.getStulpeliu_pav().get(1) + " == 0 && " + this.lentele.getStulpeliu_pav().get(2) + " == 1) {");
		java_failui.add("		   ");
		java_failui.add("		 	where += \" AND `lenteles_pav`.`lenteles_stulp`= \" + checkbox;");
		java_failui.add("		}");
		java_failui.add("	  ");
		java_failui.add("		String sql_qw =");
		java_failui.add("	  				");
		java_failui.add("	  		\"SELECT SQL_CALC_FOUND_ROWS \" ");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++) {
			java_failui.add("				+ 	\"`lenteles_pavadinimas`.`" + this.lentele.getStulpeliu_pav().get(i) + "` AS `" + this.lentele2.getStulpeliu_pav().get(i) + "` \"");
		}
		java_failui.add("				+ \"FROM \"");
		java_failui.add("				+ 		\"`lent_pavadinimas` \"  ");
		java_failui.add("				+ \"LEFT JOIN \"");
		java_failui.add("				+ \"		`lenteles_pavadinimas` ON ( \"");       
		java_failui.add("				+ 			\"`lenteles_pavadinimas`.`id`=`lent_pavadinimas`.`lenteles_pavadinimas_id` \"");
		java_failui.add("				+ 		\") \"");
		java_failui.add("				+ where");
		java_failui.add("				");
		java_failui.add("			+ \" ORDER BY\"");
		java_failui.add("			+	   \" `lent_pavadinimas`.`kiekis` DESC \"");
		java_failui.add("				;");
		java_failui.add("	  	System.out.println ( sql_qw );");
		java_failui.add("	    Query query = em.createNativeQuery ( sql_qw );");
		java_failui.add("	    return (List<" + StringUtils.capitalize(this.lentele2.getLenteles_pav()) + ">) query.getResultList();");
		java_failui.add("	}");
		java_failui.add("}");
		return java_failui;
	}
}