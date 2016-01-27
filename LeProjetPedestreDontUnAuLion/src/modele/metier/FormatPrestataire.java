package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class FormatPrestataire {

	private Prestataire prestataire;
	private int delaisJour;
	
	public FormatPrestataire(Prestataire prestataire, int delaisJour) {
		super();
		this.prestataire = prestataire;
		this.delaisJour = delaisJour;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public int getDelaisJour() {
		return delaisJour;
	}

	public void setDelaisJour(int delaisJour) {
		this.delaisJour = delaisJour;
	}
	
}
