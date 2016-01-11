package modele;

/**
 * 
 * @author leovidal
 *
 */
public class Photo {

	private String titre;
	private String commentaire;
	private FichierImage image;
	
	
	public Photo(String titre, String commentaire, FichierImage image) {
		super();
		this.titre = titre;
		this.commentaire = commentaire;
		this.image = image;
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
