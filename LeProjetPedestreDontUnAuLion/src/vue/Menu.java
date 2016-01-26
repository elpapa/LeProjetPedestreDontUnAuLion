package vue;

import java.util.Scanner;

public class Menu {
	
	static boolean connected = false;


	public void menuInscription() {
		System.out.println("Bienvenue petit pedestre !! renseigne les champs suivant pour t'inscrire : ");
		System.out.println("Nom : ");
		System.out.println("Prenom : ");
		System.out.println("etc...");
	}

	public void menuApp() {
		
		
	}

	public void menuChoixConnexion() {
		int choix = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] Déjà inscrit ? C'est par ici !");
		System.out.println("[2] Pour les nouveaux direction le stand d'inscription");
		do{
			System.out.println("-->");
			choix = sc.nextInt();
		}while(choix != 1 && choix != 2);
		
		if(choix == 1){
			System.out.println("mail : ");
			String mail = sc.nextLine();
			System.out.println("mot de passe : ");
			String mdp = sc.nextLine();
			// controller connexion
			
			connected = true;
		} else {
			menuInscription();
		}
		sc.close();
	}

}
