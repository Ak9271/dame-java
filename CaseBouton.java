import java.awt.*;
import javax.swing.*;

public class CaseBouton extends JButton {
    public static final Color PION_GRAY = new Color(211, 211, 211);
    public static final Color PION_BLEU = new Color(53, 64, 73);
    public static final Color DAME_GRAY = new Color(255, 90, 172); // reine joueur 1
    public static final Color DAME_BLEU = new Color(33, 44, 53); // reine joueur 2

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
            int taille = Math.min(getWidth(), getHeight()) - 20;
            if (piece instanceof Dame) {
                if (piece.getProprietaire().getNom().equals("Joueur 1")) {
                    g.setColor(DAME_GRAY);
                } else {
                    g.setColor(DAME_BLEU);
                }
            } else {
                if (piece.getProprietaire().getNom().equals("Joueur 1")) {
                    g.setColor(PION_GRAY);
                } else {
                    g.setColor(PION_BLEU);
                }
            }
            g.fillOval(10, 10, taille, taille);
        }
    }
}