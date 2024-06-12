public class Burn extends Condition{
  public static final double ATK_MOD = 0.5;
  public static final double DMG = -0.05;
  private double originalAtk;

  public Burn(Pokemon appliedTo){ //wait appliedTo might have to be a thing in condition
    super(appliedTo);
    originalAtk = appliedTo.getAtkStat();
  }

  public void apply(){
    if(super.getTurnsRemaining() == 4){
      appliedTo.changeAtkStat(ATK_MOD);
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }else if (super.getTurnsRemaining() == 0){
      appliedTo.setAtkStat(originalAtk);
      appliedTo.setCondition(-1);
    }else{
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }
  }

  public String toString(){
    return "Burn";
  }
  
}
