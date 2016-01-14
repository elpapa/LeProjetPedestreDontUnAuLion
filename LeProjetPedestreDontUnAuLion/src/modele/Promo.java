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
	
	public Promo(int idPromo,  Client client, float montant) {
		super();
		this.idPromo = idPromo;
		this.client = client;
		this.montant = montant;
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
