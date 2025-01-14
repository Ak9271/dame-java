import java.awt.*;
import javax.swing.*;

public class CaseBouton extends JButton {
    private Piece piece;

    public CaseBouton(Piece piece) {
        this.piece = piece;
        setContentAreaFilled(false); // Supprime le remplissage par défaut
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        repaint(); // Rafraîchit l'affichage du bouton
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessine l'arrière-plan (damier)
        if (getModel().isPressed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessine le pion si présent
        if (piece != null) {
            if (piece.getProprietaire().getNom().equals("Joueur 1")) {
                g.setColor(Color.RED); // Couleur pour le joueur 1
            } else {
                g.setColor(Color.BLUE); // Couleur pour le joueur 2
            }
            int taille = Math.min(getWidth(), getHeight()) - 20; // Taille du pion
            g.fillOval(10, 10, taille, taille); // Dessine un cercle au centre
        }
    }
}
