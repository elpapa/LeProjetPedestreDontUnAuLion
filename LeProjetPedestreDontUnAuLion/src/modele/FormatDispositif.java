package modele;

/**
 * 
 * @author leovidal
 *
 */
public class FormatDispositif {

	private DispositifTirage dispositif;
	private Format format;
	private int quantitePossible;
	
	public FormatDispositif(DispositifTirage dispositif, Format format, int quantitePossible) {
		super();
		this.dispositif = dispositif;
		this.format = format;
		this.quantitePossible = quantitePossible;
	}

	public DispositifTirage getDispositif() {
		return dispositif;
	}

	public void setDispositif(DispositifTirage dispositif) {
		this.dispositif = dispositif;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public int getQuantitePossible() {
		return quantitePossible;
	}

	public void setQuantitePossible(int quantitePossible) {
		this.quantitePossible = quantitePossible;
	}
	
}
