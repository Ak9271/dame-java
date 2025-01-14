import java.util.Scanner;

public class Joueur {
    private String nom;
    private boolean estBlanc;

    public Joueur(String nom) {
        this.nom = nom;
        estBlanc = true;
    }

    public String getNom() {
        return nom;
    }

    public boolean estBlanc() {
        return estBlanc;
    }

    public void setEstBlanc(boolean estBlanc) {
        this.estBlanc = estBlanc;
    }

    public void initialiser() {
        // Initialize the player
        System.out.println("Joueur " + nom + " est initialisé.");
    }

    public void jouer(Plateau plateau) {
        // Play a move
        Scanner scanner = new Scanner(System.in);
        System.out.println("Joueur " + nom + ", entrez les coordonnées de la pièce que vous voulez déplacer (x y) :");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("Joueur " + nom + ", entrez les coordonnées de la case où vous voulez déplacer la pièce (x y) :");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        // Check if the move is valid
        if (plateau.getCases()[x1][y1].getPiece() != null && plateau.getCases()[x1][y1].getPiece().estBlanc() == estBlanc) {
            // Move the piece
            Piece piece = plateau.getCases()[x1][y1].getPiece();
            plateau.getCases()[x1][y1].setPiece(null);
            plateau.getCases()[x2][y2].setPiece(piece);
        } else {
            System.out.println("Mouvement invalide.");
        }
    }
}
