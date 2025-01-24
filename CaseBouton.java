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
        repaint(); // Met à jour l'affichage
    }
}
