package metier;

public class Plateau {

	private char[][] tab;

	private char joueurCourant;

	public Plateau() {
		tab = new char[3][3];

		for (int i = 0; i < tab.length; i++)
			for (int j = 0; j < tab[0].length; j++)
				tab[j][i] = ' ';

		joueurCourant = 'X';
	}

	public boolean jouer(int col, int lig) {
		if (col < 0 || col >= tab.length || lig < 0 || lig >= tab[0].length)
			return false;

		if (tab[col][lig] != ' ')
			return false;

		tab[col][lig] = joueurCourant;

		return true;
	}

	public void changerJoueur() {
		joueurCourant = joueurCourant == 'O' ? 'X' : 'O';
	}

	public char getJoueurCourant() {
		return joueurCourant;
	}

	public String toString() {

		String delimiter = " +---+---+---+\n";

		StringBuilder sb = new StringBuilder();
		sb.append("   1   2   3\n");
		for (int i = 0; i < tab.length; i++) {
			sb.append(delimiter);
			sb.append(i + 1);
			for (int j = 0; j < tab[0].length; j++) {
				sb.append("| " + tab[j][i] + " ");
			}
			sb.append("|\n");
		}
		sb.append(delimiter+"\n");
		sb.append("Joueur courant : " + joueurCourant);
		return sb.toString();
	}
}
