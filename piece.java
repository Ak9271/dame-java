public abstract class Piece {
    protected Joueur proprietaire;

    public Piece(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public abstract boolean estDeplacementValide(Case source, Case destination);

    public Joueur getProprietaire() {
        return proprietaire;
    }
}
