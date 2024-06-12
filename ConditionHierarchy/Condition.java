package ConditionHierarchy;

import Pokemon.Pokemon;
public abstract class Condition{
   private int conditionID;
   private int turnsRemaining;
   private Pokemon appliedTo;
   
   public Condition(Pokemon appliedTo, int conditionID) {
	  this.appliedTo = appliedTo;
	  this.conditionID = conditionID;
   }

   public int getConditionID(){
      return conditionID;
   }
   public int getTurnsRemaining(){
      return turnsRemaining;
   }
   public Pokemon getAppliedTo(){
      return appliedTo;
   }
   public void reduceTurns(){
      turnsRemaining--;
   }

   public abstract void apply();

}
