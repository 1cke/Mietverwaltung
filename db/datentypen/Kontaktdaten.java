package datentypen;
/**
 * Dieser Datentyp stellt alle benötigten Variablen für die Kontakte zu verfügung
 * @author Johann Muenchhagen
 * @version 1.0
 */
public class Kontaktdaten {
	private int id = 0;
	private int vertragsnummer = 0;
	private String wann = "";
	private String grund = "";
	private String beschreibung = "";
	private boolean behoben = false;
	/**
	 * @return the id
	 * 
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
	 * @return the vertragsnummer
	 */
	public int getVertragsnummer() {
		return vertragsnummer;
	}
	/**
	 * @param vertragsnummer the vertragsnummer to set
	 */
	public void setVertragsnummer(int vertragsnummer) {
		this.vertragsnummer = vertragsnummer;
	}
	/**
	 * @return the wann
	 */
	public String getWann() {
		return wann;
	}
	/**
	 * @param wann the wann to set
	 */
	public void setWann(String wann) {
		this.wann = wann;
	}
	/**
	 * @return the grund
	 */
	public String getGrund() {
		return grund;
	}
	/**
	 * @param grund the grund to set
	 */
	public void setGrund(String grund) {
		this.grund = grund;
	}
	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}
	/**
	 * @param beschreibung the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	/**
	 * @return the behoben
	 */
	public boolean isBehoben() {
		return behoben;
	}
	/**
	 * @param behoben the behoben to set
	 */
	public void setBehoben(boolean behoben) {
		this.behoben = behoben;
	}
	@Override
	public String toString() {
		return "" + id + "," + vertragsnummer + "," + wann + "," + grund
				+ "," + beschreibung + "," + behoben;
	}
	/**
	 * Die Methode die Kontaktdaten in einen String um
	 * @param input vom Typ Kontaktdaten
	 * @return String
	 */
	public String parseString(Kontaktdaten input) {
		return ""+input;
	}
}
