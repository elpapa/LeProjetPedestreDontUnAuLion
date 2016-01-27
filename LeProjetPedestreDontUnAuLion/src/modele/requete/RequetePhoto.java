package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequetePhoto extends Requete{

	public RequetePhoto(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Photo> getAllPhotoFromClient (Client client) throws SQLException{
		int idPhoto, idFichierImage;
		String titre, commentaire;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM photo P WHERE client = ?");
		st.setString(1, client.getMail());
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<Photo> res = new ArrayList<Photo>();
		while(rs.next()){
			idFichierImage = rs.getInt("idFichierImage");
			idPhoto = rs.getInt("idPhoto");
			titre = rs.getString("titre");
			commentaire = rs.getString("commentaire");
			res.add(new Photo(idPhoto, titre, commentaire, new RequeteFichierImage(conn).getFichierImageFromId(idFichierImage)));
		}
		
		return res;
	}
	
	public Photo getPhotoFromId (int idPhoto) throws SQLException{
		Photo photo = null;
		int idFichierImage;
		String titre, commentaire;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM photo WHERE idPhoto = ?");
		st.setInt(1, idPhoto);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			idFichierImage = rs.getInt("idFichierImage");
			titre = rs.getString("titre");
			commentaire = rs.getString("commentaire");
			photo = new Photo(idPhoto, titre, commentaire, new RequeteFichierImage(conn).getFichierImageFromId(idFichierImage));
		}
		
		return photo;
	}
	
	public void deletePhotoFromId (int idPhoto) throws SQLException{
		PreparedStatement st = conn.prepareStatement("Delete from photo where idPhoto = ?");
		st.setInt(1, idPhoto);
		st.executeUpdate();
	}
	
	public ArrayList<Photo> getAllPhotoFromAlbumId (int idAlbum) throws SQLException{
		int idPhoto, idFichierImage;
		String titre, commentaire;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT P.idPhoto, P.titrePhoto, P.commentaire, P.idFichierImage FROM photo P, albumPhoto A WHERE A.idPhoto = P.idPhoto AND A.idAlbum = ?");
		st.setInt(1, idAlbum);
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<Photo> res = new ArrayList<Photo>();
		while(rs.next()){
			idFichierImage = rs.getInt("idFichierImage");
			idPhoto = rs.getInt("idPhoto");
			titre = rs.getString("titre");
			commentaire = rs.getString("commentaire");
			res.add(new Photo(idPhoto, titre, commentaire, new RequeteFichierImage(conn).getFichierImageFromId(idFichierImage)));
		}
		
		return res;
	}
	
	public void addPhoto(Photo photo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO photo VALUES (?,?,?,?)");
		st.setInt(1, photo.getId());
		st.setString(2, photo.getTitre());
		st.setString(3, photo.getCommentaire());
		st.setInt(4, photo.getImage().getIdImage());
		st.executeUpdate();
	}
	
	public void updatePhoto(Photo photo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("UPDATE photo SET (titre = ?, commentaire = ?) WHERE idPhoto = ? VALUES()");
		st.setString(1, photo.getTitre());
		st.setString(1, photo.getCommentaire());
		st.setInt(3, photo.getId());
		st.executeUpdate();
	}
}
