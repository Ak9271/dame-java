import java.awt.*;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
    private JPanel plateauPanel;
    private Plateau plateau;
    private Jeu jeu;
    private Case caseSelectionnee = null;

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
                CaseBouton caseBouton = new CaseBouton(currentCase.getPiece());

                // Définir la couleur de fond des cases
                caseBouton.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);

                // Gérer les clics pour déplacer les pions
                caseBouton.addActionListener(e -> {
                    if (caseSelectionnee == null) {
                        // Première sélection
                        if (!currentCase.estVide()) {
                            caseSelectionnee = currentCase;
                            System.out.println("Case sélectionnée : " + caseSelectionnee.getX() + ", " + caseSelectionnee.getY());
                        }
                    } else {
                        // Deuxième clic pour tenter un déplacement
                        if (caseSelectionnee.getPiece().estDeplacementValide(caseSelectionnee, currentCase, plateau)) {
                            currentCase.placerPiece(caseSelectionnee.getPiece());
                            caseSelectionnee.retirerPiece();

                            // Promouvoir un pion en Dame s'il atteint le bord opposé
                            if (currentCase.getPiece() instanceof Pion &&
                                (currentCase.getX() == 0 || currentCase.getX() == 7)) {
                                currentCase.placerPiece(new Dame(currentCase.getPiece().getProprietaire()));
                            }

                            caseSelectionnee = null; // Réinitialise la sélection
                            mettreAJourPlateau(); // Rafraîchit l'interface
                        } else {
                            System.out.println("Déplacement invalide.");
                            caseSelectionnee = null;
                        }
                    }
                });

                plateauPanel.add(caseBouton);
            }
        }

        plateauPanel.revalidate();
        plateauPanel.repaint();
    }
}
