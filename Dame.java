public class Dame extends Piece {
    public Dame(Joueur proprietaire) {
        super(proprietaire);
    }

    @Override
    public boolean estDeplacementValide(Case source, Case destination, Plateau plateau) {
        int deltaX = destination.getX() - source.getX();
        int deltaY = destination.getY() - source.getY();

        // Déplacement diagonal uniquement
        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            return false;
        }

        // Vérifier si le chemin est libre
        int stepX = deltaX / Math.abs(deltaX); // Direction du déplacement en X
        int stepY = deltaY / Math.abs(deltaY); // Direction du déplacement en Y
        int x = source.getX() + stepX;
        int y = source.getY() + stepY;

        while (x != destination.getX() && y != destination.getY()) {
            if (!plateau.getCase(x, y).estVide()) {
                return false; // Chemin bloqué
            }
            x += stepX;
            y += stepY;
        }

        return destination.estVide(); // Valide si la destination est vide
    }
}
