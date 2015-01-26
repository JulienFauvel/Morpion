package ihm;

abstract class Message {
	public static final String SAISIE_COL = "C'est ton tour !\nSaisir la colonne [1-3] : ";
	public static final String SAISIE_LIG = "Saisir la ligne [1-3] : ";
	public static final String ERREUR_COL = "Erreur ! Veuillez saisir une colonne entre 1 et 3.\nSaisir la colonne [1-3] : ";
	public static final String ERREUR_LIG = "Erreur ! Veuillez saisir une ligne entre 1 et 3.\nSaisir la ligne [1-3] : ";
	public static final String CONNEXION_REFUSEE = "Connexion Refusée : erreur clé de connexion";
}
