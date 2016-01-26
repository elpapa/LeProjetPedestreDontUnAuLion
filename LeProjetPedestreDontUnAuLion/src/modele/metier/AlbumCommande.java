package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class AlbumCommande {

	private Album album;
	private Format format;
	private int quantite;
	private Prestataire prestataire;
	


	public AlbumCommande(Album album, Format format, int quantite, Prestataire prestataire) {
		super();
		this.album = album;
		this.format = format;
		this.quantite = quantite;
		this.prestataire = prestataire;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantité(int quantite) {
		this.quantite = quantite;
	}
	
	
}
