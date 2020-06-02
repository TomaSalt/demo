package egzaminui.demo;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Failas, skirtas lentelių sudarymui pagal duomenis iš nuskaityto failo
 * 
 * @author Toma
 *
 */
public class SudarytiLenteles {
	/**
	 * Sukuria sąrašo tipo kintamąjį duomenims
	 */
	private ArrayList<String> duomenys;
	/**
	 * Sukuria skaičiaus tipo kintamąjį lentelių skaičiui
	 */	
	private Integer lenteliu_skaicius;
	/**
	 * Sukuria LenteleSuDuomenimis klasės sąrašo tipo kintamąjį lentelėms su duomenimis
	 */	
	private ArrayList<LenteleSuDuomenimis> lenteles_su_duomenimis = new ArrayList<LenteleSuDuomenimis>();
	/**
	 * Sukuria LenteleBeDuomenu klasės sąrašo tipo kintamąjį lentelėms be duomenų
	 */	
	private ArrayList<LenteleBeDuomenu> lenteles_be_duomenu = new ArrayList<LenteleBeDuomenu>();
	/**
	 * Tuščias konstruktorius
	 */
	public SudarytiLenteles() {
		
	}
	/**
	 * Konstruktoriui perduodami sąrašo tipo duomenys
	 * @param duomenys String sąrašo tipo kintamasis duomenims
	 */
	public SudarytiLenteles(ArrayList<String> duomenys) {
		
		this.duomenys = duomenys;
	}
	/**
	 * LenteleSuDuomenimis klasės tipo lentelė su duomenimis duombazei
	 * @return lentele
	 */
	private LenteleSuDuomenimis vienaLentele(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, Integer kiekis_stulpeliu, Integer duomenu_eiluciu_skaicius, ArrayList<ArrayList<String>> lent_duomenys) {
		
		LenteleSuDuomenimis lentele = new LenteleSuDuomenimis(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys);
		return lentele;
	}
	/**
	 * LenteleBeDuomenu klasės tipo lentelė be duomenų duombazei
	 * @return lentele
	 */
	private LenteleBeDuomenu vienaLentele(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, Integer kiekis_stulpeliu) {
		
		LenteleBeDuomenu lentele = new LenteleBeDuomenu(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu);
		return lentele;
	}
	/**
	 * Lenteliu_skaicius getter'is
	 * @return lenteliu_skaicius
	 */
	public Integer getLenteliu_skaicius() {
		
		return lenteliu_skaicius;
	}
	/**
	 * @param lenteliu_skaicius setter'is
	 */
	public void setLenteliu_skaicius(Integer lenteliu_skaicius) {
		
		this.lenteliu_skaicius = lenteliu_skaicius;
	}
	/**
	 * Lenteles_su_duomenimis getter'is
	 * @return lenteles_su_duomenimis
	 */
	public ArrayList<LenteleSuDuomenimis> getLenteles_su_duomenimis() {
		
		return lenteles_su_duomenimis;
	}
	/**
	 * @param lenteles_su_duomenimis setter'is
	 */
	public void setLenteles_su_duomenimis(ArrayList<LenteleSuDuomenimis> lenteles_su_duomenimis) {
		
		this.lenteles_su_duomenimis = lenteles_su_duomenimis;
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
	/**
	 * Metodas lentelių sudarymui
	 */
	public void visosLenteles() {
	
		lenteliu_skaicius = 0;
		String lenteles_pav = "";
		ArrayList<String> stulpeliu_pav= new ArrayList<String>();
		ArrayList<String> stulpeliu_tipai= new ArrayList<String>();
		Integer kiekis_stulpeliu = 0;
		Integer duomenu_eiluciu_skaicius = 0;
		ArrayList<ArrayList<String>> lent_duomenys = new ArrayList<ArrayList<String>>();
		boolean nauja_lentele = false;
		
		System.out.println("Nuskaityta duomenu eiluciu " + duomenys.size());
		for(int i = 0; i < duomenys.size(); i++){

			ArrayList<String> zodziai = new ArrayList<>(Arrays.asList(duomenys.get(i).split(";")));
			//System.out.println("Zodziu sarasas" + zodziai);
			if( zodziai.get(0).equals( "Values" )) {
				
				duomenu_eiluciu_skaicius += 1;
				lent_duomenys.add(new ArrayList<String>());
			}
			
			if( zodziai.get(0).equals( "Table" )){
				
				if( nauja_lentele && ( duomenu_eiluciu_skaicius != 0 )) {
					
					lenteles_su_duomenimis.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys) );
					lenteles_be_duomenu.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu) );
				}
				if( nauja_lentele && ( duomenu_eiluciu_skaicius == 0 )) {
					
					lenteles_be_duomenu.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu) );
				}
				lenteliu_skaicius += 1;
				lenteles_pav = "";
				stulpeliu_pav = new ArrayList<String>();
				stulpeliu_tipai = new ArrayList<String>();
				kiekis_stulpeliu = 0;
				duomenu_eiluciu_skaicius = 0;
				lent_duomenys = new ArrayList<ArrayList<String>>();
				nauja_lentele = true;
			}
	
			for (int y = 1; y < zodziai.size(); y++ ){
				
				String zodis_1 = zodziai.get(0);
				switch (zodis_1) {
				
					case "Table": 
						lenteles_pav = zodziai.get(1);
						break;
					case "Header":
						stulpeliu_pav.add(zodziai.get(y));
						kiekis_stulpeliu += 1; 
						break;
					case "Type":
						stulpeliu_tipai.add(zodziai.get(y));
						break;
					case "Values":
						lent_duomenys.get(duomenu_eiluciu_skaicius-1).add(zodziai.get(y));
						break;
				}
			}
		}
		/*System.out.println("Lenteles pavadinimas " + lenteles_pav);
		System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
		System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
		System.out.println("Tipai " + stulpeliu_tipai.toString());
		System.out.println("Duomenu eiluciu skaicius " + duomenu_eiluciu_skaicius);
		System.out.println("Reiksmes " + lent_duomenys.toString());*/
		if(duomenu_eiluciu_skaicius != 0) {
			
			lenteles_su_duomenimis.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys));
			lenteles_be_duomenu.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu));
			
		} else {
			
			lenteles_be_duomenu.add( vienaLentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu));
		}
	}
}
