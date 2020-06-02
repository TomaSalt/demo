package egzaminui.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas sukurti lentelę duomenų bazėje pagal duomenų bazės lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiSqlLentele {
	/**
	 * Sukuria Lentele klasės kintamąjį
	 */
	private LenteleSuDuomenimis lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiSqlLentele() {

	}
	/**
	 * Konstruktoriui perduodami LenteleSuDuomenimis class tipo duomenys
	 * @param lentele LenteleBeDuomenu klasės kintamasis duomenų bazės lentelei
	 */
	public KurtiSqlLentele(LenteleSuDuomenimis lentele) {
		
		this.lentele = lentele;
	}
	/**
	 * String tipo kintamasis SQL uzklausai lenteles duombazeje sudarymui
	 * @return sql_lent
	 */
	public String kurti() {

		String sql_lent = "";
		String data_type = "";
		String kablelis = "";
		String primary_key = " AUTO_INCREMENT PRIMARY KEY";
		sql_lent = "CREATE TABLE `" + this.lentele.getLenteles_pav() + "`(";
		for (int i = 0; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			switch(this.lentele.getStulpeliu_tipai().get(i)) {
				case("String"):
					data_type = "varchar(256)";
					break;
				case("Integer"):
					data_type = "int(10) UNSIGNED";
					break;
				case("Double"):
					data_type = "double UNSIGNED";
					break;
				case("Boolean"):
					data_type = "tinyint(4) None UNSIGNED";
					break;
				default:
					data_type = "text";
			}
			sql_lent += kablelis + " `" + lentele.getStulpeliu_pav().get(i) + "` " + data_type + primary_key;
			primary_key = "";
			kablelis = ",";
		}
		sql_lent += ");";
		return sql_lent;
	}
	/**
	 * String tipo kintamasis SQL uzklausai lenteles duomenu duombazeje papildymui
	 * @return sql_lent
	 */
	public String papildyti() {
		
		String sql_lent = "";
		String kablelis = "";
		sql_lent += "INSERT INTO `" + this.lentele.getLenteles_pav();
		sql_lent += "`(";
		for (int i = 0; i < this.lentele.getStulpeliu_pav().size(); i++) {
			sql_lent += kablelis + " `" + this.lentele.getStulpeliu_pav().get(i) + "`";
			kablelis = ",";
		}
		sql_lent += " )\n";
		sql_lent += "VALUES\n";
		String kablelis2 = "";
		for (int i = 0; i < this.lentele.getDuomenu_eiluciu_skaicius(); i++) {
			kablelis = "";
			sql_lent += kablelis2 + "(";
			for(int z = 0; z < this.lentele.getStulpeliu_pav().size(); z++) {
				sql_lent += kablelis + "'" + this.lentele.getLent_duomenys().get(i).get(z) + "'";
				kablelis = ", ";
			}
			sql_lent += ")";
			kablelis2 = ",\n";
		}
		sql_lent += ";";
		return sql_lent;
	}
}