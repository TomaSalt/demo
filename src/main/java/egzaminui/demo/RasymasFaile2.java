package egzaminui.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class RasymasFaile2 extends RasymasFaile {
	

	public RasymasFaile2(String vardas_failo) {
		
		super();
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
