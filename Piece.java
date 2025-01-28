public abstract class Piece {
    protected Joueur proprietaire;

    public Piece(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }
}
