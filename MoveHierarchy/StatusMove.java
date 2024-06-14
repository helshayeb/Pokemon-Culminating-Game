
package MoveHierarchy;

import Pokemon.*;

/**
 * Creates Damage Moves which can be used by Pokemon in Battle to deal damage to
 * the opposing Pokemon
 */
public class StatusMove extends Move {

	/**
	 * Health modifier
	 */
	private double hpMod;

	/**
	 * Attack modifier
	 */
	private double atkMod;

	/**
	 * Defence modifier
	 */
	private double defMod;

	/**
	 * Speed modifier
	 */
	private double spdMod;

	/**
	 * Pokemon that receives the stat changes
	 */
	private int recipient;

	/**
	 * This method is an accessor that allows other classes to access the health
	 * modifier of the Status Move
	 * 
	 * @return hpMod of the move
	 */
	public double getHPMod() {
		return hpMod;
	}

	/**
	 * This method is an accessor that allows other classes to access the attack
	 * modifier of the Status Move
	 * 
	 * @return atkMod of the move
	 */
	public double getAtkMod() {
		return atkMod;
	}

	/**
	 * This method is an accessor that allows other classes to access the defence
	 * modifier of the Status Move
	 * 
	 * @return defMod of the move
	 */
	public double getDefMod() {
		return defMod;
	}

	/**
	 * This method is an accessor that allows other classes to access the speed
	 * modifier of the Status Move
	 * 
	 * @return spdMod of the move
	 */
	public double getSpdMod() {
		return spdMod;
	}

	/**
	 * This method is an accessor that allows other classes to access the recipient
	 * of the Move
	 * 
	 * @return recipient of the Move
	 */
	public int getRecipient() {
		return recipient;
	}

	/**
	 * This method is a constructor that initializes the fields of the Status Move
	 * class when given its
	 * 
	 * @param objectID  Type of the Move (Condition, Damage, or Status)
	 * @param moveName  Name of the Move
	 * @param moveType  Type of the Move (0, 1, 2...)
	 * @param moveID    ID of the Move
	 * @param hpMod     Health Modifier of the Move
	 * @param atkMod    Attack Modifier of the Move
	 * @param defMod    Defence Modifier of the Move
	 * @param spdMod    Speed Modifier of the Move
	 * @param recipient Recipient of the Move
	 */
	public StatusMove(String objectID, String moveName, int moveType, int moveID, double hpMod, double atkMod,
			double defMod, double spdMod, int recipient) {
		super(objectID, moveName, moveType, moveID);
		this.hpMod = hpMod;
		this.atkMod = atkMod;
		this.defMod = defMod;
		this.spdMod = spdMod;
		this.recipient = recipient;
	}

	/**
	 * This method uses a Status Move on a Pokemon given
	 * 
	 * @param Pokemon p1 Pokemon Pokemon using the move
	 * @param Pokemon p2 Pokemon Opposing Pokemon
	 */
	public void useMove(Pokemon p1, Pokemon p2) {
		double max;
		if (recipient == 0) {
			p1.changeCurrentHP(hpMod, 0);
			p1.changeAtkStat(atkMod);
			p1.changeDefStat(defMod);
			p1.changeSpdStat(spdMod);
		} else {
			p2.changeCurrentHP(hpMod, 0);
			max = p2.getMaxHPStat();
			if (p2.getCurrentHP() > max) {
				p2.changeCurrentHP(0, max);
			}
			p2.changeAtkStat(atkMod);
			p2.changeDefStat(defMod);
			p2.changeSpdStat(spdMod);
		}
	}

	/**
	 * This method returns information about the Status Move in the form of a String
	 * 
	 * @return String Information about the Move
	 */
	public String toString() {
		String statusMoveInfo = "Status Move\nMove Name: " + super.getMoveName() + "\nType: "
				+ super.getMoveTypeName(super.getMoveType()) + "\nMove ID: " + super.getMoveID() + "\nHP Modifier: "
				+ hpMod + "\nAttack Modifier: " + atkMod + "\nDefence Modifier: " + defMod + "\nSpeed Modifier: "
				+ spdMod + "\nRecipient: " + recipient;
		return statusMoveInfo;
	}
}
