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
public class Kunden {

	public Kunden()throws ClassNotFoundException, SQLException {
		initieren();
	}
	
	private void initieren()throws ClassNotFoundException, SQLException{
		/*
		 * initiere die Tabelle Kunden
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//erstelle eine Tabelle Kunden wenn diese nicht bereits existiert
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS kunden(kd_id INTEGER PRIMARY KEY, vorname TEXT NOT NULL, nachname TEXT NOT NULL,geburtstag TEXT NOT NULL, telefon TEXT)");
		connection.close();
	}
	
	private void set_db_value_for_kd(String vorname, String nachname, String geburtstag, String telefon )throws ClassNotFoundException, SQLException{
		/*
		 * speicher den Vornamen, Nachnamen und Geburtstag in die Tabelle Kunden
		 * alle Werte als String übergeben
		 */
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO kunden (vorname,nachname, geburtstag,telefon) VALUES ('"+vorname+"','"+nachname+"','"+geburtstag+"','"+telefon+"')");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	private int get_kd_id(String vorname, String nachname, String geburtstag, String telefon)throws ClassNotFoundException, SQLException {
		/*
		 * gebe die ID des Kunden aus
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT kd_id FROM kunden WHERE vorname = '"+vorname+"' AND nachname = '"+nachname+"' AND geburtstag = '"+geburtstag+"' AND telefon = '"+telefon+"'");
		rs.next();
		int id = rs.getInt(1);
		connection.close();
		return id;
	}
	private String get_kd_vorname(int id) throws ClassNotFoundException, SQLException{
		/*
		 * gebe den Vornamen des Kunden mit der ID zurück
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT vorname FROM kunden WHERE kd_id = '"+id+"'");
		String vorname = rs.getString(1);
		connection.close();
		return vorname;
	}
	private String get_kd_nachname(int id) throws ClassNotFoundException, SQLException{
		/*
		 * gebe den Nachnamen des Kunden mit der ID zurück
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT nachname FROM kunden WHERE kd_id = '"+id+"'");
		String nachname = rs.getString(1);
		connection.close();
		return nachname;
	}
	
	private String get_kd_geburtstag(int id) throws ClassNotFoundException, SQLException{
		/*
		 * gebe den Geburtstag des Kunden mit der ID zurück
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT geburtstag FROM kunden WHERE kd_id = '"+id+"'");
		String geburtstag = rs.getString(1);
		connection.close();
		return geburtstag;
	}
	private String get_kd_telefon(int id) throws ClassNotFoundException, SQLException{
		/*
		 * gebe die Telefonnummer des Kunden mit der ID zurück
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT telefon FROM kunden WHERE kd_id = '"+id+"'");
		String telefon = rs.getString(1);
		connection.close();
		return telefon;
	}
	private void change_kd_vorname(int id,String vorname) throws ClassNotFoundException, SQLException{
		/*
		 * Ändere den Vornamen des Kunden mit der ID
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kunden SET vorname = '"+vorname+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_kd_nachname(int id,String nachname) throws ClassNotFoundException, SQLException{
		/*
		 * Ändere den Nachnamen des Kunden mit der ID
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kunden SET nachname = '"+nachname+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_kd_geburtstag(int id,String geburtstag)throws ClassNotFoundException, SQLException{
		/*
		 * Ändere den Geburtstag des Kunden mit der ID
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kunden SET geburtstag = '"+geburtstag+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_kd_telefon(int id,String telefon)throws ClassNotFoundException, SQLException{
		/*
		 * Ändere die Telefonnummer des Kunden mit der ID
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kunden SET telefon = '"+telefon+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void get_kd_all() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT * FROM kunden");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		connection.close();
	}
	private int get_last_id()throws ClassNotFoundException, SQLException{
		/*
		 * gebe die Letzte anglegete Zeile zurück
		 */
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT rowid FROM kunden ORDER BY rowid DESC limit 1");
		int id =  rs.getInt(1);
		connection.close();
		return id;
	}
	
	public int set_db_value(String vorname, String nachname, String geburtstag, String telefon)throws ClassNotFoundException, SQLException {
		//lege einen Kunden an
		set_db_value_for_kd(vorname,nachname,geburtstag,telefon);
		//gebe die letzte ID aus
		int kd_nr = get_last_id();
		return kd_nr;
	}
	public int get_id(String vorname, String nachname, String geburtstag, String telefon)throws ClassNotFoundException, SQLException {
		return get_kd_id(vorname,nachname, geburtstag, telefon);
	}
	public String get_vorname(int id) throws ClassNotFoundException, SQLException{
		return get_kd_vorname(id);
	}
	public String get_nachname(int id) throws ClassNotFoundException, SQLException{
		return get_kd_nachname(id);
	}
	public String get_geburtstag(int id) throws ClassNotFoundException, SQLException{
		return get_kd_geburtstag(id);
	}
	public String get_telefon(int id) throws ClassNotFoundException, SQLException{
		return get_kd_telefon(id);
	}
	public void change_vorname(int id, String vorname) throws ClassNotFoundException, SQLException{
		change_kd_vorname(id,vorname);
	}
	public void change_nachname(int id, String nachname)throws ClassNotFoundException, SQLException{
		change_kd_nachname(id,nachname);
	}
	public void change_geburtstag(int id, String geburtstag) throws ClassNotFoundException, SQLException{
		change_kd_geburtstag(id,geburtstag);
	}
	public void change_telefon(int id, String telefon) throws ClassNotFoundException, SQLException{
		change_kd_telefon(id,telefon);
	}
	public void get_all() throws ClassNotFoundException, SQLException{
		get_kd_all();
	}
}
