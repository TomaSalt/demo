
package egzaminui.demo;
/**
 * Class tipo failas, skirtas žinutės išvedimui į ekraną
 * 
 * @author Toma
 *
 */
public class BackEndMessage {
	/**
	 * Sukuria String tipo kintamąjį žinutei į ekraną
	 */
	String message;
	/**
	 * Sukuria String tipo kintamąjį css klasės vardui
	 */
	String css_class;
	/**
	 * Sukuria boolean tipo kintamąjį formos atnaujinimui
	 */
	boolean flag_reopen_form;
	/**
	 * Tuščias konstruktorius
	 */
	public BackEndMessage() {
		
		message = "";
		css_class = "";
	}	
	/**
	 * Konstruktoriui perduodama žinutės tekstas, formos atnaujinimo patvirtinimas, css klasės vardas
	 */
	public BackEndMessage(String message, boolean flag_reopen_form, String css_klase) {
		
		super();
		this.message = message;
		this.flag_reopen_form = flag_reopen_form;
		css_class = css_klase;		
	}
	/**
	 * Message getter'is
	 * @return message
	 */
	public String getMessage() {
		
		return message;
	}
	/**
	 * Message setter'is
	 */
	public void setMessage(String message) {
		
		this.message = message;
	}
	/**
	 * Metodas pridėti teksto į žinutę
	 */
	public void addMessage( String add_message ) {
	
		this.message += add_message; 
	}
	/**
	 * boolean tipo kintamasis formos atnaujinimo patvirtinimui
	 * @return flag_reopen_form
	 */
	public boolean isFlag_reopen_form() {
		
		return flag_reopen_form;
	}
	/**
	 * metodas formos atnaujinimo patvirtinimui pakeisti
	 */
	public void setFlag_reopen_form(boolean flag_reopen_form) {
		
		this.flag_reopen_form = flag_reopen_form;
	}
	/**
	 * Css_class getter'is
	 * @return css_class
	 */
	public String getCss_class() {
	
		return css_class;
	}
	/**
	 * Css_class setter'is
	 */
	public void setCss_class( String css_klase ) {
		
		css_class = css_klase;
	}
}
