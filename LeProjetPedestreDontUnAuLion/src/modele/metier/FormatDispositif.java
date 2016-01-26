package modele.metier;

/**
 * 
 * @author leovidal
 *
 */
public class FormatDispositif {

	private DispositifTirage dispositif;
	private int quantitePossible;
	
	public FormatDispositif(DispositifTirage dispositif, int quantitePossible) {
		super();
		this.dispositif = dispositif;
		this.quantitePossible = quantitePossible;
	}

	public DispositifTirage getDispositif() {
		return dispositif;
	}

	public void setDispositif(DispositifTirage dispositif) {
		this.dispositif = dispositif;
	}

	public int getQuantitePossible() {
		return quantitePossible;
	}

	public void setQuantitePossible(int quantitePossible) {
		this.quantitePossible = quantitePossible;
	}
	
}
