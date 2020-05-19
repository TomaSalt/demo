package egzaminui.demo;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LenteleSuDuomenimis extends LenteleBeDuomenu{
	
	private int duomenu_eiluciu_skaicius = 0;
	private ArrayList<ArrayList<String>> lent_duomenys;
	
		
	public LenteleSuDuomenimis() {
		
	}
	
	public LenteleSuDuomenimis(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, int kiekis_stulpeliu, int duomenu_eiluciu_skaicius, ArrayList<ArrayList<String>> lent_duomenys) {		
		
		super(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu);
		this.duomenu_eiluciu_skaicius = duomenu_eiluciu_skaicius;
		this.lent_duomenys = lent_duomenys;
		
	}

	public int getDuomenu_eiluciu_skaicius() {
		return duomenu_eiluciu_skaicius;
	}

	public void setDuomenu_eiluciu_skaicius(int duomenu_eiluciu_skaicius) {
		this.duomenu_eiluciu_skaicius = duomenu_eiluciu_skaicius;
	}

	public ArrayList<ArrayList<String>> getLent_duomenys() {
		return lent_duomenys;
	}

	public void setLent_duomenys(ArrayList<ArrayList<String>> lent_duomenys) {
		this.lent_duomenys = lent_duomenys;
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
		
		for(int y = 0; y < this.duomenu_eiluciu_skaicius; y++) {
			
			System.out.print("\n");
			
			for(int z = 0; z < this.kiekis_stulpeliu; z++) {
			
				System.out.print("| "+ this.lent_duomenys.get(y).get(z) + " |");
			}
			
		}

	}*/
}