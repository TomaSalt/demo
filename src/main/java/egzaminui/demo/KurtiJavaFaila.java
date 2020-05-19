package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

public class KurtiJavaFaila {
	
	private LenteleSuDuomenimis lentele;
		
	public KurtiJavaFaila() {
		
	}

	public KurtiJavaFaila(LenteleSuDuomenimis lentele) {
		
		this.lentele = lentele;
		
	}
	public ArrayList<String> JavaFailui() {
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("");
		JavaFailui.add("import javax.persistence.CascadeType;");
		JavaFailui.add("import javax.persistence.Entity;");
		JavaFailui.add("import javax.persistence.GeneratedValue;");
		JavaFailui.add("import javax.persistence.GenerationType;");
		JavaFailui.add("import javax.persistence.Id;");
		JavaFailui.add("import javax.persistence.JoinColumn;");
		JavaFailui.add("import javax.persistence.OneToMany;");
		JavaFailui.add("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("");
		JavaFailui.add("@Entity //iesko duomenu bazeje tokios lenteles");
		JavaFailui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " {");
		JavaFailui.add("");
		JavaFailui.add("	@Id");
		JavaFailui.add("	@GeneratedValue(strategy=GenerationType.IDENTITY)");
		
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			JavaFailui.add("	private " + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + ";");
			
		}
		JavaFailui.add("");
		JavaFailui.add("	//@OneToMany(mappedBy=\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\",cascade=CascadeType.ALL)");
		JavaFailui.add("	//@JsonIgnoreProperties(\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\")");
		JavaFailui.add("	//sąryšiui vienas su daug");
		JavaFailui.add("	//private List<Kitos_lenteles_pavadinimas> kitos_lenteles_pavadinimas;");
		JavaFailui.add("");
		String sarasas = "";
		for (int i = 0; i < (this.lentele.getKiekis_stulpeliu()-1); i++) {
			
			sarasas += this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + ", ";
			
		}
		sarasas += this.lentele.getStulpeliu_tipai().get(this.lentele.getKiekis_stulpeliu()-1) + " " + this.lentele.getStulpeliu_pav().get(this.lentele.getKiekis_stulpeliu()-1) + " ) {";
		JavaFailui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( " + sarasas);
		JavaFailui.add("		super();");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			JavaFailui.add("		this." + this.lentele.getStulpeliu_pav().get(i) + " = " + this.lentele.getStulpeliu_pav().get(i) + ";");
			
		}
		JavaFailui.add("	}");
		JavaFailui.add("	public " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "() {");
		JavaFailui.add("");
		JavaFailui.add("	}");
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			JavaFailui.add("	public " + this.lentele.getStulpeliu_tipai().get(i) + " get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "() {");
			JavaFailui.add("		return " + this.lentele.getStulpeliu_pav().get(i) + ";");
			JavaFailui.add("	}");
			JavaFailui.add("	public void set" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "( " + this.lentele.getStulpeliu_tipai().get(i) + " " + this.lentele.getStulpeliu_pav().get(i) + " ) {");
			JavaFailui.add("		this." + this.lentele.getStulpeliu_pav().get(i) + " = " + this.lentele.getStulpeliu_pav().get(i) + ";");
			JavaFailui.add("	}");
			
		}
		JavaFailui.add("}");
		return JavaFailui;
	}
}
