import java.awt.*;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
    private JPanel damier; // Déclaration de damier ici
    private Plateau plateau;
    private Jeu jeu;
    private Case caseSelectionnee = null;
    private Joueur joueurActif; 

    public InterfaceGraphique(Plateau plateau, Jeu jeu) {
        this.plateau = plateau;
        this.jeu = jeu;
        this.joueurActif = jeu.getJoueurActif();
        initialiserFenetre();
    }

    private void initialiserFenetre() {
        JFrame fond_blanc = new JFrame("");
        fond_blanc.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fond_blanc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre = new JFrame("Jeu de dames");
        fenetre.setSize(600, 600);
        damier = new JPanel(new GridLayout(8, 8));
        mettreAJourPlateau();
        fond_blanc.add(fenetre);
        fenetre.add(damier);
        afficher();
        fond_blanc.setVisible(true);
    }

    private void afficher () {
        fenetre.setVisible(true);
    }

    public void mettreAJourPlateau() {
        damier.removeAll();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Case caseActuelle = plateau.getCase(i, j);
                CaseBouton caseBouton = new CaseBouton(caseActuelle.getPiece());
                caseBouton.setBackground((i+j)%2 == 0 ? Color.WHITE : Color.BLACK);
                actionClic(caseBouton, caseActuelle);
                damier.add(caseBouton);
            }
        }
        damier.revalidate();
        damier.repaint();
    }
}