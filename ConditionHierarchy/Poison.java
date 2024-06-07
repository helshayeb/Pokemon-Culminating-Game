public class Poison extends Condition{
  public static final double DMG = 0.1;
  public double originalAtk;

  public Poison(Pokemon appliedTo){ //wait appliedTo might have to be a thing in condition
    super(appliedTo);
    originalAtk = appliedTo.getAtkStat();
  }

  apply(){
    if(super.getTurnsRemaining() == 4){
      appliedTo.changeAtkStat(ATK_MOD);
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }else if (super.getTurnsRemaining() == 0){
      appliedTo.setAtkStat(originalAtk);
    }else{
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }
  }
   
  
}
