package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.Client;
import modele.metier.FichierImage;

public class RequeteFichierImage extends Requete{
	
	public RequeteFichierImage(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	Utilitaires util = new Utilitaires();

	public void addFichierImage (FichierImage fi) throws SQLException{
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
	
	public ArrayList<FichierImage> getAllFichierImageFromClient(Client client) throws SQLException{
		int id, resolution, expo, iso, ouverture;
		boolean partage;
		String path;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM fichierImage WHERE client = ?");
		st.setString(1, client.getMail());
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<FichierImage> res = new ArrayList<FichierImage>();
		while(rs.next()){
			id = rs.getInt("idFichierImage");
			resolution = rs.getInt("resolution");
			expo = rs.getInt("exposition");
			ouverture = rs.getInt("ouverture");
			iso = rs.getInt("iso");
			partage = util.getBooleanFromInt(rs.getInt("partage"));
			path = rs.getString("cheminAcces");
			res.add(new FichierImage(id, path, resolution, partage, expo, iso, ouverture, client));
		}
		
		return res;
	}
	
	public void deleteFichierImageFromId(int id) throws SQLException{
		PreparedStatement st = conn.prepareStatement("Delete from fichierImage where idFichierImage = ?");
		st.setInt(1, id);
		st.executeUpdate();
	}
	
	public FichierImage getFichierImageFromId (int id) throws SQLException{
		FichierImage FI = null;
		int resolution, expo, iso, ouverture;
		boolean partage;
		String path, mail;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM fichierImage WHERE idFichierImage = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			resolution = rs.getInt("resolution");
			expo = rs.getInt("exposition");
			ouverture = rs.getInt("ouverture");
			iso = rs.getInt("iso");
			partage = util.getBooleanFromInt(rs.getInt("partage"));
			path = rs.getString("cheminAcces");
			mail = rs.getString("client");
			Client client = new RequeteClient(conn).getClientByMail(mail);
			FI = new FichierImage(id, path, resolution, partage, expo, iso, ouverture, client);
		}
		
		return FI;
	}
	
	public void updateFichierImage (FichierImage fi) throws SQLException{
		PreparedStatement st = conn.prepareStatement("UPDATE fichierImage SET (cheminAcces = ?, partage = ?) WHERE idFichierImage = ? VALUES()");
		st.setString(1, fi.getPath());
		st.setInt(2, util.getIntFromBoolean(fi.isPartage()));
		st.setInt(3, fi.getIdImage());
		st.executeUpdate();
	}
}
