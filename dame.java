public class Dame extends Piece {
    public Dame(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination) {
        // Logique de validation spécifique aux dames
        return true; // Simplifié pour l'exemple
    }
}
