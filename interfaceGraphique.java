import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceGraphique extends JFrame {
    private Plateau plateau;
    private int x1, y1, x2, y2;
    private boolean estSelectionne;

    public InterfaceGraphique(Plateau plateau) {
        this.plateau = plateau;
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        estSelectionne = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!estSelectionne) {
                    x1 = e.getX() / 100;
                    y1 = e.getY() / 100;
                    estSelectionne = true;
                } else {
                    x2 = e.getX() / 100;
                    y2 = e.getY() / 100;
                    estSelectionne = false;
                    jouer();
                }
            }
        });
    }

    private void jouer() {
        // Play a move
        if (plateau.getCases()[x1][y1].getPiece() != null) {
            // Move the piece
            Piece piece = plateau.getCases()[x1][y1].getPiece();
            plateau.getCases()[x1][y1].setPiece(null);
            plateau.getCases()[x2][y2].setPiece(piece);
            repaint();
        } else {
            System.out.println("Mouvement invalide.");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * 100, j * 100, 100, 100);
                if (plateau.getCases()[i][j].getPiece() != null) {
                    if (plateau.getCases()[i][j].getPiece().estBlanc()) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.fillOval(i * 100 + 20, j * 100 + 20, 60, 60);
                }
            }
        }
    }
}
