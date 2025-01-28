import java.awt.*;
import javax.swing.*;

public class StatistiquesJeu extends JPanel {
    private JLabel labelActif;
    private JLabel labelMangeParJoueur1;
    private JLabel labelMangesParJoueur2;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActif;
    private int pionsMangesJoueur1;
    private int pionsMangesJoueur2;

    public StatistiquesJeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurActif = joueur1;
        this.pionsMangesJoueur1 = 0;
        this.pionsMangesJoueur2 = 0;
        setLayout(new GridLayout(3, 1));
        labelActif = new JLabel("Au tour du : " + joueurActif.getNom());
        labelMangeParJoueur1 = new JLabel("Pions mangés par " + joueur1.getNom() + " : " + pionsMangesJoueur1);
        labelMangesParJoueur2 = new JLabel("Pions mangés par " + joueur2.getNom() + " : " + pionsMangesJoueur2);

        add(labelActif);
        add(labelMangeParJoueur1);
        add(labelMangesParJoueur2);
    }

    public void changerJoueurActif() {
        if (joueurActif == joueur1) {
            joueurActif = joueur2;
        } else {
            joueurActif = joueur1;
        }
        labelActif.setText("Au tour du : " + joueurActif.getNom());
    }

    public void pionsManges(Joueur joueur) {
        if (joueur == joueur1) {
            pionsMangesJoueur1++;
            labelMangeParJoueur1.setText("Pions mangés par " + joueur1.getNom() + " : " + pionsMangesJoueur1);
        } else if (joueur == joueur2) {
            pionsMangesJoueur2++;
            labelMangeParJoueur1.setText("Pions mangés par " + joueur2.getNom() + " : " + pionsMangesJoueur2);
        }
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }
}