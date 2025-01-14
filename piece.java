public class Piece {
    private boolean estBlanc;
    private int positionX;
    private int positionY;

    public Piece(boolean estBlanc, int positionX, int positionY) {
        this.estBlanc = estBlanc;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean estBlanc() {
        return estBlanc;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}