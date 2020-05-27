package egzaminui.demo;

import java.sql.*;
import java.util.ArrayList;
/**
 * Failas, skirtas kurti duombazei pagal lentelių duomenis
 * 
 * @author Toma
 *
 */
public class KurtiDuombaze {
	/**
	 * Sukuria String tipo kintamąjį nurodyti driver
	 */
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	/**
	 * Sukuria String tipo kintamąjį nurodyti duombazės adresą
	 */
	static String DB_URL = "jdbc:mysql://localhost:3306/";
	/**
	 * Sukuria String tipo kintamąjį nurodyti vartotoją
	 */
	static final String USER = "root";
	/**
	 * Sukuria String tipo kintamąjį nurodyti slaptažodį
	 */
	static final String PASS = "";
	/**
	 * Sukuria String tipo kintamąjį nurodyti duombazės vardą
	 */
	private String database_name;	
	/**
	 * Sukuria LenteleSuDuomenimis klasės sąrašo tipo kintamąjį lentelių duomenims
	 */
	ArrayList<LenteleSuDuomenimis> lenteles;
	/**
	 * Konstruktoriui perduodamas duombazės pavadinimas ir LenteleSuDuomenimis klasės sąrašo tipo duomenys, reikalingi kurti duombazę
	 */
	public KurtiDuombaze(String name, ArrayList<LenteleSuDuomenimis> lenteles) {
	   
		this.database_name = name;
		this.lenteles = lenteles;
	}
	/**
	 * Metodas sukurti ryšį su duombaze ir sukurti duombazę
	 */
	public void kurti() {
		
		Connection conn = null;
		Statement stmt = null;
		String sql_lent = "";
	   
		try{
			//STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			//STEP 3: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();
	      
			String sql_database = "CREATE DATABASE " + database_name;
			//String sql_database = "DROP DATABASE " + database_name;
			stmt.executeUpdate(sql_database);
			System.out.println("Database created successfully...\n");

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
			}
		}

		DB_URL = "jdbc:mysql://localhost:3306/" + database_name;
		try{
			// STEP 4: Open a connection
			System.out.println("Connecting to database " + database_name + "...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
			//STEP 5: Execute queries
			stmt = conn.createStatement();
			for (int i = 0; i < lenteles.size(); i++) {
				System.out.println("Creating table...");
				KurtiSqlLentele sql_lentele = new KurtiSqlLentele(lenteles.get(i));
				//sql_lent = "USE " + database_name + ";\n";
				sql_lent = sql_lentele.kurti();
				System.out.println(sql_lent);
				stmt.executeUpdate(sql_lent);
				System.out.println("Table created successfully...\n");
				
				sql_lent = sql_lentele.papildyti();
				System.out.println(sql_lent);
				stmt.executeUpdate(sql_lent);
				System.out.println("Table updated successfully...\n");
			}
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
			}
		}
		System.out.println("Goodbye!");
	}
	public void trinti() {
		Connection conn = null;
		Statement stmt = null;
		String sql_lent = "";
	   
		try{
			//STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			//STEP 3: Execute a query
			System.out.println("Deleting database...");
			stmt = conn.createStatement();
	      
			String sql_database = "DROP DATABASE " + database_name;
			stmt.executeUpdate(sql_database);
			System.out.println("Database deleted successfully...\n");

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
			}
		}

	}
}
