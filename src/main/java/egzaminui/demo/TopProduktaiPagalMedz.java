package egzaminui.demo;

import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;

public class TopProduktaiPagalMedz {
	
	protected Session em;	
	
	  public TopProduktaiPagalMedz (  Session em  ) {
		  
		    this.em = em;
	  }	
	  String create_database = "CREATE DATABASE [IF NOT EXISTS] demo";
	  Query query = em.createNativeQuery ( create_database );
	  public List<TopProduktai> topProduktai ( Integer id_medziagos, Integer gyvuline, Integer augaline ) {
		  
		  String where_by_kilme = "WHERE "
					+ 	"`produktai_medziagos`.`maistines_medz_id`=" + id_medziagos;
		  int kilme = 0;
		  if (gyvuline == 1 && augaline == 0) {
			  
			  kilme = 1;
			  where_by_kilme += " AND `produktai`.`kilme`= " + kilme;
			  
		  }
		  if (gyvuline == 0 && augaline == 1) {
			   
			  where_by_kilme += " AND `produktai`.`kilme`= " + kilme;
		  }
		  
		  String qw_top_produktai =
		  				
		  		"SELECT SQL_CALC_FOUND_ROWS " 
					+ 	"`produktai`.`id` AS `pat_id` "
					+ 	", `produktai`.`pav` AS `pav` "
					+   ", `produktai_medziagos`.`kiekis`"
					+ 	", `produktai`.`kilme` AS `kilme`"
					+ "FROM "
					+ 		"`produktai_medziagos` "  
					+ "LEFT JOIN "
					+ "		`produktai` ON ( "
					
					+ 			"`produktai`.`id`=`produktai_medziagos`.`produktai_id` "
					+ 		") "
					+ where_by_kilme
					
				+ " ORDER BY"
				+	   " `produktai_medziagos`.`kiekis` DESC "
					;
		  	System.out.println ( qw_top_produktai );
		    Query query = em.createNativeQuery ( qw_top_produktai );
		    return (List<TopProduktai>) query.getResultList();
	  }	  

}
