package backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datentypen.Wohnungsdaten;

public class Wohnung extends Wohnungsdaten{
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
	private boolean set_db_value(int adress_id,double miete,double zimmer,double baeder, int ebk,int vermietet)throws ClassNotFoundException, SQLException{
		try {
			Connection connection = null;//setze Connection auf null
			connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			//Speicher die Kundendaten in der Tabelle
			statement.executeUpdate("INSERT INTO wohnung (adress_id,miete, zimmer,baeder,ebk,vermietet) VALUES ('"+adress_id+"','"+miete+"','"+zimmer+"','"+baeder+"','"+ebk+"','"+vermietet+"')");
			connection.close();
			return true;
		}catch(Exception e) {
			return false;
			}
		
	}
	private ArrayList<Wohnungsdaten> get_values(int wohnungsnummer,String Typ) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ArrayList<Wohnungsdaten> daten = new ArrayList<Wohnungsdaten>();
		if(Typ == "all") {
			ResultSet rs = statement.executeQuery("SELECT * FROM wohnung");
			while(rs.next()) {
				Wohnungsdaten w = new Wohnungsdaten();
				w.setId(rs.getInt(1));
				w.setAdresse(rs.getInt(2));
				w.setMiete(rs.getDouble(3));
				w.setZimmer(rs.getDouble(4));
				w.setBaeder(rs.getDouble(5));
				w.setEinbaukueche(rs.getBoolean(6));
				w.setVermietet(rs.getBoolean(7));
				daten.add(w);
			}
			connection.close();
			return daten;
		}else {
			ResultSet rs = statement.executeQuery("SELECT adress_id,miete,zimmer,baeder,ebk,vermietet FROM wohnung WHERE wohnungs_id = '"+wohnungsnummer+"'");
			while(rs.next()) {
				this.setAdresse(rs.getInt(1));
				this.setMiete(rs.getDouble(2));
				this.setZimmer(rs.getDouble(3));
				this.setBaeder(rs.getDouble(4));
				this.setEinbaukueche(rs.getBoolean(5));
				this.setVermietet(rs.getBoolean(6));
			}
			connection.close();
			this.setId(wohnungsnummer);
			return daten;
		}
		
	}
	private boolean change_db_value(String anweisung)throws ClassNotFoundException, SQLException{
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
	
	private int get_whg_adress_id()throws ClassNotFoundException, SQLException{
		return this.getAdresse();
	}
	private double get_whg_miete()throws ClassNotFoundException, SQLException{
		return this.getMiete();
	}
	private double get_whg_zimmer()throws ClassNotFoundException, SQLException{
		return this.getZimmer();
	}
	private double get_whg_baeder()throws ClassNotFoundException, SQLException{
		return this.getBaeder();
	}
	private boolean get_whg_ebk()throws ClassNotFoundException, SQLException{
		return this.isEinbaukueche();
	}
	private boolean get_whg_vermietet()throws ClassNotFoundException, SQLException{
		return this.isVermietet();
	}
	private boolean change_whg_miete(int whg_id,double miete)throws ClassNotFoundException, SQLException{
		return change_db_value("UPDATE wohnung SET miete = '"+miete+"' WHERE wohnungs_id = '"+whg_id+"'");
	}
	private void change_whg_zimmer(int whg_id,double zimmer)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET zimmer = '"+zimmer+"' WHERE wohnungs_id = '"+whg_id+"'");
	}
	private void change_whg_baeder(int whg_id,double baeder)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET baeder = '"+baeder+"' WHERE wohnungs_id = '"+whg_id+"'");
	}
	private void change_whg_ebk(int whg_id,int ebk)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET ebk = '"+ebk+"' WHERE wohnungs_id = '"+whg_id+"'");
	}
	private void change_whg_vermietet(int whg_id,int vermietet)throws ClassNotFoundException, SQLException{
		change_db_value("UPDATE wohnung SET vermietet = '"+vermietet+"' WHERE wohnungs_id = '"+whg_id+"'");
	}
	private ArrayList<Wohnungsdaten> display_all_whg() throws ClassNotFoundException, SQLException{
		return get_values(0,"all");
	}
	private boolean delete_whg(int whg_id)throws ClassNotFoundException, SQLException{
		return change_db_value("DELETE FROM wohnung WHERE wohnungs_id = '"+whg_id+"'");
	}
	/**
	 * Diese Methode lädt alle Wohnungsdaten bei bekannter Wohnungsnummer.
	 * @param wohnungsnummer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void lade_daten(int wohnungsnummer) throws ClassNotFoundException, SQLException{
		 get_values(wohnungsnummer,"");
	}
	/**
	 * Diese Methode erstellt eine Wohnung.
	 * @param adress_id Die Adress-ID als Integer.
	 * @param miete Die Miete als Double.
	 * @param zimmer Die Anzahl der Zimmer als Double.
	 * @param baeder Die Anzahl der Bäder als Double.
	 * @param ebk Einbauküche vorhanden? Als Integer 0 = False, 1 = True.
	 * @param vermietet Vermietet? Als Integre 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean set_wohnungen(int adress_id,double miete,double zimmer,double baeder,int ebk,int vermietet)throws ClassNotFoundException, SQLException{
		return set_db_value(adress_id,miete,zimmer,baeder,ebk,vermietet);
	}
	/**
	 * Diese Methode gibt die Adress-ID zurück.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @return Die Adress-ID als Integer.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int get_adress_id()throws ClassNotFoundException, SQLException{
		return get_whg_adress_id();
	}
	/**
	 * Diese Methode gibt die Höhe der Miete zurück.
	 * @param whg_id Diw Wohnungs-ID als Integer.
	 * @return Die Miete als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public double get_miete()throws ClassNotFoundException, SQLException{
		return get_whg_miete();
	}
	/**
	 * Diese Methode gibt die Anzahl der Zimmer zurück.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @return Die Anzahl der Zimmer als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public double get_zimmer()throws ClassNotFoundException, SQLException{
		return get_whg_zimmer();
	}
	/**
	 * Diese Methode gibt die Anzahl der Bäder aus.
	 * @param whg_id Die Wohnnungs-ID als Integer.
	 * @return Die Anzahl als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public double get_baeder()throws ClassNotFoundException, SQLException{
		return get_whg_baeder();
	}
	/**
	 * Diese Methode gibt das Vorhanden sein einer Einbauküche zurück.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @return Den Status der Einbauküche als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_ebk()throws ClassNotFoundException, SQLException{
		return get_whg_ebk();
	}
	/**
	 * Diese Methode gibt den Vermietetstatus der Wohnung zurück.
	 * @return Den Status als Boolean.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean get_vermietet()throws ClassNotFoundException, SQLException{
		return get_whg_vermietet();
	}
	/**
	 * Diese Methode ändert die Höhe der Miete.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param miete Die Höhe der Miete als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean change_miete(int whg_id,double miete)throws ClassNotFoundException, SQLException{
		return change_whg_miete(whg_id,miete);
	}
	/**
	 * Diese Methode ändert die Anzahl der Zimmer.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param zimmer Die Anzahl der Zimmer als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_zimmer(int whg_id,double zimmer)throws ClassNotFoundException, SQLException{
		change_whg_zimmer(whg_id,zimmer);
	}
	/**
	 * Diese Methode ändert die Anzahl der Bäder.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param baeder Die Anzahl der Bäder als Double.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_baeder(int whg_id,double baeder)throws ClassNotFoundException, SQLException{
		change_whg_baeder(whg_id,baeder);
	}
	/**
	 * Diese Methode ändert den Status, ob eine Einbauküche vorhanden ist.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param ebk Den Status als Integer. 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_ebk(int whg_id,int ebk)throws ClassNotFoundException, SQLException{
		change_whg_ebk(whg_id,ebk);
	}
	/**
	 * Diese Methode ändert den Vermietetstatus der Wohnung.
	 * @param whg_id Die Wohnungs-ID als Integer.
	 * @param vermietet	Den Status als Integer. 0 = False, 1 = True.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public void change_vermietet(int whg_id,int vermietet)throws ClassNotFoundException, SQLException{
		change_whg_vermietet(whg_id,vermietet);
	}
	/**
	 * Diese Methode zeigt alle Wohnungen an.
	 * <p> Es erfolgt keine Rückgabe</p>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public ArrayList<Wohnungsdaten> display()throws ClassNotFoundException, SQLException{
		return display_all_whg();
	}
	/**
	 * Löscht eine Wohnung
	 * @param wohnungs_id als Integer
	 * @return Boolean, ob geklappt oder nicht
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see ClassNotFoundException
	 * @see SQLException
	 */
	public boolean delete(int wohnungs_id)throws ClassNotFoundException, SQLException{
		return delete_whg(wohnungs_id);
	}
}
