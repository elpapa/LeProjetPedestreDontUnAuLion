package modele;

/**
 * 
 * @author leovidal
 *
 */
public class Promo {

	private int idPromo;
	private Commande utilisePourCommande;
	private Client client;
	
	public Promo(int idPromo, Commande utilisePourCommande, Client client) {
		super();
		this.idPromo = idPromo;
		this.utilisePourCommande = utilisePourCommande;
		this.client = client;
	}
	public int getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}
	public Commande getUtilisePourCommande() {
		return utilisePourCommande;
	}
	public void setUtilisePourCommande(Commande utilisePourCommande) {
		this.utilisePourCommande = utilisePourCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
