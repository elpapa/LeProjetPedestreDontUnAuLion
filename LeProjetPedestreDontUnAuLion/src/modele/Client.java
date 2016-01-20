package modele;

/**
 * 
 * @author leovidal
 *
 */
public class Client {

	private String mail;
	private String nom;
	private String prenom;
	private String adressePostale;
	private String password;
	private boolean desactivate;
	
	public Client(String mail, String nom, String prenom, String adressePostale, String password, boolean desactivate) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.adressePostale = adressePostale;
		this.password = password;
		this.desactivate = desactivate;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdressePostale() {
		return adressePostale;
	}
	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDesactivate() {
		return desactivate;
	}

	public void setDesactivate(boolean desactivate) {
		this.desactivate = desactivate;
	}
	//change
	
}
