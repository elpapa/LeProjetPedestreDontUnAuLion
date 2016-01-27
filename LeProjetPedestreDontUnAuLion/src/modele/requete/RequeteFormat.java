package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequeteFormat extends Requete{

	public RequeteFormat(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public Format getFormatById(int idFormat) throws SQLException{
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
			ArrayList<FormatDispositif> listeD = getFormatDispositifFromFormatId(idFormat);
			ArrayList<FormatPrestataire> listeP = getFormatPrestataireFromFormatId(idFormat);
			
			format = new Format(idFormat, prixUnitaire, libelle, resolutionMini, nbPhotoJour, stockPapier, listeD, listeP);
		}
		return format;
	}
	
	public ArrayList<FormatDispositif> getFormatDispositifFromFormatId (int idFormat) throws SQLException{
		int idDispositif, quantite;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM formatDispositif WHERE idFormat = ?");
		st.setInt(1, idFormat);
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<FormatDispositif> res = new ArrayList<FormatDispositif>();
		while(rs.next()){
			idDispositif = rs.getInt("idDispositif");
			quantite = rs.getInt("quantitePossible");
			res.add(new FormatDispositif(new RequeteDispositif(conn).getDispositifById(idDispositif), quantite));
		}
		
		return res;
	}
	
	public ArrayList<FormatPrestataire> getFormatPrestataireFromFormatId (int idFormat) throws SQLException{
		int idPrestataire, delais;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM formatPrestataire WHERE idFormat = ?");
		st.setInt(1, idFormat);
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<FormatPrestataire> res = new ArrayList<FormatPrestataire>();
		while(rs.next()){
			idPrestataire = rs.getInt("idPrestataire");
			delais = rs.getInt("delaisEnJour");
			res.add(new FormatPrestataire(new RequetePrestataire(conn).getPrestataireById(idPrestataire), delais));
		}
		
		return res;
	}
}
