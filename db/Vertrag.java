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
public class Vertrag {
	public Vertrag() throws ClassNotFoundException, SQLException {
		initieren();
	}
	
	private void initieren()throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS vertrag(vertrags_id INTEGER PRIMARY KEY, kd_id INTEGER, whg_id INETEGER NOT NULL, Zeitraum TEXT NOT NULL,Schulden DOUBLE,aktiv BOOLEAN NOT NULL)");
		connection.close();
	}
	private void set_db_value_for_contract(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO vertrag (kd_id,whg_id, schulden,Zeitraum,aktiv) VALUES ('"+kd_id+"','"+whg_id+"','"+schulden+"','"+zeitraum+"','"+aktiv+"')");
		System.out.println("Werte erfolgreich gespeichert");
		connection.close();
	}
	private int get_vertrag_id(int kd_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT vertrags_id FROM vertrag WHERE kd_id = '"+kd_id+"'");
		rs.next();
		int id = rs.getInt(1);
		connection.close();
		return id;
	}
	private int get_vertrag_kd_id(int id)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT kd_id FROM vertrag WHERE vertrags_id = '"+id+"'");
		rs.next();
		int kd_id = rs.getInt(1);
		connection.close();
		return kd_id;
	}
	private int get_vertrag_whg_id(int id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT whg_id FROM vertrag WHERE vertrags_id = '"+id+"'");
		rs.next();
		int whg_id = rs.getInt(1);
		connection.close();
		return whg_id;
	}

	private String get_vertrag_zeitraum(int id)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT zeitraum FROM vertrag WHERE vertrags_id = '"+id+"'");
		rs.next();
		String mieter_seit = rs.getString(1);
		connection.close();
		return mieter_seit;
	}
	private double get_vertrag_schulden(int id)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT schulden FROM vertrag WHERE vertrags_id = '"+id+"'");
		rs.next();
		double schulden = rs.getDouble(1);
		connection.close();
		return schulden;
	}
	private boolean get_vertrag_aktiv(int id)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT aktiv FROM vertrag WHERE vertrags_id = '"+id+"'");
		rs.next();
		boolean mieter_bis = rs.getBoolean(1);
		connection.close();
		return mieter_bis;
	}
	private void get_vertrag_all() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT * FROM vertrag");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getDouble(4)+" "+rs.getString(5)+" "+rs.getBoolean(6));
		}
		connection.close();
	}
	private String get_vertrag_all_whg_by_kd_id(int kd_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("SELECT vertrags_id FROM vertrag WHERE kd_id = '"+kd_id+"'");
		String a = "";
		while (rs.next()) {
			a = a + rs.getInt(1) + ",";
		}
		connection.close();
		return a;
	}
	private void change_vertrag_kd_id(int id, int kd_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE vertrag SET kd_id = '"+kd_id+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_vertrag_whg_id(int id, int whg_id) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE vertrag SET whg_id = '"+whg_id+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_vertrag_zeitraum(int id, String zeitraum) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE vertrag SET zeitraum = '"+zeitraum+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_vertrag_schulden(int id, double schulden) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE vertrag SET schulden = '"+schulden+"' WHERE kd_id = '"+id+"'");
		connection.close();
	}
	private void change_vertrag_aktiv(int id, int aktiv) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("UPDATE vertrag SET aktiv = '"+aktiv+"' WHERE kd_id = '"+id+"'");
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
		ResultSet rs = statement.executeQuery("SELECT rowid FROM vertrag ORDER BY rowid DESC limit 1");
		int id =  rs.getInt(1);
		connection.close();
		return id;
	}
	
	public int set_db_value(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		set_db_value_for_contract(kd_id,whg_id,schulden,zeitraum,aktiv);
		int id = get_last_id();
		return id;
	}
	public int get_vertrags_id(int kd_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_id(kd_id);
	}
	public int get_kd_id(int vertrags_id) throws ClassNotFoundException, SQLException {
		return get_vertrag_kd_id(vertrags_id);
	}
	public int get_whg_id(int vertrags_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_whg_id(vertrags_id);
	}
	public String get_zeitraum(int vertrags_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_zeitraum(vertrags_id);
	}
	public double get_schulden(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_vertrag_schulden(vertrags_id);
	}
	public boolean get_aktiv(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_vertrag_aktiv(vertrags_id);
	}
	public int[] get_all_whg(int kd_nr) throws ClassNotFoundException, SQLException{
		/*
		 * rückgabe als array muss im Code dann einzeln abgerufen werden
		 */
		String s = get_vertrag_all_whg_by_kd_id(kd_nr);
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
	public void get_all()throws ClassNotFoundException, SQLException{
		get_vertrag_all();
	}
	public void change_kundennummer(int id, int kd_nr)throws ClassNotFoundException, SQLException {
		change_vertrag_kd_id(id,kd_nr);
	}
	public void change_wohnungsnummer(int id, int wohnungsnummer) throws ClassNotFoundException, SQLException{
		change_vertrag_whg_id(id,wohnungsnummer);
	}
	public void change_zeitraum(int id,String zeitraum)throws ClassNotFoundException, SQLException{
		change_vertrag_zeitraum(id,zeitraum);
	}
	public void change_schulden(int id, double schulden)throws ClassNotFoundException, SQLException{
		change_vertrag_schulden(id,schulden);
	}
	public void change_aktiv(int id, int aktiv)throws ClassNotFoundException, SQLException{
		change_vertrag_aktiv(id,aktiv);
	}
}
