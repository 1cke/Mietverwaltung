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
		//whg.set_wohnungen(1, 1.0, 2.0, 3.0, 1, 1);
		
		whg.lade_daten(1);
		System.out.println(whg.get_miete());
		System.out.println(whg.change_miete(1, 10));
		whg.lade_daten(1);
		System.out.println(whg.get_miete());
		System.out.println(whg.display());
	}
}
