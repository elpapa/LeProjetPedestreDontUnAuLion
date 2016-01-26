package controler;

import java.sql.SQLException;

import vue.Menu;

public class Accueil {

	public static void main( String args[] ) throws SQLException {
		
		Controleur controleur = new Controleur();
		
		Menu menu = new Menu();
		boolean connected = false;
		
		System.out.println("Bienvenue Sur l'application des petits pedestres !!");

		
		if(!connected){
			menu.menuChoixConnexion();
		} else {
			menu.menuApp();
		}


	}
}
