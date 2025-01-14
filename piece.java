public abstract class Piece {
    protected Joueur proprietaire;

    public Piece(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    // Méthode abstraite pour valider les déplacements
    public abstract boolean estDeplacementValide(Case source, Case destination, Plateau plateau);
}
