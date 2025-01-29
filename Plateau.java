import java.util.ArrayList;
import java.util.List;

public class Plateau {
   private Case[][] cases = new Case[10][10];
 
   public Plateau() {
      this.initialiserCases();
   }
 
   private void initialiserCases() {
      for(int var1 = 0; var1 < 10; ++var1) {
         for(int var2 = 0; var2 < 10; ++var2) {
            this.cases[var1][var2] = new Case(var1, var2);
         }
      }
   }
 
   public void initialiserPlateau(Joueur joueur1, Joueur joueur2) {
      for (int ligne = 0; ligne < 4; ligne++) {
          for (int colonne = (ligne % 2 == 0) ? 1 : 0; colonne < 10; colonne += 2) {
              this.cases[ligne][colonne].placerPiece(new Pion(joueur1));
          }
      }
      for (int ligne = 6; ligne < 10; ligne++) {
          for (int colonne = (ligne % 2 == 0) ? 1 : 0; colonne < 10; colonne += 2) {
              this.cases[ligne][colonne].placerPiece(new Pion(joueur2));
          }
      }
  }
 
   public Case getCase(int var1, int var2) {
      return this.cases[var1][var2];
   }

   public List<Case> MangePossible(Joueur joueur) {
      List<Case> possible = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 10; j++) {
              Case caseActuelle = cases[i][j];
              if (!caseActuelle.estVide() && caseActuelle.getPiece().getProprietaire() == joueur) {
                  if (PeutManger(caseActuelle)) {
                     possible.add(caseActuelle);
                  }
              }
          }
      }
      return possible;
   }

   private boolean PeutManger(Case caseActuelle) {
      Piece piece = caseActuelle.getPiece();
        int x = caseActuelle.getX();
        int y = caseActuelle.getY();
        int[][] directions = {{-2, -2}, {-2, 2}, {2, -2}, {2, 2}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10) {
                Case destination = getCase(newX, newY);
                int midX = (x + newX) / 2;
                int midY = (y + newY) / 2;
                Case caseMilieu = getCase(midX, midY);

                if (destination.estVide() && !caseMilieu.estVide() && caseMilieu.getPiece().getProprietaire() != piece.getProprietaire()) {
                    return true;
                }
            }
        }
        return false;
   }
}