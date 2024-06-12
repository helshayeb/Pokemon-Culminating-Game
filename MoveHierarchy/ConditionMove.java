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
   
 	public void useMove(Pokemon p1, Pokemon p2){
      
		p2.setCondition(conditionAppliedID);
	}
   
	public String toString() {
		return null;
	}
}


