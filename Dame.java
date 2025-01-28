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

        while (x != destination.getX() && y != destination.getY()) {
            if (!plateau.getCase(x, y).estVide()) {
                return false;
            }
            x += stepX;
            y += stepY;
        }

        return destination.estVide();
    }
}