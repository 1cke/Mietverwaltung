import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Wohnung {
	public Wohnung() throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS wohnung(wohnungs_id INTEGER PRIMARY KEY, adress_id INTEGER NOT NULL, miete DOUBLE,zimmer DOUBLE NOT NULL,baeder DOUBLE NOT NULL,ebk BOOLEAN,vermietet BOOLEAN)");
		connection.close();
	}
	private void set_db_value(int adress_id,double miete,double zimmer,double baeder, int ebk,int vermietet)throws ClassNotFoundException, SQLException{
		Connection connection = null;//setze Connection auf null
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//Speicher die Kundendaten in der Tabelle
		statement.executeUpdate("INSERT INTO wohnung (adress_id,miete, zimmer,baeder,ebk,vermietet) VALUES ('"+adress_id+"','"+miete+"','"+zimmer+"','"+baeder+"','"+ebk+"','"+vermietet+"')");
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
	private int get_whg_id(int adress_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT wohnungs_id FROM wohnung WHERE adress_id = '"+adress_id+"'")[0]);
	}
	private int get_whg_adress_id(int whg_id)throws ClassNotFoundException, SQLException{
		return Integer.parseInt(get_values("SELECT adress_id FROM wohnung WHERE wohnungs_id = '"+whg_id+"'")[0]);
	}
	private double get_whg_miete(int whg_id)throws ClassNotFoundException, SQLException{
		return Double.parseDouble(get_values("SELECT miete FROM wohnung WHERE wohnungs_id = '"+whg_id+"'")[0]);
	}
	private double get_whg_zimmer(int whg_id)throws ClassNotFoundException, SQLException{
		return Double.parseDouble(get_values("SELECT zimmer FROM wohnung WHERE wohnungs_id = '"+whg_id+"'")[0]);
	}
	private double get_whg_baeder(int whg_id)throws ClassNotFoundException, SQLException{
		return Double.parseDouble(get_values("SELECT baeder FROM wohnung WHERE wohnungs_id = '"+whg_id+"'")[0]);
	}
	private boolean get_whg_ebk(int whg_id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT ebk FROM wohnung WHERE wohnungs_id = '"+whg_id+"'");
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
	private boolean get_whg_vermietet(int whg_id)throws ClassNotFoundException, SQLException{
		String[] s = get_values("SELECT vermietet FROM wohnung WHERE wohnungs_id = '"+whg_id+"'");
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
	private void change_whg_miete(int whg_id,double miete)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET miete = '"+miete+"' WHERE wohungs_id = '"+whg_id+"'");
	}
	private void change_whg_zimmer(int whg_id,double zimmer)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET zimmer = '"+zimmer+"' WHERE wohungs_id = '"+whg_id+"'");
	}
	private void change_whg_baeder(int whg_id,double baeder)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET baeder = '"+baeder+"' WHERE wohungs_id = '"+whg_id+"'");
	}
	private void change_whg_ebk(int whg_id,int ebk)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET ebk = '"+ebk+"' WHERE wohungs_id = '"+whg_id+"'");
	}
	private void change_whg_vermietet(int whg_id,int vermietet)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET vermietet = '"+vermietet+"' WHERE wohungs_id = '"+whg_id+"'");
	}
	private void display_all_whg() throws ClassNotFoundException, SQLException{
		String[] werte = get_values("SELECT wohnungs_id FROM wohnung");
		for(int i =0; i<werte.length;i++) {
			int id = Integer.parseInt(werte[i]);
			System.out.println(id +" "+get_whg_adress_id(id)+" "+get_whg_miete(id) + " "+get_whg_zimmer(id) + " "+get_whg_baeder(id)+" "+get_whg_ebk(id)+" "+get_whg_vermietet(id));
			}
	}
	public void set_wohnungen(int adress_id,double miete,double zimmer,double baeder,int ebk,int vermietet)throws ClassNotFoundException, SQLException{
		set_db_value(adress_id,miete,zimmer,baeder,ebk,vermietet);
	}
	public int get_whg_nr(int adress_id)throws ClassNotFoundException, SQLException{
		return get_whg_id(adress_id);
	}
	public int get_adress_id(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_adress_id(whg_id);
	}
	public double get_miete(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_miete(whg_id);
	}
	public double get_zimmer(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_zimmer(whg_id);
	}
	public double get_baeder(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_baeder(whg_id);
	}
	public boolean get_ebk(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_ebk(whg_id);
	}
	public boolean get_vermietet(int whg_id)throws ClassNotFoundException, SQLException{
		return get_whg_vermietet(whg_id);
	}
	public void change_miete(int whg_id,double miete)throws ClassNotFoundException, SQLException{
		change_whg_miete(whg_id,miete);
	}
	public void change_zimmer(int whg_id,double zimmer)throws ClassNotFoundException, SQLException{
		change_whg_zimmer(whg_id,zimmer);
	}
	public void change_baeder(int whg_id,double baeder)throws ClassNotFoundException, SQLException{
		change_whg_baeder(whg_id,baeder);
	}
	public void change_ebk(int whg_id,int ebk)throws ClassNotFoundException, SQLException{
		change_whg_ebk(whg_id,ebk);
	}
	public void change_vermietet(int whg_id,int vermietet)throws ClassNotFoundException, SQLException{
		change_whg_vermietet(whg_id,vermietet);
	}
	public void display()throws ClassNotFoundException, SQLException{
		display_all_whg();
	}
}
