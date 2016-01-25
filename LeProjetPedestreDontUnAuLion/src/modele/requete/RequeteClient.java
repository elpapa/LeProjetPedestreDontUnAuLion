package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.metier.Client;

public class RequeteClient {

	public Client getClientByMail(Connection conn, String mail) throws SQLException{
		Client client;
		String nom, prenom, adresse, password;
		int desactivate;
		boolean desacti;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM Client WHERE mail = ?");
		st.setString(1, mail);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			nom = rs.getString("nom");
			prenom = rs.getString("prenom");
			adresse = rs.getString("adressePostale");
			password = rs.getString("motDePasse");
			desactivate = rs.getInt("desactivate");
			if(desactivate == 0) desacti = false; else desacti = true;
			client = new Client(mail, nom, prenom, adresse, password, desacti);
		}else{
			client = null;
		}
		
		return client;
	}
}
