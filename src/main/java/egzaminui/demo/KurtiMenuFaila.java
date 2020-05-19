package egzaminui.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class KurtiMenuFaila {
	
	private ArrayList<LenteleSuDuomenimis> lenteles;
	private LenteleBeDuomenu lentele;
	
	public KurtiMenuFaila() {
		
	}
		
	public KurtiMenuFaila(ArrayList<LenteleSuDuomenimis>lenteles, LenteleBeDuomenu lentele) {
		
		this.lenteles = lenteles;
		this.lentele = lentele;
		
	}
	
	public ArrayList<String> MenuFailui() {	
		String kablelis = "";
		String kabliataskis = "";
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("");
		JavaFailui.add("public enum Menu {");
		JavaFailui.add("");
		for (int i = 0; i < lenteles.size(); i++) {
			if (i == (lenteles.size()-1)) {
				kabliataskis = ";";
			}
			JavaFailui.add("	" + kablelis + StringUtils.capitalize(this.lenteles.get(i).getLenteles_pav()) + "(\"/" + this.lenteles.get(i).getLenteles_pav() + "\", \"" + StringUtils.capitalize(this.lenteles.get(i).getLenteles_pav()) + "\")");
			kablelis = ", ";

		}
		JavaFailui.add("	" + kablelis + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "(\"/" + this.lentele.getLenteles_pav() + "\", \"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\")" + kabliataskis);
		JavaFailui.add("");
		JavaFailui.add("	private final String itemurl;");
		JavaFailui.add("	private final String naujasPavadinimas;");
		JavaFailui.add("");              
		JavaFailui.add("	Menu( String url, String pavadinimas ) {");
		JavaFailui.add("		this.itemurl = url;");
		JavaFailui.add("		this.naujasPavadinimas = pavadinimas;");
		JavaFailui.add("	}");
		JavaFailui.add("");
		JavaFailui.add("	public String itemurl() {");
		JavaFailui.add("		return this.itemurl;");
		JavaFailui.add("	}");
		JavaFailui.add("");
		JavaFailui.add("	public String naujasPavadinimas() {");
		JavaFailui.add("		return this.naujasPavadinimas;");
		JavaFailui.add("	}");
		JavaFailui.add("}");
		return JavaFailui;
	}			
}