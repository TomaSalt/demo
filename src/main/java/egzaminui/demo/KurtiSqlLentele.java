package egzaminui.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas sukurti lentele duomenu bazeje, įvesti pagal lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiSqlLentele {

	/**
	 * Sukuria Lentele klasės kintamąjį
	 */
	private Lentele lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiSqlLentele() {

	}
	/**
	 * Konstruktoriui perduodami Lentele class tipo duomenys
	 */
	public KurtiSqlLentele(Lentele lentele) {
		
		this.lentele = lentele;
	}
	/**
	 * metodas ivykdyti sql uzklausa ir sudaryti lentele duombazeje
	 */
	public String Vykdyti() {

		String sql_lent = "";
		String data_type = "";
		String kablelis = "";
		String primary_key = " PRIMARY KEY";
		sql_lent = "CREATE TABLE demo." + this.lentele.getLenteles_pav() + "(";
		for (int i = 0; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			switch(this.lentele.getStulpeliu_tipai().get(i)) {
				case("String"):
					data_type = "varchar(256)";
					break;
				case("Integer"):
					data_type = "int(10)";
					break;
				case("Double"):
					data_type = "double";
					break;
				case("Boolean"):
					data_type = "tinyint(4)";
					break;
				default:
					data_type = "text";
			}
			sql_lent += kablelis + " " + lentele.getStulpeliu_pav().get(i) + " " + data_type + primary_key;
			primary_key = "";
			kablelis = ",";
		}
		sql_lent += ");";
		System.out.println ( sql_lent );
		return sql_lent;
	}//end Vykdyti()
}
