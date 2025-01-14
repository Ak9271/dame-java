public class Pion extends Piece {
    public Pion(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination) {
        // Logique de validation spécifique aux pions
        return true; // Simplifié pour l'exemple
    }
}
