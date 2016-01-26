package modele.metier;

import java.util.ArrayList;

public class Album {

	private int idAlbum;
	private Client proprietaire;
	private ArrayList<Photo> listePhoto;

	public Album(int idAlbum, Client proprietaire, ArrayList<Photo> listePhoto) {
		this.idAlbum = idAlbum;
		this.proprietaire = proprietaire;
		this.listePhoto = listePhoto;
	}

	public ArrayList<Photo> getListePhoto() {
		return listePhoto;
	}

	public void setListePhoto(ArrayList<Photo> listePhoto) {
		this.listePhoto = listePhoto;
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
