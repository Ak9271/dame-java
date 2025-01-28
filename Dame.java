public class Dame extends Piece {
    public Dame(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination, Plateau plateau) {
        int depalcementX = destination.getX() - source.getX();
        int deplacementY = destination.getY() - source.getY();

        if (Math.abs(depalcementX) != Math.abs(deplacementY)) {
            return false;
        }

        int stepX = depalcementX / Math.abs(depalcementX);
        int stepY = deplacementY / Math.abs(deplacementY);
        int x = source.getX() + stepX;
        int y = source.getY() + stepY;
        boolean pieceCapturee = false;
        Case caseCapturee = null;

        while (x != destination.getX() && y != destination.getY()) {
            Case caseActuelle = plateau.getCase(x, y);
            if (!caseActuelle.estVide()) {
                if (pieceCapturee == true || caseActuelle.getPiece().getProprietaire() == this.getProprietaire()) {
                    return false;
                }
                pieceCapturee = true;
                caseCapturee = caseActuelle;
            }
            x += stepX;
            y += stepY;
        }

        if (destination.estVide() && pieceCapturee) {
            if (caseCapturee != null) {
                caseCapturee.retirerPiece();
            }
            return true;
        }
        return destination.estVide();
    }
}