
package egzaminui.demo;
/**
 * Failas, skirtas žinutės išvedimui į ekraną
 * 
 * @author Toma
 *
 */
public class BackEndMessage {
	/**
	 * Sukuriamas String tipo kintamasis žinutei į ekraną
	 */
	String message;
	/**
	 * Sukuriamas String tipo kintamasis css klasės vardui
	 */
	String css_class;
	/**
	 * Sukuriamas boolean tipo kintamąjį formos atnaujinimui
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
	 * @param message String tipo kintamasis žinutei į ekraną
	 * @param flag_reopen_form boolean tipo kintamąjį formos atnaujinimui
	 * @param css_klase String tipo kintamasis css klasės vardui
	 */
	public BackEndMessage(String message, boolean flag_reopen_form, String css_klase) {
		
		super();
		this.message = message;
		this.flag_reopen_form = flag_reopen_form;
		this.css_class = css_klase;		
	}
	/**
	 * Message getter'is
	 * @return message
	 */
	public String getMessage() {
		
		return message;
	}
	/**
	 * @param message setter'is
	 */
	public void setMessage(String message) {
		
		this.message = message;
	}
	/**
	 * Metodas pridėti teksto į žinutę
	 * @param add_message String tipo kintamasis teksto į žinutę pridėjimui
	 */
	public void addMessage( String add_message ) {
	
		this.message += add_message; 
	}
	/**
	 * Metodas grąžinantis boolean tipo kintamąjį formos atnaujinimo patvirtinimui
	 * @return flag_reopen_form
	 */
	public boolean isFlag_reopen_form() {
		
		return flag_reopen_form;
	}
	/**
	 * @param flag_reopen_form setter'is
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
	 * @param css_klase setter'is
	 */
	public void setCss_class( String css_klase ) {
		
		css_class = css_klase;
	}
}
