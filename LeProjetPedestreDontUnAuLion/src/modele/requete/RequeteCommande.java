package modele.requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequeteCommande extends Requete{
	
	public RequeteCommande(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Commande> getAllCommandeFromClient (Client client) throws SQLException{
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
			
			res.add(new Commande(refCommande, dateCommande, prixTotal, client, statutCommande, paye, getAllArticleFromCommandeId(refCommande)));
		}
		
		return res;
	}
	
	public ArrayList<AlbumCommande> getAllArticleFromCommandeId(int refCommande) throws SQLException{
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
			album = new RequeteAlbum(conn).getAlbumFromId(idAlbum);
			format = new RequeteFormat(conn).getFormatById(idFormat);
			prestataire = new RequetePrestataire(conn).getPrestataireById(idPrestataire);
			res.add(new AlbumCommande(album, format, quantite, prestataire));
		}
		
		return res;
	}
	
	public Commande getCommandeByRef (int ref) throws SQLException{
		int prixTotal;
		boolean paye;
		String statutCommande;
		Date dateCommande;
		Commande res = null;
		Client client;
		
		PreparedStatement st = conn.prepareStatement("SELECT * FROM commande WHERE refCommande = ?");
		st.setInt(1, ref);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			prixTotal = rs.getInt("prixTotal");
			paye = util.getBooleanFromInt(rs.getInt("paye"));
			statutCommande = rs.getString("statutCommande");
			client = new RequeteClient(conn).getClientByMail(rs.getString("mailClient"));
			dateCommande = rs.getDate("dateCommande");
			
			res = new Commande(ref, dateCommande, prixTotal, client, statutCommande, paye, getAllArticleFromCommandeId(ref));
		}
		
		return res;
	}
	
	public void addCommande(Commande c) throws SQLException{
		
		//recuperer l'id max d'une table
		int refCommande = util.getMaxRefCommandePlusUn(conn);
		
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO commande VALUES (?,?,?,?,?,?)");
		st.setInt(1, refCommande);
		st.setDate(2, c.getDateCommande());
		st.setInt(3, c.getPrixTotal());
		st.setString(4, c.getStatus());
		st.setString(5, c.getClient().getMail());
		st.setInt(6, util.getIntFromBoolean(c.isPaye()));
		st.executeUpdate();
		
	}
	
	public void updateCommande(Commande c) throws SQLException{
		PreparedStatement st = conn.prepareStatement("UPDATE commande SET (statut = ?, paye = ?) WHERE refCommande = ?");
		st.setString(1, c.getStatus());
		st.setInt(2, util.getIntFromBoolean(c.isPaye()));
		st.setInt(3, c.getRefCommande());
		st.executeUpdate();
	}
}
