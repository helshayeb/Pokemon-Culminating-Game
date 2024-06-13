package MoveHierarchy;

import Pokemon.*;
/**
* Creates Moves which can be used by Pokemon in Battle
*/
public abstract class Move {

	/**
 	* ID of the Move's child Classes
	*/
	private String objectID;

	/**
 	* Name of the Move
	*/
	private String moveName;

	/**
 	* Type of the Move
	*/
	private int moveType;

	/**
 	* ID of the Move
	*/
	private int moveID;

	/**
	* This method is a constructor that initializes the fields of
	* the Move class when given its 
	* @param objectID Type of the Move (Condition, Damage, or Status)
	* @param moveName Name of the move
 	* @param moveType Type of the Move (0, 1, 2...)
  	* @param moveID ID of the move
 	*/
	public Move(String objectID, String moveName, int moveType, int moveID) {
		this.objectID = objectID;
		this.moveName = moveName;
		this.moveType = moveType;
		this.moveID = moveID;
	}

	/**
 	* This method is an accessor that allows other classes to access the
        * Type of Move Object
	* @return objectID 
	*/
	public String getObjectID() {
		return objectID;
	}

	/**
 	* This method is an accessor that allows other classes to access the
        * Move's type
	* @return moveType 
	*/
	public int getMoveType() {
		return moveType;
	}

	/**
 	* This method is an accessor that allows other classes to access the
        * ID of the Move
	* @return moveID 
	*/
	public int getMoveID() {
		return moveID;
	}

	/**
 	* This method is an accessor that allows other classes to access the
        * name of the Move
	* @return moveName 
	*/
	public String getMoveName() {
		return moveName;
	}

	/**
 	* This method is an accessor that allows other classes to access the
        * Type of the Move in String form
	* @param typeID ID of the Move's type
	* @return String Name of the Move's type
	*/
	public String getMoveTypeName(int typeID) {
		switch (typeID) {
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
   	* This method uses a Move on a Pokemon given
  	* @param Pokemon p1 Pokemon using the Move
 	* @param Pokemon p2 Pokemon that Move is being used on
 	*/
	public abstract void useMove(Pokemon p1, Pokemon p2);

	/**
   	* This method returns information about the Move
   	* in the form of a String
   	* @return String Information about the Move
   	*/
	public abstract String toString();

}
