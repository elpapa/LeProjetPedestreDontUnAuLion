package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modele.metier.Album;
import modele.metier.Client;
import modele.metier.DispositifTirage;

public class RequeteDispositif extends Requete{

	public RequeteDispositif(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public DispositifTirage getDispositifById(int idDispositif){
		DispositifTirage dt = new DispositifTirage(idDispositif);
		return dt;
	}
}
