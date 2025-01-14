public class Pion extends Piece {
    private boolean aDeplacé;

    public Pion(String couleur) {
        super("Pion", couleur);
        this.aDeplacé = false;
    }

    public boolean peutSeDeplacer(int dx, int dy) {
        if (dx == 0) {
            if (!aDeplacé && Math.abs(dy) == 2) {
                return true;
            }
            if (Math.abs(dy) == 1) {
                return true;
            }
        }

        return false;
    }

    public boolean peutCapturer(int dx, int dy) {
        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            return true;
        }
        return false;
    }

    public void marquerDeplacement() {
        this.aDeplacé = true;
    }

    public boolean aDejaDeplace() {
        return aDeplacé;
    }
}
