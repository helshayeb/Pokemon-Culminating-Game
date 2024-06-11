public class ConditionMove extends Move{
   private int conditionAppliedID;
   private Condition conditionApplied;
   
   public ConditionMove(String objectID, String moveName, int moveType, int moveID, int conditionAppliedID){
      super(objectID, moveName, moveType, moveID);
      this.conditionAppliedID = conditionAppliedID;
      switch(conditionAppliedID) {
         case 0:
            conditionApplied = new Burn();
            break;
         case 1:
            conditionApplied = new Paralysis();
            break;
         case 2:
            conditionApplied = new Poison();
            break;
         default:
            conditionApplied = null;
            break;
      }

   }
   
   public void useMove(Pokemon p1, Pokemon p2){
      
      p2.setCondition(conditionApplied)
   }
}


