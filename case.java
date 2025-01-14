public class Case {
    private int x, y;
    private Piece piece;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }
    
    public boolean estVide() {
        return this.piece == null;
    }

    public void placerPiece(Piece piece) {
        if (piece != null) {
            this.piece = piece;
        }
    }

    public void retirerPiece() {
        this.piece = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
