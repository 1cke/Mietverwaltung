package backend;




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
			//System.out.println(zwischenerg);//Kontrollausgabe
		}
		connection.close();
		String[] values = zwischenerg.split(",");
		return values;
	}
	private void change_db_value_for_contract(String anweisung)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate(anweisung);
		System.out.println("Änderungen erfolgreich gespeichert");
		connection.close();
	}
	private int get_vertrag_id(int kd_id) throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT vertrags_id FROM vertrag WHERE kd_id = '"+kd_id+"'")[0];
		return Integer.parseInt(wert);
	}
	private int get_vertrag_kd_id(int id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT kd_id FROM vertrag WHERE vertrags_id = '"+id+"'")[0];
		return Integer.parseInt(wert);
	}
	private int get_vertrag_whg_id(int id) throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT whg_id FROM vertrag WHERE vertrags_id = '"+id+"'")[0];
		return Integer.parseInt(wert);
	}

	private String get_vertrag_zeitraum(int id)throws ClassNotFoundException, SQLException{
		return get_values("SELECT zeitraum FROM vertrag WHERE vertrags_id = '"+id+"'")[0];
	}
	private double get_vertrag_schulden(int id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT schulden FROM vertrag WHERE vertrags_id = '"+id+"'")[0];
		return Double.parseDouble(wert);
	}
	private boolean get_vertrag_aktiv(int id)throws ClassNotFoundException, SQLException{
		String wert = get_values("SELECT aktiv FROM vertrag WHERE vertrags_id = '"+id+"'")[0];
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
	private void get_vertrag_all() throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT vertrags_id FROM vertrag");
		for(int i =0; i<werte.length;i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id +" "+get_vertrag_kd_id(id)+" "+get_vertrag_whg_id(id) + " "+get_vertrag_zeitraum(id) + " "+get_vertrag_schulden(id) + " " + get_vertrag_aktiv(id));
			}
	}
	private String get_vertrag_all_whg_by_kd_id(int kd_id) throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT vertrags_id FROM vertrag WHERE kd_id = '"+kd_id+"'");
		String a = "";
		for(int i = 0; i<werte.length;i++) {
			a = a + werte[i] + ",";
		}
		return a;
	}
	private void change_vertrag_kd_id(int id, int kd_id) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET kd_id = '"+kd_id+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_whg_id(int id, int whg_id) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET whg_id = '"+whg_id+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_zeitraum(int id, String zeitraum) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET zeitraum = '"+zeitraum+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_schulden(int id, double schulden) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET schulden = '"+schulden+"' WHERE kd_id = '"+id+"'");
	}
	private void change_vertrag_aktiv(int id, int aktiv) throws ClassNotFoundException, SQLException{
		change_db_value_for_contract("UPDATE vertrag SET aktiv = '"+aktiv+"' WHERE kd_id = '"+id+"'");
	}
	private int get_last_id()throws ClassNotFoundException, SQLException{
		String id = get_values("SELECT rowid FROM vertrag ORDER BY rowid DESC limit 1")[0];
		return Integer.parseInt(id);
	}
	/**
	 * Diese Methode legt einen Vertrag an.
	 * @param kd_id Die Kunden-ID als Integer.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param schulden	Die Höhe der Schulden als Double.
	 * @param zeitraum	Den Zeitraum als String.
	 * @param aktiv	Den Status als Integer. 0 = False, 1 = True.
	 * @return Die ID des Vertrages als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int set_db_value(int kd_id,int whg_id,double schulden, String zeitraum,int aktiv)throws ClassNotFoundException, SQLException{
		set_db_value_for_contract(kd_id,whg_id,schulden,zeitraum,aktiv);
		int id = get_last_id();
		return id;
	}
	/**
	 * Diese Methode gibt anhand der Kunden-ID die Vertrags-ID zurück.
	 * @param kd_id Die Kunden-ID als Integer.
	 * @return DIe Vertrags-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_vertrags_id(int kd_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_id(kd_id);
	}
	/**
	 * Diese Methode gibt die zugeordnete Kunden-ID zurück.
	 * <p> Return wird noch bearbeitet</p>
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return Die Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_kd_id(int vertrags_id) throws ClassNotFoundException, SQLException {
		return get_vertrag_kd_id(vertrags_id);
	}
	/**
	 * Diese Methode gibt die zugeordnete Wohnungs-ID zurück.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return DIe Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public int get_whg_id(int vertrags_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_whg_id(vertrags_id);
	}
	/**
	 * Diese Methode gibt den Zeitraum zurück.
	 * <p> Im sinne von aktiv seit oder war Kunde von xy bis yz.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return Den Zeitraum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public String get_zeitraum(int vertrags_id) throws ClassNotFoundException, SQLException{
		return get_vertrag_zeitraum(vertrags_id);
	}
	/**
	 * Diese Methode gibt die Höhe der Schulden zurück.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return Die Schulden als Double. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public double get_schulden(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_vertrag_schulden(vertrags_id);
	}
	/**
	 * Diese Methode gibt den Vertragsstatus zurück.
	 * @param vertrags_id Die Vertrags-ID als Integer.
	 * @return	Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_aktiv(int vertrags_id)throws ClassNotFoundException, SQLException{
		return get_vertrag_aktiv(vertrags_id);
	}
	/**
	 * Diese Methode gibt alle Verträge von einem Kunden zurück.
	 * @param kd_nr Die Kunden-ID als Integer.
	 * @return	Ein Integerarray mit allen zugeordneten Vertrags-IDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
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
	/**
	 * Diese Methode gibt alle Verträge und dazugehörige Daten aus
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void get_all()throws ClassNotFoundException, SQLException{
		get_vertrag_all();
	}
	/**
	 * Diese Methode ändert die Kunden-ID.
	 * @param id	Die Vertrags-ID als Integer.
	 * @param kd_nr	Die neue Kunden-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_kundennummer(int id, int kd_nr)throws ClassNotFoundException, SQLException {
		change_vertrag_kd_id(id,kd_nr);
	}
	/**
	 * Diese Methode ändert die Wohnungs-ID.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id	Die Vertrags-ID als Integer.
	 * @param wohnungsnummer	Die neue Wohnungs-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_wohnungsnummer(int id, int wohnungsnummer) throws ClassNotFoundException, SQLException{
		change_vertrag_whg_id(id,wohnungsnummer);
	}
	/**
	 * Diese Methode ändert den Zeitraum.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-ID als Integer.
	 * @param zeitraum Den neuen Zeitraum als String.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_zeitraum(int id,String zeitraum)throws ClassNotFoundException, SQLException{
		change_vertrag_zeitraum(id,zeitraum);
	}
	/**
	 * Diese Methode ändert den Schuldenwert.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-ID als Integer.
	 * @param schulden Die neuen Schulden als Double
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_schulden(int id, double schulden)throws ClassNotFoundException, SQLException{
		change_vertrag_schulden(id,schulden);
	}
	/**
	 * Diese Methode ändert den aktiv Status.
	 * <p>Es erfolgt keine Rückgabe</p>
	 * @param id Die Vertrags-Id als Integer.
	 * @param aktiv	Den neuen Status als Integer. 0 = false, 1 = True
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_aktiv(int id, int aktiv)throws ClassNotFoundException, SQLException{
		change_vertrag_aktiv(id,aktiv);
	}
}
