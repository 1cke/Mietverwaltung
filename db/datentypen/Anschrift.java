package datentypen;

public class Anschrift {
	private int id = 0;
	private String plz = "";
	private String ort = "";
	private String strasse = "";
	private String hausnummer = "";
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
	@Override
	public String toString() {
		return "" + id + "," + plz + "," + ort + ", " + strasse + ","
				+ hausnummer;
	}
	/**
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}
	/**
	 * @param plz the plz to set
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * @param ort the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	/**
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}
	/**
	 * @param strasse the strasse to set
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	/**
	 * @return the hausnummer
	 */
	public String getHausnummer() {
		return hausnummer;
	}
	/**
	 * @param hausnummer the hausnummer to set
	 */
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	/**
	 * Wandelt den Input in einen String um
	 * @param input vom Typ Anschrift
	 * @return String
	 */
	public String parseString(Anschrift input) {
		return ""+input;
	}
}
