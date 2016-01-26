package modele.metier;

import java.sql.Date;
import java.util.ArrayList;

/**
 * 
 * @author leovidal
 *
 */
public class Commande {

	private int refCommande;
	private Date dateCommande;
	private int prixTotal;
	private Client client;
	private String status;
	private boolean paye;
	private ArrayList<AlbumCommande> articles;
	

	public Commande(int refCommande, Date dateCommande, int prixTotal, Client client, String status, boolean paye,
			ArrayList<AlbumCommande> articles) {
		super();
		this.refCommande = refCommande;
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.client = client;
		this.status = status;
		this.paye = paye;
		this.articles = articles;
	}


	public ArrayList<AlbumCommande> getArticles() {
		return articles;
	}


	public void setArticles(ArrayList<AlbumCommande> articles) {
		this.articles = articles;
	}


	public boolean isPaye() {
		return paye;
	}


	public void setPaye(boolean paye) {
		this.paye = paye;
	}


	public int getRefCommande() {
		return refCommande;
	}

	public void setRefCommande(int refCommande) {
		this.refCommande = refCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
