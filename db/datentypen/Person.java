package datentypen;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author johannmunchhagen
 *
 */
public class Person {
	private int id = 0;
	private String vorname = "";
	private String nachname = "";
	private String geburtsdatum = "";
	private String telefon = "";
	private String email = "";
	private boolean interessent = false;
	private boolean aktiv = true;
	/**
	 * @return the interessent
	 */
	public boolean isInteressent() {
		return interessent;
	}
	/**
	 * @param interessent the interessent to set
	 */
	public void setInteressent(boolean interessent) {
		this.interessent = interessent;
	}
	/**
	 * @return the aktiv
	 */
	public boolean isAktiv() {
		return aktiv;
	}
	/**
	 * @param aktiv the aktiv to set
	 */
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * @return the geburtsdatum
	 */
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	/**
	 * @param geburtsdatum the geburtsdatum to set
	 */
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}
	/**
	 * @param telefon the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "" + id + "," + vorname + "," + nachname + "," + geburtsdatum
				+ "," + telefon + "," + email + "," + interessent + "," + aktiv
				;
	}
	public String parseString(Person input) {
		return ""+input;
	}
	
	
}
