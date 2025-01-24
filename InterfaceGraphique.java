import java.awt.*;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
    private JPanel plateauPanel;
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
}