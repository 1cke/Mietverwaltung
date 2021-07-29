package backend;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Vertragsdaten;

/**
 * Diese Klasse stellt informationen zu den Verträgen bereit
 * @author Johann Muenchhagen
 * @version 1.0
 * @see Vertragsdaten
 */
public class Vertrag extends Vertragsdaten{
	/**
	 * Diese Methode konstruiert die Klasse
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see initieren
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public Vertrag() throws ClassNotFoundException, SQLException {
		initieren();
	}
	/**
	 * Diese Methode überprüft ob die Tabelle vertrag in der Datenbank enthalten ist. Wenn dies nicht der Fall ist, wird die Tabelle neu angelegt.
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
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS vertrag(vertrags_id INTEGER PRIMARY KEY, kd_id INTEGER, whg_id INETEGER NOT NULL, Zeitraum TEXT NOT NULL,Schulden DOUBLE,aktiv BOOLEAN NOT NULL)");
		connection.close();
	}
	/**
	 * Diese Methode erstellt einen neuen Datenbank eintrag
	 * @param kd_id Die Kunden-ID als Integer.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param schulden Die Schulden als Double.
	 * @param zeitraum Den Zeitraum als String
	 * @param aktiv Den Aktivstatus als Integer. 1 = True, 0 = False
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean set_db_value_for_contract(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate("INSERT INTO vertrag (kd_id,whg_id, schulden,Zeitraum,aktiv) VALUES ('"+kd_id+"','"+whg_id+"','"+schulden+"','"+zeitraum+"','"+aktiv+"')");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	/**
	 * Diese Methode lädt alle Daten zu einem spezifischen Vertrag aus der Datenbank, wenn die Vertrags-ID bekannt ist.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return Boolean als Funktionsindikator.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_values(int vertrags_id) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT kd_id,whg_id,Zeitraum,schulden,aktiv FROM vertrag WHERE vertrags_id = '"+vertrags_id+"'");
			while(rs.next()) {
				this.setKundennummer(rs.getInt(1));
				this.setWohnungsnummer(rs.getInt(2));
				this.setZeitraum(rs.getString(3));
				this.setSchulden(rs.getDouble(4));
				this.setAktiv(rs.getBoolean(5));
			}
			connection.close();
			this.setId(vertrags_id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	/**
	 * Diese Methode lädt entweder alle Verträge, die einer Kundennummer zuzuordnen sind, 
	 * oder sämtliche vorhandene Verträge aus der DAtenbank
	 * @param kundennummer Die Kunden-ID als String.
	 * @param Typ Den Typ als String.
	 * @return ArrayList vom Typ Vertragsdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Vertragsdaten>get_values(int kundennummer,String Typ)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ArrayList<Vertragsdaten> daten = new ArrayList<Vertragsdaten>();
		if(Typ == "kd") {
			ResultSet rs = statement.executeQuery("SELECT vertrags_id,whg_id,Zeitraum,schulden,aktiv FROM vertrag WHERE kd_id = '"+kundennummer+"'");
			while(rs.next()) {
				Vertragsdaten v = new Vertragsdaten();
				v.setId(rs.getInt(1));
				v.setKundennummer(kundennummer);
				v.setWohnungsnummer(rs.getInt(2));
				v.setZeitraum(rs.getString(3));
				v.setSchulden(rs.getDouble(4));
				v.setAktiv(rs.getBoolean(5));
				daten.add(v);
			}
			connection.close();
			return daten;
		}else {
			ResultSet rs = statement.executeQuery("SELECT * FROM vertrag");
			while(rs.next()) {
				Vertragsdaten v = new Vertragsdaten();
				v.setId(rs.getInt(1));
				v.setKundennummer(rs.getInt(2));
				v.setWohnungsnummer(rs.getInt(3));
				v.setZeitraum(rs.getString(4));
				v.setSchulden(rs.getDouble(5));
				v.setAktiv(rs.getBoolean(6));
				daten.add(v);
			}
			connection.close();
			return daten;
		}
	}
	/**
	 * Diese Methode ändert ein Attribut in der Datenbank
	 * @param anweisung Den SQL-Befehl
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_db_value_for_contract(String anweisung)throws ClassNotFoundException, SQLException{
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
	 * Diese Methode gibt die Kunden-ID zurück
	 * @return Die Kunden-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_vertrag_kd_id()throws ClassNotFoundException, SQLException{
		return this.getKundennummer();
	}
	/**
	 * Diese Methode gibt die Wohnungs-ID zurück
	 * @return Die Wohnungs-ID als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private int get_vertrag_whg_id() throws ClassNotFoundException, SQLException{
		return this.getWohnungsnummer();
	}
	/**
	 * Diese Methode gibt den Zeitraum zurück
	 * @return Den Zeitraum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private String get_vertrag_zeitraum()throws ClassNotFoundException, SQLException{
		return this.getZeitraum();
	}
	/**
	 * Diese Methode gibt die Schulden zurück.
	 * @return Die Schulden als Double
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private double get_vertrag_schulden()throws ClassNotFoundException, SQLException{
		return this.getSchulden();
	}
	/**
	 * Diese Methode gibt den Aktivstatus zurück
	 * @return Den Aktivstatus als Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean get_vertrag_aktiv()throws ClassNotFoundException, SQLException{
		return this.isAktiv();
	}
	/**
	 * Diese Methode gibt alle Verträge zurück
	 * @return ArrayList vom Typ Vertragsdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Vertragsdaten> get_vertrag_all() throws ClassNotFoundException, SQLException{
		return get_values(0,"");
	}
	/**
	 * Diese Methode gibt alle Verträge, die einer Kundennummer zuzuordnen sind, zurück
	 * @param kd_id Die Kunden-ID als Integer
	 * @return ArrayList vom Typ Vertragsdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see Vertragsdaten
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private ArrayList<Vertragsdaten> get_vertrag_all_whg_by_kd_id(int kd_id) throws ClassNotFoundException, SQLException{
		return get_values(kd_id,"kd");
	}
	/**
	 * Diese Methode ändert die Kunden-ID in der Datenbank
	 * @param id Die Vertrags-ID als Integer.
	 * @param kd_id Die neue Kunden-ID als Integer.
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_vertrag_kd_id(int id, int kd_id) throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("UPDATE vertrag SET kd_id = '"+kd_id+"' WHERE vertrags_id = '"+id+"'");
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID in der Datenbank
	 * @param id Die Vertrags-ID als Integer.
	 * @param whg_id Die neue Wohnungs-ID als Integer.
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_vertrag_whg_id(int id, int whg_id) throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("UPDATE vertrag SET whg_id = '"+whg_id+"' WHERE vertrags_id = '"+id+"'");
	}
	/**
	 * Diese Methode ändert den Zeitraum in der Datenbank
	 * @param id Die Vertrags-ID als Integer.
	 * @param zeitraum Den neuen Zeitraum als String.
	 * @return Boolean als Funktionsindikator.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_vertrag_zeitraum(int id, String zeitraum) throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("UPDATE vertrag SET zeitraum = '"+zeitraum+"' WHERE vertrags_id = '"+id+"'");
	}
	/**  
	 * Diese Methode änder die Schulden in der Datenbank
	 * @param id Die Vertrags-ID als Integer.
	 * @param schulden Die neuen Schulden als Double.
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_vertrag_schulden(int id, double schulden) throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("UPDATE vertrag SET schulden = '"+schulden+"' WHERE vertrags_id = '"+id+"'");
	}
	/**
	 * Diese Methode ändert den Aktivstatus in der Datenbank
	 * @param id Die Vertrags-ID als Integer.
	 * @param aktiv Den neuen Status als Integer. 1 = True, 0 = False
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean change_vertrag_aktiv(int id, int aktiv) throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("UPDATE vertrag SET aktiv = '"+aktiv+"' WHERE vertrags_id = '"+id+"'");
	}
	/**
	 * Diese Methode löscht einen Vertrag in der Datenbank
	 * @param vertrags_id Die zu löschende Vertrags-ID.
	 * @return Boolean als Funktionsindikator
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	private boolean delete_contract(int vertrags_id)throws ClassNotFoundException, SQLException{
		return change_db_value_for_contract("DELETE FROM vertrag WHERE vertrags_id = '"+vertrags_id+"'");
	}
	/**
	 * Diese Methode legt einen Vertrag an.
	 * @param kd_id Die Kunden-ID als Integer.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param schulden	Die Höhe der Schulden als Double.
	 * @param zeitraum	Den Zeitraum als String.
	 * @param aktiv	Den Status als Integer. 0 = False, 1 = True.
	 * @return Die ID des Vertrages als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see set_db_value_for_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int set_db_value(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		set_db_value_for_contract(kd_id,whg_id,schulden,zeitraum,aktiv);
		return this.getId();
	}
	/**
	 * Diese Methode lädt alle Vertragsdaten für einen spezifischen Vertrag.
	 * <p><h1>Immer zu erst ausführen! Wenn nur ein Vertrag geladen werden soll.</h1></p>
	 * @param vertragsnummer
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_values
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean lade_vertrags_daten(int vertragsnummer) throws ClassNotFoundException, SQLException{
		return get_values(vertragsnummer);
	}
	/**
	 * Diese Methode gibt die zugeordnete Kunden-ID zurück.
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_kd_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_kd_id() throws ClassNotFoundException, SQLException {
		return get_vertrag_kd_id();
	}
	/**
	 * Diese Methode gibt die zugeordnete Wohnungs-ID zurück.
	 * @return Die Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_whg_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_whg_id() throws ClassNotFoundException, SQLException{
		return get_vertrag_whg_id();
	}
	/**
	 * Diese Methode gibt den Zeitraum zurück.
	 * <p> Im sinne von aktiv seit oder war Kunde von xy bis yz.
	 * @return Den Zeitraum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_zeitraum
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_zeitraum() throws ClassNotFoundException, SQLException{
		return get_vertrag_zeitraum();
	}
	/**
	 * Diese Methode gibt die Höhe der Schulden zurück.
	 * @return Die Schulden als Double. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_schulden
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public double get_schulden()throws ClassNotFoundException, SQLException{
		return get_vertrag_schulden();
	}
	/**
	 * Diese Methode gibt den Vertragsstatus zurück.
	 * @return	Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_aktiv
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_aktiv()throws ClassNotFoundException, SQLException{
		return get_vertrag_aktiv();
	}
	/**
	 * Diese Methode gibt alle Verträge von einem Kunden zurück.
	 * @param kd_nr Die Kunden-ID als Integer.
	 * @return	Ein Integerarray mit allen zugeordneten Vertrags-IDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_all_whg_by_kd_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Vertragsdaten> get_all_whg(int kd_nr) throws ClassNotFoundException, SQLException{
		return get_vertrag_all_whg_by_kd_id(kd_nr);
	}
	/**
	 * Diese Methode gibt alle Verträge und dazugehörige Daten aus
	 * @return ArrayList vom Typ Vertragsdaten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see get_vertrag_all
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Vertragsdaten> get_all()throws ClassNotFoundException, SQLException{
		return get_vertrag_all();
	}
	/**
	 * Diese Methode ändert die Kunden-ID.
	 * @param id	Die Vertrags-ID als Integer.
	 * @param kd_nr	Die neue Kunden-ID als Integer.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_vertrag_kd_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_kundennummer(int id, int kd_nr)throws ClassNotFoundException, SQLException {
		return change_vertrag_kd_id(id,kd_nr);
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID.
	 * @param id	Die Vertrags-ID als Integer.
	 * @param wohnungsnummer	Die neue Wohnungs-ID als Integer.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_vertrag_whg_id
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_wohnungsnummer(int id, int wohnungsnummer) throws ClassNotFoundException, SQLException{
		return change_vertrag_whg_id(id,wohnungsnummer);
	}
	/**
	 * Diese Methode ändert den Zeitraum.
	 * @param id Die Vertrags-ID als Integer.
	 * @param zeitraum Den neuen Zeitraum als String.
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_vertrag_zeitraum
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_zeitraum(int id,String zeitraum)throws ClassNotFoundException, SQLException{
		return change_vertrag_zeitraum(id,zeitraum);
	}
	/**
	 * Diese Methode ändert den Schuldenwert.
	 * @param id Die Vertrags-ID als Integer.
	 * @param schulden Die neuen Schulden als Double
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_vertrag_schulden
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_schulden(int id, double schulden)throws ClassNotFoundException, SQLException{
		return change_vertrag_schulden(id,schulden);
	}
	/**
	 * Diese Methode ändert den aktiv Status.
	 * @param id Die Vertrags-Id als Integer.
	 * @param aktiv	Den neuen Status als Integer. 0 = false, 1 = True
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see change_vertrag_aktiv
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_aktiv(int id, int aktiv)throws ClassNotFoundException, SQLException{
		return change_vertrag_aktiv(id,aktiv);
	}
	/**
	 * Löscht einen Vertrag
	 * @param vertrags_id Integer
	 * @return Boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see delete_contract
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean delete(int vertrags_id)throws ClassNotFoundException, SQLException{
		return delete_contract(vertrags_id);
	}
}
