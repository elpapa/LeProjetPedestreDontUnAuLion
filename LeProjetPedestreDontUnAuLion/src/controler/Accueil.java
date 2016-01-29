package controler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.requete.*;
import vue.client.Menu;
import modele.metier.*;

public class Accueil {

	public static void main( String args[] ) throws SQLException {
		
		Controleur controleur = new Controleur();
		
		Menu menu = new Menu();
		boolean connected = false;
		
		System.out.println("Bienvenue Sur l'application des petits pedestres !!");

			//menu.menuApp();

		//test client
		RequeteClient rc = new RequeteClient(controleur.getConn());
		Client c = new Client("boristhouvenin", "thouvenin", "boris", "marcel porte", "secret", false);
		rc.addClient(c);
		Client c2 = rc.getClientByMail("boristhouvenin");
		System.out.println(c2.getNom());
		
		
		//test fichier image
		/*RequeteFichierImage rfi = new RequeteFichierImage(controleur.getConn());
		FichierImage fi = new FichierImage(0, "/", 12, false, 4000, 200, 4, c2);
		FichierImage fi2 = rfi.getFichierImageFromId(1);
		System.out.println(fi2.getPath());*/
		
		
		//test photo
		/*Photo p = new Photo(0, "plage", "beach", fi2);
		RequetePhoto rp = new RequetePhoto(controleur.getConn());
		rp.addPhoto(p);
		Photo p2 = rp.getPhotoFromId(1);
		System.out.println(p2.getTitre());*/
		
		
		//test album
		/*Album album = new Album(0, c, "Vacances", null);
		RequeteAlbum ra = new RequeteAlbum(controleur.getConn());
		ra.addAlbum(album);
		Album album2 = ra.getAllAlbumFromClient(c).get(0);
		System.out.println(album2.getNom());*/
		
		
		//test ajout photo à un album
		//ra.addPhotoToAlbum(album2, p);
		

	}
}
