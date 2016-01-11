package modele;

/**
 * 
 * @author leovidal
 *
 */
public class Livre extends Album {

	private String preface;
	private String postface;
	private Photo couverture;
	private String titreCouverture;
	
	public Livre(int idAlbum, Client proprietaire, String preface, String postface, Photo couverture,
			String titreCouverture) {
		super(idAlbum, proprietaire);
		this.preface = preface;
		this.postface = postface;
		this.couverture = couverture;
		this.titreCouverture = titreCouverture;
	}

	public String getPreface() {
		return preface;
	}

	public void setPreface(String preface) {
		this.preface = preface;
	}

	public String getPostface() {
		return postface;
	}

	public void setPostface(String postface) {
		this.postface = postface;
	}

	public Photo getCouverture() {
		return couverture;
	}

	public void setCouverture(Photo couverture) {
		this.couverture = couverture;
	}

	public String getTitreCouverture() {
		return titreCouverture;
	}

	public void setTitreCouverture(String titreCouverture) {
		this.titreCouverture = titreCouverture;
	}
	
	
}
