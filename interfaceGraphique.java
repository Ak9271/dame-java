import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
    private JPanel plateauPanel;
    private Plateau plateau;
    private Jeu jeu;

    public InterfaceGraphique(Plateau plateau, Jeu jeu) {
        this.plateau = plateau;
        this.jeu = jeu;
        initialiserInterface();
    }

    private void initialiserInterface() {
        fenetre = new JFrame("Jeu de Dames");
        fenetre.setSize(600, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        plateauPanel = new JPanel(new GridLayout(8, 8));
        mettreAJourPlateau();

        fenetre.add(plateauPanel);
    }

    public void afficher() {
        fenetre.setVisible(true);
    }

    public void mettreAJourPlateau() {
        plateauPanel.removeAll(); // Réinitialise le plateau

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Case currentCase = plateau.getCase(i, j);
                JButton caseBouton = new JButton();

                // Définir la couleur de fond des cases
                caseBouton.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);

                // Ajouter un pion si la case contient une pièce
                if (!currentCase.estVide()) {
                    Piece piece = currentCase.getPiece();
                    if (piece.getProprietaire() == jeu.getJoueurActuel()) {
                        caseBouton.setText("●"); // Symbole pour le pion
                        caseBouton.setForeground(Color.RED); // Couleur pour le joueur actuel
                    } else {
                        caseBouton.setText("●");
                        caseBouton.setForeground(Color.BLUE); // Couleur pour l'autre joueur
                    }
                }

                // Gérer les clics sur les cases
                caseBouton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Case cliquée : " + currentCase.getX() + ", " + currentCase.getY());
                        // Ajouter la logique pour gérer le clic
                    }
                });

                plateauPanel.add(caseBouton);
            }
        }

        plateauPanel.revalidate();
        plateauPanel.repaint();
    }
}
