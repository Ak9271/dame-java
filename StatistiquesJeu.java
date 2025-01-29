import java.awt.*;
import javax.swing.*;

public class StatistiquesJeu extends JPanel {
    private JLabel labelActif;
    private JLabel labelPointJoueur1;
    private JLabel labelPointJoueur2;
    private int scoreJoueur1;
    private int scoreJoueur2;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActif;

    public StatistiquesJeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurActif = joueur1;
        this.scoreJoueur1 = 0;
        this.scoreJoueur2 = 0;
        setLayout(new GridLayout(3, 1));
        labelActif = new JLabel("Au tour du : " + joueurActif.getNom());
        labelPointJoueur1 = new JLabel("Score du Joueur 1 : " + scoreJoueur1);
        labelPointJoueur2 = new JLabel("Score du Joueur 2 : " + scoreJoueur2);
        add(labelPointJoueur1);
        add(labelPointJoueur2);
        add(labelActif);
    }

    public void changerJoueurActif() {
        if (joueurActif == joueur1) {
            joueurActif = joueur2;
        } else {
            joueurActif = joueur1;
        }
        labelActif.setText("Au tour du : " + joueurActif.getNom());
    }

    public void ScoreJoueur (Joueur joueur) {
        if (joueur == joueur1) {
            scoreJoueur1++;
            labelPointJoueur1.setText("Score du Joueur 1 : " + scoreJoueur1);
        } else if (joueur == joueur2) {
            scoreJoueur2++;
            labelPointJoueur2.setText("Score du Joueur 2 : " + scoreJoueur2);
        }
    }

    public void Victoire(Joueur joueur) {
        if (joueur == joueur1 && scoreJoueur1 == 20) {
            System.out.println("Victoire du Joueur 1");
        } else if (joueur == joueur2 && scoreJoueur2 == 20) {
            System.out.println("Victoire du Joueur 2");
        }
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }
}