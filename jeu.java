public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActuel;

    public Jeu() {
        initialiserJeu();
        demarrerJeu();
    }

    private void initialiserJeu() {
        plateau = new Plateau();
        joueur1 = new Joueur("Joueur 1");
        joueur2 = new Joueur("Joueur 2");
        joueurActuel = joueur1;

        plateau.initialiserPlateau(joueur1, joueur2);
    }

    private void demarrerJeu() {
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(plateau, this);
        interfaceGraphique.afficher();
    }

    public void changerTour() {
        joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    public static void main(String[] args) {
        new Jeu();
    }
}
