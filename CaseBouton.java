import java.awt.*;
import javax.swing.*;

public class CaseBouton extends JButton {
    public static final Color PION_GRAY = new Color(224,224,224);
    private Piece piece;

    public CaseBouton(Piece piece) {
        this.piece = piece;
        setContentAreaFilled(false);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getModel().isPressed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());

        if (piece != null) {
            if (piece.getProprietaire().getNom().equals("Joueur 1")) {
                g.setColor(CaseBouton.PION_GRAY);
            } else {
                g.setColor(Color.BLACK);
            }
            int taille = Math.min(getWidth(), getHeight()) - 20;
            g.fillOval(10, 10, taille, taille);
        }
    }
}