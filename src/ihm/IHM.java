package ihm;

import java.util.Scanner;

public class IHM {

	private Scanner sc;

	public IHM() {
		sc = new Scanner(System.in);
	}

	public int[] saisirCoord() {
		int[] coord = new int[2];
		
		boolean saisieCorrecte = false;
		
		System.out.print(Message.SAISIE_COL);
		while(!saisieCorrecte) {
			String saisie = sc.next();
			sc.nextLine();
			try {
				coord[0] = Integer.parseInt(saisie);
				saisieCorrecte = true;
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer un chiffre.");
			}
			if (coord[0] < 1 || coord[0] > 3) {
				System.out.print(Message.ERREUR_COL);
			} else {
				saisieCorrecte = true;
			}
		}

		System.out.print(Message.SAISIE_LIG);
		saisieCorrecte = false;
		while(!saisieCorrecte) {
			String saisie = sc.next();
			sc.nextLine();
			try {
				coord[1] = Integer.parseInt(saisie);
				saisieCorrecte = true;
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer un chiffre.");
			}
			if (coord[1] < 1 || coord[1] > 3) {
				System.out.print(Message.ERREUR_LIG);
				saisieCorrecte = false;
			} else {
				saisieCorrecte = true;
			}
		}

		coord[0]--;
		coord[1]--;

		return coord;
	}

	public void afficher(String aff) {
		System.out.println(aff);
	}

	public String saisirNom() {
		System.out.print("Saisissez votre nom : ");
		return sc.nextLine();
	}

}
