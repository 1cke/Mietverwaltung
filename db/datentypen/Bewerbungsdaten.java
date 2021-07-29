package datentypen;
/**
 * Dieser Datntyp stellt alle benötigten Variablen für die Bewerbung zu verfügung
 * @author Johann Muenchhagen
 * @version 1.0
 */
public class Bewerbungsdaten {
	private int id = 0;
	private int kundenummer = 0;
	private int wohnungsnummer = 0;
	private String datum ="";
	private boolean status = true;
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
	 * @return the kundenummer
	 */
	public int getKundenummer() {
		return kundenummer;
	}
	/**
	 * @param kundenummer the kundenummer to set
	 */
	public void setKundenummer(int kundenummer) {
		this.kundenummer = kundenummer;
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
	 * @return the datum
	 */
	public String getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "" + id + "," + kundenummer + "," + wohnungsnummer
				+ "," + datum + "," + status;
	}
	public String parseString(Bewerbungsdaten input) {
		return ""+input;
	}
}
