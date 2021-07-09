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
public class Kontakt {
	public Kontakt() throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS kontakt(kontakts_id INTEGER PRIMARY KEY, vertrags_id INTEGER NOT NULL, wann TEXT NOT NULL,grund TEXT NOT NULL,beschreibung TEXT,behoben BOOLEAN)");
		connection.close();
	}
	private void set_db_value_for_contact(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
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
	private void change_db_value(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
		System.out.println("Änderungen erfolgreich gespeichert");
		connection.close();
	}
	private String[] get_contact_kontakts_id(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT kontakts_id FROM kontakt WHERE vertrags_id = '"+vertrags_id+"'");
	}
	private int get_contact_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT vertrags_id FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'")[0]);
	}
	private String get_contact_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT wann FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'")[0];
	}
	private String get_contact_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT grund FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'")[0];
	}
	private String get_contact_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT beschreibung FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'")[0];
	}
	private boolean get_contact_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT behoben FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'")[0];
		boolean behoben;
		int zaehlwert1 = Integer.parseInt(wert);
		if (zaehlwert1 == 1){
			behoben =  Boolean.valueOf("true");
			return behoben;
		}else {
			behoben =  Boolean.valueOf("false");
				return behoben;
			}
	}
	private void change_contact_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE kontakt SET beschreibung = '"+beschreibung+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
	private void change_contact_behoben(int kontakt_id,int behoben)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE kontakt SET behoben = '"+behoben+"' WHERE kontakts_id = '"+kontakt_id+"'");
	}
	private void get_display_contact() throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT kontakts_id FROM kontakt");
		for(int i = 0; i<werte.length;i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id+" "+get_contact_vertrags_id(id)+" "+get_contact_wann(id)+" "+get_contact_grund(id)+" "+get_contact_beschreibung(id) + " " +get_contact_behoben(id));
		}
	}
	/**
	 * Diese Methode erstellt einen Kontakt.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @param wann Der Zeitpunkt des Auftretens als String.
	 * @param grund Der Grund als String.
	 * @param beschreibung Die Beschreibung als String. Wenn nicht vorhanden dann leeren String " ".
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void set_kontakt_value(int vertrags_id,String wann,String grund, String beschreibung)throws ClassNotFoundException, SQLException{
		set_db_value_for_contact("INSERT INTO kontakt(vertrags_id,wann,grund,beschreibung) VALUES('"+vertrags_id+"','"+wann+"','"+grund+"','"+beschreibung+"')");
		
	}
	/**
	 * Diese Methode gibt alle Kontakt-IDs eines Vertrages zurück.
	 * @param vertrags_nummer Die Vertragsnummer als Integer.
	 * @return Ein Integerarray mit allen IDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int[] get_kontakt_id(int vertrags_nummer)throws ClassNotFoundException, SQLException{
		String[] werte = get_contact_kontakts_id(vertrags_nummer);
		int[] wert = new int[werte.length];
		for(int i = 0; i < werte.length;i++) {
			wert[i] = Integer.parseInt(werte[i]);
		}
		return wert;
	}
	/**
	 * Diese Methode gibt die Vertrags-ID zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Die Vertrags-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_vertrags_id(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Zeitpunkt des Auftretens zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Den Zeitpunkt als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_wann(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Grund des Kontaktes zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Den Grund als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_grund(kontakt_id);
	}
	/**
	 * Diese Methode gibt die Beschreibung des Kontaktes zurück.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @return Die Beschreibung als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_beschreibung(kontakt_id);
	}
	/**
	 * Diese Methode gibt den Behobenstatus des Kontatks zurück.
	 * @param kontakt_id Die Kontakt-ID.
	 * @return Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean get_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_behoben(kontakt_id);
	}
	
	/**
	 * Diese Methode ändert die Beschreibung.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @param beschreibung Die Beschreibung als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		change_contact_beschreibung(kontakt_id,beschreibung);
	}
	/**
	 * Diese Methode ändert den Behobenstatus.
	 * @param kontakt_id Die Kontakt-ID als Integer.
	 * @param behoben Den Statuts als Integer. 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_behoben(int kontakt_id, int behoben)throws ClassNotFoundException, SQLException{
		change_contact_behoben(kontakt_id,behoben);
	}
	/**
	 * Diese Methode gibt alle Kontakte zurück. Kunden unspeziefisch.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void display_kontakt()throws ClassNotFoundException, SQLException{
		get_display_contact();
	}
}
