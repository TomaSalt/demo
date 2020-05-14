package egzaminui.demo;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

/**
 * Failas, skirtas kuriamo HTML failo duomenims įvesti pagal lentelės duomenis
 * 
 * @author Toma
 *
 */

public class KurtiHtmlFaila {
	/**
	 * Sukuria Lentele klasės kintamąjį
	 */
	private Lentele lentele;
	/**
	 * Tuščias konstruktorius
	 */
	public KurtiHtmlFaila() {
	
	}
	/**
	 * Konstruktoriui perduodami Lentele class tipo duomenys
	 */
	public KurtiHtmlFaila(Lentele lentele) {
		
		this.lentele = lentele;
	}
	/**
	 * Papildomas String sąrašo tipo kintamasis duomenimis
	 */
	public ArrayList<String> HtmlFailui() {
		/**
		 * Sukuria String sąrašo tipo kintamąjį
		 */
		ArrayList<String> HtmlFailui = new ArrayList<String>();
		String visi_laukai = "			allFields = $( [] )";
		HtmlFailui.add("<!DOCTYPE html>");
		HtmlFailui.add("<html xmlns:th=\"http://www.thymeleaf.org\">");
		HtmlFailui.add("<head>");
		HtmlFailui.add("	<title>" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "</title>");
		HtmlFailui.add("	<meta charset=\"utf-8\">");
		HtmlFailui.add("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		HtmlFailui.add("	<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">");
		HtmlFailui.add("	<link rel=\"stylesheet\" href=\"https://jqueryui.com/resources/demos/style.css\">");
		HtmlFailui.add("	<link rel=\"stylesheet\" href=\"menu.css\">");
		HtmlFailui.add("	<link rel=\"stylesheet\" href=\"common.css\">");
		HtmlFailui.add("	<style>");
		HtmlFailui.add("	</style>");
		HtmlFailui.add("	<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>");
		HtmlFailui.add("	<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>");
		HtmlFailui.add("	<script>");
		HtmlFailui.add("		$( function() {");
		HtmlFailui.add("			var dialog, form,");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			HtmlFailui.add("			" + this.lentele.getStulpeliu_pav().get(i) + " = $(\"#" + this.lentele.getStulpeliu_pav().get(i) + "\"),");
			visi_laukai += ".add( " + this.lentele.getStulpeliu_pav().get(i) + " )";
		}
		visi_laukai += ",";
		HtmlFailui.add(visi_laukai);
		HtmlFailui.add("			tips = $( \".validateTips\" );");
		HtmlFailui.add("");
		HtmlFailui.add("			function updateTips( t ) {");
		HtmlFailui.add("				tips");
		HtmlFailui.add("				.text( t )");	 
		HtmlFailui.add("				.addClass( \"ui-state-highlight\" );");
		HtmlFailui.add("				setTimeout(function() {");
		HtmlFailui.add("				tips.removeClass( \"ui-state-highlight\", 1500 );");
		HtmlFailui.add("				}, 500 );");
		HtmlFailui.add("			}");
		HtmlFailui.add("			function checkLength( o, n, min, max ) {");
		HtmlFailui.add("				if ( o.val().length > max || o.val().length < min ) {");
		HtmlFailui.add("					o.addClass( \"ui-state-error\" );");
		HtmlFailui.add("					updateTips( n +  \" ilgis turi būti tarp \" +");
		HtmlFailui.add("						min + \" ir \" + max + \" raidžių.\" );");
		HtmlFailui.add("					return false;");
		HtmlFailui.add("				} else {");
		HtmlFailui.add("					return true;");
		HtmlFailui.add("				}");
		HtmlFailui.add("			}");
		HtmlFailui.add("			function checkNumber( o, n, min, max ) {");
		HtmlFailui.add("				if ( parseInt( o.val() ) > max || parseInt ( o.val() ) < min ) {");
		HtmlFailui.add("					o.addClass( \"ui-state-error\" );");
		HtmlFailui.add("					updateTips( n +  \" reikšmė turi būti tarp \" +");
		HtmlFailui.add("						min + \" ir \" + max + \".\" );");
		HtmlFailui.add("					return false;");
		HtmlFailui.add("				} else {");
		HtmlFailui.add("					return true;");
		HtmlFailui.add("				}");
		HtmlFailui.add("			}");
		HtmlFailui.add("			function checkRegexp( o, regexp, n ) {");
		HtmlFailui.add("				if ( !( regexp.test( o.val() ) ) ) {");
		HtmlFailui.add("					o.addClass( \"ui-state-error\" );");
		HtmlFailui.add("					updateTips( n );");
		HtmlFailui.add("					return false;");
		HtmlFailui.add("				} else {");
		HtmlFailui.add("					return true;");
		HtmlFailui.add("				}");
		HtmlFailui.add("			}");
		HtmlFailui.add("			function addElement() {");
		HtmlFailui.add("				var valid = true;");
		HtmlFailui.add("				allFields.removeClass( \"ui-state-error\" );");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			if( this.lentele.getStulpeliu_tipai().get(i).equals("String") ) {
				HtmlFailui.add("				valid = valid && checkLength( " + this.lentele.getStulpeliu_pav().get(i) + ", \"" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "\", 1, 30 );");
			}
			if( ( this.lentele.getStulpeliu_tipai().get(i).equals("Integer") ) || ( this.lentele.getStulpeliu_tipai().get(i).equals("Double") ) ) {
				HtmlFailui.add("				valid = valid && checkNumber( " + this.lentele.getStulpeliu_pav().get(i) + ", \"" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "\", 0, 1000 );");
			}
		}
		HtmlFailui.add("				// valid = valid && checkRegexp( " + this.lentele.getStulpeliu_pav().get(1) + ", /^[a-z]([0-9a-z_\\s])+$/i, \"product may consist of a-z, 0-9, underscores, spaces and must begin with a letter.\");");
		HtmlFailui.add("				if ( valid ) {");
		HtmlFailui.add("					alert ( 'Submiting '  + " + this.lentele.getStulpeliu_pav().get(1)+ ".val() );"); 
		HtmlFailui.add("					$( '#element_forma' ).submit();");	
		HtmlFailui.add("					dialog.dialog( \"close\" );");	
		HtmlFailui.add("				}");
		HtmlFailui.add("				return valid;");
		HtmlFailui.add("			}");	
		HtmlFailui.add("			dialog = $( \"#dialog-form\" ).dialog({");
		HtmlFailui.add("				autoOpen: false,");
		HtmlFailui.add("				height: 400,");
		HtmlFailui.add(" 				width: 350,");
		HtmlFailui.add("				modal: true,");
		HtmlFailui.add("				buttons: {");
		HtmlFailui.add("					\"Sukurti\": addElement,");
		HtmlFailui.add("					Atšaukti: function() {");
		HtmlFailui.add("						dialog.dialog( \"close\" );");
		HtmlFailui.add("					}");
		HtmlFailui.add("				},");
		HtmlFailui.add("				close: function() {");
		HtmlFailui.add("					form[ 0 ].reset();");
		HtmlFailui.add("					allFields.removeClass( \"ui-state-error\" );");
		HtmlFailui.add("				}");
		HtmlFailui.add("			});");
		HtmlFailui.add("			form = dialog.find( \"form\" );");
		HtmlFailui.add("			trintidialog = $( \"#dialog-confirm\" ).dialog({");
		HtmlFailui.add("				autoOpen: false,");
		HtmlFailui.add("				resizable: false,");
		HtmlFailui.add("				height: \"auto\",");
		HtmlFailui.add("				width: 400,");
		HtmlFailui.add("				modal: true,");
		HtmlFailui.add("				buttons: {");
		HtmlFailui.add("					\"Ištrinti įrašą\": function() {");
		HtmlFailui.add("						$( '#salinimo_forma' ).submit();");
		HtmlFailui.add("						$( this ).dialog( \"close\" );");
		HtmlFailui.add("					},");
		HtmlFailui.add("					Atšaukti: function() {");
		HtmlFailui.add("						$( this ).dialog( \"close\" );");
		HtmlFailui.add("					}");
		HtmlFailui.add("				}");
		HtmlFailui.add("			});");
		HtmlFailui.add("			$( \"#create-element\" ).button().on( \"click\", function() {");
		HtmlFailui.add("				$( '#pav_veiksmo' ).html ( 'Kuriamas naujas įrašas' );");
		HtmlFailui.add("				$( '#veiksmas' ).val ( 'papildyti' );");
		HtmlFailui.add("				dialog.dialog( \"open\" );");
		HtmlFailui.add("			});");
		HtmlFailui.add("		");
		HtmlFailui.add("			$( \".keisti\" ).each ( function() {");
		HtmlFailui.add("			");
		HtmlFailui.add("				$( this ).on( \"click\", function() {");
		HtmlFailui.add("					id = $( this ).data( 'id' );");

		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			HtmlFailui.add("					$('#" + this.lentele.getStulpeliu_pav().get(i) + "').val( $( this ).data ( '" + this.lentele.getStulpeliu_pav().get(i) + "' ));");
			
		}
		HtmlFailui.add("					$( '#id_taisomo_iraso' ).val ( id );");
		HtmlFailui.add("					$( '#pav_veiksmo' ).html (  'Koreguojamas įrašas' );");
		HtmlFailui.add("					$( '#veiksmas' ).val ( 'pakeisti' );");
/*		HtmlFailui.add("					kilme = $( this ).data( 'kilme' );");
		HtmlFailui.add("					if ( kilme == 1){");
		HtmlFailui.add("					$('#kilme').prop('checked', true);}");*/
		HtmlFailui.add("					dialog.dialog( \"open\" );	");
		HtmlFailui.add("				});");
		HtmlFailui.add("			});");
		HtmlFailui.add("			$( \".salinti\" ).each ( function() {");
		HtmlFailui.add("		");
		HtmlFailui.add("				$( this ).on( \"click\", function() {");
		HtmlFailui.add("			");		
		HtmlFailui.add("					$( '#id_salinamo_iraso' ).val ( id );");
		HtmlFailui.add("					$( '#pav_salinamo_iraso' ).html ($( this ).data('" + this.lentele.getStulpeliu_pav().get(1) + "'));");
		HtmlFailui.add("					trintidialog.dialog( \"open\" );");
		HtmlFailui.add("				});");
		HtmlFailui.add("			});");
		HtmlFailui.add("		});");
		HtmlFailui.add("	</script>");
		HtmlFailui.add("</head>");
		HtmlFailui.add("<body>");
		HtmlFailui.add("	<p th:attr=\"class=${back_end_message.getCss_class()}\"  th:text=\"${back_end_message.getMessage()}\"></p>");
		HtmlFailui.add("	<div id=\"menu\">");
		HtmlFailui.add("		<ul id=\"menu_sarasas\">");
		HtmlFailui.add("			<li id=\"menu_punktas\" th:each=\"menu_item : ${lst_menu}\">");
		HtmlFailui.add("				<a th:href=\"${menu_item.itemurl()}\" th:text=\"${menu_item.naujasPavadinimas()}\" th:attr=\"class=${menu_item.itemurl()}=='/" + this.lentele.getLenteles_pav() + "' ? 'active' : 'zzz'\"></a>");
		HtmlFailui.add("			</li>");
		HtmlFailui.add("		</ul>");
		HtmlFailui.add("	</div>");
		HtmlFailui.add("	<div id=\"dialog-form\" title=\"" + StringUtils.capitalize(this.lentele.getLenteles_pav()) + "\">");
		HtmlFailui.add("		<p class=\"validateTips\">Visi laukai privalomi</p>");
		HtmlFailui.add("		<p id=\"pav_veiksmo\"></p>");
		HtmlFailui.add("		<form id=\"element_forma\" method=\"POST\">");
		HtmlFailui.add("			<fieldset>");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++ ) {
			
			HtmlFailui.add("				<label for=\"" + this.lentele.getStulpeliu_pav().get(i) + "\">"+ this.lentele.getStulpeliu_pav().get(i) + "</label>");
			if( this.lentele.getStulpeliu_tipai().get(i).equals("String")) {
				
				HtmlFailui.add("				<input type=\"text\" name=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" id=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" value=\"\" class=\"text ui-widget-content ui-corner-all\" required>");
			
			}
			if(this.lentele.getStulpeliu_tipai().get(i).equals("Integer") || this.lentele.getStulpeliu_tipai().get(i).equals("Double")){
				
				HtmlFailui.add("				<input type=\"number\" name=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" id=\"" + this.lentele.getStulpeliu_pav().get(i) + "\" value=\"0\" class=\"text ui-widget-content ui-corner-all\" required>");
			}
		}
		
		HtmlFailui.add("				<input type=\"hidden\" name=\"veiksmas\" id=\"veiksmas\" value=\"papildyti\">");
		HtmlFailui.add("				<input type=\"hidden\" name=\"id\" id=\"id_taisomo_iraso\" value=\"0\">");
		//HtmlFailui.add("				<input type=\"checkbox\" name=\"kilme\" id=\"kilme\" value=\"1\">");
		//HtmlFailui.add("				<label for=\"kilme\"> gyvulines kilmes </label><br>");
		HtmlFailui.add("				<input type=\"submit\" tabindex=\"-1\" style=\"position:absolute; top:-1000px\">");
		HtmlFailui.add("			</fieldset>");
		HtmlFailui.add("		</form>");
		HtmlFailui.add("	</div>");
		HtmlFailui.add("	<div id=\"main\">");
		HtmlFailui.add("		<h3>Esami " + this.lentele.getLenteles_pav() + "</h3>");
		HtmlFailui.add("		<button id=\"create-element\">Irašyti naują</button>");
		HtmlFailui.add("		<table id=\"duombazes_lentele\">");
		HtmlFailui.add("			<thead>");
		HtmlFailui.add("			<tr>");
		HtmlFailui.add("				<th>Veiksmai</th>");
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			
			HtmlFailui.add("				<th>" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "</th>");
			
		}
		HtmlFailui.add("			</tr>");
		HtmlFailui.add("			</thead>");
		HtmlFailui.add("			<tbody>");
		HtmlFailui.add("			<tr th:each=\"" + this.lentele.getLenteles_pav() + " : ${lst}\">");
		HtmlFailui.add("				<td>");
		HtmlFailui.add("					<input type=\"button\" class=\"keisti\" value=\"keisti\" id=\"keisti\"");
		visi_laukai = "";
		String kablelis = "";
		for (int i = 0; i < this.lentele.getStulpeliu_pav().size(); i++) {
			visi_laukai += kablelis + " data-" + this.lentele.getStulpeliu_pav().get(i) + "=${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "()}";
			kablelis = ",";
		}
		HtmlFailui.add("					th:attr=\"" + visi_laukai + "\">");
		visi_laukai = "";
		visi_laukai += "data-" + this.lentele.getStulpeliu_pav().get(0) + "=${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(0)) + "()}";
		visi_laukai += kablelis + " data-" + this.lentele.getStulpeliu_pav().get(1) + "=${" + this.lentele.getLenteles_pav() + ".get" + this.lentele.getStulpeliu_pav().get(1) + "()}";
		HtmlFailui.add("					<input type=\"button\" class=\"salinti\" value=\"šalinti\" id=\"salinti\" ");
		HtmlFailui.add("					th:attr=\"" + visi_laukai + "\">");
		HtmlFailui.add("				</td>");
		/*HtmlFailui.add("				<td>");
		HtmlFailui.add("					<a th:href=\"@{/elementas(id=${elementas.getId()})}\" th:text=\"${elementas.getPav()}\"></a>");
		HtmlFailui.add("				</td>");*/
		for (int i = 1; i < this.lentele.getStulpeliu_pav().size(); i++) {
			HtmlFailui.add("				<td th:text=\"${" + this.lentele.getLenteles_pav() + ".get" + StringUtils.capitalize(this.lentele.getStulpeliu_pav().get(i)) + "()}\"></td>");
		}
		/*HtmlFailui.add("				<td th:text=\"${elementas.getKilme()}==1 ? 'gyvuline' : 'augaline'\">");
		HtmlFailui.add("				</td>");*/
		HtmlFailui.add("			</tr>");
		HtmlFailui.add("			</tbody>");
		HtmlFailui.add("		</table>");
		HtmlFailui.add("	</div>");
		HtmlFailui.add("	<div id=\"dialog-confirm\" title=\"Ištrinti įrašą?\">");
		HtmlFailui.add("		<p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:12px 12px 20px 0;\"></span>");
		HtmlFailui.add("		<p>Šis įrašas <span id=\"pav_salinamo_iraso\"></span> bus ištrintas ir nebus įmanoma jo atkurti. Ar tikrai norite ištrinti įrašą?</p>");
		HtmlFailui.add("		<form id=\"salinimo_forma\" method=\"POST\">");
		HtmlFailui.add("			<input type=\"hidden\" name=\"salinti\" value=\"pasalinti\">");
		HtmlFailui.add("			<input type=\"hidden\" name=\"id\" id=\"id_salinamo_iraso\" value=\"0\">");
		HtmlFailui.add("			<input type=\"submit\" tabindex=\"-1\" style=\"position:absolute; top:-1000px\">");
		HtmlFailui.add("		</form>");
		HtmlFailui.add("	</div>");
		HtmlFailui.add("</body>");
		HtmlFailui.add("</html>");

		return HtmlFailui;
		
	}

}
