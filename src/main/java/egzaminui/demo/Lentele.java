package egzaminui.demo;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Lentele {
	
	
	private String lenteles_pav = "";
	private ArrayList<String> stulpeliu_pav;
	private ArrayList<String> stulpeliu_tipai;
	private int kiekis_stulpeliu = 0;
	private int duomenu_eiluciu_skaicius = 0;
	private ArrayList<ArrayList<String>> lent_duomenys;
	
		
	public Lentele() {
		
	}
	
	public Lentele(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, int kiekis_stulpeliu, int duomenu_eiluciu_skaicius, ArrayList<ArrayList<String>> lent_duomenys) {

		
		this.lenteles_pav = lenteles_pav;
		this.stulpeliu_pav = stulpeliu_pav;
		this.stulpeliu_tipai = stulpeliu_tipai;
		this.kiekis_stulpeliu = kiekis_stulpeliu;
		this.duomenu_eiluciu_skaicius = duomenu_eiluciu_skaicius;
		this.lent_duomenys = lent_duomenys;
		
	}	
	
	public void spausdintiLentele() {
		
		System.out.println ( "\n"+ this.lenteles_pav + ": \n");
		
		for(int i = 0; i < this.kiekis_stulpeliu; i++) {
			
			System.out.print("| "+ this.stulpeliu_pav.get(i) + " |");
		}
		for(int i = 0; i < this.kiekis_stulpeliu; i++) {
			
			System.out.print("\n");
			System.out.print("| "+ this.stulpeliu_tipai.get(i) + " |");
		}		
		
		for(int y = 0; y < this.duomenu_eiluciu_skaicius; y++) {
			
			System.out.print("\n");
			
			for(int z = 0; z < this.kiekis_stulpeliu; z++) {
			
				System.out.print("| "+ this.lent_duomenys.get(y).get(z) + " |");
			}
			
		}

	}
}