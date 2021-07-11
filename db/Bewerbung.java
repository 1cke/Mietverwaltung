import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Johann Muenchhagen
 *
 */
public class Bewerbung {
	public Bewerbung() throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS bewerbung(bewerbungs_id INTEGER PRIMARY KEY, kunden_id INTEGER NOT NULL,wohnungs_id INTEGER NOT NULL, datum TEXT NOT NULL,status Boolean)");
		connection.close();
	}
	private void set_db_value(int wohnungs_id,int kunden_id,String datum)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO berwerbung(kunden_id,wohnungs_id,datum,status) VALUES ('"+kunden_id+"','"+wohnungs_id+"','"+datum+"',1");
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
	private int get_apply_bewerbungs_id(int wohnungs_id, int bewerber_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT bewerbungs_id FROM bewerbung WHERE wohnungs_id = '"+wohnungs_id+"' AND kunden_id = '"+bewerber_id+"'")[0]);
	}
	private int get_apply_bewerber_id(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT bewerber_id FROM bewerbung WHERE bewerbungs_id = '"+bewerbungs_id+"'")[0]);
	}
	private int get_apply_wohnungs_id(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT wohnungs_id FROM bewerbung WHERE bewerbungs_id = '"+bewerbungs_id+"'")[0]);
	}
	private String get_apply_datum(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT datum FROM bewerbung WHERE bewerbungs_id = '"+bewerbungs_id+"'")[0];
	}
	private boolean get_apply_status(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT status FROM kontakt WHERE kontakts_id = '"+bewerbungs_id+"'")[0];
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
	private void change_apply_bewerber_id(int bewerbungs_id,int bewerber_id)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE bewerbung SET bewerber_id = '"+bewerber_id+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	private void change_apply_wohnungs_id(int bewerbungs_id,int wohnungs_id)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE bewerbung SET wohnungs_id = '"+wohnungs_id+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	private void change_apply_datum(int bewerbungs_id,String datum)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE bewerbung SET datum = '"+datum+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	private void change_apply_status(int bewerbungs_id,int status)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE bewerbung SET status = '"+status+"' WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	private void delete_value(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		change_db_value("DELETE FROM bewerbung WHERE bewerbungs_id = '"+bewerbungs_id+"'");
	}
	/**
	 * Diese Methode erstellt eine neue Bewerbung
	 * @param wohnungs_id Die Wohnungs-ID als Integer.
	 * @param kunden_id	Die Kunden-ID als Integer.
	 * @param datum Das Datum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void set_bewerbung(int wohnungs_id,int kunden_id,String datum)throws ClassNotFoundException, SQLException{
		set_db_value(wohnungs_id,kunden_id,datum);
	}
	/**
	 * Diese Methode gibt die Bewerbungs-ID zurück.
	 * @param wohnungs_id Die Wohnungs-ID als Integer.
	 * @param bewerber_id Die Kunden-ID als Integer.
	 * @return Die Bewerbungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_bewerbungs_id(int wohnungs_id,int bewerber_id)throws ClassNotFoundException, SQLException{
		return get_apply_bewerbungs_id(wohnungs_id,bewerber_id);
	}
	/**
	 * Diese Methode gibt die Kunden-ID zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_kunden_id(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return get_apply_bewerber_id(bewerbungs_id);
	}
	/**
	 * Diese Methode gibt die Wohnungs-ID zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Die Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_wohnungs_id(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return get_apply_wohnungs_id(bewerbungs_id);
	}
	/**
	 * Diese Methode gibt das Datum der Bewerbung zurück.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @return Das Datum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_datum(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return get_apply_datum(bewerbungs_id);
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
	public boolean get_status(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		return get_apply_status(bewerbungs_id);
	}
	/**
	 * Diese Methode ändert die Bewerber-ID.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param bewerber_id Die neue Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_bewerber_id(int bewerbungs_id,int bewerber_id)throws ClassNotFoundException, SQLException{
		change_apply_bewerber_id(bewerbungs_id,bewerber_id);
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param wohnungs_id Die neue Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_wohnungs_id(int bewerbungs_id,int wohnungs_id)throws ClassNotFoundException, SQLException{
		change_apply_wohnungs_id(bewerbungs_id,wohnungs_id);
	}
	/**
	 * Diese Methode ändert das Datum der Bewerbung.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @param datum Das neue Datum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_datum(int bewerbungs_id,String datum)throws ClassNotFoundException, SQLException{
		change_apply_datum(bewerbungs_id,datum);
	}
	/**
	 * Diese Methode ändert den Status der Bewerbung
	 * @param bewerbungs_id Die Bewerbungs_id als Integer.
	 * @param status Den neuen Status als Integer. 0 = False, 1 = True
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_status(int bewerbungs_id,int status)throws ClassNotFoundException, SQLException{
		change_apply_status(bewerbungs_id,status);
	}
	/**
	 * Diese Methode löscht eine Bewerbung.
	 * @param bewerbungs_id Die Bewerbungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void delete_bewerbung(int bewerbungs_id)throws ClassNotFoundException, SQLException{
		delete_value(bewerbungs_id);
	}
}
