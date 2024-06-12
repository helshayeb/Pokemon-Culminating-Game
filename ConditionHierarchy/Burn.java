/**
* This class makes it so the user can interact with everything 
* in the Pokemon game
*/
package ConditionHierarchy;

import Pokemon.*;
public class Burn extends Condition{
  public static final double ATK_MOD = 0.5;
  public static final double DMG = -0.05;
  public static final int CONDITION_ID = 0;
  private double originalAtk;

  public Burn(Pokemon appliedTo){ //wait appliedTo might have to be a thing in condition
    super(appliedTo, CONDITION_ID);
    originalAtk = appliedTo.getAttackStat();
  }

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

  public String toString(){
    return "Burn";
  }
  
}
