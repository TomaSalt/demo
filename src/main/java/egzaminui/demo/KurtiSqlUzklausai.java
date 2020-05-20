package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas kuriamo Java failo duomenims įvesti pagal ataskaitos ir paieškos lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiSqlUzklausai {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį duomenims iš Html gauti
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Sukuria dar vieną LenteleBeDuomenu klasės kintamąjį duomenims iš duombazės gauti
	 */
	private LenteleBeDuomenu lentele2;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiSqlUzklausai() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo kintamieji, reikalingi paimti duomenis iš Html ir iš duomenų bazės
	 */
	public KurtiSqlUzklausai(LenteleBeDuomenu lentele_is_html, LenteleBeDuomenu lentele_i_html) {
		
		this.lentele = lentele_is_html;
		this.lentele2 = lentele_i_html;
	}
	/**
	 * String sąrašo tipo kintamasis, reikalingas java failo kūrimui
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
		java_failui.add("	 * Sukuria Session klasės kintamąjį");
		java_failui.add("	 */");
		java_failui.add("	protected Session em;	");
		java_failui.add("	");
		java_failui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " (  Session em  ) {");
		java_failui.add("		  ");
		java_failui.add("		this.em = em;");
		java_failui.add("	}	");
		java_failui.add("");
		java_failui.add("	/**");
		java_failui.add("	 * sarasas duomenu gautas ivykdzius sql uzklausa duombazeje");
		java_failui.add("	 */");
		java_failui.add("");
		String duomenu_eilute = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++) {
			duomenu_eilute += kablelis + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i);
			kablelis = ", ";
		}
		java_failui.add("	public List<Ataskaita> ataskaitos_lentele ( " + duomenu_eilute + " ) {");
		java_failui.add("	  ");
		java_failui.add("		String where = \"WHERE \"");
		java_failui.add("				+ 	\"`lenteles_pavadinimas`.`" + this.lentele.getStulpeliu_pav().get(0) + "`=\" + " + this.lentele.getStulpeliu_pav().get(0) + ";");
		java_failui.add("		//int checkbox = 0;");
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
		java_failui.add("	    return (List<PaieskosLentele>) query.getResultList();");
		java_failui.add("	}");
		java_failui.add("}");
		return java_failui;
	}
}