package ConditionHierarchy;

import Pokemon.*;
/**
* This class creates and allows the Poison Condition to be used and applied to Pokemon 
* in the Pokemon game
* The Poison Condition deals considerable damage to the Pokemon every turn it is applied on
*/
public class Poison extends Condition {

	/**
        * Damage (represented as a portion of max hp) done to Poisoned Pokemon every turn
        */
	public static final double DMG = -0.1;

	/**
        * Condition ID of the Poison Condition, 2
        */
	public static final int CONDITION_ID = 2;

	/**
	* This method is a constructor that initializes the fields of
	* the Poison class when given its 
	* @param appliedTo Pokemon the Condition is applied to
 	*/
	public Poison(Pokemon appliedTo) { 
		super(appliedTo, CONDITION_ID);
	}

	/**
        * This method applies the turn-based effects of the condition onto the
        * the Pokemon that the Poison is applied to
        */
	public void apply() {
		if (super.getTurnsRemaining() != 0) {
			super.getAppliedTo().changeCurrentHP(DMG, 0);
			super.reduceTurns();
		} else {
			super.getAppliedTo().changeCurrentHP(DMG, 0);
			super.getAppliedTo().setCondition(-1);
		}
	}

	/**
        * This method returns the type of Condition it is 
        * in the form of a String
        * @return "Poison" as a String
        */
	public String toString() {
		return "Poison";
	}
}
