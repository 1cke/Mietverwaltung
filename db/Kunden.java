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
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS kunden(kd_id INTEGER PRIMARY KEY, vorname TEXT NOT NULL, nachname TEXT NOT NULL,geburtstag TEXT NOT NULL, telefon TEXT,email TEXT,interessent BOOLEAN, aktiv BOOLEAN)");
		connection.close();
	}
	
	private void set_db_value_for_kd(String vorname, String nachname, String geburtstag, String telefon, String email,int interessent )throws ClassNotFoundException, SQLException{
		/*
		 * speicher den Vornamen, Nachnamen und Geburtstag in die Tabelle Kunden
		 * alle Werte als String übergeben
		 */
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO kunden (vorname,nachname, geburtstag,telefon,email,interessent,aktiv) VALUES ('"+vorname+"','"+nachname+"','"+geburtstag+"','"+telefon+"','"+email+"','"+interessent+"',1)");
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
		String[] values = zwischenerg.split(",");
		return values;
	}
	private void change_db_value_for_costumer(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
		System.out.println("Änderungen erfolgreich gespeichert");
		connection.close();
	}
	private int get_kd_id(String vorname, String nachname, String geburtstag)throws ClassNotFoundException, SQLException {
		String id = get_values("SELECT kd_id FROM kunden WHERE vorname = '"+vorname+"' AND nachname = '"+nachname+"' AND geburtstag = '"+geburtstag+"'")[0];
		return Integer.parseInt(id);
	}
	private String get_kd_vorname(int id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT vorname FROM kunden WHERE kd_id = '"+id+"'")[0];
	}
	private String get_kd_nachname(int id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT nachname FROM kunden WHERE kd_id = '"+id+"'")[0];
	}
	
	private String get_kd_geburtstag(int id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT geburtstag FROM kunden WHERE kd_id = '"+id+"'")[0];
	}
	private String get_kd_telefon(int id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT telefon FROM kunden WHERE kd_id = '"+id+"'")[0];
	}
	private String get_kd_email(int id) throws ClassNotFoundException, SQLException{
		return get_values("SELECT email FROM kunden WHERE kd_id = '"+id+"'")[0];
	}
	private boolean get_kd_interessent(int id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT interessent FROM kunden WHERE kd_id = '"+id+"'")[0];
		boolean aktiv;
		int zaehlwert1 = Integer.parseInt(wert);
		if (zaehlwert1 == 1){
			aktiv =  Boolean.valueOf("true");
			return aktiv;
		}else {
			aktiv =  Boolean.valueOf("false");
				return aktiv;
			}
	}
	private boolean get_kd_aktiv(int id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT aktiv FROM kunden WHERE kd_id = '"+id+"'")[0];
		boolean aktiv;
		int zaehlwert1 = Integer.parseInt(wert);
		if (zaehlwert1 == 1){
			aktiv =  Boolean.valueOf("true");
			return aktiv;
		}else {
			aktiv =  Boolean.valueOf("false");
				return aktiv;
			}
	}
	private void change_kd_vorname(int id,String vorname) throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET vorname = '"+vorname+"' WHERE kd_id = '"+id+"'");
		
	}
	private void change_kd_nachname(int id,String nachname) throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET nachname = '"+nachname+"' WHERE kd_id = '"+id+"'");
	}
	private void change_kd_geburtstag(int id,String geburtstag)throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET geburtstag = '"+geburtstag+"' WHERE kd_id = '"+id+"'");
	}
	private void change_kd_telefon(int id,String telefon)throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET telefon = '"+telefon+"' WHERE kd_id = '"+id+"'");
	}
	private void change_kd_email(int id,String email)throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET email = '"+email+"' WHERE kd_id = '"+id+"'");
	}
	private void change_kd_interessent(int id,int interessent)throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET interessent = '"+interessent+"' WHERE kd_id = '"+id+"'");
	}
	private void change_kd_aktiv(int id,int aktiv)throws ClassNotFoundException, SQLException{
		change_db_value_for_costumer("UPDATE kunden SET aktiv = '"+aktiv+"' WHERE kd_id = '"+id+"'");
	}
	private void get_kd_all() throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT kd_id FROM kunden");
		for(int i = 0; i<werte.length; i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id+" "+get_kd_vorname(id)+" "+get_kd_nachname(id)+" "+get_kd_geburtstag(id)+" "+get_kd_telefon(id)+" "+get_kd_email(id)+ " "+get_kd_aktiv(id)+ " "+get_kd_interessent(id));
		}
	}
	private int get_last_id()throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT rowid FROM kunden ORDER BY rowid DESC limit 1")[0]);
	}
	
	public int set_db_value(String vorname, String nachname, String geburtstag, String telefon,String email,int interessent)throws ClassNotFoundException, SQLException {
		set_db_value_for_kd(vorname,nachname,geburtstag,telefon,email,interessent);
		int id = get_last_id();
		return id;
	}
	public int get_id(String vorname, String nachname, String geburtstag)throws ClassNotFoundException, SQLException {
		return get_kd_id(vorname,nachname, geburtstag);
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
	public String get_email(int id)throws ClassNotFoundException, SQLException{
		return get_kd_email(id);
	}
	public boolean get_interessent(int id)throws ClassNotFoundException, SQLException{
		return get_kd_interessent(id);
	}
	public boolean get_aktiv(int id)throws ClassNotFoundException, SQLException{
		return get_kd_aktiv(id);
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
	public void change_email(int id, String email) throws ClassNotFoundException, SQLException{
		change_kd_email(id,email);
	}
	public void change_interessent(int id, int interessent) throws ClassNotFoundException, SQLException{
		change_kd_interessent(id,interessent);
	}
	/**
	 * Diese Methode ändert den Status des Kunden, ob dieser noch Kunde ist oder nicht.
	 * @param id Die Kunden-ID als Integer.
	 * @param aktiv Den Status als Integer. 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_aktiv(int id, int aktiv) throws ClassNotFoundException, SQLException{
		change_kd_aktiv(id,aktiv);
	}
	/**
	 * Diese Methode gibt alle Kunden aus.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void get_all() throws ClassNotFoundException, SQLException{
		get_kd_all();
	}
}
