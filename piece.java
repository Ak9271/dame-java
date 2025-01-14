public abstract class Piece {
    private boolean estBlanc;

    public Piece(boolean estBlanc) {
        this.estBlanc = estBlanc;
    }

    public boolean estBlanc() {
        return estBlanc;
    }

    public abstract boolean estRoi();
}
