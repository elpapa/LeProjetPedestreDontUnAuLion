package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequeteAlbum extends Requete{

	public RequeteAlbum(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Album> getAllAlbumFromClient (Client client) throws SQLException{
		int idAlbum;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM album WHERE client = ?");
		st.setString(1, client.getMail());
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<Album> res = new ArrayList<Album>();
		while(rs.next()){
			idAlbum = rs.getInt("idAlbum");
			res.add(new Album(idAlbum, client, new RequetePhoto(conn).getAllPhotoFromAlbumId(idAlbum)));
		}
		
		return res;
	}
	
	public void addAlbum(Album album) throws SQLException{
		//recuperer l'id max d'une table
		int id = new Utilitaires().getMaxIdPlusUn(conn, "Album");
		
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO album VALUES (?,?)");
		st.setInt(1, id);
		st.setString(2, album.getProprietaire().getMail());
		st.executeUpdate();
	}
	
	public Album getAlbumFromId(int id) throws SQLException{
		Client client;
		Album album = null;
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM album WHERE idAlbum = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		//resultat
		if(rs.next()){
			client = new RequeteClient(conn).getClientByMail(rs.getString("client"));
			album = new Album(id, client, new RequetePhoto(conn).getAllPhotoFromAlbumId(id));
		}
		return album;
	}
	
	public void addPhotoToAlbum(Album album, Photo photo) throws SQLException{
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO albumPhoto VALUES (?,?)");
		st.setInt(1, photo.getId());
		st.setInt(2, album.getIdAlbum());
		st.executeUpdate();
	}
	
	public void deleteAlbumById(int idAlbum) throws SQLException{
		PreparedStatement st = conn.prepareStatement("Delete from album where idAlbum = ?");
		st.setInt(1, idAlbum);
		st.executeUpdate();
	}
	
}
