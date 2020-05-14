package egzaminui.demo;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import org.springframework.util.StringUtils;

/**
 * Failas, skirtas sukurti lentele duomenu bazeje, įvesti pagal lentelės duomenis
 * 
 * @author Toma
 *
 */

public class KurtiSqlUzklausoms {
	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";

	/**
	 * Sukuria Lentele klasės kintamąjį
	 */
	private Lentele lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiSqlUzklausoms() {

	}
	/**
	 * Konstruktoriui perduodami Lentele class tipo duomenys
	 */
	public KurtiSqlUzklausoms(Lentele lentele) {
		
		this.lentele = lentele;
	}
	/**
	 * metodas ivykdyti sql uzklausa ir sudaryti lentele duombazeje
	 */
	public void SlqLentelei() {
	
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("import javax.persistence.*;");
		JavaFailui.add("import org.hibernate.Session;");
		JavaFailui.add("");
		JavaFailui.add("public class SqlUzklausoms {");
		JavaFailui.add("	");
		JavaFailui.add("	protected Session em;	");
		JavaFailui.add("	");
		JavaFailui.add("	  public TopProduktaiPagalMedz (  Session em  ) {");
		JavaFailui.add("		  ");
		JavaFailui.add("		    this.em = em;");
		JavaFailui.add("	  }	");
		JavaFailui.add("	  ");
		JavaFailui.add("	  public void SqlLentele ( Lentele lentele ) {");
		JavaFailui.add("		  ");
		JavaFailui.add("		  String sql_lent =");
		JavaFailui.add("		  				");
		JavaFailui.add("		  		CREATE TABLE " + lentele.getLenteles_pav() + "(");
		for (int i = 0; i < lentele.getStulpeliu_pav().size(); i++) {
			String kablelis = "";
			switch(lentele.getStulpeliu_tipai().get(i)) {
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
			JavaFailui.add("					+	" + kablelis + " " + lentele.getStulpeliu_pav().get(i) + " " + data_type);
		}
			JavaFailui.add("
		JavaFailui.add("		  	System.out.println ( qw_top_produktai );");
		JavaFailui.add("		    Query query = em.createNativeQuery ( qw_top_produktai );");
		JavaFailui.add("		    return (List<TopProduktai>) query.getResultList();");
		JavaFailui.add("	  }	  ");
		JavaFailui.add("");
		JavaFailui.add("}");
