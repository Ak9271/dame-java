import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private boolean estBlanc;
    private List<Piece> listPiece;

    public Joueur(String nom, boolean estBlanc) {
        this.nom = nom;
        this.estBlanc = estBlanc;
        this.listPiece = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public boolean estBlanc() {
        return estBlanc;
    }

    public void ajouterPiece(Piece piece) {
        listPiece.add(piece);
    }

    public void retirerPiece(Piece piece) {
        listPiece.remove(piece);
    }

    public boolean aDesPiecesRestantes() {
        return !listPiece.isEmpty();
    }

    public void afficherPiecesRestantes() {
        for (Piece piece : listPiece) {
            System.out.println(piece);
        }
    }

    public void jouerTour() {
        System.out.println(nom + " joue son tour.");
    }
}
