import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class InterfaceGraphique {
    private JFrame fenetre;
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

        JPanel plateauPanel = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton caseBouton = new JButton();
                caseBouton.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                plateauPanel.add(caseBouton);

                int finalI = i, finalJ = j;
                caseBouton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Case cliquée : " + finalI + ", " + finalJ);
                        // Ajouter la logique pour gérer le clic
                    }
                });
            }
        }

        fenetre.add(plateauPanel);
    }

    public void afficher() {
        fenetre.setVisible(true);
    }
}
