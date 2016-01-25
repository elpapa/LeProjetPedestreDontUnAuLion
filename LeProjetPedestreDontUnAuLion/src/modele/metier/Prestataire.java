package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class Prestataire {

	private int idPrestataire;
	private int preference;
	
	public Prestataire(int idPrestataire, int preference) {
		super();
		this.idPrestataire = idPrestataire;
		this.preference = preference;
	}
	public int getIdPrestataire() {
		return idPrestataire;
	}
	public void setIdPrestataire(int idPrestataire) {
		this.idPrestataire = idPrestataire;
	}
	public int getPreference() {
		return preference;
	}
	public void setPreference(int preference) {
		this.preference = preference;
	}
	
}
