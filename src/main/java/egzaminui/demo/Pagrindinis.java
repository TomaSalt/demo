package egzaminui.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	public Pagrindinis() {
	}
	
	public Pagrindinis(SkaitymasIsFailo sf, RasymasFaile rf, String skaitomo_failo_var, String irasomo_failo_var) {

		this.rf = rf;
		this.sf = sf;
		
		this.skaitomo_failo_var = skaitomo_failo_var;
		this.irasomo_failo_var = irasomo_failo_var;
	}	
	
	public void Dariti() {
		
		this.sf.setVardas_failo(this.skaitomo_failo_var);
		nuskaityti_duomenys = sf.iMasyva();
		
		this.rf.setVardas_failo(this.irasomo_failo_var);
		this.rf.iEilutes(nuskaityti_duomenys);
	}
	
}
