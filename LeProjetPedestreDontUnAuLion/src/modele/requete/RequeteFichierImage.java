package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.metier.FichierImage;

public class RequeteFichierImage {
	
	Utilitaires util = new Utilitaires();

	public void addFichierImage (Connection conn, FichierImage fi) throws SQLException{
		//recuperer l'id max d'une table
		int id = new Utilitaires().getMaxIdPlusUn(conn, "FichierImage");
		
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO fichierImage VALUES (?,?,?,?,?,?,?,?)");
		st.setInt(1, id);
		st.setString(2, fi.getPath());
		st.setInt(3, fi.getResolution());
		st.setInt(4, util.getIntFromBoolean(fi.isPartage()));
		st.setInt(5, fi.getTempsExposition());
		st.setInt(6, fi.getOuverture());
		st.setInt(7, fi.getIso());
		st.setString(8, fi.getClient().getMail());
		st.executeUpdate();
	}
}
