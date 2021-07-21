package backend;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Person;

/**
 * @author Johann Muenchhagen
 *.
 */
public class Kunden extends Person{
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
	
	private boolean set_db_value_for_kd(String vorname, String nachname, String geburtstag, String telefon, String email,int interessent )throws ClassNotFoundException, SQLException{
		/*
		 * speicher den Vornamen, Nachnamen und Geburtstag in die Tabelle Kunden
		 * alle Werte als String übergeben
		 */try {
				Connection connection = null;//setze Connection auf null
				connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				statement.executeUpdate("INSERT INTO kunden (vorname,nachname, geburtstag,telefon,email,interessent,aktiv) VALUES ('"+vorname+"','"+nachname+"','"+geburtstag+"','"+telefon+"','"+email+"','"+interessent+"',1)");
				connection.close();
				return true;
		 }catch(Exception e) {
			 return false;
		 }
	}
	private ArrayList<Person> get_all_values(String anweisung) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		ResultSet rs = statement.executeQuery(anweisung);
		ArrayList<Person> daten = new ArrayList<Person>();
		while(rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt(1));
			p.setVorname(rs.getString(2));
			p.setNachname(rs.getString(3));
			p.setGeburtsdatum(rs.getString(4));
			p.setTelefon(rs.getString(5));
			p.setEmail(rs.getString(6));
			p.setInteressent(rs.getBoolean(7));
			p.setAktiv(rs.getBoolean(8));
			daten.add(p);
		}
		connection.close();
		return daten;	
	}
	private boolean change_db_value_for_costumer(String anweisung)throws ClassNotFoundException, SQLException{
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
	private int get_kd_id(String vorname, String nachname, String geburtstag)throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		ResultSet rs = statement.executeQuery("SELECT kd_id,telefon,email FROM kunden WHERE vorname = '"+vorname+"' AND nachname = '"+nachname+"' AND geburtstag = '"+geburtstag+"'");
		while(rs.next()) {
			this.setId(rs.getInt(1));
			this.setTelefon(rs.getString(2));
			this.setEmail(rs.getString(3));
		}
		connection.close();
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setGeburtsdatum(geburtstag);
		return this.getId();
	}
	private boolean get_kd_daten(int id)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//System.out.println(anweisung);//Kontrollausgabe
			ResultSet rs = statement.executeQuery("SELECT vorname,nachname,geburtstag,telefon,email,interessent,aktiv FROM kunden WHERE kd_id = '" + id+"'");
			while(rs.next()) {
				this.setId(id);
				this.setVorname(rs.getString(1));
				this.setNachname(rs.getString(2));
				this.setGeburtsdatum(rs.getString(3));
				this.setTelefon(rs.getString(4));
				this.setEmail(rs.getString(5));
				this.setInteressent(rs.getBoolean(6));
				this.setAktiv(rs.getBoolean(7));
			}
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	private String get_kd_vorname() throws ClassNotFoundException, SQLException{
		return this.getVorname();
	}
	private String get_kd_nachname() throws ClassNotFoundException, SQLException{
		return this.getNachname();
	}
	
	private String get_kd_geburtstag() throws ClassNotFoundException, SQLException{
		return this.getGeburtsdatum();
	}
	private String get_kd_telefon() throws ClassNotFoundException, SQLException{
		return this.getTelefon();
	}
	private String get_kd_email() throws ClassNotFoundException, SQLException{
		return this.getEmail();
	}
	private boolean get_kd_interessent()throws ClassNotFoundException, SQLException{
		return this.isInteressent();
	}
	private boolean get_kd_aktiv()throws ClassNotFoundException, SQLException{
		return this.isAktiv();
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
		System.out.println(get_all_values("SELECT * FROM kunden"));
	}
	private boolean delete_kd(int kunden_id)throws ClassNotFoundException, SQLException{
		return change_db_value_for_costumer("DELETE FROM kunden WHERE kd_id = '"+kunden_id+"'");
	}
	
	/**
	 * Diese Methode lädt alle Kundendaten.
	 * <p>Immer als erstes nutzen, wenn die Kundennummer bekannt ist</p>
	 * @param kunden_nummer Die Kundennummer als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *  @see ClassNotFoundException
	 * @see SQLException
	 */
	public void lade_kunden_daten(int kunden_nummer)throws ClassNotFoundException, SQLException{
		get_kd_daten(kunden_nummer);
	}
	/**
	 * Diese Methode erstellt einen Kunden.
	 * <p> Der Kunde wird Standardmäßig aktiv gesetzt</p>
	 * @param vorname Den Vornamen des Kunden als String.
	 * @param nachname Den Nachnamen des Kunden als String.
	 * @param geburtstag Das Geburtsdatum als String.
	 * @param telefon Die Telefonnummer als String. Falls unbekannt, leeren String " ".
	 * @param email Die Email als String. Falls unbekannt, leeren String " ".
	 * @param interessent Den Interessentenstatus des Kunden als Integer. 0 = False, 1 = True.
	 * @return Die ID des Kunden als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void set_db_value(String vorname, String nachname, String geburtstag, String telefon,String email,int interessent)throws ClassNotFoundException, SQLException {
		set_db_value_for_kd(vorname,nachname,geburtstag,telefon,email,interessent);
	}
	/**
	 * Diese Methode gibt die Kunden-ID zurück.
	 * <p> Alle Parameter müssen so geschrieben werden, wie Sie in der Datenbank stehen. Ansonsten gibt es keine Ausgabe.</p>
	 * <p> Dieser Zwang wird noch geändert</p>
	 * @param vorname Den Vornamen des Kunden als String.
	 * @param nachname Den Nachnamen des Kunden als String.
	 * @param geburtstag Das Geburtsdatum des Kunden als String.
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_id(String vorname, String nachname, String geburtstag)throws ClassNotFoundException, SQLException {
		return get_kd_id(vorname,nachname, geburtstag);
	}
	/**
	 * Diese Methode gibt den Vornamen des Kunden zurück.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Den Vornamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_vorname() throws ClassNotFoundException, SQLException{
		return get_kd_vorname();
	}
	/**
	 * Diese Methode gibt den Nachnamen des Kunden zurück.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Den Nachnamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_nachname() throws ClassNotFoundException, SQLException{
		return get_kd_nachname();
	}
	/**
	 * Diese Methode gibt das Geburtsdatum des Kunden zurück.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Das Geburtsdatum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_geburtstag() throws ClassNotFoundException, SQLException{
		return get_kd_geburtstag();
	}
	/**
	 * Diese Methode gibt die Telefonnummer des Kunden zurück.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Die Telefonnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_telefon() throws ClassNotFoundException, SQLException{
		return get_kd_telefon();
	}
	/**
	 * Diese Methode gibt die Email des Kunden zurück.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Die Email als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_email()throws ClassNotFoundException, SQLException{
		return get_kd_email();
	}
	/**
	 * Diese Methode gibt zurück ob der Kunde ein Interessent ist.
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Den Interessentenstatus als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean get_interessent()throws ClassNotFoundException, SQLException{
		return get_kd_interessent();
	}
	/**
	 * Diese Methode gibt den Status des Kunden zurück.
	 * <p> Ist dieser noch Kunde oder nicht</p>
	 * <p> Zuerst die Methode lade_kunden_daten() ausführen, wenn die ID bekannt ist und die Methode nicht schon mal ausgeführt wurde</p>
	 * <p> Bei unbekannter ID die Funktion lade_kunden_daten()ignorieren</p>
	 * @return Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_aktiv()throws ClassNotFoundException, SQLException{
		return get_kd_aktiv();
	}
	/**
	 * Diese Methode ändert den Vornamen des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param vorname Den Vornamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_vorname(int id, String vorname) throws ClassNotFoundException, SQLException{
		change_kd_vorname(id,vorname);
	}
	/**
	 * Diese Methode ändert den Nachnamen des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param nachname Den Nachnamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_nachname(int id, String nachname)throws ClassNotFoundException, SQLException{
		change_kd_nachname(id,nachname);
	}
	/**
	 * Diese Methode ändert das Geburtsdatum des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param geburtstag Das Geburtsdatum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_geburtstag(int id, String geburtstag) throws ClassNotFoundException, SQLException{
		change_kd_geburtstag(id,geburtstag);
	}
	/**
	 * Diese Methode ändert die Telefonnummer des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param telefon Die Telefonnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_telefon(int id, String telefon) throws ClassNotFoundException, SQLException{
		change_kd_telefon(id,telefon);
	}
	/**
	 * Diese Methode ändert die Email des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param email Die Email als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_email(int id, String email) throws ClassNotFoundException, SQLException{
		change_kd_email(id,email);
	}
	/**
	 * Diese Methode ändert den Interessentenstatus des Kunden.
	 * @param id Die Kunden-ID als Integer.
	 * @param interessent Den Interessentenstatus als Integer. 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
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
	/**
	 * Löscht einen Kunden
	 * @param kunden_id als Integer
	 * @return Boolean ob geklappt oder nicht
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean delete(int kunden_id)throws ClassNotFoundException, SQLException{
		return delete_kd(kunden_id);
	}
}
