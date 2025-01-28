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
}