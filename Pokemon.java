public class Pokemon{
   /**
   *The name of the Pokemon
   */
   private String name;
   private int type;
   private int id;
   private double maxHPStat;
   private double currentHP;
   private double attackStat;
   private double defenceStat;
   private double speedStat;
   private Move[] moveList;
   private Condition currentCondition;
   private Location foundIn;
   private Item itemHolding;

   public Pokemon(String name, int type, int id, double hps, double atk, double def, double spd, int m1, int m2, int m3, int m4, int loca){
      this.name = name;
      this.type = type;
      this.id = id;
      maxHPStat = hps;
      currentHP = maxHPStat;
      attackStat = atk;
      defenceStat = def;
      speedStat = spd;
      moveList[0] = new Move(m1);
      moveList[1] = new Move(m2);
      moveList[2] = new Move(m3);
      moveList[3] = new Move(m4);
      currentCondition = null;
      foundIn = new location(loca);
      itemHolding = null;
   }

   public void changeCurrentHP(double hpMod, double hpChange){
      currentHP += maxHpStat*hpMod;
      currentHP += hpChange;
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

   public void attack(Pokemon p2, Move m1){
      m1.useMove(this, p2, m1);
   }
}


Contains all accessors, constructors, and mutators
attack(): takes in two pokemon (one implicitly one explicitly) and a move. Uses the two pokemon and one move to call the useMove method in the Move class.
toString(): returns the information of the pokemon in text format. Includes the Pokemon’s name, ID, type, statistics, if it has an Item, and what route it can be found in,
