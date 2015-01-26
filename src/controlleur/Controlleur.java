package controlleur;

import ihm.IHM;
import metier.Plateau;
import connexion.Connexion;

public class Controlleur {

	private Plateau plateau;
	private IHM ihm;
	private Connexion connexion;
	private char symJoueur;
	private String id;

	public Controlleur(String adr, int port, String id) {
		plateau = new Plateau();
		ihm = new IHM();
		connexion = new Connexion(adr, port);
		this.id = id;
		connexion.envoyer(id);

		if (id.split("\\|")[1].equals("1")) {
			symJoueur = 'X';
		} else {
			symJoueur = 'O';
		}

		jouer();
	}

	public void jouer() {
		String str = connexion.recevoir();
		ihm.afficher(str);
		
		if(str.equals("Connexion refusée")) {
			System.out.println("Connexion refusée");
			System.exit(0);
		}
		
		boolean fini = false;		
		while (!fini) {
			int[] coord = new int[2];
			if (plateau.getJoueurCourant() == symJoueur) {
				//Saisie des coordonnées par l'utilisateur
				coord = ihm.saisirCoord();
				
				//Envoie des coordonnées
				connexion.envoyer(id+"|"+coord[0] + "," + coord[1]);
				
				//Récupération si la validité des coordonnées
				String valide = connexion.recevoir();
				
				//Débugage
				
				if(valide.equals("valide")) {
				} else if(valide.equals("fin")) {
					fini = true;
				} else {
					while(!valide.equals("valide")) {
						coord = ihm.saisirCoord();
						connexion.envoyer(id+"|"+coord[0] + "," + coord[1]);
						
						valide = connexion.recevoir();
						System.out.println("RECU : "+valide);
					}
				}
			} else {
				ihm.afficher("Tour de l'adversaire ! En attente de l'action ...");
				String valide;
				
				do {
					valide = connexion.recevoir();
					if(valide.indexOf("invalide")>-1)
						ihm.afficher("Action invalide, rejoue.");
				} while(valide.indexOf("invalide")>-1);
				
				if(valide.indexOf("fin")>-1) {
					fini = true;
				}
				
			}
			
			//Recupération des coordonnées
			String coordStr = connexion.recevoir();
			String[] tabCoordStr = coordStr.split(",");
			coord[0] = new Integer(tabCoordStr[0]);
			coord[1] = new Integer(tabCoordStr[1]);
			plateau.jouer(coord[0], coord[1]);			
	
			ihm.afficher(plateau.toString());
			if(!fini) plateau.changerJoueur();
		}
		ihm.afficher(connexion.recevoir());
		System.exit(0); //Evite les exceptions
		
	}
}
