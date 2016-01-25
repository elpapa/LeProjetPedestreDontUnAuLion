package modele.metier;

/**
 * relation entre Album et Photo
 * @author leovidal
 *
 */
public class AlbumPhoto {

	private FichierImage image;
	private Photo photo;
	private Album album;
	
	public AlbumPhoto(FichierImage image, Photo photo, Album album) {
		super();
		this.image = image;
		this.photo = photo;
		this.album = album;
	}

	public FichierImage getImage() {
		return image;
	}

	public void setImage(FichierImage image) {
		this.image = image;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
