package modele;

/**
 * 
 * @author leovidal
 *
 */
public class AlbumCommande {

	private Commande commande;
	private Album album;
	private Format format;
	private int quantite;
	
	public AlbumCommande(Commande commande, Album album, Format format, int quantité) {
		super();
		this.commande = commande;
		this.album = album;
		this.format = format;
		this.quantite = quantité;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
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

	public int getQuantité() {
		return quantite;
	}

	public void setQuantité(int quantité) {
		this.quantite = quantité;
	}
	
	
}
