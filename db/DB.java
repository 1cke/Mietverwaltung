/**
 * @author Johann Münchhagen
 * Dies ist ein Klasse um die anderen Klassen zu testen.
 */
import java.sql.SQLException;



public class DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Adresse adresse= new Adresse();
		Wohnung whg = new Wohnung();
		Vertrag vertrag = new Vertrag();
		Kunden kunde = new Kunden();
		Kontakt kontakt = new Kontakt();
		Bewerbung bewerbungs = new Bewerbung();
		System.out.println("Test");
		
		//adresse.set_address_value("10117", "Berlin", "Pariser Platz", "2");
		//adresse.set_address_value("20457", "Hamburg", "Platz der Deutschen Einheit", "4");
		//whg.set_wohnungen(adresse.get_adress_id("80939", "München", "Werner-Heisenberg-Allee", "25"), 638.72, 4, 2, 1, 1);
		//whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz", "2"), 189.52, 1, 1, 1, 1);
		//whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz", "2"), 1052.00, 5, 3.5, 1, 1);
		//whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz", "2"), 802.41, 4, 2,1, 1);
		//kunde.set_db_value("Max", "Mustermann", "01.01.2001", "+4930/2345619", " ",1);
		//kunde.set_db_value("Hannelore", "Müller", "23.04.1982", " ", "hannelore_mueller@test.de",1);
		//kunde.set_db_value("Franzl", "Wolf", "13.05.1968", " ", "franzl.wolf@test.de",0);
		//kunde.get_all();
		//adresse.display_adresse();
		//vertrag.set_db_value(kunde.get_id("Franzl", "Wolf", "13.05.1968"), whg.get_whg_nr(adresse.get_adress_id("80939", "München", "Werner-Heisenberg-Allee", "25")), 0.0,"05.02.2002", 1);
		//vertrag.set_db_value(kunde.get_id("Max", "Mustermann", "01.01.2001"), whg.get_whg_nr(adresse.get_adress_id("10117", "Berlin", "Pariser Platz", "2")), 20.0,"01.01.2011", 1);
		//vertrag.set_db_value(kunde.get_id("Peter", "Lustig", "01.01.1972"), whg.get_whg_nr(adresse.get_adress_id("10117", "Berlin", "Pariser Platz", "2")), 20.0,"01.01.2011", 0);
		//kontakt.set_kontakt_value(vertrag.get_vertrags_id(kunde.get_id("Franzl", "Wolf", "13.05.1968")), "27.09.2011", "Rohrbruch", " ");
		System.out.println("Test ausgabe");
		
		int kd_nr = kunde.get_id("Franzl", "Wolf", "13.05.1968");
		String vorname = kunde.get_vorname(kd_nr);
		String nachname = kunde.get_nachname(kd_nr);
		String geburtsdatum = kunde.get_geburtstag(kd_nr);
		String telefon = kunde.get_telefon(kd_nr);
		String email = kunde.get_email(kd_nr);
		System.out.println("Kundennummer: "+kd_nr+"\nName: "+vorname + " " + nachname+"\nGeboren am: "+ geburtsdatum+"\nKontakt möglichkeit: " + telefon+" "+email);
		int vertrags_id = vertrag.get_vertrags_id(kd_nr);
		int adress_id = whg.get_adress_id(vertrag.get_whg_id(vertrags_id));
		String plz = adresse.get_plz(adress_id);
		String ort= adresse.get_ort(adress_id);
		String straße = adresse.get_strasse(adress_id);
		String hn = adresse.get_hn(adress_id);
		System.out.println("Wohnhaft in: " + plz+" "+ort+" "+straße+ " "+hn);
		int whg_nr = vertrag.get_whg_id(vertrag.get_vertrags_id(kd_nr));
		double miete = whg.get_miete(whg_nr);
		double zimmer = whg.get_zimmer(whg_nr);
		double baeder = whg.get_baeder(whg_nr);
		boolean ebk = whg.get_ebk(whg_nr);
		double schulden = vertrag.get_schulden(vertrags_id);
		System.out.println("Wohnungsdaten\nWohnungsnummer: "+whg_nr+", Höhe der Miete: "+miete+"€, Schulden: "+schulden +"€, Anzahl der Zimmer: "+zimmer+", Anzahl der Bäder: "+baeder+ ", Einbauküche vorhanden: "+ebk);
		try {
			int kontakt_nr = kontakt.get_kontakt_id(vertrags_id)[0];
			String wann = kontakt.get_wann(kontakt_nr);
			String grund = kontakt.get_grund(kontakt_nr);
			String beschreibung = kontakt.get_beschreibung(kontakt_nr);
			System.out.println("Kontakte: "+kontakt_nr+ ", Wann: "+wann+", Grund: "+grund+", Beschreibung: "+beschreibung);
		}catch(Exception e) {
			
		}
		//vertrag.change_wohnungsnummer(kd_nr, 2);
		
		
		
	}
}
