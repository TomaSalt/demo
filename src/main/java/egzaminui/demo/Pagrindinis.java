package egzaminui.demo;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Pagrindinis {
	
	/*private String eilute_is_failo;*/
	private SkaitymasIsFailo sf;
	private RasymasFaile rf;
	private String skaitomo_failo_var;
	private String irasomo_failo_var;
	ArrayList<String> nuskaityti_duomenys;
	ArrayList<Lentele> lenteles;
	int lenteliu_skaicius = 0;
	
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
		System.out.println("Nuskaityti duomenys dydis " + nuskaityti_duomenys.size());
		boolean nauja_lentele = false;
	
		for(int i = 0; i < nuskaityti_duomenys.size(); i++) {

			ArrayList<String> zodziai = new ArrayList<>(Arrays.asList(nuskaityti_duomenys.get(i).split(";")));
			//System.out.println("Zodziu sarasas" + zodziai);
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
		System.out.println("Lenteles pavadinimas " + lenteles_pav);
		System.out.println("Stulpeliu pavadinimai " + stulpeliu_pav.toString());
		System.out.println("Kiekis stulpeliu " + kiekis_stulpeliu);
		System.out.println("Tipai " + stulpeliu_tipai.toString());
		System.out.println("Duomenu eiluciu skaicius " + duomenu_eiluciu_skaicius);
		System.out.println("Reiksmes " + lent_duomenys.toString());
		lenteles.add( new Lentele(lenteles_pav, stulpeliu_pav, stulpeliu_tipai, kiekis_stulpeliu, duomenu_eiluciu_skaicius, lent_duomenys) );
	}
	public ArrayList<String> kurtiJavaFaila(Lentele lentele) {
		
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("import javax.persistence.CascadeType;");
		JavaFailui.add("import javax.persistence.Entity;");
		JavaFailui.add("import javax.persistence.GeneratedValue;");
		JavaFailui.add("import javax.persistence.GenerationType;");
		JavaFailui.add("import javax.persistence.Id;");
		JavaFailui.add("import javax.persistence.JoinColumn;");
		JavaFailui.add("import javax.persistence.OneToMany;");
		JavaFailui.add("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("@Entity //iesko duomenu bazeje tokios lenteles");
		JavaFailui.add("public class " + lentele.lenteles_pav + " {}");
		JavaFailui.add("@Id");
		JavaFailui.add("@GeneratedValue(strategy=GenerationType.IDENTITY)");
		
		for (int i = 0; i < lentele.kiekis_stulpeliu; i++ ) {
			
			JavaFailui.add("private " + lentele.stulpeliu_tipai.get(i) + " " + lentele.stulpeliu_pav.get(i) + ";");
			
		}
		JavaFailui.add("@OneToMany(mappedBy=\"" + lentele.lenteles_pav + "\",cascade=CascadeType.ALL)");
		JavaFailui.add("@JsonIgnoreProperties(\"" + lentele.lenteles_pav + "\")");
	
		    private List<Produktai_medziagos> produktai_medziagos;    
		   
			public Produktai(Integer id, String pav, Integer kilme) {
				super();
				this.id = id;
				this.pav = pav;
				this.kilme = kilme;
				
			}
			
			public Produktai() {
				
			}
			/**
			 * @return the pav
			 */
			
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
			/**
			 * @return the pav
			 */
			public String getPav() {
				return pav;
			}

			/**
			 * @param pav the pav to set
			 */
			public void setPav(String pav) {
				this.pav = pav;
			}
			
			public Integer getKilme() {
				return kilme;
			}

			public void setKilme(Integer kilme) {
				this.kilme = kilme;
			}

			public List<Produktai_medziagos> getProduktai_medziagos() {
				
				return produktai_medziagos;
			}
			public void setProduktai_medziagos (List<Produktai_medziagos> produktai_medziagos) {
				
				this.produktai_medziagos = produktai_medziagos;
			}

		}

	}
}
