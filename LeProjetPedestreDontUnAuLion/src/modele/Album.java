package modele;

public class Album {

	private int idAlbum;
	private Client proprietaire;
	
	public Album(int idAlbum, Client proprietaire) {
		super();
		this.idAlbum = idAlbum;
		this.proprietaire = proprietaire;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
}
