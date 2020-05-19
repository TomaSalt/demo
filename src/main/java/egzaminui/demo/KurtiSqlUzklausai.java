package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas kuriamo Java failo duomenims įvesti pagal ataskaitos lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiSqlUzklausai {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Sukuria dar viena LenteleBeDuomenu klasės kintamąjį
	 */
	private LenteleBeDuomenu lentele2;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiSqlUzklausai() {
	
	}

	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu class tipo duomenys
	 */
	public KurtiSqlUzklausai(LenteleBeDuomenu lentele_is_html, LenteleBeDuomenu lentele_i_html) {
		
		this.lentele = lentele_is_html;
		this.lentele2 = lentele_i_html;
	}
	public ArrayList<String> JavaFailui() {
		/**
		 * Sukuria String sąrašo tipo kintamąjį
		 */
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("import javax.persistence.*;");
		JavaFailui.add("import org.hibernate.Session;");
		JavaFailui.add("");
		JavaFailui.add("/**");
		JavaFailui.add(" * Failas, skirtas sukurti sql uzklausa ir pasiimti duomenis is duomenu bazes");
		JavaFailui.add(" * ");
		JavaFailui.add(" * @author Toma");
		JavaFailui.add(" *");
		JavaFailui.add(" */");
		JavaFailui.add("");
		JavaFailui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " {");
		JavaFailui.add("	/**");
		JavaFailui.add("	 * Sukuria Session klasės kintamąjį");
		JavaFailui.add("	 */");
		JavaFailui.add("	protected Session em;	");
		JavaFailui.add("	");
		JavaFailui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " (  Session em  ) {");
		JavaFailui.add("		  ");
		JavaFailui.add("		this.em = em;");
		JavaFailui.add("	}	");
		JavaFailui.add("");
		JavaFailui.add("	/**");
		JavaFailui.add("	 * sarasas duomenu gautas ivykdzius sql uzklausa duombazeje");
		JavaFailui.add("	 */");
		JavaFailui.add("");
		String duomenu_eilute = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++) {
			duomenu_eilute += kablelis + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i);
			kablelis = ", ";
		}
		JavaFailui.add("	public List<Ataskaita> ataskaitos_lentele ( " + duomenu_eilute + " ) {");
		JavaFailui.add("	  ");
		JavaFailui.add("		String where = \"WHERE \"");
		JavaFailui.add("				+ 	\"`lenteles_pavadinimas`.`" + this.lentele.getStulpeliu_pav().get(0) + "`=\" + " + this.lentele.getStulpeliu_pav().get(0) + ";");
		JavaFailui.add("		//int checkbox = 0;");
		JavaFailui.add("		//if (" + this.lentele.getStulpeliu_pav().get(1) + " == 1 && " + this.lentele.getStulpeliu_pav().get(2) + " == 0) {");
		JavaFailui.add("		  ");
		JavaFailui.add("		//	checkbox = 1;");
		JavaFailui.add("		//	where += \" AND `lenteles_pav`.`lenteles_stulp`= \" + checkbox;");
		JavaFailui.add("		  ");
		JavaFailui.add("		//}");
		JavaFailui.add("		if (" + this.lentele.getStulpeliu_pav().get(1) + " == 0 && " + this.lentele.getStulpeliu_pav().get(2) + " == 1) {");
		JavaFailui.add("		   ");
		JavaFailui.add("		 	where += \" AND `lenteles_pav`.`lenteles_stulp`= \" + checkbox;");
		JavaFailui.add("		}");
		JavaFailui.add("	  ");
		JavaFailui.add("		String sql_qw =");
		JavaFailui.add("	  				");
		JavaFailui.add("	  		\"SELECT SQL_CALC_FOUND_ROWS \" ");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++) {
			JavaFailui.add("				+ 	\"`lenteles_pavadinimas`.`" + this.lentele.getStulpeliu_pav().get(i) + "` AS `" + this.lentele2.getStulpeliu_pav().get(i) + "` \"");
		}
		JavaFailui.add("				+ \"FROM \"");
		JavaFailui.add("				+ 		\"`lent_pavadinimas` \"  ");
		JavaFailui.add("				+ \"LEFT JOIN \"");
		JavaFailui.add("				+ \"		`lenteles_pavadinimas` ON ( \"");       
		JavaFailui.add("				+ 			\"`lenteles_pavadinimas`.`id`=`lent_pavadinimas`.`lenteles_pavadinimas_id` \"");
		JavaFailui.add("				+ 		\") \"");
		JavaFailui.add("				+ where");
		JavaFailui.add("				");
		JavaFailui.add("			+ \" ORDER BY\"");
		JavaFailui.add("			+	   \" `lent_pavadinimas`.`kiekis` DESC \"");
		JavaFailui.add("				;");
		JavaFailui.add("	  	System.out.println ( sql_qw );");
		JavaFailui.add("	    Query query = em.createNativeQuery ( sql_qw );");
		JavaFailui.add("	    return (List<PaieskosLentele>) query.getResultList();");
		JavaFailui.add("	}");
		JavaFailui.add("}");
		return JavaFailui;
	}
}