package egzaminui.demo;

import java.util.ArrayList;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas kuriamo java RepositoryTest failo duomenims įvesti pagal lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiRepositoryTest {
	/**
	 * Sukuria LenteleSuDuomenimis klasės kintamąjį
	 */
	private LenteleSuDuomenimis lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiRepositoryTest() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleSuDuomenimis klasės tipo duomenys
	 */
	public KurtiRepositoryTest(LenteleSuDuomenimis lentele) {
		
		this.lentele = lentele;
		
	}
	/**
	 * Papildomas String sąrašo tipo kintamasis duomenimis
	 * @return java_failui
	 */
	public ArrayList<String> repositoryTest() {
		ArrayList<String> java_failui = new ArrayList<String>();
		java_failui.add("package egzaminui.demo;");
		java_failui.add("");
		java_failui.add("//import static org.junit.Assert.assertEquals;");
		java_failui.add("//import static org.junit.Assert.assertNotNull;");
		java_failui.add("import static org.junit.jupiter.api.Assertions.assertEquals;");
		java_failui.add("import static org.junit.jupiter.api.Assertions.assertNotNull;");
		java_failui.add("");
		java_failui.add("import java.util.List;");
		java_failui.add("import java.util.Optional;");
		java_failui.add("");
		java_failui.add("import org.junit.jupiter.api.Test;");
		java_failui.add("//import org.junit.Test;");
		java_failui.add("//import org.junit.runner.RunWith;");
		java_failui.add("import org.springframework.beans.factory.annotation.Autowired;");
		java_failui.add("");
		java_failui.add("//import org.springframework.test.context.junit4.SpringRunner;");
		java_failui.add("import org.springframework.boot.test.context.SpringBootTest;");
		java_failui.add("");
		java_failui.add("// @RunWith(SpringRunner.class)");
		java_failui.add("@SpringBootTest");
		java_failui.add("");
		java_failui.add("/**");
		java_failui.add(" * Class tipo failas, skirtas " + this.lentele.getLenteles_pav() + " Repository testavimui");
		java_failui.add(" * ");
		java_failui.add(" * @author ");
		java_failui.add(" *");
		java_failui.add(" */");
		java_failui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "RepositoryTest {");
		java_failui.add("");
		java_failui.add("// @DataJpaTest");
		java_failui.add("	@Autowired");
		java_failui.add("/**");
		java_failui.add(" * Sukuria " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "Repository tipo kintamąjį " + this.lentele.getLenteles_pav() + "Repository");
		java_failui.add(" */");
		java_failui.add("	private " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "Repository " + this.lentele.getLenteles_pav() + "Repository;");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas testuoti elemento išsaugojimą");
		java_failui.add("	 */");
		java_failui.add("	@Test");
		java_failui.add("	public void testSaveGet" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "() {");
		java_failui.add("");
		String duomenu_eilute = "";
		String kablelis = "";
		for (int i = 1; i < this.lentele.getKiekis_stulpeliu(); i++) {
			duomenu_eilute += kablelis + this.lentele.getLent_duomenys().get(1).get(i);
			kablelis = ", ";
		}
		java_failui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "(100, " + duomenu_eilute +");");
		java_failui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = " + this.lentele.getLenteles_pav() + "Repository.save(elementas);");
		java_failui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.findBy" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(1)) + "("+ this.lentele.getLent_duomenys().get(1).get(1)+");");
		java_failui.add("		assertNotNull(elementas);");
		java_failui.add("		assertNotNull(el);        ");
		for (int i = 1; i < this.lentele.getKiekis_stulpeliu(); i++) {
			java_failui.add("		assertEquals(el.get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "(), elementas.get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "());");

		}
		java_failui.add("		" + this.lentele.getLenteles_pav() + "Repository.deleteById(element.getId());");															        
		java_failui.add("	}");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas testuoti elementų suradimą");
		java_failui.add("	 */");
		java_failui.add("	@Test");
		java_failui.add("	public void testFindAll" + StringUtils.capitalize(this.lentele.getLenteles_pav())+ "() {");
		java_failui.add("");	
		java_failui.add("		assertNotNull(" + this.lentele.getLenteles_pav() + "Repository.findAll());");
		java_failui.add("	}");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas testuoti elementų ištrynimą pagal pavadinimą");
		java_failui.add("	 */");
		java_failui.add("	@Test");
		java_failui.add("	public void deleteFoundedByName() {");
		java_failui.add("");
		java_failui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( 101, " + duomenu_eilute + ");");
		java_failui.add("	    " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.save( elementas );        ");
		java_failui.add("	    " + this.lentele.getLenteles_pav() + "Repository.delete( el );                  					    // -- pagal pavyzdį neveikia  :(  ");
		java_failui.add("	    " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = " + this.lentele.getLenteles_pav() + "Repository.findBy" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(1)) + "(" + this.lentele.getLent_duomenys().get(1).get(1) + ");");
		java_failui.add("	    assertEquals( element, null );		");
		java_failui.add("	}");
		java_failui.add("	/**");
		java_failui.add("	 * Metodas testuoti elementų ištrynimą pagal id");
		java_failui.add("	 */");
		java_failui.add("	@Test");
		java_failui.add("	public void deleteBy" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "IdTest() {");
		java_failui.add("");
		java_failui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = null;");
		java_failui.add("        " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( 102, " + duomenu_eilute + ");");
		java_failui.add("        " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.save(elementas);");
		java_failui.add("        Integer id_el = el.getId();");
		java_failui.add("        " + this.lentele.getLenteles_pav() + "Repository.deleteById(id_el);");
		java_failui.add("        Optional <" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "> found = " + this.lentele.getLenteles_pav() + "Repository.findById( id_el );");
		java_failui.add("");
		java_failui.add("		if ( found.isPresent() ) {");
		java_failui.add("");
		java_failui.add("			   element = found.get();");
		java_failui.add("		}");
		java_failui.add("        assertEquals( element, null );        ");
		java_failui.add("    }   ");
		java_failui.add("}");
		return java_failui;
	}
}
