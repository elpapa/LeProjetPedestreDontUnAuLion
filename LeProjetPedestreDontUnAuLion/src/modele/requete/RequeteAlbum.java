package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.metier.*;

public class RequeteAlbum {

	public ArrayList<Album> getAllAlbumFromClient (Connection conn, Client client) throws SQLException{
		int idAlbum;
		
		//requete SQL
		PreparedStatement st = conn.prepareStatement("SELECT * FROM album WHERE client = ?");
		st.setString(1, client.getMail());
		ResultSet rs = st.executeQuery();
		
		//resultat
		ArrayList<Album> res = new ArrayList<Album>();
		while(rs.next()){
			idAlbum = rs.getInt("idAlbum");
			res.add(new Album(idAlbum, client, new RequetePhoto().getAllPhotoFromAlbumId(conn, idAlbum)));
		}
		
		return res;
	}
	
	public void addAlbum(Connection conn, Album album) throws SQLException{
		//recuperer l'id max d'une table
		int id = new Utilitaires().getMaxIdPlusUn(conn, "Album");
		
		//requete
		PreparedStatement st = conn.prepareStatement("INSERT INTO album VALUES (?,?)");
		st.setInt(1, id);
		st.setString(2, album.getProprietaire().getMail());
		st.executeUpdate();
	}
	
}
