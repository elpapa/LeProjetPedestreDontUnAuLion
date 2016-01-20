package modele;

/**
 * 
 * @author leovidal
 *
 */
public class Promo {

	private int idPromo;
	private Client client;
	private float montant;
	private Commande commande;
	
	
	public Promo(int idPromo, Client client, float montant, Commande commande) {
		super();
		this.idPromo = idPromo;
		this.client = client;
		this.montant = montant;
		this.commande = commande;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public int getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
}
