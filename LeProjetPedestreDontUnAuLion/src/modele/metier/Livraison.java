package modele.metier;

import java.sql.Date;

/**
 * 
 * @author leovidal
 *
 */
public class Livraison {

	private int idLivraison;
	private Commande commande;
	private Date dateEstimee;
	private String status;
	
	public Livraison(int idLivraison, Commande commande, Date dateEstimee, String status) {
		super();
		this.idLivraison = idLivraison;
		this.commande = commande;
		this.dateEstimee = dateEstimee;
		this.status = status;
	}

	public int getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Date getDateEstimee() {
		return dateEstimee;
	}

	public void setDateEstimee(Date dateEstimee) {
		this.dateEstimee = dateEstimee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
