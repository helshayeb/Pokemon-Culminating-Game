public class Paralysis extends Condition{
  public static final double SPD_MOD = 0.5;
  public double originalSpd;

  public Paralysis(Pokemon appliedTo){ 
    super(appliedTo);
    originalSpd = appliedTo.getSpdStat();
  }

  apply(){
    if(super.getTurnsRemaining() == 4){
      appliedTo.changeSpdStat(SPD_MOD);
      super.reduceTurns();
    }else if (super.getTurnsRemaining() == 0){
      appliedTo.setSpdStat(originalSpd);
      appliedTo.setCondition(-1);
    }else{
      super.reduceTurns();
    }
  }
   
  
}
