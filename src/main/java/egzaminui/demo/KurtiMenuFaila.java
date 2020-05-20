package egzaminui.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas kuriamo menu java failo duomenims įvesti pagal lentelės duomenis
 * 
 * @author Toma
 *
 */
@Component
public class KurtiMenuFaila {
	/**
	 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį lentelių duomenims
	 */
	private ArrayList<LenteleBeDuomenu> lenteles;
	/**
	 * Sukuria dar vieną LenteleBeDuomenu klasės sąrašo tipo kintamąjį ataskaitos lentelių
	 */
	private ArrayList<LenteleBeDuomenu> ataskaitos_lenteles;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiMenuFaila() {
		
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės sąrašo tipo duomenys, reikalingi menu failo sudarymui
	 */
	public KurtiMenuFaila(ArrayList<LenteleBeDuomenu> lenteles, ArrayList<LenteleBeDuomenu> ataskaitos_lenteles) {
		
		this.lenteles = lenteles;
		this.ataskaitos_lenteles = ataskaitos_lenteles;
		
	}	
	/**
	 * Papildomas String sąrašo tipo kintamasis duomenimis, reikalingais menu failo kūrimui
	 * @return java_failui
	 */
	public ArrayList<String> menuFailui() {	
		
		String kablelis = "";
		String kabliataskis = "";
		ArrayList<String> java_failui = new ArrayList<String>();
		java_failui.add("package egzaminui.demo;");
		java_failui.add("");
		java_failui.add("public enum Menu {");
		java_failui.add("");
		for (int i = 0; i < lenteles.size(); i++) {
			if (i == ( lenteles.size()-1 ) && ataskaitos_lenteles.size() == 0 ) {
				kabliataskis = ";";
			}
			java_failui.add("	" + kablelis + StringUtils.capitalize(lenteles.get(i).getLenteles_pav()) + "(\"/" + lenteles.get(i).getLenteles_pav() + "\", \"" + StringUtils.capitalize(lenteles.get(i).getLenteles_pav()) + "\")" + kabliataskis);
			kablelis = ", ";

		}
		for (int i = 0; i < ataskaitos_lenteles.size(); i++) {
			
			if (i == (ataskaitos_lenteles.size()-1)) {
				kabliataskis = ";";
			}
			java_failui.add("	" + kablelis + StringUtils.capitalize(ataskaitos_lenteles.get(i).getLenteles_pav()) + "(\"/" + ataskaitos_lenteles.get(i).getLenteles_pav() + "\", \"" + StringUtils.capitalize(ataskaitos_lenteles.get(i).getLenteles_pav()) + "\")" + kabliataskis);
			kablelis = ", ";

		}
		java_failui.add("");
		java_failui.add("	private final String itemurl;");
		java_failui.add("	private final String naujasPavadinimas;");
		java_failui.add("");              
		java_failui.add("	Menu( String url, String pavadinimas ) {");
		java_failui.add("		this.itemurl = url;");
		java_failui.add("		this.naujasPavadinimas = pavadinimas;");
		java_failui.add("	}");
		java_failui.add("");
		java_failui.add("	public String itemurl() {");
		java_failui.add("		return this.itemurl;");
		java_failui.add("	}");
		java_failui.add("");
		java_failui.add("	public String naujasPavadinimas() {");
		java_failui.add("		return this.naujasPavadinimas;");
		java_failui.add("	}");
		java_failui.add("}");
		return java_failui;
	}			
}