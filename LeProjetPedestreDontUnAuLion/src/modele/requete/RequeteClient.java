package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.metier.Client;

public class RequeteClient {
	
	Utilitaires util = new Utilitaires();

	public Client getClientByMail(Connection conn, String mail) throws SQLException{
		Client client;
		String nom, prenom, adresse, password;
		int desactivate;
		boolean desacti = false;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM client WHERE mail = ?");
		st.setString(1, mail);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			nom = rs.getString("nom");
			prenom = rs.getString("prenom");
			adresse = rs.getString("adressePostale");
			password = rs.getString("motDePasse");
			desactivate = rs.getInt("desactivate");
			desacti = util.getBooleanFromInt(desactivate);
			client = new Client(mail, nom, prenom, adresse, password, desacti);
		}else{
			client = null;
		}
		
		return client;
	}
	
	public void addClient(Connection conn, Client client) throws SQLException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO client VALUES (?,?,?,?,?,?)");
		// Execute the query
		st.setString(1, client.getMail());
		st.setString(2, client.getNom());
		st.setString(3, client.getPrenom());
		st.setString(4, client.getAdressePostale());
		st.setString(5, client.getPassword());
		int d = util.getIntFromBoolean(client.isDesactivate());
		st.setInt(6, d);
		st.executeUpdate();
	}
}
