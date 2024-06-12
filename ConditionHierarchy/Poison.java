package ConditionHierarchy;

import Pokemon.*;

public class Poison extends Condition {
	public static final double DMG = -0.1;
	public static final int CONDITION_ID = 2;

	public Poison(Pokemon appliedTo) { // wait appliedTo might have to be a thing in condition
		super(appliedTo, CONDITION_ID);
	}

	public void apply() {
		if (super.getTurnsRemaining() != 0) {
			super.getAppliedTo().changeCurrentHP(DMG, 0);
			super.reduceTurns();
		} else {
			super.getAppliedTo().changeCurrentHP(DMG, 0);
			super.getAppliedTo().setCondition(-1);
		}
	}

	public String toString() {
		return "Poison";
	}
}
