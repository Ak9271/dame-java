public class Pion extends Piece {
    public Pion(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination) {
        return true; // Logique simplifiée
    }
}
