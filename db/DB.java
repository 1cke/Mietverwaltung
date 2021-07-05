
import java.sql.SQLException;



public class DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Kunden kunde = new Kunden();
		//System.out.println(kunde.set_db_value("Elisabeth", "von Possenhofen", "01.01.1900","+4312345678987"));
		//int a = kunde.get_id("Franzl", "Mustermann", "01.01.2001", "+4912345678987");
		//System.out.println(kunde.get_vorname(a));
		//kunde.change_vorname(1, "Michael");
		//System.out.println(kunde.get_vorname(1));
		//System.out.println(kunde.get_nachname(1));
		//kunde.change_nachname(1, "Müller");
		//System.out.println(kunde.get_nachname(1));
		//System.out.println(kunde.get_geburtstag(1));
		//kunde.change_geburtstag(3, "24.12.1900");
		//System.out.println(kunde.get_geburtstag(1));
		//System.out.println(kunde.get_telefon(1));
		//kunde.change_telefon(1, "030123456");
		//System.out.println(kunde.get_telefon(1));
		//kunde.get_all();
		//Vertrag vertrag = new Vertrag();
		//vertrag.set_db_value(1, 1, 0.0, "01.10.2020", 1);
		//vertrag.get_all();
		//System.out.println(vertrag.get_vertrags_id(1));
		//System.out.println(vertrag.get_all_whg(1)[1]);
		//Kontakt kontakt = new Kontakt();
		//kontakt.display_kontakt();
		//kontakt.set_kontakt_value(1,"24.06.2021", "Beschwerde", "Nachbar ist zu laut");
		//for(int i = 0; i < kontakt.get_kontakt_id(1).length; i++) {
			//System.out.println(kontakt.get_kontakt_id(1)[i]);
		//}
		//Adresse adresse = new Adresse();
		//adresse.set_address_value("12345", "Musterstadt", "Musterstraße", "1");
		//System.out.println(adresse.test());
		Interessenten interessent = new Interessenten();
		//System.out.print(interessent.set_interessent("Max", "Mustermann", "01.01.2001"," "," "));
		interessent.display_all();
		
	}
}
