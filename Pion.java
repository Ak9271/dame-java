public class Pion extends Piece {
    public Pion(Joueur var1) {
        super(var1);
    }

    public boolean estDeplacementValide(Case var1, Case var2, Plateau var3) {
        int var4 = var2.getX() - var1.getX();
        int var5 = var2.getY() - var1.getY();

        if ((this.getProprietaire().getNom().equals("Joueur 1") && var4 < 0) || (this.getProprietaire().getNom().equals("Joueur 2") && var4 > 0)) {
            return false;
        }

        if (Math.abs(var4) == 1 && Math.abs(var5) == 1) {
            return var2.estVide();
        } else if (Math.abs(var4) == 2 && Math.abs(var5) == 2) {
            int var6 = (var1.getX() + var2.getX()) / 2;
            int var7 = (var1.getY() + var2.getY()) / 2;
            Case var8 = var3.getCase(var6, var7);
            return var2.estVide() && var8.getPiece() != null && var8.getPiece().getProprietaire() != this.getProprietaire();
        } else {
            return false;
        }
    }
}