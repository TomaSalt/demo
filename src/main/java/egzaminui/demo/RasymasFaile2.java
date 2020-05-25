package egzaminui.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * Class tipo failas, skirtas duomenų įrašymui į failą su pagalbiniais priedais, kuris paveldi RasymasFaile
 * 
 * @author Toma
 *
 */
public class RasymasFaile2 extends RasymasFaile {
	/**
	 * Konstruktoriui perduodamas failo vardas
	 */
	public RasymasFaile2(String vardas_failo) {
		
		super(vardas_failo);
	}
	/**
	 * Metodas įrašymui į failą po eilutę su papildomu pagalbiniu tekstu
	 */
	public void iEilutes ( ArrayList<String> zodziai ) {
		
		try  {
			
			BufferedWriter bw = new BufferedWriter( new FileWriter( vardas_failo ) );

			for ( String value : zodziai ) { 
						
				bw.write ("java_failui.add(\"" + value + "\");\n");
			}
			bw.close();
					
		} catch ( Exception e ) {
				
				System.err.format ( "IOException: %s%n", e );
		}		
	}	
}
