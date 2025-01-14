public class Plateau {

    private Case[][] cases;

    public Plateau() {
        cases = new Case[9][9];
        initialiserPlateau();
    }

    public void initialiserPlateau() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 || i == 8 || j == 0 || j == 8) {
                    cases[i][j] = new Case("---", i, j);
                } else {
                    cases[i][j] = new Case("Vide", i, j);
                }
            }
        }
    }

    public Case getCase(int x, int y) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return cases[x][y];
        } else {
            throw new IllegalArgumentException("Les coordonnées donné sont hors du plateau.");
        }
    }

    public void afficherPlateau() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(cases[i][j].getType() + " ");
            }
            System.out.println();
        }
    }

    public class Case {
        private String type;
        private int x, y;

        public Case(String type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        plateau.afficherPlateau();
    }
}
