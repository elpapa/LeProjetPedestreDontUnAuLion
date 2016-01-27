package modele.metier;

import java.util.ArrayList;

/**
 * 
 * @author leovidal
 *
 */
public class Format {

	private int idFormat;
	private int prixUnitaire;
	private String libelle;
	private int resolutionMini;
	private int nbPhotoJour;
	private int stockPapier;
	private ArrayList<FormatDispositif> listeDispositif;
	private ArrayList<FormatPrestataire> listePrestataire;
	
	

	public Format(int idFormat, int prixUnitaire, String libelle, int resolutionMini, int nbPhotoJour, int stockPapier,
			ArrayList<FormatDispositif> listeDispositif, ArrayList<FormatPrestataire> listePrestataire) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
		this.libelle = libelle;
		this.resolutionMini = resolutionMini;
		this.nbPhotoJour = nbPhotoJour;
		this.stockPapier = stockPapier;
		this.listeDispositif = listeDispositif;
		this.listePrestataire = listePrestataire;
	}

	public ArrayList<FormatPrestataire> getListePrestataire() {
		return listePrestataire;
	}

	public void setListePrestataire(ArrayList<FormatPrestataire> listePrestataire) {
		this.listePrestataire = listePrestataire;
	}

	public ArrayList<FormatDispositif> getListeDispositif() {
		return listeDispositif;
	}

	public void setListeDispositif(ArrayList<FormatDispositif> listeDispositif) {
		this.listeDispositif = listeDispositif;
	}

	public int getIdFormat() {
		return idFormat;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getResolutionMini() {
		return resolutionMini;
	}

	public void setResolutionMini(int resolutionMini) {
		this.resolutionMini = resolutionMini;
	}

	public int getNbPhotoJour() {
		return nbPhotoJour;
	}

	public void setNbPhotoJour(int nbPhotoJour) {
		this.nbPhotoJour = nbPhotoJour;
	}

	public int getStockPapier() {
		return stockPapier;
	}

	public void setStockPapier(int stockPapier) {
		this.stockPapier = stockPapier;
	}
	
	
}
