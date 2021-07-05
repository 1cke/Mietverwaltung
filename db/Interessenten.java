import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Johann Muenchhagen
 *
 */
public class Interessenten {
	public Interessenten() throws ClassNotFoundException, SQLException{
		initieren();
	}
	
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS interessenten(interessenten_id INTEGER PRIMARY KEY, vorname TEXT NOT NULL, nachname TEXT NOT NULL,geburtsdatum TEXT,telefonnummer TEXT, email TEXT,aktiv BOOLEAN NOT NULL)");
		connection.close();
	}
	private void set_db_value_for_intrests(String vorname,String nachname,String geburtsdatum, String email, String telefon)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO interessenten (vorname,nachname, geburtsdatum,telefonnummer,email,aktiv) VALUES ('"+vorname+"','"+nachname+"','"+geburtsdatum+"','"+telefon+"','"+email+"',true)");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	private void change_db_value_for_intrests(String anweisung)throws ClassNotFoundException, SQLException{
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
		statement.executeUpdate("DELETE FROM interessenten WHERE interessenten_id = '"+ id+"'");
		System.out.println("Interessent erfolgreich gelöscht");
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
			zwischenerg = zwischenerg + rs.getString(1) + ",";
		//System.out.println(zwischenerg);//Kontrollausgabe
		}
		connection.close();
		//System.out.println(zwischenerg);
		String[] values = zwischenerg.split(",");
		//System.out.println(values[0]);
			return values;
	}
	private int get_interest_id(String vorname, String nachname, String geburtsdatum) throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT interessenten_id FROM interessenten WHERE vorname = '"+vorname+" AND nachname = '"+nachname+"' AND geburtsdatum = '" + geburtsdatum+"'"); 
		int id = Integer.parseInt(s[0]);
		return id;
	}
	private String get_interest_vorname(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT vorname FROM interessenten where interessenten_id = '"+id+"'");
		return s[0];
	}
	private String get_interest_nachname(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT nachname FROM interessenten where interessenten_id = '"+id+"'");
		return s[0];
	}
	private String get_interest_geburtsdatum(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT geburtsdatum FROM interessenten where interessenten_id = '"+id+"'");
		return s[0];
	}
	private String get_interest_telefonnummer(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT telefonnummer FROM interessenten where interessenten_id = '"+id+"'");
		return s[0];
	}
	private String get_interest_email(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT email FROM interessenten where interessenten_id = '"+id+"'");
		return s[0];
	}
	private boolean get_interest_aktiv(int id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT aktiv FROM interessenten where interessenten_id = '"+id+"'");
		boolean aktiv;
		int zaehlwert1 = Integer.parseInt(s[0]);
		if (zaehlwert1 == 1){
			aktiv =  Boolean.valueOf("true");
			return aktiv;
		}else {
			aktiv =  Boolean.valueOf("false");
				return aktiv;
			}
	}
	private void change_interest_vorname(int id, String vorname)throws ClassNotFoundException, SQLException{
		change_db_value_for_intrests("UPDATE interessenten SET vorname  = '"+vorname+"' WHERE interessenten_id = '"+id+"'");
	}
	private void change_interest_nachname(int id, String nachname)throws ClassNotFoundException, SQLException{
		change_db_value_for_intrests("UPDATE interessenten SET nachname  = '"+nachname+"' WHERE interessenten_id = '"+id+"'");
	}
	private void change_interest_geburtsdatum(int id, String geburtsdatum)throws ClassNotFoundException, SQLException{
		change_db_value_for_intrests("UPDATE interessenten SET geburtsdatum  = '"+geburtsdatum+"' WHERE interessenten_id = '"+id+"'");
	}
	
	private void change_interest_telefonnummer(int id, String telefonnummer)throws ClassNotFoundException, SQLException{
		change_db_value_for_intrests("UPDATE interessenten SET telefonnummer  = '"+telefonnummer+"' WHERE interessenten_id = '"+id+"'");
	}
	private void change_interest_email(int id, String email)throws ClassNotFoundException, SQLException{
		change_db_value_for_intrests("UPDATE interessenten SET email  = '"+email+"' WHERE interessenten_id = '"+id+"'");
	}
	private void change_interest_aktiv(int id, int aktiv)throws ClassNotFoundException, SQLException{
		//boolean 1 = true, 0 = false übergabe erfolgt als integer
	change_db_value_for_intrests("UPDATE interessenten SET aktiv  = '"+aktiv+"' WHERE interessenten_id = '"+id+"'");
	}
	private void display_all_interessenten() throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT interessenten_id FROM interessenten");
		for(int i =0; i<werte.length;i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id +" "+get_interest_vorname(id)+" "+get_interest_nachname(id) + " "+get_interest_geburtsdatum(id) + " "+get_interest_telefonnummer(id) + " " + get_interest_email(id) +" " + get_interest_aktiv(id));
			}
	}
	
	private int get_last_id()throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT rowid FROM interessenten ORDER BY rowid DESC limit 1");
		int id =  rs.getInt(1);
		connection.close();
		return id;
	}
	/**
	 * Diese Methode legt einen Interessenten an und gibt seine Interessentennummer zurück.
	 * @param vorname Den Vornamen als String.
	 * @param nachname Den Nachnamen als String.
	 * @param geburtsdatum Das Geburtsdatum als String.
	 * @param whg_nr Die Wohnungsnummer als Integer.
	 * @return Die Interessentennummer als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int set_interessent(String vorname,String nachname,String geburtsdatum, String telefon, String email)throws ClassNotFoundException, SQLException{
		set_db_value_for_intrests(vorname, nachname,geburtsdatum, telefon, email);
		return get_last_id();
	}
	/**
	 * Diese Methode gibt die Interessentennummer zurück.
	 * @param vorname Den Vornamen des Interessenten als String.
	 * @param nachname Den Nachnamen des Interessenten als String.
	 * @param geburtsdatum Das Geburtsdatum des Interessenten als String.
	 * @return Die Interessentennummer als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_id (String vorname,String nachname, String geburtsdatum)throws ClassNotFoundException, SQLException{
		return get_interest_id(vorname,nachname,geburtsdatum);
	}
	/**
	 * Diese Methode gibt den Vornamen des Interessenten zurück.
	 * @param interessenten_nr Die Interessentennummer als Integer.
	 * @return Den Vornamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_vorname (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_vorname(interessenten_nr);
	}
	/**
	 * Diese Methode gibt den Nachnamen des Interessenten zurück.
	 * @param interessenten_nr Die Interessentennummer als Integer.
	 * @return Den Nachnamen als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_nachname (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_nachname(interessenten_nr);
	}
	/**
	 * Diese Methode gibt das Geburtsdatum des Interessenten zurück.
	 * @param interessenten_nr Die Interessentennummer als Integer.
	 * @return Die Telefonnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_geburtsdatum (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_geburtsdatum(interessenten_nr);
	}
	/**
	 * Diese Methode gibt die Telefonnummer des Interessenten zurück.
	 * @param interessenten_nr Die Interessentennummer als Integer.
	 * @return Die Telefonnummer als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_telefonnummer (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_telefonnummer(interessenten_nr);
	}
	/**
	 * Diese Methode gibt die Email-Adresse des Interessenten zurück.
	 * @param interessenten_nr Die Interessenten Nummer als Integer.
	 * @return Die Email-Adresse als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_email (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_email(interessenten_nr);
	}
	/**
	 * Diese Methode gibt den Status des Interessenten zurück
	 * @param interessenten_nr	Die Interessentennummer als Integer.
	 * @return Den Status des Interessenten mit True oder False
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_aktiv (int interessenten_nr)throws ClassNotFoundException, SQLException{
		return get_interest_aktiv(interessenten_nr);
	}
	/**
	 * Diese Methode ändert den Vornamen des Interessenten.
	 * 
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer.
	 * @param vorname	Den Vornamen als String. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_vorname(int interessenten_nr,String vorname)throws ClassNotFoundException, SQLException{
		change_interest_vorname(interessenten_nr,vorname);
	}
	/**
	 * Diese Methode ändert den Nachnamen des Interessenten.
	 * 
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer.
	 * @param nachname	Den Nachnamen als String. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_nachname(int interessenten_nr,String nachname)throws ClassNotFoundException, SQLException{
		change_interest_nachname(interessenten_nr,nachname);
	}
	/**
	 * Diese Methode ändert das Geburtsdatum des Interessenten.
	 * 
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer.
	 * @param geburtsdatum	Das Geburtsdatum als String. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_geburtsdatum(int interessenten_nr,String geburtsdatum)throws ClassNotFoundException, SQLException{
		change_interest_geburtsdatum(interessenten_nr,geburtsdatum);
	}
	/**
	 * Diese Methode ändert die Telefonnummer des Interessenten.
	 * So kann auch nachträglich eine Telefonnummer hinzugefügt werden.
	 * <p> Bitte auf die Ländervorwahl achten, um mögliche Doppelungen zu vermeiden.</p>
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer.
	 * @param telefonnummer	Die Telefonnummer als String. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_telefonnummer(int interessenten_nr,String telefonnummer)throws ClassNotFoundException, SQLException{
		change_interest_telefonnummer(interessenten_nr,telefonnummer);
	}
	/**
	 * Diese Methode ändert die Email-Adresse des Interessenten.
	 * So kann auch nachträglich eine Email hinzugefügt werden.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer
	 * @param email	Die Email-Adresse als String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_email(int interessenten_nr,String email)throws ClassNotFoundException, SQLException{
		change_interest_email(interessenten_nr,email);
	}
	/**
	 * Diese Methode ändert den Status des Interessenten.
	 * Standardmäßig ist der Status: True.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param interessenten_nr	Die Interessentennummer als Integer
	 * @param aktiv	Ist ein Integer, wobei 0 für False und 1 für True steht
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_aktiv(int interessenten_nr,int aktiv)throws ClassNotFoundException, SQLException{
		change_interest_aktiv(interessenten_nr,aktiv);
	}
	/**
	 * Diese Methode löscht Interesenten anhand Ihrer Interessentennummer
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id	Hierbei handelt es sich um die Interessentennummer als Integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void delete_interessent(int id) throws ClassNotFoundException, SQLException{
		delete_db_value(id);
	}
	/**
	 * Diese Methode zeigt alle Interessenten an.
	 * <p>Es werden keine Parameter an die Methode übergeben.</p>
	 * <p>Es erfolgt keine Rückgabe</p>
	 * @throws ClassNotFoundException	wirft eine ClassNotFoundException
	 * @throws SQLException				wirft eine SQLException
	 * 
	 * @see SQLException
	 * @see ClassNotFoundException
	 */
	public void display_all()throws ClassNotFoundException, SQLException{
		display_all_interessenten();
	}
}


