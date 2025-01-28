import java.awt.*;
import java.util.regex.MatchResult;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
    private JPanel damier;
    private Plateau plateau;
    private Jeu jeu;
    private Case caseChoisi = null;
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

    private void actionClic (CaseBouton caseBouton, Case caseActuelle) {
        caseBouton.addActionListener(a -> {
            if (caseChoisi == null ) {
                if (caseActuelle.estVide() && caseActuelle.getPiece().getProprietaire() == joueurActif) {
                    caseChoisi = caseActuelle;
                    System.out.println("Case séléctionnée: " + caseChoisi.getX() + ", " + caseChoisi.getY());
                }
            } else if (caseChoisi.getPiece().estDeplacementValide(caseChoisi, caseActuelle, plateau)) {
                int deplacementX = caseActuelle.getX() - caseChoisi.getX();
                int deplacementY = caseActuelle.getY() - caseChoisi.getY();
                if (Math.abs(deplacementX) == 2 && Math.abs(deplacementY) == 2) {
                    int milieuX = (caseChoisi.getX() + caseActuelle.getX()) / 2;
                    int milieuY = (caseChoisi.getY() + caseActuelle.getY()) / 2;
                    Case caseMilieu = (plateau.getCase(milieuX, milieuY));
                    caseMilieu.retirerPiece();
                    System.out.println("Piece mangée en: " + milieuX + ", " + milieuY);
                }
                caseActuelle.placerPiece(caseChoisi.getPiece());
                caseChoisi.retirerPiece();
                if (caseActuelle.getPiece() instanceof Pion && (caseActuelle.getX() == 0 || caseActuelle.getX() == 7)) {
                    caseActuelle.placerPiece(new Dame(caseActuelle.getPiece().getProprietaire()));
                }
                changeJoueurActif();
                caseChoisi = null; 
                mettreAJourPlateau();
            } else {
                System.out.println("Déplacement invalide");
                caseChoisi = null;
            }  
        });
    }

    private void changeJoueurActif() {
        if (joueurActif == jeu.getJoueur1()) {
            joueurActif = jeu.getJoueur2();
        } else {
            joueurActif = jeu.getJoueur1();
        }
    }
}