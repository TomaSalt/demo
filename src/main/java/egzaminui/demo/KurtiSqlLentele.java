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
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
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
	public void Vykdyti() {
		Connection conn = null;
		Statement stmt = null;
		String sql_lent = "";
		String data_type = "";
		String kablelis = "";
		String primary_key = " PRIMARY KEY";
		sql_lent = "CREATE TABLE " + this.lentele.getLenteles_pav() + "(";
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
		try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	      //STEP 4: Execute a query
	      System.out.println("Creating table...");
	      stmt = conn.createStatement();
	      
	      stmt.executeUpdate(sql_lent);
	      
	      System.out.println("Table created successfully...");
	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end Vykdyti()
}
