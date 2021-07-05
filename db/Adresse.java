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
			zwischenerg = rs.getString(1) + ",";
			System.out.println(zwischenerg);//Kontrollausgabe
		}
		connection.close();
		String[] values = zwischenerg.split(",");
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
	public void set_address_value(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		set_db_value_for_address(plz,ort,strasse,hn);
	}
	public int get_adress_id(String plz,String ort, String strasse, String hn)throws ClassNotFoundException, SQLException{
		return get_address_adress_id(plz,ort,strasse,hn);
	}
	public String get_plz(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_plz(adress_id);
	}
	public String get_ort(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_ort(adress_id);
	}
	public String get_strasse(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_strasse(adress_id);
	}
	public String get_hn(int adress_id)throws ClassNotFoundException, SQLException{
		return get_address_hn(adress_id);
	}
	public void display_adresse()throws ClassNotFoundException, SQLException{
		display_address_all();
	}
	public void change_plz(int adress_id, String plz)throws ClassNotFoundException, SQLException{
		change_address_plz(adress_id,plz);
	}
	public void change_ort(int adress_id, String ort)throws ClassNotFoundException, SQLException{
		change_address_ort(adress_id,ort);
	}
	public void change_strasse(int adress_id, String strasse)throws ClassNotFoundException, SQLException{
		change_address_strasse(adress_id,strasse);
	}
	public void change_hn(int adress_id, String hn)throws ClassNotFoundException, SQLException{
		change_address_hn(adress_id,hn);
	}
	public void delete_addresse(int id) throws ClassNotFoundException, SQLException{
		delete_db_value(id);
	}
}
