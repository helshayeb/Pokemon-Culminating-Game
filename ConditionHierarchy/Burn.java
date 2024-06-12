package ConditionHierarchy;

import Pokemon.*;
/**
* This class creates and allows the Burn Condition to be used and applied to Pokemon 
* in the Pokemon game
*/
public class Burn extends Condition{

  /**
   * Attack modifier of Burning Pokemon
   */
  public static final double ATK_MOD = 0.5;

  /**
   * Damage (represented as a portion of max hp) done to Burning Pokemon every turn
   */
  public static final double DMG = -0.05;

  /**
   * Condition ID of the Burn Condition, 0
   */
  public static final int CONDITION_ID = 0;

  /**
   * Original attack stat of the Pokemon, which is to be change to after the Pokemon stops Burning
   */
  private double originalAtk;

  /**
   * This method is a constructor that initializes the fields of
   * the Burn Condition when given its 
   * @param appliedTo Pokemon the Burn is applied to
   */
  public Burn(Pokemon appliedTo){
    super(appliedTo, CONDITION_ID);
    originalAtk = appliedTo.getAttackStat();
  }

  /**
   * This method applies the turn-based effects of the condition onto the
   * the Pokemon that the Burn is applied to
   */
  public void apply(){
    if(super.getTurnsRemaining() == 4){
    	super.getAppliedTo().changeAtkStat(ATK_MOD);
    	super.getAppliedTo().changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }else if (super.getTurnsRemaining() == 0){
    	super.getAppliedTo().setAttackStat(originalAtk);
    	super.getAppliedTo().setCondition(-1);
    }else{
    	super.getAppliedTo().changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }
  }

  /**
   * This method returns the type of Condition it is 
   * in the form of a String
   * @return "Burn" as a String
   */
  public String toString(){
    return "Burn";
  }
  
}
