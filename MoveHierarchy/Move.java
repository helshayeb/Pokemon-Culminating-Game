package MoveHierarchy;

import PokeDex.*;
import Pokemon.*;

public abstract class Move {
	private String objectID;
	private String moveName;
	private int moveType;
	private int moveID;

	public Move(String objectID, String moveName, int moveType, int moveID) {
		this.objectID = objectID;
		this.moveName = moveName;
		this.moveType = moveType;
		this.moveID = moveID;
	}

	public String getObjectID() {
		return objectID;
	}

	public int getMoveType() {
		return moveType;
	}

	public int getMoveID() {
		return moveID;
	}

	public String getMoveName() {
		return moveName;
	}

	
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

	public abstract void useMove(Pokemon p1, Pokemon p2);

	public abstract String toString();

}
