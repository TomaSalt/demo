package duomenys.mitybai;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
																						// import org.springframework.boot.test.autoconfigure.orm.jpa.*; - nereikia iš pvz. !

//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;



// @RunWith(SpringRunner.class)
@SpringBootTest

public class ProduktaiRepositoryTest {

// @DataJpaTest											         - nereikia iš pvz. !
	@Autowired
	private ProduktaiRepository produktaiRepository;
	   
	@Test
	public void testSaveGetProduktai() {
	        																			     // System.out.println (" starting here test ! ");    	
		Produktai produktas = new Produktai(100, "saulegrazos", 1);
		Produktai produkt = produktaiRepository.save(produktas);
		Produktai prod = produktaiRepository.findByPav("saulegrazos");
	        											
		assertNotNull(produktas);
		        																			     // System.out.println (" kt2 ! ");        
		assertNotNull(prod);        
		        																			     // System.out.println (" kt3 ! ");        
		assertEquals(prod.getPav(), produktas.getPav());
		        																				 // System.out.println (" kt4 ! ");   
		        																				 // -- neveiks kt4 nespaudina .. 
		assertEquals(prod.getKilme(), produktas.getKilme());
		        																				 // System.out.println (" kt5 ! ");      
		        
		produktaiRepository.deleteById(produkt.getId());				  
	        																		         // System.out.println (" ending here test ! ");
	}
	    
	@Test   
	public void testFindAllProduktai() {
		assertNotNull(produktaiRepository.findAll());
	}
	    
	@Test    
	public void deleteFoundedByName() {
	        																			// System.out.println (" kt6 ! ");       
		Produktai produktas = new Produktai( 101, "sezamai", 0 ); 
	    Produktai prod = produktaiRepository.save( produktas );        
	    produktaiRepository.delete( prod );                  					    // -- pagal pavyzdį neveikia  :(  
	    Produktai produkt = produktaiRepository.findByPav("sezamai");
	    assertEquals( produkt, null );		
	}    

	@Test
	public void deletByProduktaiIdTest() {
	    	
		Produktai produkt = null;
        Produktai produktas = new Produktai( 102, "moliugu_seklos", 0 );    	
        Produktai prod = produktaiRepository.save(produktas);
        Integer id_prod = prod.getId();
        produktaiRepository.deleteById(id_prod);
        Optional <Produktai> found = produktaiRepository.findById( id_prod );
        
		if ( found.isPresent() ) {
			
			   produkt = found.get();
		}
        assertEquals( produkt, null );        
    }   
}
