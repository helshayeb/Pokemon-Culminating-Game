public abstract class Condition{
   private int conditionID;
   private int turnsRemaining;
   private Pokemon appliedTo;
   
   public Condition(Pokemon appliedTo, int conditionID);

   public int getConditionID(){
      return conditionID;
   }
   public int getTurnsRemaining(){
      return turnsRemaining;
   }
   public Pokemon getAppliedTo(){
      return appliedTo;
   }
   public void reduceTurns(){
      turnsRemaining--;
   }

   public int getTurnsRemaining(){
      return turnsRemaining;
   }
   
   public void apply();

}
