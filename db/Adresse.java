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
	
	private int get_address_adress_id(String plz, String ort, String strasse, String hn) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT adress_id FROM adresse WHERE plz = '"+plz+"' AND ort = '"+ort+"' AND strasse = '"+strasse+"' and hn = '"+hn+"'");
		rs.next();
		int a =  rs.getInt(1);
		connection.close();
		return a;
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
	private String get_address_plz(int adress_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT plz FROM adresse WHERE adress_id = '"+adress_id+"'");
		rs.next();
		String a =  rs.getString(1);
		connection.close();
		return a;
	}
	private String get_address_ort(int adress_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT ort FROM adresse WHERE adress_id = '"+adress_id+"'");
		rs.next();
		String a =  rs.getString(1);
		connection.close();
		return a;
	}
	private String get_address_strasse(int adress_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT strasse FROM adresse WHERE adress_id = '"+adress_id+"'");
		rs.next();
		String a =  rs.getString(1);
		connection.close();
		return a;
	}
	private String get_address_hn(int adress_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT hn FROM adresse WHERE adress_id = '"+adress_id+"'");
		rs.next();
		String a =  rs.getString(1);
		connection.close();
		return a;
	}
	private void display_address_all()throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT * FROM adresse");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		connection.close();
	}
	private void change_address_plz(int adress_id,String plz)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE adresse SET plz = '"+plz+"' WHERE adress_id = '"+adress_id+"'");
		connection.close();
	}
	private void change_address_ort(int adress_id,String ort)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE adresse SET ort = '"+ort+"' WHERE adress_id = '"+adress_id+"'");
		connection.close();
	}
	private void change_address_strasse(int adress_id,String strasse)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE adresse SET strasse = '"+strasse+"' WHERE adress_id = '"+adress_id+"'");
		connection.close();
	}
	private void change_address_hn(int adress_id,String hn)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE adresse SET hn = '"+hn+"' WHERE adress_id = '"+adress_id+"'");
		connection.close();
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
	public String test() throws ClassNotFoundException, SQLException{
		String[] a = get_values("SELECT ort FROM adresse WHERE adress_id = 1");
		String b = a[0];
		return b;
	}
}
