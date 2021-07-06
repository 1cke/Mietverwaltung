/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Johann Muenchhagen
 *
 */
public class Adresse {
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
	
	private String[] get_values(String anweisung) throws ClassNotFoundException, SQLException{
		String zwischenerg ="";
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		ResultSet rs = statement.executeQuery(anweisung);
		while(rs.next()) {
			zwischenerg = zwischenerg+rs.getString(1) + ",";
			//System.out.println(zwischenerg);//Kontrollausgabe
		}
		connection.close();
		//System.out.println(zwischenerg);
		String[] values = zwischenerg.split(",");
		//System.out.println(values[0]);
		return values;
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
		String wert = get_values("SELECT adress_id FROM adresse WHERE plz = '"+plz+"' AND ort = '"+ort+"' AND strasse = '"+strasse+"' AND hn = '" + hn+"'")[0];
		return Integer.parseInt(wert);
	}
	private String get_address_plz(int adress_id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT plz FROM adresse WHERE adress_id = '"+adress_id+"'")[0];
	}
	private String get_address_ort(int adress_id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT ort FROM adresse WHERE adress_id = '"+adress_id+"'")[0];
	}
	private String get_address_strasse(int adress_id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT strasse FROM adresse WHERE adress_id = '"+adress_id+"'")[0];
	}
	private String get_address_hn(int adress_id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT hn FROM adresse WHERE adress_id = '"+adress_id+"'")[0];
	}
	private void display_address_all()throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT adress_id FROM adresse");
		for(int i =0; i<werte.length;i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id +" "+get_address_plz(id)+" "+get_address_ort(id) + " "+get_address_strasse(id) + " "+get_address_hn(id));
			}
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
	public void display_adresse()throws ClassNotFoundException, SQLException{
		display_address_all();
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
