package PokeDex;

import java.io.*;
import MoveHierarchy.*;
/**
* Creates a PokeDex which can be accessed and used to 
* manipulate Moves
*/
public class MoveDex {
	
	/**
 	* Amount of Moves in the database
	*/
	private int numMoveData;

	/**
 	* Array of Moves
	*/
	private Move[] moveList;

	/**
 	* Typechart that represents the matchups between attacking and defending types
	*/
	public static final double[][] TYPECHART = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 0.5, 1},
            {1, 1, 0.5, 0.5, 1, 1, 2, 1, 1},
            {1, 0, 2, 1, 2, 1, 0.5, 2, 1},
            {1, 1, 1, 1, 0.5, 0.5, 2, 1,  1},
            {1, 1, 1, 2, 2, 0.5, 0.5, 1, 1},
            {1, 0.5, 0.5, 2, 0.5, 2, 0.5, 1, 1},
            {1, 2, 1, 0, 1, 2, 0.5, 0.5, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 0.5}};
	
	/**
	* This method is a constructor that initializes the fields of
	* the MoveDex class
 	*/
	public MoveDex () {
		numMoveData = 0;
	}

	/**
 	* This method uses BufferedReader to read in information from a text file given
        * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
	public boolean readMoves(String fileName) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			numMoveData = Integer.parseInt(in.readLine());
			moveList = new Move[PokeDex.MAX_SIZE];
			String objectID;
			String moveName;
			int moveType;
			int moveID;
			int basePower;
			double hpMod;
			double atkMod;
			double defMod;
			double spdMod;
			int recipient;
			int conditionApplied;
			for (int i = 0; i < numMoveData; i++) {
				objectID = in.readLine();
				if (objectID.equalsIgnoreCase("Damage")) {
					moveName = in.readLine();
					moveType = Integer.parseInt(in.readLine());
					moveID = Integer.parseInt(in.readLine());
					basePower = Integer.parseInt(in.readLine());
					in.readLine();
					moveList[i] = new DamageMove(objectID, moveName, moveType, moveID, basePower);
				} else if (objectID.equalsIgnoreCase("Status")) {
					moveName = in.readLine();
					moveType = Integer.parseInt(in.readLine());
					moveID = Integer.parseInt(in.readLine());
					hpMod = Double.parseDouble(in.readLine());
					atkMod = Double.parseDouble(in.readLine());
					defMod = Double.parseDouble(in.readLine());
					spdMod = Double.parseDouble(in.readLine());
					recipient = Integer.parseInt(in.readLine());
					in.readLine();
					moveList[i] = new StatusMove(objectID, moveName, moveType, moveID, hpMod, atkMod, defMod, spdMod,
							recipient);
				} else if (objectID.equalsIgnoreCase("Condition")) {
					moveName = in.readLine();
					moveType = Integer.parseInt(in.readLine());
					moveID = Integer.parseInt(in.readLine());
					conditionApplied = Integer.parseInt(in.readLine());
					in.readLine();
					moveList[i] = new DamageMove(objectID, moveName, moveType, moveID, conditionApplied);
				}
			}
			in.close();
			return true;
		} catch (IOException iox) {
			System.out.println("Error accessing file");
			return false;
		}
	}

	/**
 	* This method uses BufferedWriter to write information from moveList to the given
        * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
	public boolean saveMoves(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(numMoveData);
			for (int i = 0; i <= numMoveData; i++) {
				if (moveList[i] instanceof DamageMove) {
					out.write(moveList[i].getObjectID());
					out.write(moveList[i].getMoveName());
					out.write(moveList[i].getMoveType());
					out.write(moveList[i].getMoveID());
					out.write(((DamageMove) moveList[i]).getBasePower());
				} else if (moveList[i] instanceof StatusMove) {
					out.write(moveList[i].getObjectID());
					out.write(moveList[i].getMoveName());
					out.write(moveList[i].getMoveType());
					out.write(moveList[i].getMoveID());
					out.write("" + ((StatusMove) moveList[i]).getHPMod());
					out.write("" + ((StatusMove) moveList[i]).getAtkMod());
					out.write("" + ((StatusMove) moveList[i]).getDefMod());
					out.write("" + ((StatusMove) moveList[i]).getSpdMod());
					out.write(((StatusMove) moveList[i]).getRecipient());
				} else if (moveList[i] instanceof ConditionMove) {
					out.write(moveList[i].getObjectID());
					out.write(moveList[i].getMoveName());
					out.write(moveList[i].getMoveType());
					out.write(moveList[i].getMoveID());
					out.write(((ConditionMove) moveList[i]).getConditionAppliedID());
				}
				out.newLine();
			}
			out.close();
			return true;
		} catch (IOException iox) {
			System.out.println("Error saving file");
			return false;
		}
	}

	/**
 	* This method is a wrapper method used to search for a Pokemon given
	* @param id ID of the Move being searched for
	* @return Move if successful, null if not
	*/
	public Move searchMoveByID(int id) {
		int left = 0;
		int right = numMoveData - 1;
		return searchMoveByID(moveList, id, left, right);
	}

	/**
 	* This method uses recursive binary search to search for a Pokemon given
        * @param moveList List of moves to search in
	* @param id ID of the Move being searched
 	* @param left Left bound
 	* @param right Right bound
	* @return Move if successful, null if not
	*/
	public Move searchMoveByID(Move[] moveList, int id, int left, int right) {
		int mid = left + (right - left) / 2;
		if (left > right) {
			return null;
		}
		if (moveList[mid].getMoveID() == id) {
			return moveList[mid];
		} else if (moveList[mid].getMoveID() > id) {
			return searchMoveByID(moveList, id, left, mid - 1);
		} else {
			return searchMoveByID(moveList, id, mid + 1, right);
		}
	}

	/**
 	* This method uses sequential search to search for a Pokemon given
	* @param name Name of the Move being searched for
	* @return Move if successful, null if not
	*/
	public Move searchMoveByName(String name) {
		for (int i = 0; i < numMoveData; i++) {
			if (moveList[i].getMoveName().equalsIgnoreCase(name)) {
				return moveList[i];
			}
		}
		return null;
	}

	/**
 	* This method adds a Damage Move to the list of Moves when given
	* @param name Name of the Move 
 	* @param moveType of the Move
  	* @param basePower Base power of the Move
	* @return true if successful, false if not
	*/
	public boolean addDamageMove(String moveName, int moveType, int basePower) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new DamageMove("Damage", moveName, moveType, numMoveData, basePower);
		numMoveData++;
		return true;
	}

	/**
 	* This method adds a Status Move to the list of Moves when given
	* @param name Name of the Move 
 	* @param moveType of the Move
	* @param hpMod Health Modifier of the Move
    	* @param atkMod Attack Modifier of the Move
    	* @param defMod Defence Modifier of the Move
    	* @param spdMod Speed Modifier of the Move
    	* @param recipient Recipient of the Move	
     	* @return true if successful, false if not
	*/
	public boolean addStatusMove(String moveName, int moveType, double hpMod, double atkMod, double defMod,
			double spdMod, int recipient) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new StatusMove("Status", moveName, moveType, numMoveData, hpMod, atkMod, defMod, spdMod,
				recipient);
		numMoveData++;
		return true;
	}

	/**
 	* This method adds a Condition Move to the list of Moves when given
	* @param name Name of the Move 
 	* @param moveType of the Move
  	* @param conditionAppliedID ID of the Condition being applied
	* @return true if successful, false if not
	*/
	public boolean addConditionMove(String moveName, int moveType, int conditionAppliedID) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new ConditionMove("Status", moveName, moveType, numMoveData, conditionAppliedID);
		numMoveData++;
		return true;
	}

}
