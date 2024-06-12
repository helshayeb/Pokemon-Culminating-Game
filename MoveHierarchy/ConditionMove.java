package MoveHierarchy;

import Pokemon.Pokemon;
//import ConditionHierarchy.*;
/**
* Creates Condition Moves which can be used by Pokemon in Battle
* to apply a condition to the opposing Pokemon
*/
public class ConditionMove extends Move{

	/**
 	* ID of the Condition that the Move applies
	*/
	private int conditionAppliedID;
 		// private Condition conditionApplied;

	
   	/**
	* This method is a constructor that initializes the fields of
	* the ConditionMove class when given its 
	* @param objectID Type of the Move (Condition, Damage, or Status)
	* @param moveName Name of the move
 	* @param moveType Type of the Move (0, 1, 2...)
  	* @param moveID ID of the move
   	* @param conditionAppliedID ID of the Conditioned that is applied
 	*/
   	public ConditionMove(String objectID, String moveName, int moveType, int moveID, int conditionAppliedID){
		super(objectID, moveName, moveType, moveID);
		this.conditionAppliedID = conditionAppliedID;
	      /*switch(conditionAppliedID) {
		 case 0:
		    conditionApplied = new Burn();
		    break;
		 case 1:
		    conditionApplied = new Paralysis();
		    break;
		 case 2:
		    conditionApplied = new Poison();
		    break;
		 default:
		    conditionApplied = null;
		    break;
	      }*/

   	}
	
	/**
 	* This method is an accessor that allows other classes to access the
        * ID of the Condition that the Move applies
	*/
	public int getConditionAppliedID(){
    		return conditionAppliedID;
 	}

	/**
 	* This method uses a Condition Move on a Pokemon given
        * @param Pokemon p1 Pokemon using the Move
	* @param Pokemon p2 Pokemon that Move is being used on
	*/
 	public void useMove(Pokemon p1, Pokemon p2){
		p2.setCondition(conditionAppliedID);
	}

	/**
        * This method returns information about the Condition Move
        * in the form of a String
        * @return String Information about the Move
        */
	public String toString(){
     		String damageMoveInfo = "Condition Move\nMove Name: " + super.getMoveName() + "\nType: " + super.getMoveTypeName(super.getMoveType()) + "\nMove ID: " + super.getMoveID() + "\nCondition Applied ID: " + conditionAppliedID; 
     		return damageMoveInfo;
   	}
}


