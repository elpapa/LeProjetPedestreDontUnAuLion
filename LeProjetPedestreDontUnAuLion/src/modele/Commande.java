package modele;

import java.sql.Date;

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
	
	public Commande(int refCommande, Date dateCommande, int prixTotal, Client client, String status) {
		super();
		this.refCommande = refCommande;
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.client = client;
		this.status = status;
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
