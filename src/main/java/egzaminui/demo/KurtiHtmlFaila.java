package egzaminui.demo;

import java.util.ArrayList;
import org.springframework.util.StringUtils;
/**
 * Failas, skirtas kurti HTML failą pagal duomenų bazės lentelės duomenis
 * 
 * @author Toma
 *
 */
public class KurtiHtmlFaila {
	/**
	 * Sukuria LenteleBeDuomenu klasės kintamąjį
	 */
	private LenteleBeDuomenu lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiHtmlFaila() {
	
	}
	/**
	 * Konstruktoriui perduodami LenteleBeDuomenu klasės tipo duomenys
	 * @param lentele LenteleBeDuomenu klasės tipo kintamasis
	 */
	public KurtiHtmlFaila(LenteleBeDuomenu lentele) {
		
		this.lentele = lentele;
	}
	/**
	 * Metodas grąžinti String sąrašo tipo kintamajį HTML failo kūrimui
	 * @return html_failui
	 */
	public ArrayList<String> htmlFailui() {

		ArrayList<String> html_failui = new ArrayList<String>();
		String visi_laukai = "			allFields = $( [] )";
		html_failui.add("<!DOCTYPE html>");
		html_failui.add("<html xmlns:th=\"http://www.thymeleaf.org\">");
		html_failui.add("<head>");
		html_failui.add("	<title>" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "</title>");
		html_failui.add("	<meta charset=\"utf-8\">");
		html_failui.add("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		html_failui.add("	<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">");
		html_failui.add("	<link rel=\"stylesheet\" href=\"https://jqueryui.com/resources/demos/style.css\">");
		html_failui.add("	<link rel=\"stylesheet\" href=\"menu.css\">");
		html_failui.add("	<link rel=\"stylesheet\" href=\"common.css\">");
		html_failui.add("	<style>");
		html_failui.add("	</style>");
		html_failui.add("	<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>");
		html_failui.add("	<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>");
		html_failui.add("	<script>");
		html_failui.add("		$( function() {");
		html_failui.add("			var dialog, form,");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			html_failui.add("			" + this.lentele.getStulpeliu_pav().get(i) + " = $(\"#" + this.lentele.getStulpeliu_pav().get(i) + "\"),");
			visi_laukai += ".add( " + this.lentele.getStulpeliu_pav().get(i) + " )";
		}
		visi_laukai += ",";
		html_failui.add(visi_laukai);
		html_failui.add("			tips = $( \".validateTips\" );");
		html_failui.add("");
		html_failui.add("			function updateTips( t ) {");
		html_failui.add("			");	
		html_failui.add("				tips");
		html_failui.add("				.text( t )");	 
		html_failui.add("				.addClass( \"ui-state-highlight\" );");
		html_failui.add("				setTimeout(function() {");
		html_failui.add("				tips.removeClass( \"ui-state-highlight\", 1500 );");
		html_failui.add("				}, 500 );");
		html_failui.add("			}");
		html_failui.add("			function checkLength( o, n, min, max ) {");
		html_failui.add("			");	
		html_failui.add("				if ( o.val().length > max || o.val().length < min ) {");
		html_failui.add("					o.addClass( \"ui-state-error\" );");
		html_failui.add("					updateTips( n +  \" ilgis turi būti tarp \" +");
		html_failui.add("						min + \" ir \" + max + \" raidžių.\" );");
		html_failui.add("					return false;");
		html_failui.add("				} else {");
		html_failui.add("					return true;");
		html_failui.add("				}");
		html_failui.add("			}");
		html_failui.add("			function checkNumber( o, n, min, max ) {");
		html_failui.add("			");	
		html_failui.add("				if ( parseInt( o.val() ) > max || parseInt ( o.val() ) < min ) {");
		html_failui.add("					o.addClass( \"ui-state-error\" );");
		html_failui.add("					updateTips( n +  \" reikšmė turi būti tarp \" +");
		html_failui.add("						min + \" ir \" + max + \".\" );");
		html_failui.add("					return false;");
		html_failui.add("				} else {");
		html_failui.add("					return true;");
		html_failui.add("				}");
		html_failui.add("			}");
		html_failui.add("			function checkRegexp( o, regexp, n ) {");
		html_failui.add("			");	
		html_failui.add("				if ( !( regexp.test( o.val() ) ) ) {");
		html_failui.add("					o.addClass( \"ui-state-error\" );");
		html_failui.add("					updateTips( n );");
		html_failui.add("					return false;");
		html_failui.add("				} else {");
		html_failui.add("					return true;");
		html_failui.add("				}");
		html_failui.add("			}");
		html_failui.add("			function addElement() {");
		html_failui.add("			");	
		html_failui.add("				var valid = true;");
		html_failui.add("				allFields.removeClass( \"ui-state-error\" );");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			if( this.lentele.getStulpeliu_tipai().get(i).equals("String") ) {
				html_failui.add("				valid = valid && checkLength( " + this.lentele.getStulpeliu_pav().get(i) + ", \"" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "\", 1, 30 );");
			}
			if( ( this.lentele.getStulpeliu_tipai().get(i).equals("Integer") ) || ( this.lentele.getStulpeliu_tipai().get(i).equals("Double") ) ) {
				html_failui.add("				valid = valid && checkNumber( " + this.lentele.getStulpeliu_pav().get(i) + ", \"" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "\", 0, 1000 );");
			}
		}
		html_failui.add("				// valid = valid && checkRegexp( " + this.lentele.getStulpeliu_pav().get(1) + ", /^[a-z]([0-9a-z_\\s])+$/i, \"product may consist of a-z, 0-9, underscores, spaces and must begin with a letter.\");");
		html_failui.add("				if ( valid ) {");
		html_failui.add("					alert ( 'Submiting '  + " + this.lentele.getStulpeliu_pav().get(1)+ ".val() );"); 
		html_failui.add("					$( '#element_forma' ).submit();");	
		html_failui.add("					dialog.dialog( \"close\" );");	
		html_failui.add("				}");
		html_failui.add("				return valid;");
		html_failui.add("			}");	
		html_failui.add("			dialog = $( \"#dialog-form\" ).dialog({");
		html_failui.add("			");	
		html_failui.add("				autoOpen: false,");
		html_failui.add("				height: 400,");
		html_failui.add(" 				width: 350,");
		html_failui.add("				modal: true,");
		html_failui.add("				buttons: {");
		html_failui.add("					\"Sukurti\": addElement,");
		html_failui.add("					Atšaukti: function() {");
		html_failui.add("						dialog.dialog( \"close\" );");
		html_failui.add("					}");
		html_failui.add("				},");
		html_failui.add("				close: function() {");
		html_failui.add("					form[ 0 ].reset();");
		html_failui.add("					allFields.removeClass( \"ui-state-error\" );");
		html_failui.add("				}");
		html_failui.add("			});");
		html_failui.add("			form = dialog.find( \"form\" );");
		html_failui.add("			trintidialog = $( \"#dialog-confirm\" ).dialog({");
		html_failui.add("			");	
		html_failui.add("				autoOpen: false,");
		html_failui.add("				resizable: false,");
		html_failui.add("				height: \"auto\",");
		html_failui.add("				width: 400,");
		html_failui.add("				modal: true,");
		html_failui.add("				buttons: {");
		html_failui.add("					\"Ištrinti įrašą\": function() {");
		html_failui.add("						$( '#salinimo_forma' ).submit();");
		html_failui.add("						$( this ).dialog( \"close\" );");
		html_failui.add("					},");
		html_failui.add("					Atšaukti: function() {");
		html_failui.add("						$( this ).dialog( \"close\" );");
		html_failui.add("					}");
		html_failui.add("				}");
		html_failui.add("			});");
		html_failui.add("			$( \"#create-element\" ).button().on( \"click\", function() {");
		html_failui.add("			");	
		html_failui.add("				$( '#pav_veiksmo' ).html ( 'Kuriamas naujas įrašas' );");
		html_failui.add("				$( '#veiksmas' ).val ( 'papildyti' );");
		html_failui.add("				dialog.dialog( \"open\" );");
		html_failui.add("			});");
		html_failui.add("		");
		html_failui.add("			$( \".keisti\" ).each ( function() {");
		html_failui.add("			");
		html_failui.add("				$( this ).on( \"click\", function() {");
		html_failui.add("					id = $( this ).data( 'id' );");

		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			html_failui.add("					$('#" + this.lentele.getStulpeliu_pav().get(i) + "').val( $( this ).data ( '" + this.lentele.getStulpeliu_pav().get(i) + "' ));");
			
		}
		html_failui.add("					$( '#id_taisomo_iraso' ).val ( id );");
		html_failui.add("					$( '#pav_veiksmo' ).html (  'Koreguojamas įrašas' );");
		html_failui.add("					$( '#veiksmas' ).val ( 'pakeisti' );");
/*		html_failui.add("					kilme = $( this ).data( 'kilme' );");
		html_failui.add("					if ( kilme == 1){");
		html_failui.add("					$('#kilme').prop('checked', true);}");*/
		html_failui.add("					dialog.dialog( \"open\" );	");
		html_failui.add("				});");
		html_failui.add("			});");
		html_failui.add("			$( \".salinti\" ).each ( function() {");
		html_failui.add("		");
		html_failui.add("				$( this ).on( \"click\", function() {");	
		html_failui.add("					id = $( this ).data( 'id' );");
		html_failui.add("					$( '#id_salinamo_iraso' ).val ( id );");
		html_failui.add("					$( '#pav_salinamo_iraso' ).html ($( this ).data('" + this.lentele.getStulpeliu_pav().get(1) + "'));");
		html_failui.add("					trintidialog.dialog( \"open\" );");
		html_failui.add("				});");
		html_failui.add("			});");
		html_failui.add("		});");
		html_failui.add("	</script>");
		html_failui.add("</head>");
		html_failui.add("<body>");
		html_failui.add("	<p th:attr=\"class=${back_end_message.getCss_class()}\"  th:text=\"${back_end_message.getMessage()}\"></p>");
		html_failui.add("	<div id=\"menu\">");
		html_failui.add("		<ul id=\"menu_sarasas\">");
		html_failui.add("			<li id=\"menu_punktas\" th:each=\"menu_item : ${lst_menu}\">");
		html_failui.add("				<a th:href=\"${menu_item.itemurl()}\" th:text=\"${menu_item.naujasPavadinimas()}\" th:attr=\"class=${menu_item.itemurl()}=='/" + this.lentele.getLenteles_pav() + "' ? 'active' : 'zzz'\"></a>");
		html_failui.add("			</li>");
		html_failui.add("		</ul>");
		html_failui.add("	</div>");
		html_failui.add("	<div id=\"dialog-form\" title=\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\">");
		html_failui.add("		<p class=\"validateTips\">Visi laukai privalomi</p>");
		html_failui.add("		<p id=\"pav_veiksmo\"></p>");
		html_failui.add("		<form id=\"element_forma\" method=\"POST\">");
		html_failui.add("			<fieldset>");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++ ) {
			
			html_failui.add("				<label for=\"" + this.lentele.getStulpeliu_pav().get(i) + "\">"+ this.lentele.getStulpeliu_pav().get(i) + "</label>");
			if( this.lentele.getStulpeliu_tipai().get(i).equals("String")) {
				
				html_failui.add("				<input type=\"text\" name=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" id=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" value=\"\" class=\"text ui-widget-content ui-corner-all\" required>");
			
			}
			if(this.lentele.getStulpeliu_tipai().get(i).equals("Integer") || this.lentele.getStulpeliu_tipai().get(i).equals("Double")){
				
				html_failui.add("				<input type=\"number\" name=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" id=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" value=\"0\" class=\"text ui-widget-content ui-corner-all\" required>");
			}
		}
		
		html_failui.add("				<input type=\"hidden\" name=\"veiksmas\" id=\"veiksmas\" value=\"papildyti\">");
		html_failui.add("				<input type=\"hidden\" name=\"id\" id=\"id_taisomo_iraso\" value=\"0\">");
		//html_failui.add("				<input type=\"checkbox\" name=\"kilme\" id=\"kilme\" value=\"1\">");
		//html_failui.add("				<label for=\"kilme\"> gyvulines kilmes </label><br>");
		html_failui.add("				<input type=\"submit\" tabindex=\"-1\" style=\"position:absolute; top:-1000px\">");
		html_failui.add("			</fieldset>");
		html_failui.add("		</form>");
		html_failui.add("	</div>");
		html_failui.add("	<div id=\"main\">");
		html_failui.add("		<h3>Esami " + this.lentele.getLenteles_pav() + "</h3>");
		html_failui.add("		<button id=\"create-element\">Irašyti naują</button>");
		html_failui.add("		<table id=\"duombazes_lentele\">");
		html_failui.add("			<thead>");
		html_failui.add("			<tr>");
		html_failui.add("				<th>Veiksmai</th>");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			html_failui.add("				<th>" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "</th>");
			
		}
		html_failui.add("			</tr>");
		html_failui.add("			</thead>");
		html_failui.add("			<tbody>");
		html_failui.add("			<tr th:each=\"" + this.lentele.getLenteles_pav() + " : ${lst}\">");
		html_failui.add("				<td>");
		html_failui.add("					<input type=\"button\" class=\"keisti\" value=\"keisti\" id=\"keisti\"");
		visi_laukai = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getStulpeliu_pav().size(); i++) {
			visi_laukai += kablelis + " data-" + this.lentele.getStulpeliu_pav().get(i) + "=${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "()}";
			kablelis = ",";
		}
		html_failui.add("					th:attr=\"" + visi_laukai + "\">");
		visi_laukai = "";
		visi_laukai += "data-" + this.lentele.getStulpeliu_pav().get(0) + "=${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(0)) + "()}";
		visi_laukai += kablelis + " data-" + this.lentele.getStulpeliu_pav().get(1) + "=${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(1)) + "()}";
		html_failui.add("					<input type=\"button\" class=\"salinti\" value=\"šalinti\" id=\"salinti\" ");
		html_failui.add("					th:attr=\"" + visi_laukai + "\">");
		html_failui.add("				</td>");
		/*html_failui.add("				<td>");
		html_failui.add("					<a th:href=\"@{/elementas(id=${elementas.getId()})}\" th:text=\"${elementas.getPav()}\"></a>");
		html_failui.add("				</td>");*/
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			html_failui.add("				<td th:text=\"${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "()}\"></td>");
		}
		/*html_failui.add("				<td th:text=\"${elementas.getKilme()}==1 ? 'gyvuline' : 'augaline'\">");
		html_failui.add("				</td>");*/
		html_failui.add("			</tr>");
		html_failui.add("			</tbody>");
		html_failui.add("		</table>");
		html_failui.add("	</div>");
		html_failui.add("	<div id=\"dialog-confirm\" title=\"Ištrinti įrašą?\">");
		html_failui.add("		<p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:12px 12px 20px 0;\"></span>");
		html_failui.add("		<p>Šis įrašas <span id=\"pav_salinamo_iraso\"></span> bus ištrintas ir nebus įmanoma jo atkurti. Ar tikrai norite ištrinti įrašą?</p>");
		html_failui.add("		<form id=\"salinimo_forma\" method=\"POST\">");
		html_failui.add("			<input type=\"hidden\" name=\"salinti\" value=\"pasalinti\">");
		html_failui.add("			<input type=\"hidden\" name=\"id\" id=\"id_salinamo_iraso\" value=\"0\">");
		html_failui.add("			<input type=\"submit\" tabindex=\"-1\" style=\"position:absolute; top:-1000px\">");
		html_failui.add("		</form>");
		html_failui.add("	</div>");
		html_failui.add("</body>");
		html_failui.add("</html>");

		return html_failui;
	}
}
