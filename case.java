public class Case {
    private int x, y;
    private Piece piece;
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }
    public boolean estVide() {
        return piece == null;
    }
    public void placerPiece(Piece piece) {
        this.piece = piece;
    }
    public void retirerPiece() {
        this.piece = null;
    }
    public Piece getPiece() {
        return piece;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}