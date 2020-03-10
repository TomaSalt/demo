package egzaminui.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Pagrindinis {
	
	/*private String eilute_is_failo;
	private int kiekis_lenteliu = 0; */
	private SkaitymasIsFailo sf;
	private RasymasFaile rf;
	private String skaitomo_failo_var;
	private String irasomo_failo_var;
	ArrayList<String> nuskaityti_duomenys;
	ArrayList<Lentele> lenteles;
	
	public Pagrindinis() {
	}
	
	public Pagrindinis(SkaitymasIsFailo sf, RasymasFaile rf, String skaitomo_failo_var, String irasomo_failo_var) {

		this.rf = rf;
		this.sf = sf;
		
		this.skaitomo_failo_var = skaitomo_failo_var;
		this.irasomo_failo_var = irasomo_failo_var;
	}	
	
	public void Daryti() {
		
		this.sf.setVardas_failo(this.skaitomo_failo_var);
		nuskaityti_duomenys = sf.iMasyva();
		
		this.rf.setVardas_failo(this.irasomo_failo_var);
		this.rf.iEilutes(nuskaityti_duomenys);
	}
	
	public void ILentele() {
		
		Integer lenteliu_skaicius = 0;
		String lenteles_pav = "";
		ArrayList<String> stulpeliu_pav;
		ArrayList<String> stulpeliu_tipai;
		int kiekis_stulpeliu = 0;
		int duomenu_eiluciu_skaicius = 0;
		ArrayList<ArrayList<String>> lent_duomenys;

		stulpeliu_pav = new ArrayList<String>();
		stulpeliu_tipai = new ArrayList<String>();	
		lent_duomenys = new ArrayList<ArrayList<String>>();		
		System.out.println("Nuskaityti duomenys dydis " + nuskaityti_duomenys.size());
		boolean nauja_lentele = false;
	
		for(int i = 0; i < nuskaityti_duomenys.size(); i++) {
			//System.out.println((nuskaityti_duomenys.get(i)).toString());
			ArrayList<String> zodziai = new ArrayList<>(Arrays.asList(nuskaityti_duomenys.get(i).split(";")));
			System.out.println("Zodziu sarasas" + zodziai);
			if( zodziai.get(0).equals( "Values" )) {
				
				duomenu_eiluciu_skaicius += 1;
				lent_duomenys.add(new ArrayList<String>());
				
			}
						
			if( zodziai.get(0).equals( "Table" )) {
				
				if(nauja_lentele) {
					System.out.println("Lenteles pavadinimas " + lenteles_pav);
					System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
					System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
					System.out.println("Tipai " + stulpeliu_tipai.toString());
					System.out.println("Duomenu eiluciu skaicius " + duomenu_eiluciu_skaicius);
					System.out.println("Reiksmes " + lent_duomenys.toString());
					lenteles.add( new Lentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys) );
				}
				
				lenteliu_skaicius += 1;
				lenteles_pav = "";
				stulpeliu_pav = new ArrayList<String>();
				stulpeliu_tipai = new ArrayList<String>();
				kiekis_stulpeliu = 0;
				duomenu_eiluciu_skaicius = 0;
				lent_duomenys = new ArrayList<ArrayList<String>>();
				lenteles = new ArrayList<Lentele>();
				nauja_lentele = true;
			}
	
			for (int y = 1; y < zodziai.size(); y++ ) {
				
				String zodis_1 = zodziai.get(0);
				//System.out.println("Zodis1 " + zodis_1);
				
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
					//	System.out.println("Value reiksmes " + zodziai.get(y));
						lent_duomenys.get(duomenu_eiluciu_skaicius-1).add(zodziai.get(y));
						break;
				}
			}
			

		}
		System.out.println("Lenteles pavadinimas " + lenteles_pav);
		System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
		System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
		System.out.println("Tipai " + stulpeliu_tipai.toString());
		System.out.println("Duomenu eiluciu skaicius " + duomenu_eiluciu_skaicius);
		System.out.println("Reiksmes " + lent_duomenys.toString());
		lenteles.add( new Lentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys) );
	}
}
