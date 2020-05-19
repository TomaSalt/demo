package egzaminui.demo;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
public class KurtiDuombaze {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static String DB_URL = "jdbc:mysql://localhost:3306/";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	private String database_name;
	ArrayList<LenteleSuDuomenimis> lenteles;
   
	public KurtiDuombaze(String name, ArrayList<LenteleSuDuomenimis> lenteles) {
	   
		this.database_name = name;
		this.lenteles = lenteles;
	}
   
	public void Kurti() {
		
		Connection conn = null;
		Statement stmt = null;
		String sql_lent = "";
	   
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			//STEP 4: Execute a query
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
		}//end finally try

		DB_URL = "jdbc:mysql://localhost:3306/" + database_name;
		try{
			//STEP 5: Open a connection
			System.out.println("Connecting to database " + database_name + "...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
			//STEP 6: Execute queries
			stmt = conn.createStatement();
			for (int i = 0; i < lenteles.size(); i++) {
				System.out.println("Creating table...");
				KurtiSqlLentele sql_lentele = new KurtiSqlLentele(lenteles.get(i));
				//sql_lent = "USE " + database_name + ";\n";
				sql_lent = sql_lentele.Kurti();
				System.out.println(sql_lent);
				stmt.executeUpdate(sql_lent);
				System.out.println("Table created successfully...\n");
				
				sql_lent = sql_lentele.Papildyti();
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
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end Kurti()
}//end KurtiDuombaze
