package PokeDex;

import java.io.*;
import MoveHierarchy.*;

public class MoveDex {
	private int numMoveData;
	private Move[] moveList;

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

	public Move searchMoveByID(int id) {
		int left = 0;
		int right = numMoveData - 1;
		return searchMoveByID(moveList, id, left, right);
	}

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

	public Move searchMoveByName(String name) {
		for (int i = 0; i < numMoveData; i++) {
			if (moveList[i].getMoveName().equalsIgnoreCase(name)) {
				return moveList[i];
			}
		}
		return null;
	}

	public boolean addDamageMove(String moveName, int moveType, int moveID, int basePower) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new DamageMove("Damage", moveName, moveType, moveID, basePower);
		numMoveData++;
		return true;
	}

	public boolean addStatusMove(String moveName, int moveType, int moveID, double hpMod, double atkMod, double defMod,
			double spdMod, int recipient) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new StatusMove("Status", moveName, moveType, moveID, hpMod, atkMod, defMod, spdMod,
				recipient);
		numMoveData++;
		return true;
	}

	public boolean addConditionMove(String moveName, int moveType, int moveID, int conditionAppliedID) {
		if (numMoveData >= PokeDex.MAX_SIZE) {
			return false;
		}
		moveList[numMoveData] = new ConditionMove("Status", moveName, moveType, moveID, conditionAppliedID);
		numMoveData++;
		return true;
	}

}
