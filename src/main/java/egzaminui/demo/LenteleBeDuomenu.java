package egzaminui.demo;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LenteleBeDuomenu {
	
	private String lenteles_pav = "";
	private ArrayList<String> stulpeliu_pav;
	private ArrayList<String> stulpeliu_tipai;
	private int kiekis_stulpeliu = 0;

	public LenteleBeDuomenu() {
		
	}
	
	public LenteleBeDuomenu(String lenteles_pav, ArrayList<String> stulpeliu_pav, ArrayList<String> stulpeliu_tipai, int kiekis_stulpeliu) {		
		
		this.lenteles_pav = lenteles_pav;
		this.stulpeliu_pav = stulpeliu_pav;
		this.stulpeliu_tipai = stulpeliu_tipai;
		this.kiekis_stulpeliu = kiekis_stulpeliu;
		
	}

	public String getLenteles_pav() {
		return lenteles_pav;
	}

	public void setLenteles_pav(String lenteles_pav) {
		this.lenteles_pav = lenteles_pav;
	}

	public ArrayList<String> getStulpeliu_pav() {
		return stulpeliu_pav;
	}

	public void setStulpeliu_pav(ArrayList<String> stulpeliu_pav) {
		this.stulpeliu_pav = stulpeliu_pav;
	}

	public ArrayList<String> getStulpeliu_tipai() {
		return stulpeliu_tipai;
	}

	public void setStulpeliu_tipai(ArrayList<String> stulpeliu_tipai) {
		this.stulpeliu_tipai = stulpeliu_tipai;
	}

	public int getKiekis_stulpeliu() {
		return kiekis_stulpeliu;
	}

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