package ConditionHierarchy;

import Pokemon.*;
/**
* This class creates and allows the Paralysis Condition to be used and applied to Pokemon 
* in the Pokemon game
* The Paralysis Class drastically reduces the Pokemon's speed stat
*/
public class Paralysis extends Condition {

	/**
 	* Speed modifier for Paralyzed Pokemon 
	*/
	public static final double SPD_MOD = 0.11;

	/**
 	* Condition ID for the Paralysis Condition, 1
	*/
	public static final int CONDITION_ID = 1;

	/**
 	* Original Speed stat of the Pokemon, which is to be changed to after the Pokemon stops being Paralyzed
	*/
	public double originalSpd;

	/**
	* This method is a constructor that initializes the fields of
	* the Paralysis class when given its 
	* @param appliedTo Pokemon the Condition is applied to
 	*/
	public Paralysis(Pokemon appliedTo) {
		super(appliedTo, CONDITION_ID);
		originalSpd = appliedTo.getSpeedStat();
	}

	
	/**
        * This method applies the turn-based effects of the condition onto the
        * the Pokemon that the Paralysis is applied to
        */
	public void apply() {
		if (super.getTurnsRemaining() == 4) {
			super.getAppliedTo().changeSpdStat(SPD_MOD);
			super.reduceTurns();
		} else if (super.getTurnsRemaining() == 0) {
			super.getAppliedTo().setSpeedStat(originalSpd);
			super.getAppliedTo().setCondition(-1);
		} else {
			super.reduceTurns();
		}
	}
	
	/**
        * This method returns the type of Condition it is 
        * in the form of a String
        * @return "Paralysis" as a String
        */
	public String toString() {
		return "Paralysis";
	}
}
