package egzaminui.demo;
import java.util.ArrayList;
import org.springframework.util.StringUtils;
public class KurtiRepositoryTest {
	
	private LenteleSuDuomenimis lentele;
	
	public KurtiRepositoryTest() {
	
	}
	public KurtiRepositoryTest(LenteleSuDuomenimis lentele) {
		
		this.lentele = lentele;
		
	}
	
	public ArrayList<String> RepositoryTest() {
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("");
		JavaFailui.add("//import static org.junit.Assert.assertEquals;");
		JavaFailui.add("//import static org.junit.Assert.assertNotNull;");
		JavaFailui.add("import static org.junit.jupiter.api.Assertions.assertEquals;");
		JavaFailui.add("import static org.junit.jupiter.api.Assertions.assertNotNull;");
		JavaFailui.add("");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("import java.util.Optional;");
		JavaFailui.add("");
		JavaFailui.add("import org.junit.jupiter.api.Test;");
		JavaFailui.add("//import org.junit.Test;");
		JavaFailui.add("//import org.junit.runner.RunWith;");
		JavaFailui.add("import org.springframework.beans.factory.annotation.Autowired;");
		JavaFailui.add("");
		JavaFailui.add("//import org.springframework.test.context.junit4.SpringRunner;");
		JavaFailui.add("import org.springframework.boot.test.context.SpringBootTest;");
		JavaFailui.add("");
		JavaFailui.add("// @RunWith(SpringRunner.class)");
		JavaFailui.add("@SpringBootTest");
		JavaFailui.add("");
		JavaFailui.add("public class " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "RepositoryTest {");
		JavaFailui.add("");
		JavaFailui.add("// @DataJpaTest");
		JavaFailui.add("	@Autowired");
		JavaFailui.add("	private " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "Repository " + this.lentele.getLenteles_pav() + "Repository;");
		JavaFailui.add("");
		JavaFailui.add("	@Test");
		JavaFailui.add("	public void testSaveGet" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "() {");
		JavaFailui.add("");
		String duomenu_eilute = "";
		String kablelis = "";
		for (int i = 1; i < this.lentele.getKiekis_stulpeliu(); i++) {
			duomenu_eilute += kablelis + this.lentele.getLent_duomenys().get(1).get(i);
			kablelis = ", ";
		}
		JavaFailui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "(100, " + duomenu_eilute +");");
		JavaFailui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = " + this.lentele.getLenteles_pav() + "Repository.save(elementas);");
		JavaFailui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.findBy" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(1)) + "("+ this.lentele.getLent_duomenys().get(1).get(1)+");");
		JavaFailui.add("");
		JavaFailui.add("		assertNotNull(elementas);");
		JavaFailui.add("");
		JavaFailui.add("		assertNotNull(el);        ");
		JavaFailui.add("");
		for (int i = 1; i < this.lentele.getKiekis_stulpeliu(); i++) {
			JavaFailui.add("		assertEquals(el.get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "(), elementas.get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "());");
			JavaFailui.add("		        ");
		}
		JavaFailui.add("		" + this.lentele.getLenteles_pav() + "Repository.deleteById(element.getId());");
		JavaFailui.add("");																        
		JavaFailui.add("	}");
		JavaFailui.add("	    ");
		JavaFailui.add("	@Test");
		JavaFailui.add("	public void testFindAll" + StringUtils.capitalize(this.lentele.getLenteles_pav())+ "() {");
		JavaFailui.add("		assertNotNull(" + this.lentele.getLenteles_pav() + "Repository.findAll());");
		JavaFailui.add("	}");
		JavaFailui.add("	    ");
		JavaFailui.add("	@Test");
		JavaFailui.add("	public void deleteFoundedByName() {");
		JavaFailui.add("");
		JavaFailui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( 101, " + duomenu_eilute + ");");
		JavaFailui.add("	    " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.save( elementas );        ");
		JavaFailui.add("	    " + this.lentele.getLenteles_pav() + "Repository.delete( el );                  					    // -- pagal pavyzdį neveikia  :(  ");
		JavaFailui.add("	    " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = " + this.lentele.getLenteles_pav() + "Repository.findBy" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(1)) + "(" + this.lentele.getLent_duomenys().get(1).get(1) + ");");
		JavaFailui.add("	    assertEquals( element, null );		");
		JavaFailui.add("	}");
		JavaFailui.add("");
		JavaFailui.add("	@Test");
		JavaFailui.add("	public void deleteBy" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "IdTest() {");
		JavaFailui.add("");
		JavaFailui.add("		" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " element = null;");
		JavaFailui.add("        " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " elementas = new " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "( 102, " + duomenu_eilute + ");");
		JavaFailui.add("        " + StringUtils.capitalize(this.lentele.getLenteles_pav()) + " el = " + this.lentele.getLenteles_pav() + "Repository.save(elementas);");
		JavaFailui.add("        Integer id_el = el.getId();");
		JavaFailui.add("        " + this.lentele.getLenteles_pav() + "Repository.deleteById(id_el);");
		JavaFailui.add("        Optional <" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "> found = " + this.lentele.getLenteles_pav() + "Repository.findById( id_el );");
		JavaFailui.add("");
		JavaFailui.add("		if ( found.isPresent() ) {");
		JavaFailui.add("");
		JavaFailui.add("			   element = found.get();");
		JavaFailui.add("		}");
		JavaFailui.add("        assertEquals( element, null );        ");
		JavaFailui.add("    }   ");
		JavaFailui.add("}");
		return JavaFailui;
	}
}
