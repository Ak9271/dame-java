public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu() {
        joueur1 = new Joueur("Joueur 1");
        joueur2 = new Joueur("Joueur 2");
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        Jeu jeu = new Jeu();

        plateau.initialiserPlateau(jeu.getJoueur1(), jeu.getJoueur2());

        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(plateau, jeu);
        interfaceGraphique.afficher();
    }
}
