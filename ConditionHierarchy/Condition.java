package ConditionHierarchy;

import Pokemon.*;
/**
* Class Name: Condition
* Author: David Guan
* Date: June 14th 2024
* School: A. Y. Jackson SS
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

	/**
        * This method is an accessor that allows other classes to access
        * the condition ID of the Condition
        * @return conditionID of the Condition
        */
	public int getConditionID(){
		return conditionID;
	}
	
	/**
        * This method is an accessor that allows other classes to access
        * the turns remaining until the Condition wears off
        * @return turnsRemaining of the Condition
        */
	public int getTurnsRemaining(){
		return turnsRemaining;
	}

	/**
        * This method is an accessor that allows other classes to access
        * the Pokemon the Condition is applied to
        * @return appliedTo of the Condition
        */
	public Pokemon getAppliedTo(){
		return appliedTo;
	}

	/**
        * This method is a mutator that allows other classes to change
        * the turns remaining of the Condition by 1
        */
	public void reduceTurns(){
		turnsRemaining--;
	}

	/**
 	* This abstract method will apply the turn-based effects of the Condition onto the
 	* the Pokemon that the specified Condition is applied to
	*/
	public abstract void apply();

}
