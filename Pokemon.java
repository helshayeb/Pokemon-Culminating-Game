/**
* Creates Pokemon which can be caught and used to battle other Pokemon
*/
public class Pokemon{
   
   /**
   * Name of the Pokemon
   */
   private String name;
   
   /**
   * Type of the Pokemon
   */
   private int type;

   /**
   * ID of the Pokemon
   */
   private int id;

   /**
   * Max health of the Pokemon
   */
   private double maxHPStat;

   /**
   * Current health of the Pokemon
   */
   private double currentHP;

   /**
   * Attack stat of the Pokemon, which determines the damage it can deal to other Pokemon in battle
   */
   private double attackStat;

   /**
   * Defence stat of the Pokemon, which determines the damage it takes from other Pokemon in battle
   */
   private double defenceStat;

   /**
   * Speed stat of the Pokemon, which determines which Pokemon goes first in battle
   */
   private double speedStat;

   /**
   * List of the moves that the Pokemon can use in battle
   */
   private Move[] moveList;

   /**
   * Current Condition of the Pokemon
   */
   private Condition currentCondition;

   /**
   * Location in which the Pokemon can be found
   */
   private Location foundIn;

   /**
   * Item that the Pokemon is currently holding
   */
   private Item itemHolding;

   /**
   * This method is a constructor that initializes the fields of
   * the Pokemon when given its 
   * @param name The name of the Pokemon
   * @param type The type of the Pokemon
   * @param id The ID of the Pokemon
   * @param hps The max health of the Pokemon
   * @param atk The attack stat of the Pokemon
   * @param def The defence stat of the Pokemon
   * @param spd The speed stat of the Pokemon
   * @param m1 The first move the Pokemon can use
   * @param m2 The second move the Pokemon can use
   * @param m3 The third move the Pokemon can use
   * @param m4 The fourth move the Pokemon can use
   * @param loca The location in which the Pokemon can be found
   */
   public Pokemon(String name, int type, int id, double hps, double atk, double def, double spd, int m1, int m2, int m3, int m4, int loca){
      moveList = new Move[4];
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
