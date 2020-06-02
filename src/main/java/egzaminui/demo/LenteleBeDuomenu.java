package egzaminui.demo;

import org.springframework.stereotype.Component;
import java.util.*;
/**
 * Failas, skirtas lentelės be duomenų sudarymui pagal perduotus pavadinimus ir tipus
 * 
 * @author Toma
 *
 */
@Component
public class LenteleBeDuomenu {
	/**
	 * Sukuria String tipo kintamąjį lentelės pavadinimui
	 */
	private String lenteles_pav = "";
	/**
	 * Sukuria String sąrašo tipo kintamąjį stulpelių pavadinimams
	 */
	private ArrayList<String> stulpeliu_pav;
	/**
	 * Sukuria String sąrašo tipo kintamąjį stulpelių tipams
	 */
	private ArrayList<String> stulpeliu_tipai;
	/**
	 * Sukuria kiekis_stulpeliu skaičiaus tipo kintamąjį stulpelių kiekiui
	 */
	private int kiekis_stulpeliu = 0;
	/**
	 * Tuščias konstruktorius
	 */
	public LenteleBeDuomenu() {
		
	}
	/**
	 * Konstruktoriui perduodamas lentelės pavadinimas, stulpelių pavadinimai, tipai ir kiekis
	 * @param lenteles_pav kintamasis lentelės pavadinimui
	 * @param stulpeliu_pav String sąrašo tipo kintamasis stulpelių pavadinimams
	 * @param stulpeliu_tipai String sąrašo tipo kintamasis stulpelių tipams
	 * @param kiekis_stulpeliu Integer tipo kintamasis stulpelių kiekiui
	 */
	public LenteleBeDuomenu(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, int kiekis_stulpeliu) {		
		
		this.lenteles_pav = lenteles_pav;
		this.stulpeliu_pav = stulpeliu_pav;
		this.stulpeliu_tipai = stulpeliu_tipai;
		this.kiekis_stulpeliu = kiekis_stulpeliu;
		
	}
	/**
	 * Lenteles_pav getter'is
	 * @return lenteles_pav
	 */
	public String getLenteles_pav() {
		
		return this.lenteles_pav;
	}
	/**
	 * @param lenteles_pav setter'is
	 */
	public void setLenteles_pav(String lenteles_pav) {
		
		this.lenteles_pav = lenteles_pav;
	}
	/**
	 * Stulpeliu_pav getter'is
	 * @return stulpeliu_pav
	 */
	public ArrayList<String> getStulpeliu_pav() {
		
		return this.stulpeliu_pav;
	}
	/**
	 * @param stulpeliu_pav setter'is
	 */
	public void setStulpeliu_pav(ArrayList<String> stulpeliu_pav) {
		
		this.stulpeliu_pav = stulpeliu_pav;
	}
	/**
	 * Stulpeliu_tipai getter'is
	 * @return stulpeliu_tipai
	 */
	public ArrayList<String> getStulpeliu_tipai() {
		return stulpeliu_tipai;
	}
	/**
	 * @param stulpeliu_tipai setter'is
	 */
	public void setStulpeliu_tipai(ArrayList<String> stulpeliu_tipai) {
		this.stulpeliu_tipai = stulpeliu_tipai;
	}
	/**
	 * Kiekis_stulpeliu getter'is
	 * @return kiekis_stulpeliu
	 */
	public int getKiekis_stulpeliu() {
		return kiekis_stulpeliu;
	}
	/**
	 * @param kiekis_stulpeliu setter'is
	 */
	public void setKiekis_stulpeliu(int kiekis_stulpeliu) {
		this.kiekis_stulpeliu = kiekis_stulpeliu;
	}

	/*public void spausdintiLentele() {
		
		System.out.println ( "\n"+ this.lenteles_pav + ": \n");
		
		for(int i = 0; i < this.kiekis_stulpeliu; i++) {
			
			System.out.print("| "+ this.stulpeliu_pav.get(i) + " |");
		}
		for(int i = 0; i < this.kiekis_stulpeliu; i++) {
			
			System.out.print("\n");
			System.out.print("| "+ this.stulpeliu_tipai.get(i) + " |");
		}		

	}*/
}