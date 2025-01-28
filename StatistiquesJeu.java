import java.awt.*;
import javax.swing.*;

public class StatistiquesJeu extends JPanel {
    private JLabel labelActif;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActif;

    public StatistiquesJeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurActif = joueur1;
        setLayout(new GridLayout(1, 1));
        labelActif = new JLabel("Au tour du : " + joueurActif.getNom());

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

    public Joueur getJoueurActif() {
        return joueurActif;
    }
}