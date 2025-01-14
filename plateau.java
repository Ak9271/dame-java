public class Plateau {
    private Case[][] cases;
    private Piece[][] pieces;
    private Joueur gagnant;

    public Plateau() {
        cases = new Case[8][8];
        pieces = new Piece[8][8];
        gagnant = null;

        // Initialize the cases and pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cases[i][j] = new Case(i, j);
                if ((i + j) % 2 == 1) {
                    if (i < 3) {
                        pieces[i][j] = new Pion(true);
                    } else if (i > 4) {
                        pieces[i][j] = new Pion(false);
                    }
                }
            }
        }
    }

    public void initialiser() {
        // Reset the plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cases[i][j].setPiece(null);
            }
        }

        // Place the pieces on the plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null) {
                    cases[i][j].setPiece(pieces[i][j]);
                }
            }
        }
    }

    public boolean estFini() {
        // Check if the game is over
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (cases[i][j].getPiece() != null && cases[i][j].getPiece().estRoi()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }

    public Case[][] getCases() {

        return cases;

    }
}
