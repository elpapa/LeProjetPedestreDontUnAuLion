package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void addDispositifTirage(DispositifTirage dt) throws SQLException{
		//recuperer l'id max d'une table
		int id = new Utilitaires().getMaxIdPlusUn(conn, "Dispositif");
		
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO dispositifTirage VALUES (?)");
		st.setInt(1, id);
		st.executeUpdate();
	}
	
	public void deleteDispositifById(int id) throws SQLException{
		PreparedStatement st = conn.prepareStatement("Delete from dispositifTirage where idDispositif = ?");
		st.setInt(1, id);
		st.executeUpdate();
	}
}
