package datentypen;


public class Vertragsdaten {
	private int id = 0;
	private int kundennummer = 0;
	private int wohnungsnummer = 0;
	private String zeitraum = "";
	private double schulden = 0.0;
	private boolean aktiv = true;
	
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
	 * @return the kundennummer
	 */
	public int getKundennummer() {
		return kundennummer;
	}
	/**
	 * @param kundennummer the kundennummer to set
	 */
	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}
	/**
	 * @return the wohnungsnummer
	 */
	public int getWohnungsnummer() {
		return wohnungsnummer;
	}
	/**
	 * @param wohnungsnummer the wohnungsnummer to set
	 */
	public void setWohnungsnummer(int wohnungsnummer) {
		this.wohnungsnummer = wohnungsnummer;
	}
	/**
	 * @return the zeitraum
	 */
	public String getZeitraum() {
		return zeitraum;
	}
	/**
	 * @param zeitraum the zeitraum to set
	 */
	public void setZeitraum(String zeitraum) {
		this.zeitraum = zeitraum;
	}
	/**
	 * @return the schulden
	 */
	public double getSchulden() {
		return schulden;
	}
	/**
	 * @param schulden the schulden to set
	 */
	public void setSchulden(double schulden) {
		this.schulden = schulden;
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
	@Override
	public String toString() {
		return "" + id + "," + kundennummer + "," + wohnungsnummer
				+ "," + zeitraum + "," + schulden + "," + aktiv;
	}
	/**
	 * Wandelt die Vertragsdaten in einen String um
	 * @param input vom Typ Vertragsdaten
	 * @return String
	 */
	public String parseString(Vertragsdaten input) {
		return ""+input;
	}
}
