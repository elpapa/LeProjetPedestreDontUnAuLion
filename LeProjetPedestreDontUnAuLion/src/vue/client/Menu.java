package vue.client;

import java.sql.SQLException;
import java.util.Scanner;

import controler.Controleur;
import modele.metier.Album;
import modele.requete.RequeteAlbum;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main( String args[] ) throws SQLException {
		Controleur controleur = new Controleur();

		System.out.println("Bienvenue Sur l'application des petits pedestres !!");
		menuApp();
	}
	
	public void menuInscription() {
		System.out.println("Bienvenue petit pedestre !! renseigne les champs suivant pour t'inscrire : ");
		System.out.print("Mail : ");
		String mail = sc.nextLine();
		System.out.print("Nom : ");
		String nom = sc.nextLine();
		System.out.print("Prenom : ");
		String prenom = sc.nextLine();
		System.out.print("Adresse : ");
		String adresse = sc.nextLine();
		System.out.print("Mot de passe : ");
		String mdp = sc.nextLine();
		
		
	}

	public static void menuApp() {
		int choix = 0;
		System.out.println("----------------------Menu Client----------------------");
		System.out.println("1: Créer un album");
		System.out.println("2: Gérer ses photos");
		System.out.println("3: Mes albums");
		System.out.println("4: Mes Commandes");
		System.out.println("5: Mes informations");
		System.out.println("6: Saisir une commande");
		System.out.println("-------------------------------------------------------");
		
		do{
			System.out.print("--> ");
			choix = sc.nextInt();
		} while(choix < 1 && choix > 6);
		
		switch (choix) {
		case 1: choixAlbum();
			break;
		case 2: //controller gestion photo
			break;
		case 3: //controller album
			break;
		case 4: //controller commande
			break;
		case 5: //controller client
			break;
		case 6: //controller commande
			break;
		default:
			break;
		}
	}

	public void menuChoixConnexion() {
		int choix = 0;	
		System.out.println("[1] Déjà inscrit ? C'est par ici !");
		System.out.println("[2] Pour les nouveaux direction le stand d'inscription");
		do{
			System.out.print("--> ");
			choix = sc.nextInt();
			sc.nextLine();
		}while(choix != 1 && choix != 2);
		
		if(choix == 1){
			System.out.print("mail : ");
			String mail = sc.nextLine();
			System.out.print("mot de passe : ");
			String mdp = sc.nextLine();
			
			//controller connexion
		} else {
			menuInscription();
		}
		sc.close();
	}
	
	public static void choixAlbum(){
		int choix = 0;
		System.out.println("-----------------------Choix du format-----------------------");
		System.out.println("1: Agenda");
		System.out.println("2: Calendrier");
		System.out.println("3: Livre");
		System.out.println("4: Album");
		System.out.println("-------------------------------------------------------------");
		
		do{
			System.out.print("--> ");
			choix = sc.nextInt();
			sc.nextLine();
		}while(choix<1 && choix>4);
		
		switch (choix) {
		case 1: //requete agenda
			break;
		case 2: //requete calendrier
			break;
		case 3: //requete livre
			break;
		case 4: 
			break;
		default:
			break;
		}
	}
	
	public void creationAlbumForm(){
		System.out.print("Nom de l'album : ");
		String nom = sc.nextLine();
		
		System.out.println();
	}
	

}
