public class Pokemon{
   private String name;
   private int type;
   private int id;
   private double maxHPStat;
   private double currentHP;
   private double attackStat;
   private double defenseStat;
   private double speedStat;
   private Move[] moveList;
   private Condition currentCondition;
   private Location foundIn;

   public Pokemon(String name, int type, int id, double hps, double chp, double atk, double def, double spd, int m1, int m2, int m3, int m4){
   }

   public void changeCurrentHP(double hpMod, double hpHeal){
      currentHP += maxHpStat*hpMod;
      currentHP += hpHeal;
      if(currentHP > maxHPStat){
         currentHP = maxHPStat;
      }
   }

   public void changeAtkStat(double atkMod){
      attackStat *= atkMod;
   }
   public void changeDefStat(double defMod){
      defenseStat *= defMod;
   }
   public void changeSpdStat(double spdMod){
      speedStat *= spdMod;
   }
   public static String getTypeName(int typeID){
      switch(typeID) {
         case 0:
            return "Normal";
         case 1:
            return "Flying";
         case 2:
            return "Poison";
         case 3:
            return "Ground";
         case 4:
            return "Fire";
         case 5: 
            return "Water";
         case 6:
            return "Grass";
         case 7:
            return "Electric";
         case 8:
            return "Psychic";
         default:
            return "Type Not Found";
      }
      
   }
}


Contains all accessors, constructors, and mutators
attack(): takes in two pokemon (one implicitly one explicitly) and a move. Uses the two pokemon and one move to call the useMove method in the Move class.
toString(): returns the information of the pokemon in text format. Includes the Pokemon’s name, ID, type, statistics, if it has an Item, and what route it can be found in,
