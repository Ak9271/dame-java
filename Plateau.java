// Source code is decompiled from a .class file using FernFlower decompiler.
public class Plateau {
    private Case[][] cases = new Case[8][8];
 
    public Plateau() {
       this.initialiserCases();
    }
 
    private void initialiserCases() {
       for(int var1 = 0; var1 < 8; ++var1) {
          for(int var2 = 0; var2 < 8; ++var2) {
             this.cases[var1][var2] = new Case(var1, var2);
          }
       }
 
    }
 
    public void initialiserPlateau(Joueur var1, Joueur var2) {
       int var3;
       int var4;
       for(var3 = 0; var3 < 3; ++var3) {
          for(var4 = var3 % 2; var4 < 8; var4 += 2) {
             this.cases[var3][var4].placerPiece(new Pion(var1));
          }
       }
 
       for(var3 = 5; var3 < 8; ++var3) {
          for(var4 = var3 % 2; var4 < 8; var4 += 2) {
             this.cases[var3][var4].placerPiece(new Pion(var2));
          }
       }
 
    }
 
    public Case getCase(int var1, int var2) {
       return this.cases[var1][var2];
    }
 }
 