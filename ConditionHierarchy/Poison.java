public class Poison extends Condition{
  public static final double DMG = -0.1;

  public Poison(Pokemon appliedTo){ //wait appliedTo might have to be a thing in condition
    super(appliedTo);
  }

  public void apply(){
    if(super.getTurnsRemaining() != 0){
      appliedTo.changeCurrentHP(DMG, 0);
      super.reduceTurns();
    }else{
      appliedTo.changeCurrentHP(DMG, 0);
      appliedTo.setCondition(-1);
    }
  }
   
  public StringtoString(){
    return "Poison";
  }
}
