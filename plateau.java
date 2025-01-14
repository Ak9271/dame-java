public class Plateau {
    private Case[][] cases;

    public Plateau() {
        cases = new Case[8][8];
        initialiserCases();
    }

    private void initialiserCases() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cases[i][j] = new Case(i, j);
            }
        }
    }

    public void initialiserPlateau(Joueur joueur1, Joueur joueur2) {
        for (int i = 0; i < 3; i++) {
            for (int j = (i % 2); j < 8; j += 2) {
                cases[i][j].placerPiece(new Pion(joueur1));
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = (i % 2); j < 8; j += 2) {
                cases[i][j].placerPiece(new Pion(joueur2));
            }
        }
    }

    public Case getCase(int x, int y) {
        return cases[x][y];
    }
}
