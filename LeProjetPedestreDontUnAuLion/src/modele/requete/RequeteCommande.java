package modele.requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequeteCommande {
	
	public Utilitaires util = new Utilitaires();

	public ArrayList<Commande> getAllCommandeFromClient (Connection conn, Client client) throws SQLException{
		int refCommande, prixTotal;
		boolean paye;
		String statutCommande;
		Date dateCommande;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM commande WHERE mailClient = ?");
		st.setString(1, client.getMail());
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<Commande> res = new ArrayList<Commande>();
		while(rs.next()){
			refCommande = rs.getInt("refCommande");
			prixTotal = rs.getInt("prixTotal");
			paye = util.getBooleanFromInt(rs.getInt("paye"));
			statutCommande = rs.getString("statutCommande");
			dateCommande = rs.getDate("dateCommande");
			
			res.add(new Commande(refCommande, dateCommande, prixTotal, client, statutCommande, paye, getAllArticleFromCommandeId(conn, refCommande)));
		}
		
		return res;
	}
	
	public ArrayList<AlbumCommande> getAllArticleFromCommandeId(Connection conn, int refCommande) throws SQLException{
		Album album;
		Format format;
		int quantite, idAlbum, idPrestataire, idFormat;
		Prestataire prestataire;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM Article WHERE refCommande = ?");
		st.setInt(1, refCommande);
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<AlbumCommande> res = new ArrayList<AlbumCommande>();
		while(rs.next()){
			idAlbum = rs.getInt("idAlbum");
			idFormat = rs.getInt("idFormat");
			idPrestataire = rs.getInt("idPrestataire");
			quantite = rs.getInt("quantite");
			album = new RequeteAlbum().getAlbumFromId(conn, idAlbum);
			format = new RequeteFormat().getFormatById(conn, idFormat);
			prestataire = new RequetePrestataire().getPrestataireById(conn, idPrestataire);
			res.add(new AlbumCommande(album, format, quantite, prestataire));
		}
		
		return res;
	}
}
