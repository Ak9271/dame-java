public class Pion extends Piece {
    public Pion(boolean estBlanc) {
        super(estBlanc);
    }

    @Override
    public boolean estRoi() {
        return false;
    }
}
