class Jeu {
    private Plateau plateau;
    private Joueur joueurActuel;
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu() {
        plateau = new Plateau();
        joueur1 = new Joueur("Joueur 1");
        joueur2 = new Joueur("Joueur 2");
        joueurActuel = joueur1;
    }

    public void jouer() {
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(this);
        interfaceGraphique.setVisible(true);
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    public void changerJoueur() {
        if (joueurActuel == joueur1) {
            joueurActuel = joueur2;
        } else {
            joueurActuel = joueur1;
        }
    }
}