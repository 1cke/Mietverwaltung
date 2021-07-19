package backend;

/**
 * @author Johann Münchhagen
 * Dies ist ein Klasse um die anderen Klassen zu testen.
 */
import java.sql.SQLException;

public class DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Adresse adresse = new Adresse();
		Wohnung whg = new Wohnung();
		Vertrag vertrag = new Vertrag();
		Kunden kunde = new Kunden();
		Kontakt kontakt = new Kontakt();
		Bewerbung bewerbungs = new Bewerbung();
		System.out.println("Test");
		whg.display();
		//kunde.get_all();
		// adresse.set_address_value("10117", "Berlin", "Pariser Platz", "2");
		// adresse.set_address_value("20457", "Hamburg", "Platz der Deutschen Einheit",
		// "4");
		// adresse.set_address_value("80939", "München", "Werner-Heisenberg-Allee",
		// "25");
		// whg.set_wohnungen(adresse.get_adress_id("80939", "München",
		// "Werner-Heisenberg-Allee", "25"), 638.72, 4, 2, 1, 1);
		// whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz",
		// "2"), 189.52, 1, 1, 1, 1);
		// whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz",
		// "2"), 1052.00, 5, 3.5, 1, 1);
		// whg.set_wohnungen(adresse.get_adress_id("10117", "Berlin", "Pariser Platz",
		// "2"), 802.41, 4, 2,1, 1);
		// whg.display();
		// kunde.set_db_value("Max", "Mustermann", "01.01.2001", "+4930/2345619", "
		// ",1);
		// kunde.set_db_value("Hannelore", "Müller", "23.04.1982", " ",
		// "hannelore_mueller@test.de",1);
		// kunde.set_db_value("Franzl", "Wolf", "13.05.1968", " ",
		// "franzl.wolf@test.de",0);
		// kunde.get_all();
		// adresse.display_adresse();
		// vertrag.set_db_value(kunde.get_id("Franzl", "Wolf", "13.05.1968"),
		// whg.get_whg_nr(adresse.get_adress_id("80939", "München",
		// "Werner-Heisenberg-Allee", "25")), 0.0,"05.02.2002", 1);
		// vertrag.set_db_value(kunde.get_id("Max", "Mustermann", "01.01.2001"),
		// whg.get_whg_nr(adresse.get_adress_id("10117", "Berlin", "Pariser Platz",
		// "2")), 20.0,"01.01.2011", 1);
		// vertrag.set_db_value(kunde.get_id("Peter", "Lustig", "01.01.1972"),
		// whg.get_whg_nr(adresse.get_adress_id("10117", "Berlin", "Pariser Platz",
		// "2")), 20.0,"01.01.2011", 0);
		// kontakt.set_kontakt_value(vertrag.get_vertrags_id(kunde.get_id("Franzl",
		// "Wolf", "13.05.1968")), "27.09.2011", "Rohrbruch", " ");
		System.out.println("Test ausgabe");
		kunde.get_vorname();
		//int kd_nr = kunde.get_id("Max", "Mustermann", "01.01.2001");
		kunde.lade_kunden_daten(100);
		int kd_nr = kunde.getId();
		String vorname = kunde.get_vorname();
		String nachname = kunde.get_nachname();
		String geburtsdatum = kunde.get_geburtstag();
		String telefon = kunde.get_telefon();
		String email = kunde.get_email();
		System.out.println("Kundennummer: " + kd_nr + "\nName: " + vorname + " " + nachname + "\nGeboren am: "
				+ geburtsdatum + "\nKontakt möglichkeit: " + telefon + " " + email+"\nInteressent: "+kunde.get_interessent()+" Aktiv: "+kunde.get_aktiv());
	}
}
