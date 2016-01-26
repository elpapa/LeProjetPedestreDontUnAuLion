package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.metier.Format;
import modele.metier.Prestataire;

public class RequetePrestataire{
	public Prestataire getPrestataireById(Connection conn, int idPrestataire) throws SQLException{
		int preference;
		Prestataire presta = null;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM prestataire WHERE idPrestataire = ?");
		st.setInt(1, idPrestataire);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			preference = rs.getInt("preference");
			
			presta = new Prestataire(idPrestataire, preference);
		}
		return presta;
	}
}
