package controler;

import java.sql.SQLException;
import java.util.ArrayList;

import vue.Menu;
import modele.requete.*;
import modele.metier.*;

public class Accueil {

	public static void main( String args[] ) throws SQLException {
		
		Controleur controleur = new Controleur();
		
//		Menu menu = new Menu();
//		boolean connected = false;
//		
//		System.out.println("Bienvenue Sur l'application des petits pedestres !!");
//
//		
//		if(!connected){
//			menu.menuChoixConnexion();
//		} else {
//			menu.menuApp();
//		}

		RequeteClient rc = new RequeteClient(controleur.getConn());
		Client c = new Client("johndiliger@gmail.com", "diliger", "john", "12 rue de monc", "ahah", false);
		//rc.addClient(c);
		
		RequeteFichierImage rfi = new RequeteFichierImage(controleur.getConn());
		FichierImage fi2 = rfi.getFichierImageFromId(3);
		
		Photo p = new Photo(0, "plage", "beach", fi2);
		RequetePhoto rp = new RequetePhoto(controleur.getConn());
		Photo ski = new Photo(0, "ski", "neige", fi2);
		
		Album album = new Album(0, c, null);
		RequeteAlbum ra = new RequeteAlbum(controleur.getConn());
		//ra.addAlbum(album);
		Album zob = ra.getAllAlbumFromClient(c).get(0);
		zob.getListePhoto().add(p);
		ra.addPhotoToAlbum(zob, p);
		

	}
}
