public class Poison extends Condition{
  public static final double DMG = -0.1;

  public Poison(Pokemon appliedTo){ //wait appliedTo might have to be a thing in condition
    super(appliedTo);
    originalAtk = appliedTo.getAtkStat();
  }

  apply(){
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
  }
   
  
}
