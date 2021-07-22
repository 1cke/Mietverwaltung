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
		System.out.println("Test");
		
		// Alle Kunden jeweils in ein seperates Array geladen
		ArrayList<Person> kd = kunde.get_all();
		ArrayList<String[]> test = new ArrayList<String[]>();
		for(int i = 0;i<kd.size();i++) {
			String[]nutzer = new String[8];
			String parse = kunde.parseString(kd.get(i));
			nutzer = parse.split(",");
			test.add(nutzer);
		}
		// Ausgabe aller Kunden einzeln
		for(int i = 0; i<test.size();i++) {
			System.out.println(test.get(i)[0]+" "+test.get(i)[1]+" "+test.get(i)[2]+" "+test.get(i)[3]+" "
					+test.get(i)[4]+ " "+test.get(i)[5]+" "+test.get(i)[6]+" "+test.get(i)[7]);
					
		}
		
	}
}
