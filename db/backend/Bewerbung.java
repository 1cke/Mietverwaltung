package backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Bewerbungsdaten;
/**
 * Diese Methode stellt alle Daten zur Bewerbung bereit
 * @author Johann Muenchhagen
 * @version 1.0
 * @see Bewerbungsdaten
 */
public class Bewerbung extends Bewerbungsdaten{
	/**
	 * Diese Methode konstuiert die Klasse
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see initieren
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public Bewerbung() throws ClassNotFoundException, SQLException{
		initieren();
	}
	/**
	 * Diese Methode überprüft ob die Tabelle bewerbung in der Datenbank existiert.
	 * Wenn dies nicht der Fall ist, wird sie neu angelegt.
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
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS bewerbung(bewerbungs_id INTEGER PRIMARY KEY, kunden_id INTEGER NOT NULL,wohnungs_id INTEGER NOT NULL, datum TEXT NOT NULL,status Boolean)");
		connection.close();
	}
	/**
	 * Diese Methode erstellt einen Datenbankeintrag
	 * @param wohnungs_id Die Wohnungs-ID als Integer
	 * @param kunden_id Die Kunden-ID als Integer
	 * @param datum Das Datum als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean set_db_value(int wohnungs_id,int kunden_id,String datum)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate("INSERT INTO bewerbung(kunden_id,wohnungs_id,datum,status) VALUES ('"+kunden_id+"','"+wohnungs_id+"','"+datum+"',True)");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode lädt eine spezifische Bewerbung
	 * @param id Die Bewerbungs-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_values(int id) throws ClassNotFoundException, SQLException{
		try{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		ResultSet rs = statement.executeQuery("SELECT kunden_id,wohnungs_id,datum,status FROM bewerbung WHERE bewerbungs_id = '"+id+"'");
		while(rs.next()) {
			this.setKundenummer(rs.getInt(1));
			this.setWohnungsnummer(rs.getInt(2));
			this.setDatum(rs.getString(3));
			this.setStatus(rs.getBoolean(4));
		}
		connection.close();
		this.setId(id);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	/**
	 * Diese Methode lädt alle Bewerbungen die einer Wohnung zuzuordnen sind oder sie lädt sämtliche Bewerbungen
	 * @param wohnungs_id Die Wohnungs-ID als Integer
	 * @param typ Der Typ als String
	 * @return ArrayList vom Typ Bewerbungsdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Bewerbungsdaten> get_values(int wohnungs_id,String typ)throws ClassNotFoundException, SQLException{
		ArrayList<Bewerbungsdaten> daten = new ArrayList<Bewerbungsdaten>();
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		if(typ == "eine") {
			ResultSet rs = statement.executeQuery("SELECT bewerbungs_id,kunden_id,datum,status FROM bewerbung WHERE wohnungs_id = '"+wohnungs_id+"'");
			while(rs.next()) {
				Bewerbungsdaten b = new Bewerbungsdaten();
				b.setId(rs.getInt(1));
				b.setKundenummer(rs.getInt(2));
				b.setWohnungsnummer(wohnungs_id);
				b.setDatum(rs.getString(3));
				b.setStatus(rs.getBoolean(4));
				daten.add(b);
				
				}
			return daten;
			}
		else {
			ResultSet rs = statement.executeQuery("SELECT * FROM bewerbung");
			while(rs.next()) {
				Bewerbungsdaten b = new Bewerbungsdaten();
				b.setId(rs.getInt(1));
				b.setKundenummer(rs.getInt(2));
				b.setWohnungsnummer(rs.getInt(3));
				b.setDatum(rs.getString(4));
				b.setStatus(rs.getBoolean(5));
				daten.add(b);
			}
			return daten;
		}
	}
	/**
	 * Diese Methode ändert ein Atrribut in der Datenbank
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
	 * Diese Methode gibt die Bewerbungs-ID zurück
	 * @return Die Bewerbungs-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_apply_bewerbungs_id()throws ClassNotFoundException, SQLException{
		return this.getId();
	}
	/**
	 * Diese Methode gibt die Kunden-ID zurück
	 * @return Die Kunden-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_apply_bewerber_id()throws ClassNotFoundException, SQLException{
		return this.getKundenummer();
	}
	/**
	 * Diese Methode gibt die Wohnungs-ID zurück
	 * @return Die Wohnungs-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_apply_wohnungs_id()throws ClassNotFoundException, SQLException{
		return this.getWohnungsnummer();
	}
	/**
	 * Diese Methode gibt das Datum zurück
	 * @return Das Datum als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_apply_datum()throws ClassNotFoundException, SQLException{
		return this.getDatum();
	}
	/**
	 * Diese Methode gibt den Status zurück
	 * @return Den Status als Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_apply_status()throws ClassNotFoundException, SQLException{
		return this.isStatus();
	}
	/**
	 * Diese Methode ändert die Kunden-ID
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer
	 * @param bewerber_id Die neue Kunden-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_apply_bewerber_id(int bewerbungs_id,int bewerber_id)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE bewerbung SET kunden_id = '"+bewerber_id+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode ändert die Woihnungs-ID
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer
	 * @param wohnungs_id Die neue Wohnungs-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_apply_wohnungs_id(int bewerbungs_id,int wohnungs_id)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE bewerbung SET wohnungs_id = '"+wohnungs_id+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode ändert das Datum
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer
	 * @param datum Das neue Datum als String
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_apply_datum(int bewerbungs_id,String datum)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE bewerbung SET datum = '"+datum+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode ändert den Status
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer
	 * @param status Den neuen Status als Integer. 1 = True, 0 = False
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_apply_status(int bewerbungs_id,int status)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE bewerbung SET status = '"+status+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode löscht einen Datenbankeintrag
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean delete_value(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return change_db_value("DELETE FROM bewerbung WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode erstellt eine neue Bewerbung
	 * @param wohnungs_id Die Wohnungs-ID als Integer.
	 * @param kunden_id	Die Kunden-ID als Integer.
	 * @param datum Das Datum als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see set_db_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean set_bewerbung(int wohnungs_id,int kunden_id,String datum)throws ClassNotFoundException, SQLException{
		return set_db_value(wohnungs_id,kunden_id,datum);
	}
	/**
	 * Diese Methode gibt die Bewerbungs-ID zurück.
	 * @param wohnungs_id Die Wohnungs-ID als Integer.
	 * @param bewerber_id Die Kunden-ID als Integer.
	 * @return Die Bewerbungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_apply_bewerbungs_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_bewerbungs_id()throws ClassNotFoundException, SQLException{
		return get_apply_bewerbungs_id();
	}
	/**
	 * Diese Methode lädt eine spezifische Bewerbung.
	 * <p> Immer zu erst ausführen</p>
	 * @param id Die Bewerbungsnummer als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void lade_daten(int id) throws ClassNotFoundException, SQLException{
		get_values(id);
	}
	/**
	 * Diese Methode gibt die Kunden-ID zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_apply_bewerber_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_kunden_id()throws ClassNotFoundException, SQLException{
		return get_apply_bewerber_id();
	}
	/**
	 * Diese Methode gibt die Wohnungs-ID zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Die Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_apply_wohnungs_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_wohnungs_id()throws ClassNotFoundException, SQLException{
		return get_apply_wohnungs_id();
	}
	/**
	 * Diese Methode gibt das Datum der Bewerbung zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Das Datum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_apply_datum
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_datum()throws ClassNotFoundException, SQLException{
		return get_apply_datum();
	}
	/**
	 * Diese Methode gibt den Status der Bewerbung zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Den Status der Bewerbung als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_status()throws ClassNotFoundException, SQLException{
		return get_apply_status();
	}
	/**
	 * Diese Methode ändert die Bewerber-ID.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param bewerber_id Die neue Kunden-ID als Integer.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_apply_bewerber_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_bewerber_id(int bewerbungs_id,int bewerber_id)throws ClassNotFoundException, SQLException{
		return change_apply_bewerber_id(bewerbungs_id,bewerber_id);
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param wohnungs_id Die neue Wohnungs-ID als Integer.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_apply_wohnungs_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_wohnungs_id(int bewerbungs_id,int wohnungs_id)throws ClassNotFoundException, SQLException{
		return change_apply_wohnungs_id(bewerbungs_id,wohnungs_id);
	}
	/**
	 * Diese Methode ändert das Datum der Bewerbung.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param datum Das neue Datum als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_apply_datum
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_datum(int bewerbungs_id,String datum)throws ClassNotFoundException, SQLException{
		return change_apply_datum(bewerbungs_id,datum);
	}
	/**
	 * Diese Methode ändert den Status der Bewerbung
	 * @param bewerbungs_id Die Bewerbungs_id als Integer.
	 * @param status Den neuen Status als Integer. 0 = False, 1 = True
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_apply_status
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_status(int bewerbungs_id,int status)throws ClassNotFoundException, SQLException{
		return change_apply_status(bewerbungs_id,status);
	}
	/**
	 * Diese Methode löscht eine Bewerbung.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see delete_value
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean delete_bewerbung(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return delete_value(bewerbungs_id);
	}
	/**
	 * Diese Methode gibt eine ArrayList mit allen Bewerbungen für eine spezifische Wohnung an.
	 * @param wohnungs_id Die gewünschte Wohnung als Integer
	 * @return Eine ArrayList mit allen Bewerbungen.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Bewerbungsdaten> get_alle_bewerbung_fuer_eine_whg(int wohnungs_id)throws ClassNotFoundException, SQLException{
		return get_values(wohnungs_id,"eine");
	}
	/**
	 * Diese Methode gibt alle vorhanden Bewerbungen zurück.
	 * @return Eine ArrayList mit allen Bewerbungen
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see Bewerbungsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Bewerbungsdaten> get_all()throws ClassNotFoundException, SQLException{
		return get_values(0,"");
	}
}
