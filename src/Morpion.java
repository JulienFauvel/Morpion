import controlleur.Controlleur;

public class Morpion {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Erreur, usage : Morpion [URL] [port] [id]");
			System.exit(0);
		}
		
		int port = 0;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println("Le port doit être un nombre.");
		}

		if (port > 0) {
			Controlleur c = new Controlleur(args[0], port, args[2]);
			c.jouer();
		}
	}
}
