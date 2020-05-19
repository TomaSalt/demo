
package egzaminui.demo;

public class BackEndMessage {
	
	String message;
	
	String css_class;
	
	boolean flag_reopen_form;
	
	public BackEndMessage() {
		
		message = "";
		css_class = "";
	}	

	public BackEndMessage(String message, boolean flag_reopen_form, String css_klase) {
		super();
		this.message = message;
		this.flag_reopen_form = flag_reopen_form;
		css_class = css_klase;		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addMessage( String add_message ) {
	
		this.message += add_message; 
	}

	public boolean isFlag_reopen_form() {
		return flag_reopen_form;
	}

	public void setFlag_reopen_form(boolean flag_reopen_form) {
		this.flag_reopen_form = flag_reopen_form;
	}
	
	public String getCss_class() {
	
		return css_class;
	}
	
	public void setCss_class( String css_klase ) {
		
		css_class = css_klase;
	}
}
