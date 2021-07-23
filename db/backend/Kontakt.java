package backend;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Kontaktdaten;

/**
 * @author Johann-Christian Münchhagen
 *
 */
public class Kontakt extends Kontaktdaten{
	public Kontakt() throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS kontakt(kontakts_id INTEGER PRIMARY KEY, vertrags_id INTEGER NOT NULL, wann TEXT NOT NULL,grund TEXT NOT NULL,beschreibung TEXT,behoben BOOLEAN)");
		connection.close();
	}
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
	private int get_contact_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		return this.getVertragsnummer();
	}
	private String get_contact_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		return this.getWann();
	}
	private String get_contact_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		return this.getGrund();
	}
	private String get_contact_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		return this.getBeschreibung();
	}
	private boolean get_contact_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		return this.isBehoben();
	}
	private boolean change_contact_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE kontakt SET beschreibung = '"+beschreibung+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
	private boolean change_contact_behoben(int kontakt_id,int behoben)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE kontakt SET behoben = '"+behoben+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
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
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_vertrags_id(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Zeitpunkt des Auftretens zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Den Zeitpunkt als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_wann(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Grund des Kontaktes zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Den Grund als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_grund(kontakt_id);
	}
	/**
	 * Diese Methode gibt die Beschreibung des Kontaktes zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Die Beschreibung als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_beschreibung(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Behobenstatus des Kontatks zurück.
	 * @param kontakt_id Die Kontakt-ID.
	 * @return Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean get_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_behoben(kontakt_id);
	}
	
	/**
	 * Diese Methode ändert die Beschreibung.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @param beschreibung Die Beschreibung als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
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
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_behoben(int kontakt_id, int behoben)throws ClassNotFoundException, SQLException{
		return change_contact_behoben(kontakt_id,behoben);
	}
	/**
	 * Diese Methode gibt alle Kontakte zurück. Kunden unspeziefisch.
	 * @return ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Kontaktdaten> display_kontakt()throws ClassNotFoundException, SQLException{
		return get_display_contact();
	}
	/**
	 * Lädt einen spezifischen Kontakt
	 * @param vertrags_id Die Vertrags-ID als Integer
	 * @return Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean lade_daten(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_values(vertrags_id);
	}
	/**
	 * Lädt alle Kontakte zu einem spezifischen Vertrag
	 * @param vertrags_id als Integer
	 * @return eine ArrayList vom Typ Kontaktdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Kontaktdaten>get_all_fuer_einen_vertrag(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_values(vertrags_id,"einer");
	}
}
