package Pokemon;
import ConditionHierarchy.*;
import MoveHierarchy.*;
import LocationHierarchy.*;
import ItemHierarchy.*;
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
   public Pokemon(String name, int type, int id, double hps, double atk, double def, double spd, Move m1, Move m2, Move m3, Move m4, Location loca){
      moveList = new Move[4];
      this.name = name;
      this.type = type;
      this.id = id;
      maxHPStat = hps;
      currentHP = maxHPStat;
      attackStat = atk;
      defenceStat = def;
      speedStat = spd;
      moveList[0] = m1;
      moveList[1] = m2;
      moveList[2] = m3;
      moveList[3] = m4;
      currentCondition = null;
      foundIn = loca;
      itemHolding = null;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the name of the Pokemon
   * @return Name of the Pokemon
   */
   public String getName () {
      return name;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the type of the Pokemon
   * @return Type of the Pokemon
   */
   public int getType () {
      return type;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the ID of the Pokemon
   * @return ID of the Pokemon
   */
   public int getID () {
      return id;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the max health of the Pokemon
   * @return Max health of the Pokemon
   */
   public double getMaxHPStat () {
      return maxHPStat;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current health of the Pokemon
   * @return Current health of the Pokemon
   */
   public double getCurrentHP () {
      return currentHP;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the attack stat of the Pokemon
   * @return Attack stat of the Pokemon
   */
   public double getAttackStat () {
      return attackStat;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the defence stat of the Pokemon
   * @return Defence stat of the Pokemon
   */
   public double getDefenceStat () {
      return defenceStat;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the defence stat of the Pokemon
   * @return Defence stat of the Pokemon
   */
   public double getSpeedStat () {
      return speedStat;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of moves of the Pokemon
   * @return moveList[] The array storing the Pokemon's four moves
   */
   public Move[] getMoveList(){
      return moveList;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current condition of the Pokemon
   * @return currentCondition The Pokemon's current condition
   */
   public Condition getCurrentCondition(){
      return currentCondition;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the location in which the Pokemon can be found
   * @return foundIn The location of the Pokemon
   */
   public Location getFoundIn(){
      return foundIn;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the item the Pokemon is holding
   * @return itemHolding The Pokemon's current item
   */
   public Item getItemHolding(){
      return itemHolding;
   }
   
   /**
   * This method is a mutator that changes the current health of
   * the Pokemon when given the 
   * @param hpMod Multiplier to determine percentage changes in health
   * @param hpChange Value to determine numerical changes in health
   */
   public void changeCurrentHP(double hpMod, double hpChange){
      currentHP += maxHPStat*hpMod;
      currentHP += hpChange;
      if(currentHP > maxHPStat){
         currentHP = maxHPStat;
      }
   }

   /**
   * This method is a mutator that changes the attack stat of
   * the Pokemon when given the 
   * @param atkMod Multiplier to determine percentage changes in the attack stat
   */
   public void changeAtkStat(double atkMod){
      attackStat *= atkMod;
   }
   
   /**
   * This method is a mutator that changes the defence stat of
   * the Pokemon when given the 
   * @param defMod Multiplier to determine percentage changes in the defence stat
   */
   public void changeDefStat(double defMod){
      defenceStat *= defMod;
   }

   /**
   * This method is a mutator that changes the speed stat of
   * the Pokemon when given the 
   * @param spdMod Multiplier to determine percentage changes in the speed stat
   */
   public void changeSpdStat(double spdMod){
      speedStat *= spdMod;
   }
   
   /**
    * This method is a mutator that sets the speed stat of
    * the Pokemon when given the 
    * @param stat Value to set the speed stat to
    */
   public void setSpeedStat(double stat) {
	   speedStat = stat;
   }
   
   /**
    * This method is a mutator that sets the attack stat of
    * the Pokemon when given the 
    * @param stat Value to set the attack stat to
    */
   public void setAttackStat(double stat) {
	   attackStat = stat;
   }
   
   /**
   * This method is a mutator that sets the current Condition of
   * the Pokemon when given the 
   * @param conditionID Integer used to identify Conditions
   */
   public void setCondition(int conditionID){
      Condition cd;
      if(conditionID == 0){
         cd = new Burn(this);
         currentCondition = cd;
      }else if(conditionID == 1){
         cd = new Paralysis(this);
         currentCondition = cd;
      }else if(conditionID == 2){
         cd = new Poison(this);
         currentCondition = cd;
      }else{
         currentCondition = null;
      }
   }

   /**
   * This method is a mutator that sets the item of
   * the Pokemon when given the 
   * @param holding Item the Pokemon is holding
   */
   public void setItemHolding(Item holding) {
	   itemHolding = holding;
   }
	
   /**
   * This method returns the name of 
   * a type when given its
   * @param typeID Integer used to identify types
   * @return Name of the Type in String format
   */
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
   
   /**
   * This method calls the useMove method in
   * the Move class when given the
   * @param p2 Pokemon the move is being used on
   * @param m1 Move that is being used
   */
   public void attack(Pokemon p2, Move m1){
      m1.useMove(this, p2);
   }

   /**
   * This method calls the apply method in
   * the Condition class
   */
   public void applyCondition(){
      if(currentCondition != null){
         currentCondition.apply();
      }
   }

   /**
   * This method calls the useItem method in
   * the Item class
   * @param it Item that is being used
   */
   public void consumeItem(Item it){
      it.useItem(this);
   }
   
   /**
   * This method returns the information about
   * the Pokemon
   * @return Information in String form
   */
   public String toString(){
      String cond;
      if(currentCondition == null){
	cond = "No Condition Applied";
      }else{
	cond == conditionApplied.toString();
      }
	
      String pokemonInfo = "Name: " + name + "\nType: " + getTypeName(type) + "\nID: " + id + "\nMax Health: " + maxHPStat + "\nAttack Stat: " + attackStat + "\nDefence Stat" + defenceStat + "\nSpeedStat: " + speedStat + "Moves: " + moveList[0].getMoveName() + "\n" + moveList[1].getMoveName() + "\n" + moveList[2].getMoveName() + "\n" + moveList[3].getMoveName() + "\nCondition: " + cond + "\nLocation: " + foundIn.getRegionType();  
      return pokemonInfo;
   }
}
