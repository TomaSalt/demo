package egzaminui.demo;

/**
 * @author
 * by https://www.mkyong.com/java/java-enum-example/
 * by https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 * by https://www.geeksforgeeks.org/enum-in-java/
 */
public enum Menu {

	Produktai("/produktai", "Produktai")
	, Maistines_medz("/maistines_medz", "Maistinės medžiagos")
	, Maisto_medz_grupes("/maisto_medz_grupes", "Maisto medžiagų grupės")
	, Produktai_medziagos("/produktai_medziagos", "Produkto medžiagų kiekis")
	, Paieska("/paieska", "Paieška");
	
	private final String itemurl;
	private final String naujasPavadinimas;
	
	Menu( String url, String pavadinimas ) {
		this.itemurl = url;
		this.naujasPavadinimas = pavadinimas;
	}
	
	public String itemurl() {
		return this.itemurl;
	}
	public String naujasPavadinimas() {
		return this.naujasPavadinimas;
	}
}