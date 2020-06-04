package egzaminui.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas kurti Java failą, sql užklausų kūrimui, pagal ataskaitos ir paieškos lentelių duomenis
 * 
 * @author Toma
 *
 */
public class KurtiPaieskosFaila {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį duomenims iš Html gauti
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį duomenims iš duombazės gauti
	 */
	private LenteleBeDuomenu lentele2;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiPaieskosFaila() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo kintamieji, reikalingi paimti duomenis iš Html ir iš duomenų bazės
	 * @param lentele_is_html LenteleBeDuomenu klasės kintamasis paieškos lentelei
	 * @param lentele_i_html LenteleBeDuomenu klasės kintamasis ataskaitos lentelei
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
		java_failui.add(" * @author x");
		java_failui.add(" *");
		java_failui.add(" */");
		java_failui.add("");
		java_failui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " {");
		java_failui.add("	/**");
		java_failui.add("	 * Sukuria em Session klasės kintamąjį sesijai į duombazę");
		java_failui.add("	 */");
		java_failui.add("	protected Session em;	");
		java_failui.add("	");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas priskirti Session klasės kintamąjį");
		java_failui.add("	 * @param em Session klasės kintamasis sukurti sesijai į duombazę");
		java_failui.add("	 */");
		java_failui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " (  Session em  ) {");
		java_failui.add("		  ");
		java_failui.add("		this.em = em;");
		java_failui.add("	}	");
		java_failui.add("");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas grąžinti " + StringUtils.capitalize(this.lentele2.getLenteles_pav()) + " sąrašo tipo kintamajį sudarytą įvykdžius sql uzklausą duombazėje");
		for( int y=0; y < lentele.getKiekis_stulpeliu(); y++ ) {
			java_failui.add("	* @param " + lentele.getStulpeliu_pav().get(y) + " " + StringUtils.capitalize(lentele.getStulpeliu_tipai().get(y)) + " klasės tipo kintamasis");
		}
		java_failui.add("	 * @return (List<Ataskaita>)query.getResultList()");
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
		java_failui.add("	  //!!! Sudaroma WHERE sąlyga pagal užduotį !!!");
		java_failui.add("		String where = \"WHERE \"");
		
		java_failui.add("				+ 	\"`lentele1`.`" + this.lentele.getStulpeliu_pav().get(0) + "`= " + Character.toString ((char) 92) + "\"\" + " + this.lentele.getStulpeliu_pav().get(0) + " + \"" + Character.toString ((char) 92) + "\"\";");
		java_failui.add("		where += \" AND `lentele3`.`" + this.lentele.getStulpeliu_pav().get(1) + "`= " + Character.toString ((char) 92) + "\"\" + " + this.lentele.getStulpeliu_pav().get(1) + " + \"" + Character.toString ((char) 92) + "\"\";");
		java_failui.add("		  ");
		java_failui.add("		where += \" AND `lentele1`.`" + this.lentele.getStulpeliu_pav().get(2) +"`= " + Character.toString ((char) 92) + "\"\" + " + this.lentele.getStulpeliu_pav().get(2) + " + \"" + Character.toString ((char) 92) + "\"\";");
		java_failui.add("	  ");
		java_failui.add("	  //!!! Lentelių pavadinimus pakeisti pagal užduotį !!!");
		java_failui.add("		String sql_qw =");
		java_failui.add("	  				");
		java_failui.add("	  		\"SELECT SQL_CALC_FOUND_ROWS \" ");
		kablelis = "";
		for (int i = 0; i < this.lentele2.getKiekis_stulpeliu(); i++) {
			java_failui.add("				+ 	\""+ kablelis + "`lentele3`.`" + this.lentele2.getStulpeliu_pav().get(i) + "` AS `" + this.lentele2.getStulpeliu_pav().get(i) + "` \"");
			kablelis = ", ";
		}
		java_failui.add("				+ \"FROM \"");
		java_failui.add("				+ 		\"`lentele3` \"  ");
		java_failui.add("				+ \"LEFT JOIN \"");
		java_failui.add("				+ \"		`lentele1` ON ( \"");       
		java_failui.add("				+ 			\"`lentele1`.`id`=`lentele3`.`lentele1_id` \"");
		java_failui.add("				+ 		\") \"");
		java_failui.add("				+ where");
		java_failui.add("				");
		java_failui.add("			+ \" GROUP BY\"");
		java_failui.add("			+	   \" `lentele1`.`stulp2`\"");
		java_failui.add("			+ \" ORDER BY\"");
		java_failui.add("			+	   \" `lentele3`.`" + this.lentele2.getStulpeliu_pav().get(0) + "` DESC \"");
		java_failui.add("				;");
		java_failui.add("	  	System.out.println ( sql_qw );");
		java_failui.add("	    Query query = em.createNativeQuery ( sql_qw );");
		java_failui.add("	    return (List<" + StringUtils.capitalize(this.lentele2.getLenteles_pav()) + ">) query.getResultList();");
		java_failui.add("	}");
		java_failui.add("}");
		return java_failui;
	}
}