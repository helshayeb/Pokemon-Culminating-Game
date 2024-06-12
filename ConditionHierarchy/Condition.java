package ConditionHierarchy;

import Pokemon.Pokemon;
/**
* This class creates the Condition abstract class, which allows other Conditions to be used 
* in the Pokemon game
*/
public abstract class Condition{

   	/**
 	* Condition ID of the Condition
	*/
	private int conditionID;

	/**
 	* Turns remaining until the Condition wears off
	*/
	private int turnsRemaining;

	/**
 	* Pokemon that the Condition is applied to
	*/
	private Pokemon appliedTo;

	/**
	* This method is a constructor that initializes the fields of
	* the Condition class when given its 
	* @param appliedTo Pokemon the Condition is applied to
	* @param conditionID the ID of the condition, to be specified in
 	* the child classes
 	*/
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

	/**
 	* This abstract method will apply the turn-based effects of the Condition onto the
 	* the Pokemon that the specified Condition is applied to
	*/
	public abstract void apply();

}
