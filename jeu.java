public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu() {
        plateau = new Plateau();
        joueur1 = new Joueur("Joueur 1");
        joueur2 = new Joueur("Joueur 2");
        joueur2.setEstBlanc(false);
    }

    public void jouer() {
        // Initialize the game
        plateau.initialiser();
        joueur1.initialiser();
        joueur2.initialiser();

        // Create the graphical interface
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(plateau);

        // Game loop
        while (true) {
            // Joueur 1's turn
            joueur1.jouer(plateau);
            if (plateau.estFini()) {
                break;
            }

            // Joueur 2's turn
            joueur2.jouer(plateau);
            if (plateau.estFini()) {
                break;
            }
        }

        // Display the winner
        if (plateau.getGagnant() == joueur1) {
            System.out.println("Joueur 1 a gagné!");
        } else {
            System.out.println("Joueur 2 a gagné!");
        }
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.jouer();
    }
}
