package egzaminui.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class RasymasFaile2 {

	
	public String vardas_failo;
	
	public RasymasFaile2() {
		
	}
	
	public RasymasFaile2( String vardas_failo ) {
		
		this.vardas_failo = vardas_failo;
	}
	
	public void setVardas_failo( String vardas_failo ) {
		
		this.vardas_failo = vardas_failo;
	}	

	public void iEilutes ( ArrayList<String> zodziai ) {
		
		try  {
			
			BufferedWriter bw = new BufferedWriter( new FileWriter( vardas_failo ) );

			for ( String value : zodziai ) { 
						
				bw.write ("JavaFailui.add(\"" + value + "\");\n");
			}
			bw.close();
					
		} catch ( Exception e ) {
				
				System.err.format ( "IOException: %s%n", e );
		}		
	}	
}