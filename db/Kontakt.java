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
	private void set_db_value_for_contact(int vertrags_id,String wann,String grund, String beschreibung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO kontakt (vertrags_id,wann, grund,beschreibung) VALUES ('"+vertrags_id+"','"+wann+"','"+grund+"','"+beschreibung+"')");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	 
	private String get_contact_kontakts_id(int vertrags_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT kontakts_id FROM kontakt WHERE vertrags_id = '"+vertrags_id+"'");
		String a = "";
		while (rs.next()) {
			a = a + rs.getInt(1) + ",";
		}
		connection.close();
		return a;
	}
	private int get_contact_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT vertrags_id FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'");
		rs.next();
		int id = rs.getInt(1);
		connection.close();
		return id;
	}
	private String get_contact_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT wann FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'");
		rs.next();
		String wann = rs.getString(1);
		connection.close();
		return wann;
	}
	private String get_contact_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT grund FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'");
		rs.next();
		String grund = rs.getString(1);
		connection.close();
		return grund;
	}
	private String get_contact_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT beschreibung FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'");
		rs.next();
		String beschreibung = rs.getString(1);
		connection.close();
		return beschreibung;
	}
	private boolean get_contact_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT behoben FROM kontakt WHERE kontakts_id = '"+kontakt_id+"'");
		rs.next();
		boolean behoben = rs.getBoolean(1);
		connection.close();
		return behoben;
	}
	private String get_contact_all_by_contract_id(int vertrags_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT kontakts_id FROM kontakt WHERE vertrags_id = '"+vertrags_id+"'");
		String a = "";
		while (rs.next()) {
			a = a + rs.getInt(1) + ",";
		}
		connection.close();
		return a;
	}
	private void change_contact_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kontakt SET beschreibung = '"+beschreibung+"' WHERE kontakts_id = '"+kontakt_id+"'");
		connection.close();
	}
	private void change_contact_behoben(int kontakt_id,int behoben)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE kontakt SET behoben = '"+behoben+"' WHERE kontakts_id = '"+kontakt_id+"'");
		connection.close();
	}
	private void get_display_contact() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT * FROM kontakt");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5) + " " +rs.getBoolean(6));
		}
	}
	public void set_kontakt_value(int vertrags_id,String wann,String grund, String beschreibung)throws ClassNotFoundException, SQLException{
		set_db_value_for_contact(vertrags_id,wann,grund,beschreibung);
	}
	public int[] get_kontakt_id(int vertrags_nummer)throws ClassNotFoundException, SQLException{
		String s =  get_contact_kontakts_id(vertrags_nummer);
		String[] part = s.split(",");
		int[]wert = new int[part.length];
		String a = "";
		for(int i = 0; i < wert.length;i++) {
			a = part[i];
			int zwischen_erg = Integer.parseInt(a);
			wert[i] = zwischen_erg;
		}
		return wert;
	}
	public int get_vertrags_id(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_vertrags_id(kontakt_id);
	}
	public String get_wann(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_wann(kontakt_id);
	}
	public String get_grund(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_grund(kontakt_id);
	}
	public String get_beschreibung(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_beschreibung(kontakt_id);
	}
	public boolean get_behoben(int kontakt_id)throws ClassNotFoundException, SQLException{
		return get_contact_behoben(kontakt_id);
	}
	public int[] get_all_contacts(int vertrags_id)throws ClassNotFoundException, SQLException{
		String s = get_contact_all_by_contract_id(vertrags_id);
		String[] part = s.split(",");
		int[]wert = new int[part.length];
		String a = "";
		for(int i = 0; i < wert.length;i++) {
			a = part[i];
			int zwischen_erg = Integer.parseInt(a);
			wert[i] = zwischen_erg;
		}
		return wert;
	}
	public void change_beschreibung(int kontakt_id,String beschreibung)throws ClassNotFoundException, SQLException{
		change_contact_beschreibung(kontakt_id,beschreibung);
	}
	public void change_behoben(int kontakt_id, int behoben)throws ClassNotFoundException, SQLException{
		change_contact_behoben(kontakt_id,behoben);
	}
	public void display_kontakt()throws ClassNotFoundException, SQLException{
		get_display_contact();
	}
}
