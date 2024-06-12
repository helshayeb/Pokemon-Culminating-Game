package MoveHierarchy;

import PokeDex.*;
import Pokemon.*;

public class StatusMove extends Move {
	private double hpMod;
	private double atkMod;
	private double defMod;
	private double spdMod;
	private int recipient;

	public double getHPMod() {
		return hpMod;
	}

	public double getAtkMod() {
		return atkMod;
	}

	public double getDefMod() {
		return defMod;
	}

	public double getSpdMod() {
		return spdMod;
	}

	public int getRecipient() {
		return recipient;
	}

	public StatusMove(String objectID, String moveName, int moveType, int moveID, double hpMod, double atkMod,
			double defMod, double spdMod, int recipient) {
		super(objectID, moveName, moveType, moveID);
		this.hpMod = hpMod;
		this.atkMod = atkMod;
		this.defMod = defMod;
		this.spdMod = spdMod;
		this.recipient = recipient;
	}

	public void useMove(Pokemon p1, Pokemon p2) {
		double max;
		if (recipient == 0) {
			p1.changeCurrentHP(hpMod, 0);

			p1.changeAtkStat(atkMod); // reminder to make it attackStat*atkMod inside the mutator in pokemon class
			p1.changeDefStat(defMod); // same with everything here
			p1.changeSpdStat(spdMod);
		} else {
			p2.changeCurrentHP(hpMod, 0);
			max = p2.getMaxHPStat();
			if (p2.getCurrentHP() > max) {
				p2.changeCurrentHP(0, max);
			}
			p2.changeAtkStat(atkMod); // reminder to make it attackStat*atkMod inside the mutator in pokemon class
			p2.changeDefStat(defMod); // same with everything here
			p2.changeSpdStat(spdMod);
		}
	}

	public String toString() {
		return null;
	}
}
