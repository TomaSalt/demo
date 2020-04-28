package egzaminui.demo;
import java.util.ArrayList;
import org.springframework.util.StringUtils;

public class KurtiRepositoryFaila {
	
	private Lentele lentele;
	
	public KurtiRepositoryFaila() {
	
	}
	public KurtiRepositoryFaila(Lentele lentele) {
		
		this.lentele = lentele;
		
	}
	
	public ArrayList<String> RepositoryFailui() {
		ArrayList<String> JavaFailui = new ArrayList<String>();
		JavaFailui.add("package egzaminui.demo;");
		JavaFailui.add("import java.util.List;");
		JavaFailui.add("import org.springframework.data.jpa.repository.Query;");
		JavaFailui.add("//import java.util.stream.*;");
		JavaFailui.add("//import org.springframework.data.repository.Repository;");
		JavaFailui.add("import org.springframework.data.repository.CrudRepository;");
		JavaFailui.add("//import org.springframework.data.repository.query.Param;");
		JavaFailui.add("");
		JavaFailui.add("public interface " + StringUtils.capitalize(lentele.getLenteles_pav()) + "Repository extends CrudRepository<" + StringUtils.capitalize(lentele.getLenteles_pav()) + ", Integer>{");
		JavaFailui.add("");
		JavaFailui.add("	//" + StringUtils.capitalize(lentele.getLenteles_pav()) + " findByPav( String pav );");
		JavaFailui.add("");
		String select_stulpeliu_pav = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getKiekis_stulpeliu(); i++ ) {
			
			select_stulpeliu_pav += kablelis + this.lentele.getStulpeliu_pav().get(i);
			kablelis = ", ";
		}
		JavaFailui.add("	//@Query(value=\"SELECT " + select_stulpeliu_pav + " FROM " + lentele.getLenteles_pav() + " WHERE salyga=1\", nativeQuery = true)");
		JavaFailui.add("	//List<" + StringUtils.capitalize(lentele.getLenteles_pav()) + "> findAllQuery();");
		JavaFailui.add("}");
		return JavaFailui;
		
	}
}
