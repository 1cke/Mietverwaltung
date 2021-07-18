package datentypen;

public class Wohnungsdaten {
	private int id = 0;
	private int adresse = 0;
	private double miete = 0.0;
	private double zimmer = 0.0;
	private double baeder = 0.0;
	private boolean einbaukueche = false;
	private boolean vermietet = false;
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
	 * @return the adresse
	 */
	public int getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the miete
	 */
	public double getMiete() {
		return miete;
	}
	/**
	 * @param miete the miete to set
	 */
	public void setMiete(double miete) {
		this.miete = miete;
	}
	/**
	 * @return the zimmer
	 */
	public double getZimmer() {
		return zimmer;
	}
	/**
	 * @param zimmer the zimmer to set
	 */
	public void setZimmer(double zimmer) {
		this.zimmer = zimmer;
	}
	/**
	 * @return the baeder
	 */
	public double getBaeder() {
		return baeder;
	}
	/**
	 * @param baeder the baeder to set
	 */
	public void setBaeder(double baeder) {
		this.baeder = baeder;
	}
	/**
	 * @return the einbaukueche
	 */
	public boolean isEinbaukueche() {
		return einbaukueche;
	}
	/**
	 * @param einbaukueche the einbaukueche to set
	 */
	public void setEinbaukueche(boolean einbaukueche) {
		this.einbaukueche = einbaukueche;
	}
	/**
	 * @return the vermietet
	 */
	public boolean isVermietet() {
		return vermietet;
	}
	/**
	 * @param vermietet the vermietet to set
	 */
	public void setVermietet(boolean vermietet) {
		this.vermietet = vermietet;
	}
	@Override
	public String toString() {
		return "Wohnungsdaten [id=" + id + ", adresse=" + adresse + ", miete=" + miete + ", zimmer=" + zimmer
				+ ", baeder=" + baeder + ", einbaukueche=" + einbaukueche + ", vermietet=" + vermietet + "]";
	}
}
