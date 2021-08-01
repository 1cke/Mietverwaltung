package backend;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Kontaktdaten;

/**
 * Diese Klasse stellt Daten zu den Kontakten bereit
 * @author Johann-Christian Münchhagen
 * @version 1.0
 * @see Kontaktdaten
 */
public class Kontakt extends Kontaktdaten{
	/**
	 * Diese Methode konstruiert die Klasse
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see initieren
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public Kontakt() throws ClassNotFoundException, SQLException{
		initieren();
	}
	/**
	 * Diese Methode überprüft ob die Tabelle kontakt bereits in der Datenbank existiert
	 * Wenn dies nicht der Fall ist, wird diese Tabelle neu angelegt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS kontakt(kontakts_id INTEGER PRIMARY KEY, vertrags_id INTEGER NOT NULL, wann TEXT NOT NULL,grund TEXT NOT NULL,beschreibung TEXT,behoben BOOLEAN)");
		connection.close();
	}
	/**
	 * Diese Methode erstellt einen neuen Datenbank eintrag
	 * @param anweisung EIín SQL-Befehl als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean set_db_value_for_contact(String anweisung)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate(anweisung);
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode lädt einen spezifischen Kontakt
	 * @param kontakts_id Die Kontakts-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_values(int kontakts_id) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//System.out.println(anweisung);//Kontrollausgabe
			ResultSet rs = statement.executeQuery("SELECT vertrags_id, wann, grund,beschreibung,behoben FROM kontakt WHERE kontakts_id = '"+kontakts_id+"'");
			while(rs.next()) {
				this.setVertragsnummer(rs.getInt(1));
				this.setWann(rs.getString(2));
				this.setGrund(rs.getString(3));
				this.setBeschreibung(rs.getString(4));
				this.setBehoben(rs.getBoolean(5));
			}
			connection.close();
			this.setId(kontakts_id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	} 
	/**
	 * Diese Methode lädt alle Kontakte die einem Vertrag zugeordnet werden können, bzw lädt diese Methode alle Kontakte
	 * @param vertrags_id Die Vertrags-ID als Integer
	 * @param typ den Typ als String
	 * @return ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Kontaktdaten> get_values(int vertrags_id,String typ) throws ClassNotFoundException, SQLException{
		ArrayList<Kontaktdaten> daten = new ArrayList<Kontaktdaten>();
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		if(typ == "einer") {
			ResultSet rs = statement.executeQuery("SELECT kontakts_id, wann, grund,beschreibung,behoben FROM kontakt WHERE vertrags_id = '"+vertrags_id+"'");
			while(rs.next()) {
				Kontaktdaten k = new Kontaktdaten();
				k.setId(rs.getInt(1));
				k.setVertragsnummer(vertrags_id);
				k.setWann(rs.getString(2));
				k.setGrund(rs.getString(3));
				k.setBeschreibung(rs.getString(4));
				k.setBehoben(rs.getBoolean(5));
				daten.add(k);
			}
			connection.close();
			return daten;
		}else {
			ResultSet rs = statement.executeQuery("SELECT * FROM kontakt");
			while(rs.next()) {
				Kontaktdaten k = new Kontaktdaten();
				k.setId(rs.getInt(1));
				k.setVertragsnummer(rs.getInt(2));
				k.setWann(rs.getString(3));
				k.setGrund(rs.getString(4));
				k.setBeschreibung(rs.getString(5));
				k.setBehoben(rs.getBoolean(6));
				daten.add(k);
			}
			connection.close();
			return daten;
		}
	
	}
	/**
	 * Diese Methode ändert ein Attribut in der Datenbank
	 * @param anweisung Ein SQL-Befehl als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_db_value(String anweisung)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate(anweisung);
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode gibts die Vertrags-ID zurück
	 * @return Die Vertrags-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_contact_vertrags_id()throws ClassNotFoundException, SQLException{
		return this.getVertragsnummer();
	}
	/**
	 * Diese Methode gibt das Datum zurück
	 * @return Das Datum als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_contact_wann()throws ClassNotFoundException, SQLException{
		return this.getWann();
	}
	/**
	 * Diese Methode gibt den Grund zurück
	 * @return Den Grund als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_contact_grund()throws ClassNotFoundException, SQLException{
		return this.getGrund();
	}
	/**
	 * Diese Methode gibt die Beschreibung zurück
	 * @return Die Beschreibung als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_contact_beschreibung()throws ClassNotFoundException, SQLException{
		return this.getBeschreibung();
	}
	/**
	 * Diese Methode gibt den Behobenstatus zurück
	 * @return Der Status als Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_contact_behoben()throws ClassNotFoundException, SQLException{
		return this.isBehoben();
	}
	/**
	 * Diese Methode ändert die Beschreibung
	 * @param kontakt_id Die Kontakt-ID als Integer
	 * @param beschreibung Die neue Beschreibung als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_contact_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE kontakt SET beschreibung = '"+beschreibung+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
	/**
	 * Diese Methode ändert den Behobenstatus
	 * @param kontakt_id Die Kontakt-ID als Integer
	 * @param behoben Den neuen Status als Integer. 1 = True, 0 = False
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_contact_behoben(int kontakt_id,int behoben)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE kontakt SET behoben = '"+behoben+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
	/**
	 * Diese Methode ändert die Vertrags-ID
	 * @param kontakt_id Die Kontakt-ID als Integer
	 * @param vertrags_id Die neue Vertrags-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_contact_vertrags_id(int kontakt_id,int vertrags_id)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE kontakt SET vertrags_id = '"+vertrags_id+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
		
	/**
	 * Diese Method gibt alle Kontakte zurück
	 * @return ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Kontaktdaten> get_display_contact() throws ClassNotFoundException, SQLException{
		return get_values(0,"");
	}
	/**
	 * Diese Methode erstellt einen Kontakt.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @param wann Der Zeitpunkt des Auftretens als String.
	 * @param grund Der Grund als String.
	 * @param beschreibung Die Beschreibung als String. Wenn nicht vorhanden dann leeren String " ".
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see set_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean set_kontakt_value(int vertrags_id,String wann,String grund, String beschreibung)throws ClassNotFoundException, SQLException{
		return set_db_value_for_contact("INSERT INTO kontakt(vertrags_id,wann,grund,beschreibung) VALUES('"+vertrags_id+"','"+wann+"','"+grund+"','"+beschreibung+"')");
		
	}
	/**
	 * Diese Methode gibt die Vertrags-ID zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Die Vertrags-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_contract_vertrags_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_vertrags_id()throws ClassNotFoundException, SQLException{
		return get_contact_vertrags_id();
	}
	/**
	 * Diese Methode gibt den Zeitpunkt des Auftretens zurück.
	 * @return Den Zeitpunkt als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_contact_wann
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_wann()throws ClassNotFoundException, SQLException{
		return get_contact_wann();
	}
	/**
	 * Diese Methode gibt den Grund des Kontaktes zurück.
	 * @return Den Grund als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_contact_grund
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_grund()throws ClassNotFoundException, SQLException{
		return get_contact_grund();
	}
	/**
	 * Diese Methode gibt die Beschreibung des Kontaktes zurück.
	 * @return Die Beschreibung als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_contact_beschreibung
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_beschreibung()throws ClassNotFoundException, SQLException{
		return get_contact_beschreibung();
	}
	/**
	 * Diese Methode gibt den Behobenstatus des Kontatks zurück.
	 * @return Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_contact_behoben
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_behoben()throws ClassNotFoundException, SQLException{
		return get_contact_behoben();
	}
	
	/**
	 * Diese Methode ändert die Beschreibung.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @param beschreibung Die Beschreibung als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_contact_beschreibung
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		return change_contact_beschreibung(kontakt_id,beschreibung);
	}
	/**
	 * Diese Methode ändert den Behobenstatus.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @param behoben Den Statuts als Integer. 0 = False, 1 = True.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_contact_behoben
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_behoben(int kontakt_id, int behoben)throws ClassNotFoundException, SQLException{
		return change_contact_behoben(kontakt_id,behoben);
	}
	/**
	 * Diese Methode ändert die Vertrags-ID
	 * @param kontakt_id Die Kontakt-ID als Integer
	 * @param vertrags_id Die neue Vertrags-ID als Integer
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_contact_vertrags_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_vertrags_id(int kontakt_id, int vertrags_id)throws ClassNotFoundException, SQLException{
		return change_contact_vertrags_id(kontakt_id,vertrags_id);
	}
	/**
	 * Diese Methode gibt alle Kontakte zurück. Kunden unspeziefisch.
	 * @return ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_display_contact
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Kontaktdaten> display_kontakt()throws ClassNotFoundException, SQLException{
		return get_display_contact();
	}
	/**
	 * Lädt einen spezifischen Kontakt
	 * @param kontakt_id Die Kontakts-ID als Integer
	 * @return Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean lade_daten(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_values(kontakt_id);
	}
	/**
	 * Lädt alle Kontakte zu einem spezifischen Vertrag
	 * @param vertrags_id als Integer
	 * @return eine ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see Kontaktdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Kontaktdaten>get_all_fuer_einen_vertrag(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_values(vertrags_id,"einer");
	}
}
