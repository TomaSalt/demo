package egzaminui.demo;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Pagrindinis{
	
	/*private String eilute_is_failo;*/
	private SkaitymasIsFailo sf;
	private RasymasFaile rf;
	private String skaitomo_failo_var;
	private String irasomo_failo_var;
	ArrayList<String> nuskaityti_duomenys;
	ArrayList<LenteleSuDuomenimis> lenteles;
	LenteleBeDuomenu lentele;
	int lenteliu_skaicius = 0;
	
	public Pagrindinis(){
	}
	
	public Pagrindinis(SkaitymasIsFailo sf, RasymasFaile rf, String skaitomo_failo_var, String irasomo_failo_var){

		this.rf = rf;
		this.sf = sf;
		
		this.skaitomo_failo_var = skaitomo_failo_var;
		this.irasomo_failo_var = irasomo_failo_var;
	}	
	
	public void SkaitytiIsFailo(){
		
		this.sf.setVardas_failo(this.skaitomo_failo_var);
		nuskaityti_duomenys = sf.iMasyva();
			
	}
	
	public void IrasytiIFaila(){
		
		this.rf.setVardas_failo(this.irasomo_failo_var);
		this.rf.iEilutes(nuskaityti_duomenys);
	}
	
	public String getSkaitomo_failo_var() {
		return skaitomo_failo_var;
	}

	public void setSkaitomo_failo_var(String skaitomo_failo_var) {
		this.skaitomo_failo_var = skaitomo_failo_var;
	}

	public String getIrasomo_failo_var() {
		return irasomo_failo_var;
	}

	public void setIrasomo_failo_var(String irasomo_failo_var) {
		this.irasomo_failo_var = irasomo_failo_var;
	}

	public void SudarytiLenteles(){
		
		lenteles = new ArrayList<LenteleSuDuomenimis>();
		lenteliu_skaicius = 0;
		String lenteles_pav = "";
		ArrayList<String> stulpeliu_pav;
		ArrayList<String> stulpeliu_tipai;
		int kiekis_stulpeliu = 0;
		int duomenu_eiluciu_skaicius = 0;
		ArrayList<ArrayList<String>> lent_duomenys;

		stulpeliu_pav = new ArrayList<String>();
		stulpeliu_tipai = new ArrayList<String>();	
		lent_duomenys = new ArrayList<ArrayList<String>>();	
		System.out.println("Nuskaityta duomenu eiluciu " + nuskaityti_duomenys.size());
		boolean nauja_lentele = false;
	
		for(int i = 0; i < nuskaityti_duomenys.size(); i++){

			ArrayList<String> zodziai = new ArrayList<>(Arrays.asList(nuskaityti_duomenys.get(i).split(";")));
			//System.out.println("Zodziu sarasas" + zodziai);
			if( zodziai.get(0).equals( "Values" )) {
				
				duomenu_eiluciu_skaicius += 1;
				lent_duomenys.add(new ArrayList<String>());
				
			}
						
			if( zodziai.get(0).equals( "Table" )){
				
				if(nauja_lentele) {
					/*System.out.println("Lenteles pavadinimas " + lenteles_pav);
					System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
					System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
					System.out.println("Tipai " + stulpeliu_tipai.toString());
					System.out.println("Duomenu eiluciu skaicius " + duomenu_eiluciu_skaicius);
					System.out.println("Reiksmes " + lent_duomenys.toString());*/
					lenteles.add( new LenteleSuDuomenimis(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys) );
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
		lenteles.add( new LenteleSuDuomenimis(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys));
	}
	public void SudarytiAtaskaitosLentele(){
		
		lentele = new LenteleBeDuomenu();
		String lenteles_pav = "";
		ArrayList<String> stulpeliu_pav;
		ArrayList<String> stulpeliu_tipai;
		int kiekis_stulpeliu = 0;

		stulpeliu_pav = new ArrayList<String>();
		stulpeliu_tipai = new ArrayList<String>();
		System.out.println("Nuskaityta duomenu eiluciu " + nuskaityti_duomenys.size());
	
		for(int i = 0; i < nuskaityti_duomenys.size(); i++){

			ArrayList<String> zodziai = new ArrayList<>(Arrays.asList(nuskaityti_duomenys.get(i).split(";")));
			//System.out.println("Zodziu sarasas" + zodziai);
	
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
				}
			}
		}
		System.out.println("Lenteles pavadinimas " + lenteles_pav);
		System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
		System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
		System.out.println("Tipai " + stulpeliu_tipai.toString());
		lentele = new LenteleBeDuomenu(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu);
	}
	public void IsvestiLentelesIKonsole(){
	
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

	public ArrayList<LenteleSuDuomenimis> getLenteles() {
		return lenteles;
	}

	public void setLenteles(ArrayList<LenteleSuDuomenimis> lenteles) {
		this.lenteles = lenteles;
	}

	public LenteleBeDuomenu getLentele() {
		return lentele;
	}

	public void setLentele(LenteleBeDuomenu lentele) {
		this.lentele = lentele;
	}
	
}
