package modele;

/**
 * 
 * @author leovidal
 *
 */
public class FichierImage {

	private int idImage;
	private String path;
	private int resolution;
	private boolean partage;
	private int tempsExposition;
	private int iso;
	private int ouverture;
	
	
	public FichierImage(int idImage, String path, int resolution, boolean partage, int tempsExposition, int iso,
			int ouverture) {
		super();
		this.idImage = idImage;
		this.path = path;
		this.resolution = resolution;
		this.partage = partage;
		this.tempsExposition = tempsExposition;
		this.iso = iso;
		this.ouverture = ouverture;
	}
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	public boolean isPartage() {
		return partage;
	}
	public void setPartage(boolean partage) {
		this.partage = partage;
	}
	public int getTempsExposition() {
		return tempsExposition;
	}
	public void setTempsExposition(int tempsExposition) {
		this.tempsExposition = tempsExposition;
	}
	public int getIso() {
		return iso;
	}
	public void setIso(int iso) {
		this.iso = iso;
	}
	public int getOuverture() {
		return ouverture;
	}
	public void setOuverture(int ouverture) {
		this.ouverture = ouverture;
	}
	
	
}
