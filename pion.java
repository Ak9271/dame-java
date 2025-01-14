public class Pion extends Piece {
    public Pion(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination, Plateau plateau) {
        int deltaX = destination.getX() - source.getX();
        int deltaY = destination.getY() - source.getY();

        // Déplacement simple en diagonale (1 case)
        if (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 1) {
            return destination.estVide();
        }

        // Capture (sauter une pièce adverse)
        if (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 2) {
            int middleX = (source.getX() + destination.getX()) / 2;
            int middleY = (source.getY() + destination.getY()) / 2;
            Case middleCase = plateau.getCase(middleX, middleY);

            return destination.estVide() && middleCase.getPiece() != null &&
                   middleCase.getPiece().getProprietaire() != this.getProprietaire();
        }

        return false; // Déplacement invalide
    }
}
