package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.Client;
import modele.metier.FichierImage;

public class RequeteClient extends Requete{
	
	public RequeteClient(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public Client getClientByMail(String mail) throws SQLException{
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
	
	public void addClient(Client client) throws SQLException{
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
	
	public void deleteClientById(String id) throws SQLException{
		//regrouper tous ses fichierImage
		ArrayList<FichierImage> bob = new RequeteFichierImage(conn).getAllFichierImageFromClient(getClientByMail(id));
		
		//les passer en non partageable
		for (int i=0; i<bob.size(); i++){
			bob.get(i).setPartage(false);
			new RequeteFichierImage(conn).updateFichierImage(bob.get(i));
		}
		
		//supprimer client
		PreparedStatement st = conn.prepareStatement("Delete from client where idClient = ?");
		st.setString(1, id);
		st.executeUpdate();
	}
}
