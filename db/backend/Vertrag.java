package backend;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Vertragsdaten;

/**
 * @author Johann Muenchhagen
 *
 */
public class Vertrag extends Vertragsdaten{
	public Vertrag() throws ClassNotFoundException, SQLException {
		initieren();
	}
	
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS vertrag(vertrags_id INTEGER PRIMARY KEY, kd_id INTEGER, whg_id INETEGER NOT NULL, Zeitraum TEXT NOT NULL,Schulden DOUBLE,aktiv BOOLEAN NOT NULL)");
		connection.close();
	}
	private void set_db_value_for_contract(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO vertrag (kd_id,whg_id, schulden,Zeitraum,aktiv) VALUES ('"+kd_id+"','"+whg_id+"','"+schulden+"','"+zeitraum+"','"+aktiv+"')");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	private void get_values(int vertrags_id) throws ClassNotFoundException, SQLException{
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
	}
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
	
	private void change_db_value_for_contract(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
		System.out.println("Änderungen erfolgreich gespeichert");
		connection.close();
	}
	private int get_vertrag_kd_id()throws ClassNotFoundException, SQLException{
		return this.getKundennummer();
	}
	private int get_vertrag_whg_id() throws ClassNotFoundException, SQLException{
		return this.getWohnungsnummer();
	}

	private String get_vertrag_zeitraum()throws ClassNotFoundException, SQLException{
		return this.getZeitraum();
	}
	private double get_vertrag_schulden()throws ClassNotFoundException, SQLException{
		return this.getSchulden();
	}
	private boolean get_vertrag_aktiv()throws ClassNotFoundException, SQLException{
		return this.isAktiv();
	}
	private void get_vertrag_all() throws ClassNotFoundException, SQLException{
		System.out.println(get_values(0,""));
	}
	private ArrayList<Vertragsdaten> get_vertrag_all_whg_by_kd_id(int kd_id) throws ClassNotFoundException, SQLException{
		return get_values(kd_id,"kd");
	}
	private void change_vertrag_kd_id(int id, int kd_id) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET kd_id = '"+kd_id+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_whg_id(int id, int whg_id) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET whg_id = '"+whg_id+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_zeitraum(int id, String zeitraum) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET zeitraum = '"+zeitraum+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_schulden(int id, double schulden) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET schulden = '"+schulden+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_aktiv(int id, int aktiv) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET aktiv = '"+aktiv+"' WHERE kd_id = '"+id+"'");
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
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int set_db_value(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		set_db_value_for_contract(kd_id,whg_id,schulden,zeitraum,aktiv);
		return this.getId();
	}
	public void lade_vertrags_daten(int vertragsnummer) throws ClassNotFoundException, SQLException{
		get_values(vertragsnummer);
	}
	/**
	 * Diese Methode gibt die zugeordnete Kunden-ID zurück.
	 * <p> Return wird noch bearbeitet</p>
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_kd_id() throws ClassNotFoundException, SQLException {
		return get_vertrag_kd_id();
	}
	/**
	 * Diese Methode gibt die zugeordnete Wohnungs-ID zurück.
	 * @return DIe Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
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
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Vertragsdaten> get_all_whg(int kd_nr) throws ClassNotFoundException, SQLException{
		return get_vertrag_all_whg_by_kd_id(kd_nr);
	}
	/**
	 * Diese Methode gibt alle Verträge und dazugehörige Daten aus
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void get_all()throws ClassNotFoundException, SQLException{
		get_vertrag_all();
	}
	/**
	 * Diese Methode ändert die Kunden-ID.
	 * @param id	Die Vertrags-ID als Integer.
	 * @param kd_nr	Die neue Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_kundennummer(int id, int kd_nr)throws ClassNotFoundException, SQLException {
		change_vertrag_kd_id(id,kd_nr);
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id	Die Vertrags-ID als Integer.
	 * @param wohnungsnummer	Die neue Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_wohnungsnummer(int id, int wohnungsnummer) throws ClassNotFoundException, SQLException{
		change_vertrag_whg_id(id,wohnungsnummer);
	}
	/**
	 * Diese Methode ändert den Zeitraum.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-ID als Integer.
	 * @param zeitraum Den neuen Zeitraum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_zeitraum(int id,String zeitraum)throws ClassNotFoundException, SQLException{
		change_vertrag_zeitraum(id,zeitraum);
	}
	/**
	 * Diese Methode ändert den Schuldenwert.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-ID als Integer.
	 * @param schulden Die neuen Schulden als Double
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_schulden(int id, double schulden)throws ClassNotFoundException, SQLException{
		change_vertrag_schulden(id,schulden);
	}
	/**
	 * Diese Methode ändert den aktiv Status.
	 * <p>Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-Id als Integer.
	 * @param aktiv	Den neuen Status als Integer. 0 = false, 1 = True
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_aktiv(int id, int aktiv)throws ClassNotFoundException, SQLException{
		change_vertrag_aktiv(id,aktiv);
	}
}
