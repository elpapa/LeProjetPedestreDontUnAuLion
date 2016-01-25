package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class Photo {

	private int id;
	private String titre;
	private String commentaire;
	private FichierImage image;
	
	
	public Photo(int id, String titre, String commentaire, FichierImage image) {
		super();
		this.titre = titre;
		this.commentaire = commentaire;
		this.image = image;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public FichierImage getImage() {
		return image;
	}
	public void setImage(FichierImage image) {
		this.image = image;
	}
	
	
}
