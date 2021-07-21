package backend;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Anschrift;

/**
 * @author Johann Muenchhagen
 *
 */
public class Adresse extends Anschrift{
	public Adresse()throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS adresse(adress_id INTEGER PRIMARY KEY, plz TEXT NOT NULL, ort TEXT NOT NULL,strasse TEXT NOT NULL,hn TEXT NOT NULL)");
		connection.close();
	}
	private void set_db_value_for_address(String plz,String ort,String strasse, String hn)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO adresse (plz,ort, strasse,hn) VALUES ('"+plz+"','"+ort+"','"+strasse+"','"+hn+"')");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	
	private void get_values(String plz, String ort, String strasse, String hn) throws ClassNotFoundException, SQLException{
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
	}
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
	private void change_db_value_for_address(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
		System.out.println("Änderungen erfolgreich gespeichert");
		connection.close();
	}
	private void delete_db_value(int id) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("DELETE FROM adresse WHERE adress_id = '"+ id+"'");
		System.out.println("Adresse erfolgreich gelöscht");
		connection.close();
	}
	private int get_address_adress_id(String plz, String ort, String strasse, String hn) throws ClassNotFoundException, SQLException{
		get_values(plz,ort,strasse,hn);
		return this.getId();
	}
	private String get_address_plz(int adress_id) throws ClassNotFoundException, SQLException{
		return this.getPlz();
	}
	private String get_address_ort(int adress_id) throws ClassNotFoundException, SQLException{
		return this.getOrt();
	}
	private String get_address_strasse(int adress_id) throws ClassNotFoundException, SQLException{
		return this.getStrasse();
	}
	private String get_address_hn(int adress_id) throws ClassNotFoundException, SQLException{
		return this.getHausnummer();
	}
	private ArrayList<Anschrift> display_address_all()throws ClassNotFoundException, SQLException{
		return get_all_values();
	}
	private void change_address_plz(int adress_id,String plz)throws ClassNotFoundException, SQLException{
		change_db_value_for_address("UPDATE adresse SET plz = '"+plz+"' WHERE adress_id = '"+adress_id+"'");
	}
	private void change_address_ort(int adress_id,String ort)throws ClassNotFoundException, SQLException{
		change_db_value_for_address("UPDATE adresse SET ort = '"+ort+"' WHERE adress_id = '"+adress_id+"'");
	}
	private void change_address_strasse(int adress_id,String strasse)throws ClassNotFoundException, SQLException{
		change_db_value_for_address("UPDATE adresse SET strasse = '"+strasse+"' WHERE adress_id = '"+adress_id+"'");
	}
	private void change_address_hn(int adress_id,String hn)throws ClassNotFoundException, SQLException{
		change_db_value_for_address("UPDATE adresse SET hn = '"+hn+"' WHERE adress_id = '"+adress_id+"'");
	}
	/**
	 * Diese Methode erstellt einen neuen Datenbankeintrag.
	 * @param plz Die Postleitzahl des Ortes als String.
	 * @param ort	Den Ortsnamen als String.
	 * @param strasse Die Straße als String.
	 * @param hn	Die Hausnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void set_address_value(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		set_db_value_for_address(plz,ort,strasse,hn);
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
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_adress_id(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		return get_address_adress_id(plz,ort,strasse,hn);
	}
	/**
	 * Diese Methode gibt die Postleizahl zurück.
	 * @param adress_id Die Adress-ID als Integer
	 * @return Die Postleizahl als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_plz(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_plz(adress_id);
	}
	/**
	 * Diese Methode gibt den Ort zurück.
	 * @param adress_id Die Adress-ID als Integer
	 * @return Den Ort als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_ort(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_ort(adress_id);
	}
	/**
	 * Diese Methode gibt die Straße zurück.
	 * @param adress_id Die Adress-ID als Integer.
	 * @return Die Straße als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_strasse(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_strasse(adress_id);
	}
	/**
	 * Diese Methode gibt die Hausnummer zurück.
	 * @param adress_id Die Adress-ID als Integer
	 * @return Die Hausnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_hn(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_hn(adress_id);
	}
	/**
	 * Diese Methode gibt alle Datenbankeinträge aus.
	 * <p> Es werden keine Parameter übergeben </p>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Anschrift> display_adresse()throws ClassNotFoundException, SQLException{
		return display_address_all();
	}
	/**
	 * Diese Methode ändert die Postleitzahl.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param adress_id Die Adress-ID als Integer
	 * @param plz Die neue Postleitzahl als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_plz(int adress_id, String plz)throws ClassNotFoundException, SQLException{
		change_address_plz(adress_id,plz);
	}
	/**
	 * Diese Methode ändert den Ort.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param adress_id Die Adress-ID als Integer
	 * @param ort Den neuen Ort als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_ort(int adress_id, String ort)throws ClassNotFoundException, SQLException{
		change_address_ort(adress_id,ort);
	}
	/**
	 * Diese Methode ändert die Straße.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param adress_id Die Adress-ID als Integer.
	 * @param strasse Die neue Straße als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_strasse(int adress_id, String strasse)throws ClassNotFoundException, SQLException{
		change_address_strasse(adress_id,strasse);
	}
	/**
	 * Diese Methode ändert die Hausnummer.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param adress_id Die Adress-ID als Intger.
	 * @param hn Die neue Hausnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_hn(int adress_id, String hn)throws ClassNotFoundException, SQLException{
		change_address_hn(adress_id,hn);
	}
	/**
	 * Diese Methode löscht eine Adresse.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id Die Adress-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void delete_addresse(int id) throws ClassNotFoundException, SQLException{
		delete_db_value(id);
	}
}
