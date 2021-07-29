package backend;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Anschrift;

/**
 * Diese Klasse stellt alle Daten zur Adresse bereit
 * @author Johann Muenchhagen
 * @version 1.0
 * @see Anschrift
 * 
 */
public class Adresse extends Anschrift{
	/**
	 * Diese Methode Konstruiert die Klasse
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see initieren
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public Adresse()throws ClassNotFoundException, SQLException{
		initieren();
	}
	/**
	 * Diese Methode überprüft ob die Tabelle adresse in der Datenbank existiert. 
	 * Wenn dies nicht der Fall ist, wird die Tabelle neu angelget
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
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS adresse(adress_id INTEGER PRIMARY KEY, plz TEXT NOT NULL, ort TEXT NOT NULL,strasse TEXT NOT NULL,hn TEXT NOT NULL)");
		connection.close();
	}
	/**
	 * Diese Methode legt eine neue Adresse in der Datenbank an
	 * @param plz Die Postleitzahl als String
	 * @param ort Den Ort als String
	 * @param strasse Die Straße als String
	 * @param hn Die Hausnummer als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean set_db_value_for_address(String plz,String ort,String strasse, String hn)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate("INSERT INTO adresse (plz,ort, strasse,hn) VALUES ('"+plz+"','"+ort+"','"+strasse+"','"+hn+"')");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	
	}
	/**
	 * Diese Methode lädt eine Adresse, bei unbekannter Adress-ID
	 * @param plz Die Postleitzahl als String
	 * @param ort Den Ort als String
	 * @param strasse Die Straße als String
	 * @param hn Die Hausnummer als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_values(String plz, String ort, String strasse, String hn) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT adress_id FROM adresse WHERE plz = '"+plz+"' AND ort = '"+ort+"' AND strasse = '"+strasse+"' AND hn = '" + hn+"'");
			while(rs.next()) {
				this.setId(rs.getInt(1));
			}
			connection.close();
			this.setPlz(plz);
			this.setOrt(ort);
			this.setStrasse(strasse);
			this.setHausnummer(hn);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode lädt alle Adressen
	 * @return ArrayList vom Typ Anschrift
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Anschrift> get_all_values() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT * FROM adresse");
		ArrayList<Anschrift> daten = new ArrayList<Anschrift>();
		while(rs.next()) {
			Anschrift a = new Anschrift();
			a.setId(rs.getInt(1));
			a.setPlz(rs.getString(2));
			a.setOrt(rs.getString(3));
			a.setStrasse(rs.getString(4));
			a.setHausnummer(rs.getString(5));
			daten.add(a);
		}
		connection.close();
		return daten;
	}
	/**
	 * Diese Methode lädt die Adresse bei bekannter Adress-ID
	 * @param id Die Adress-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_adresse(int id) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT plz,ort,strasse,hn FROM adresse WHERE adress_id = '"+id+"'");
			while(rs.next()) {
				this.setId(id);
				this.setPlz(rs.getString(1));
				this.setOrt(rs.getString(2));
				this.setStrasse(rs.getString(3));
				this.setHausnummer(rs.getString(4));
			}
			connection.close();
			return true;
		}catch(Exception e) {return false;}
		
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
	private boolean change_db_value_for_address(String anweisung)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate(anweisung);
			System.out.println("Änderungen erfolgreich gespeichert");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode löscht einen Datenbankeintrag
	 * @param id Die zu löschende Adress-ID
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private boolean delete_db_value(int id) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate("DELETE FROM adresse WHERE adress_id = '"+ id+"'");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode lädt eine Adresse und gibt die Adress-ID zurück.
	 * @param plz Die Postleitzahl als String
	 * @param ort Den Ort als String
	 * @param strasse Die Straße als String
	 * @param hn Die Hausnummer als String
	 * @return Die Adress-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_address_adress_id(String plz, String ort, String strasse, String hn) throws ClassNotFoundException, SQLException{
		get_values(plz,ort,strasse,hn);
		return this.getId();
	}
	/**
	 * Diese Methode gibt die Postleitzahl zurück
	 * @return Die Postleitzahl als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_address_plz() throws ClassNotFoundException, SQLException{
		return this.getPlz();
	}
	/**
	 * Diese Methode gibt den Ort zurück
	 * @return Der Ort als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_address_ort() throws ClassNotFoundException, SQLException{
		return this.getOrt();
	}
	/**
	 * Diese Methode gibt die Straße zurück
	 * @return Die Straße als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_address_strasse() throws ClassNotFoundException, SQLException{
		return this.getStrasse();
	}
	/**
	 * Diese Methode gibt die Hausnummer zurück
	 * @return Die Hausnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_address_hn() throws ClassNotFoundException, SQLException{
		return this.getHausnummer();
	}
	/**
	 * Diese Methode gibt alle Adressen zurück
	 * @return ArrayList vom Typ Anschrift
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Anschrift
	 * @see get_all_values
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Anschrift> display_address_all()throws ClassNotFoundException, SQLException{
		return get_all_values();
	}
	/**
	 * Diese Methode ändert die Postleitzahl
	 * @param adress_id Die Adress-ID als Integer
	 * @param plz Die neue Postleitzahl als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_address
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_address_plz(int adress_id,String plz)throws ClassNotFoundException, SQLException{
		return change_db_value_for_address("UPDATE adresse SET plz = '"+plz+"' WHERE adress_id = '"+adress_id+"'");
	}
	/**
	 * Diese Methode ändert den Ort
	 * @param adress_id Adress-ID als Integer
	 * @param ort Der neue Ort als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_address
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_address_ort(int adress_id,String ort)throws ClassNotFoundException, SQLException{
		return change_db_value_for_address("UPDATE adresse SET ort = '"+ort+"' WHERE adress_id = '"+adress_id+"'");
	}
	/**
	 * Diese Methode ändert die Straße
	 * @param adress_id Adress-ID als Integer
	 * @param strasse Die neue Straße als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_address
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_address_strasse(int adress_id,String strasse)throws ClassNotFoundException, SQLException{
		return change_db_value_for_address("UPDATE adresse SET strasse = '"+strasse+"' WHERE adress_id = '"+adress_id+"'");
	}
	/**
	 * Diese Methode änder die Hausnummer
	 * @param adress_id Adress-ID als Integer
	 * @param hn Die neue Hausnummer als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_address
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_address_hn(int adress_id,String hn)throws ClassNotFoundException, SQLException{
		return change_db_value_for_address("UPDATE adresse SET hn = '"+hn+"' WHERE adress_id = '"+adress_id+"'");
	}
	/**
	 * Diese Methode erstellt einen neuen Datenbankeintrag.
	 * @param plz Die Postleitzahl des Ortes als String.
	 * @param ort	Den Ortsnamen als String.
	 * @param strasse Die Straße als String.
	 * @param hn	Die Hausnummer als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see set_db_value_for_address
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean set_address_value(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		return set_db_value_for_address(plz,ort,strasse,hn);
	}
	/**
	 * Diese Methode gibt die Adress-ID zurück
	 * @param plz	Die Postleitzahl als String.
	 * @param ort	Den Ort als String.
	 * @param strasse	Die Straße als String.
	 * @param hn	Die Hausnummer als String.
	 * @return	Die Address-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_address_adress_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_adress_id(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		return get_address_adress_id(plz,ort,strasse,hn);
	}
	/**
	 * Diese Methode gibt die Postleizahl zurück.
	 * @return Die Postleizahl als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_address_plz
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_plz()throws ClassNotFoundException, SQLException{
		return get_address_plz();
	}
	/**
	 * Diese Methode gibt den Ort zurück.
	 * @return Den Ort als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_address_ort
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_ort()throws ClassNotFoundException, SQLException{
		return get_address_ort();
	}
	/**
	 * Diese Methode gibt die Straße zurück.
	 * @return Die Straße als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_address_strasse
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_strasse()throws ClassNotFoundException, SQLException{
		return get_address_strasse();
	}
	/**
	 * Diese Methode gibt die Hausnummer zurück.
	 * @return Die Hausnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_address_hn
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_hn()throws ClassNotFoundException, SQLException{
		return get_address_hn();
	}
	/**
	 * Diese Methode gibt alle Datenbankeinträge aus.
	 * @return ArrayList vom Typ Anschrift
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see display_address_all
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Anschrift> display_adresse()throws ClassNotFoundException, SQLException{
		return display_address_all();
	}
	/**
	 * Diese Methode ändert die Postleitzahl.
	 * @param adress_id Die Adress-ID als Integer
	 * @param plz Die neue Postleitzahl als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_address_plz
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_plz(int adress_id, String plz)throws ClassNotFoundException, SQLException{
		return change_address_plz(adress_id,plz);
	}
	/**
	 * Diese Methode ändert den Ort.
	 * @param adress_id Die Adress-ID als Integer
	 * @param ort Den neuen Ort als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_address_ort
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_ort(int adress_id, String ort)throws ClassNotFoundException, SQLException{
		return change_address_ort(adress_id,ort);
	}
	/**
	 * Diese Methode ändert die Straße.
	 * @param adress_id Die Adress-ID als Integer.
	 * @param strasse Die neue Straße als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_address_strasse
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_strasse(int adress_id, String strasse)throws ClassNotFoundException, SQLException{
		return change_address_strasse(adress_id,strasse);
	}
	/**
	 * Diese Methode ändert die Hausnummer.
	 * @param adress_id Die Adress-ID als Intger.
	 * @param hn Die neue Hausnummer als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_address_hn
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_hn(int adress_id, String hn)throws ClassNotFoundException, SQLException{
		return change_address_hn(adress_id,hn);
	}
	/**
	 * Diese Methode löscht eine Adresse.
	 * @param id Die Adress-ID als Integer.
	 * @return Boolean. Hat geklappt oder nicht
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see delete_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean delete_addresse(int id) throws ClassNotFoundException, SQLException{
		return delete_db_value(id);
	}
	/**
	 * Diese Methode lädt alle Adressdaten zu einer spezifischen Adresse.
	 * @param id Die Adress-ID als Integer
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_adresse
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean lade_adresse(int id)throws ClassNotFoundException, SQLException{
		return get_adresse(id);
	}
}
