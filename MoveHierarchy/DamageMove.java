package MoveHierarchy;

import Pokemon.Pokemon;
public class DamageMove extends Move{
   private int basePower;

   public int getBasePower(){
      return basePower;
   }
   
   public DamageMove(String objectID, String moveName, int moveType, int moveID, int basePower){
      super(objectID, moveName, moveType, moveID);
      this.basePower = basePower;
   }
   
   public void useMove(Pokemon p1, Pokemon p2){
      double multiplier = super.getMatchup(super.getMoveType(), p2.getType());
      double damageDone = -0.2*(p1.getAttackStat()*basePower)/p2.getDefenceStat()*multiplier;
      p2.changeCurrentHP(0, damageDone);
   }
   
   public String toString(){
      String damageMoveInfo = "Move Type: Damage\nMove Name: " + super.getMoveName() + "\nType: " + super.getMoveTypeName(super.getMoveType()) + "\nMove ID: " + super.getMoveID() + "\nBase Power: " + basePower; 
      return damageMoveInfo;
   }

}
