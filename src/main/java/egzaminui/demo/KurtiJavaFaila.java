package egzaminui.demo;

import java.util.ArrayList;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas kurti java klasės failą pagal duomenų bazės lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiJavaFaila {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiJavaFaila() {
		
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo duomenys
	 * @param lentele_be_duomenu LenteleBeDuomenu klasės kintamasis duomenų bazės lentelei
	 */
	public KurtiJavaFaila(LenteleBeDuomenu lentele_be_duomenu) {
		
		this.lentele = lentele_be_duomenu;
		
	}
	/**
	 * Metodas grąžinti String sąrašo tipo kintamajį java failo kūrimui
	 * @return java_failui
	 */
	public ArrayList<String> javaFailui() {
		ArrayList<String> java_failui = new ArrayList<String>();
		java_failui.add("package egzaminui.demo;");
		java_failui.add("");
		java_failui.add("import javax.persistence.CascadeType;");
		java_failui.add("import javax.persistence.Entity;");
		java_failui.add("import javax.persistence.GeneratedValue;");
		java_failui.add("import javax.persistence.GenerationType;");
		java_failui.add("import javax.persistence.Id;");
		java_failui.add("import javax.persistence.JoinColumn;");
		java_failui.add("import javax.persistence.OneToMany;");
		java_failui.add("import javax.persistence.ManyToOne;");
		java_failui.add("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;");
		java_failui.add("import java.util.List;");
		java_failui.add("/**");
		java_failui.add(" * Failas, skirtas " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " java klasės failo duomenims įvesti pagal lentelės duomenis");
		java_failui.add(" *");
		java_failui.add(" * @author x");
		java_failui.add(" *");
		java_failui.add(" */");
		java_failui.add("@Entity //iesko duomenu bazeje tokios lenteles");
		java_failui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " {");
		java_failui.add("");
		java_failui.add("	@Id");
		java_failui.add("	@GeneratedValue(strategy=GenerationType.IDENTITY)");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			java_failui.add("	/**");
			java_failui.add("	 * Sukuria " + this.lentele.getStulpeliu_tipai().get(i) + " klasės tipo kintamąjį "); 
			java_failui.add("	 */");
			java_failui.add("	private " + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + ";");
		}
		java_failui.add("");
		java_failui.add("	//@OneToMany(mappedBy=\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\",cascade=CascadeType.ALL)");
		java_failui.add("	//@JsonIgnoreProperties(\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\")");
		java_failui.add("	//sąryšiui vienas su daug");
		java_failui.add("	//private List<Kitos_lenteles_pavadinimas> kitos_lenteles_pavadinimas;");
		java_failui.add("");
		java_failui.add("	//@JsonIgnoreProperties(\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\")");
		java_failui.add("	//@ManyToOne");
		java_failui.add("	//@JoinColumn(insertable=false, updatable=false)");
		java_failui.add("	//private Kitos_lenteles_pavadinimas kitos_lenteles_pavadinimas;");
		java_failui.add("");
		String sarasas = "";
		for (int i = 0; i < (this.lentele.getKiekis_stulpeliu()-1); i++) {
			
			sarasas += this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + ", ";
		}
		sarasas += this.lentele.getStulpeliu_tipai().get(this.lentele.getKiekis_stulpeliu()-1) + " " + this.lentele.getStulpeliu_pav().get(this.lentele.getKiekis_stulpeliu()-1) + " ) {";
		java_failui.add("	/**");
		java_failui.add("	 * Konstruktoriui perduodami lentelės duomenys");
		for (int i = 0; i < (this.lentele.getKiekis_stulpeliu()); i++) {
			java_failui.add("	 * @param " + this.lentele.getStulpeliu_pav().get(i) + " " + this.lentele.getStulpeliu_tipai().get(i) + " klasės tipo kintamasis");
		}
		java_failui.add("	 */");
		java_failui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( " + sarasas);
		java_failui.add("		super();");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			java_failui.add("		this." + this.lentele.getStulpeliu_pav().get(i) + " = " + this.lentele.getStulpeliu_pav().get(i) + ";");
		}
		java_failui.add("	}");
		java_failui.add("	/**");
		java_failui.add("	 * Tuščias konstruktorius");
		java_failui.add("	 */");
		java_failui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "() {");
		java_failui.add("");
		java_failui.add("	}");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			java_failui.add("	/**");
			java_failui.add("	 * " + this.lentele.getStulpeliu_pav().get(i) + " getter'is");
			java_failui.add("	 * @return " + this.lentele.getStulpeliu_pav().get(i));
			java_failui.add("	 */");
			java_failui.add("	public " + this.lentele.getStulpeliu_tipai().get(i) + " get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "() {");
			java_failui.add("");
			java_failui.add("		return " + this.lentele.getStulpeliu_pav().get(i) + ";");
			java_failui.add("	}");
			java_failui.add("	/**");
			java_failui.add("	 * " + this.lentele.getStulpeliu_pav().get(i) + " setter'is");
			java_failui.add("	 * @param " + this.lentele.getStulpeliu_pav().get(i) + " " + this.lentele.getStulpeliu_tipai().get(i) + " klasės tipo kintamasis");
			java_failui.add("	 */");
			java_failui.add("	public void set" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "( " + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + " ) {");
			java_failui.add("");
			java_failui.add("		this." + this.lentele.getStulpeliu_pav().get(i) + " = " + this.lentele.getStulpeliu_pav().get(i) + ";");
			java_failui.add("	}");
		}
		java_failui.add("}");
		return java_failui;
	}
}
