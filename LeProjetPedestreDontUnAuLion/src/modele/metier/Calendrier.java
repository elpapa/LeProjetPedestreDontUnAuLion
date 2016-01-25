package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public abstract class Calendrier extends Album {
	
	private Photo janvier;
	private Photo fevrier;
	private Photo mars;
	private Photo avril;
	private Photo mai;
	private Photo juin;
	private Photo juillet;
	private Photo aout;
	private Photo septembre;
	private Photo octobre;
	private Photo novembre;
	private Photo decembre;
	private Photo couverture;

	public Calendrier(int idAlbum, Client proprietaire, Photo janvier, Photo fevrier, Photo mars, Photo avril,
			Photo mai, Photo juin, Photo juillet, Photo aout, Photo septembre, Photo octobre, Photo novembre,
			Photo decembre, Photo couverture) {
		super(idAlbum, proprietaire);
		this.janvier = janvier;
		this.fevrier = fevrier;
		this.mars = mars;
		this.avril = avril;
		this.mai = mai;
		this.juin = juin;
		this.juillet = juillet;
		this.aout = aout;
		this.septembre = septembre;
		this.octobre = octobre;
		this.novembre = novembre;
		this.decembre = decembre;
		this.couverture = couverture;
	}

	public Photo getJanvier() {
		return janvier;
	}

	public void setJanvier(Photo janvier) {
		this.janvier = janvier;
	}

	public Photo getFevrier() {
		return fevrier;
	}

	public void setFevrier(Photo fevrier) {
		this.fevrier = fevrier;
	}

	public Photo getMars() {
		return mars;
	}

	public void setMars(Photo mars) {
		this.mars = mars;
	}

	public Photo getAvril() {
		return avril;
	}

	public void setAvril(Photo avril) {
		this.avril = avril;
	}

	public Photo getMai() {
		return mai;
	}

	public void setMai(Photo mai) {
		this.mai = mai;
	}

	public Photo getJuin() {
		return juin;
	}

	public void setJuin(Photo juin) {
		this.juin = juin;
	}

	public Photo getJuillet() {
		return juillet;
	}

	public void setJuillet(Photo juillet) {
		this.juillet = juillet;
	}

	public Photo getAout() {
		return aout;
	}

	public void setAout(Photo aout) {
		this.aout = aout;
	}

	public Photo getSeptembre() {
		return septembre;
	}

	public void setSeptembre(Photo septembre) {
		this.septembre = septembre;
	}

	public Photo getOctobre() {
		return octobre;
	}

	public void setOctobre(Photo octobre) {
		this.octobre = octobre;
	}

	public Photo getNovembre() {
		return novembre;
	}

	public void setNovembre(Photo novembre) {
		this.novembre = novembre;
	}

	public Photo getDecembre() {
		return decembre;
	}

	public void setDecembre(Photo decembre) {
		this.decembre = decembre;
	}

	public Photo getCouverture() {
		return couverture;
	}

	public void setCouverture(Photo couverture) {
		this.couverture = couverture;
	}
	
	

}
