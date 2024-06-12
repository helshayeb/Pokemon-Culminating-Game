package ConditionHierarchy;

import Pokemon.*;

public class Paralysis extends Condition {
	public static final double SPD_MOD = 0.5;
	public static final int CONDITION_ID = 1;
	public double originalSpd;

	public Paralysis(Pokemon appliedTo) {
		super(appliedTo, CONDITION_ID);
		originalSpd = appliedTo.getSpeedStat();
	}

	public String toString() {
		return "Paralysis";
	}

	public void apply() {
		if (super.getTurnsRemaining() == 4) {
			super.getAppliedTo().changeSpdStat(SPD_MOD);
			super.reduceTurns();
		} else if (super.getTurnsRemaining() == 0) {
			super.getAppliedTo().setSpeedStat(originalSpd);
			super.getAppliedTo().setCondition(-1);
		} else {
			super.reduceTurns();
		}
	}
}
