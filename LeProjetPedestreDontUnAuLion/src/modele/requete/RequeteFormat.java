package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.metier.Album;
import modele.metier.Client;
import modele.metier.Format;

public class RequeteFormat{

	public Format getFormatById(Connection conn, int idFormat) throws SQLException{
		int resolutionMini, prixUnitaire, nbPhotoJour, stockPapier;
		String libelle;
		Format format = null;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM format WHERE idFormat = ?");
		st.setInt(1, idFormat);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			resolutionMini = rs.getInt("resolutionMini");
			prixUnitaire = rs.getInt("prixUnitaire");
			nbPhotoJour = rs.getInt("nbPhotoJour");
			stockPapier = rs.getInt("stockPapier");
			libelle = rs.getString("libelle");
			
			format = new Format(idFormat, prixUnitaire, libelle, resolutionMini, nbPhotoJour, stockPapier);
		}
		return format;
	}
}
