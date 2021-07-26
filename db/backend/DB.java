package backend;


/**
 * @author Johann Münchhagen
 * Dies ist ein Klasse um die anderen Klassen zu testen.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import datentypen.Bewerbungsdaten;
import datentypen.Person;

public class DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Adresse adresse = new Adresse();
		Wohnung whg = new Wohnung();
		Vertrag vertrag = new Vertrag();
		Kunden kunde = new Kunden();
		Kontakt kontakt = new Kontakt();
		Bewerbung bewerbung = new Bewerbung();
		
		
		System.out.println(vertrag.lade_vertrags_daten(1));
		System.out.println(vertrag.get_kd_id());
		System.out.println(vertrag.change_kundennummer(1, 7));
		System.out.println(vertrag.lade_vertrags_daten(1));
		System.out.println(vertrag.get_kd_id());
	}
}
