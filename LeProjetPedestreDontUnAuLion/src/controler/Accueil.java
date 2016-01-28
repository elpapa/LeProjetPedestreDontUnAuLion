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

			menu.menuApp();

		/*RequeteClient rc = new RequeteClient(controleur.getConn());
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
		
		Date date = new Date(2016, 01, 27);
		Commande cmd = new Commande(0, date, 250, c, "envoye", false, new ArrayList<AlbumCommande>());
		RequeteCommande rcmd = new RequeteCommande(controleur.getConn());
		rcmd.addCommande(cmd);*/
		
		
		

	}
}
