package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class FormatPrestataire {

	private Prestataire prestataire;
	private Format format;
	private int delaisJour;
	
	public FormatPrestataire(Prestataire prestataire, Format format, int delaisJour) {
		super();
		this.prestataire = prestataire;
		this.format = format;
		this.delaisJour = delaisJour;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public int getDelaisJour() {
		return delaisJour;
	}

	public void setDelaisJour(int delaisJour) {
		this.delaisJour = delaisJour;
	}
	
}
