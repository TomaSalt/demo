package egzaminui.demo;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Component;
/**
 * Failas, skirtas nurodyti skaitomo, įrašomo failų vardams ir duomenų iš jų paėmimui, apdorojimui ir išsaugojimui
 * 
 * @author Toma
 *
 */
@Component
public class Pagrindinis{
	/**
	 * Sukuria SkaitymasIsFailo klasės tipo kintamąjį skaitymui iš failo
	 */
	private SkaitymasIsFailo sf;
	/**
	 * Sukuria RasymasFaile klasės tipo kintamąjį įrašymui į failą
	 */
	private RasymasFaile rf;
	/**
	 * Sukuria String tipo kintamąjį skaitomo failo vardui
	 */
	private String skaitomo_failo_var;
	/**
	 * Sukuria String tipo kintamajį įrašomo failo vardui
	 */
	private String irasomo_failo_var;
	/**
	 * Sukuria String sąrašo tipo kintamąjį nuskaitytiems duomenims
	 */
	ArrayList<String> nuskaityti_duomenys;
	/**
	 * Sukuria LenteleSuDuomenimis klasės sąrašo tipo kintamajį lentelėms su duomenimis
	 */	
	ArrayList<LenteleSuDuomenimis> lenteles;
	/**
	 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį lentelėms be duomenų
	 */	
	ArrayList<LenteleBeDuomenu> lenteles_be_duomenu;
	/**
	 * Sukuria LenteleSuDuomenimis klasės sąrašo tipo kintamajį lentelėms su duomenimis
	 */	
	Integer lenteliu_skaicius = 0;
	/**
	 * Tuščias konstruktorius
	 */
	public Pagrindinis(){
		
	}
	/**
	 * Konstruktoriui perduodami skaitymas ir rašymas bei skaitomo, įrašomo failų vardai
	 * @param sf SkaitymasIsFailo klasės tipo kintamasis skaitymui iš failo
	 * @param rf RasymasFaile klasės tipo kintamasis įrašymui į failą
	 * @param skaitomo_failo_var String tipo kintamasis skaitomo failo vardui
	 * @param irasomo_failo_var String tipo kintamasis įrašomo failo vardui
	 */
	public Pagrindinis(SkaitymasIsFailo sf, RasymasFaile rf, String skaitomo_failo_var, String irasomo_failo_var){

		this.rf = rf;
		this.sf = sf;
		this.skaitomo_failo_var = skaitomo_failo_var;
		this.irasomo_failo_var = irasomo_failo_var;
	}	
	/**
	 * Metodas skaitymui iš failo
	 */
	public void skaitytiIsFailo(){
		
		this.sf.setVardas_failo(this.skaitomo_failo_var);
		nuskaityti_duomenys = sf.iMasyva();
	}
	/**
	 * Metodas įrašymui į failą
	 */
	public void irasytiIFaila(){
		
		this.rf.setVardas_failo(this.irasomo_failo_var);
		this.rf.iEilutes(nuskaityti_duomenys);
	}
	/**
	 * Skaitomo_failo_var getter'is
	 * @return skaitomo_failo_var
	 */
	public String getSkaitomo_failo_var() {
		
		return skaitomo_failo_var;
	}
	/**
	 * @param skaitomo_failo_var setter'is
	 */
	public void setSkaitomo_failo_var(String skaitomo_failo_var) {
		
		this.skaitomo_failo_var = skaitomo_failo_var;
	}
	/**
	 * Irasomo_failo_var getter'is
	 * @return irasomo_failo_var
	 */
	public String getIrasomo_failo_var() {
		
		return irasomo_failo_var;
	}
	/**
	 * @param irasomo_failo_var setter'is
	 */
	public void setIrasomo_failo_var(String irasomo_failo_var) {
		
		this.irasomo_failo_var = irasomo_failo_var;
	}
	/**
	 * Metodas lentelių gavimui iš nuskaitytų duomenų
	 */
	public void gautiLenteles() {
		
		SudarytiLenteles sudaryti_lenteles = new SudarytiLenteles(nuskaityti_duomenys);
		sudaryti_lenteles.visosLenteles();
		lenteles = sudaryti_lenteles.getLenteles_su_duomenimis();
		lenteles_be_duomenu = sudaryti_lenteles.getLenteles_be_duomenu();
		lenteliu_skaicius = sudaryti_lenteles.getLenteliu_skaicius();
	}
	/**
	 * Metodas lentelių su duomenimis išvedimui į konsolę
	 */	
	public void isvestiLentelesIKonsole(){
	
		for(int y = 0; y < lenteles.size(); y++) {
			
			int z = 1;
			System.out.println("Lenteliu skaicius " + lenteles.size());
			System.out.println("Lent pav " + lenteles.get(y).getLenteles_pav());
			System.out.println("Stulp pav " + lenteles.get(y).getStulpeliu_pav().toString());
			System.out.println("Stulp tip " + lenteles.get(y).getStulpeliu_tipai().toString());
			for( ArrayList<String> duomenu_sar : lenteles.get(y).getLent_duomenys()) {
				
	            System.out.println("Duomenu eilute " + z + " " + duomenu_sar );
	            z += 1;
	        }
		}
	}
	/**
	 * Lenteles getter'is
	 * @return lenteles
	 */
	public ArrayList<LenteleSuDuomenimis> getLenteles() {
		
		return lenteles;
	}
	/**
	 * @param lenteles setter'is
	 */
	public void setLenteles(ArrayList<LenteleSuDuomenimis> lenteles) {
		
		this.lenteles = lenteles;
	}
	/**
	 * Lenteles_be_duomenu getter'is
	 * @return lenteles_be_duomenu
	 */
	public ArrayList<LenteleBeDuomenu> getLenteles_be_duomenu() {
		
		return lenteles_be_duomenu;
	}
	/**
	 * @param lenteles_be_duomenu setter'is
	 */
	public void setLenteles_be_duomenu(ArrayList<LenteleBeDuomenu> lenteles_be_duomenu) {
		
		this.lenteles_be_duomenu = lenteles_be_duomenu;
	}
}
