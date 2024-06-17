package MoveHierarchy;

import Pokemon.*;
import PokeDex.*;
/**
* Class Name: DamageMove
* Author: David Guan
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates Damage Moves which can be used by Pokemon in Battle
* to deal damage to the opposing Pokemon
*/
public class DamageMove extends Move{

   /**
   * Base power of the move, which (along with the Pokemon's attack stat)
   * determines how much damage they can deal to opposing Pokemon
   */
   private int basePower;

   /**
   * This method is an accessor that allows other classes to access the
   * @param basePower Base power of the move
   */
   public int getBasePower(){
      return basePower;
   }

   /**
   * This method is a constructor that initializes the fields of
   * the Damagemove class when given its 
   * @param objectID Type of the Move (Condition, Damage, or Status)
   * @param moveName Name of the move
   * @param moveType Type of the Move (0, 1, 2...)
   * @param moveID ID of the Move
   * @param basePower Base power of the Move
   */
   public DamageMove(String objectID, String moveName, int moveType, int moveID, int basePower){
      super(objectID, moveName, moveType, moveID);
      this.basePower = basePower;
   }

   /**
   * This method uses a Damage Move on a Pokemon given
   * @param Pokemon p1 Pokemon using the Move
   * @param Pokemon p2 Pokemon that Move is being used on
   */
   public void useMove(Pokemon p1, Pokemon p2){
      double multiplier = MoveDex.TYPECHART[super.getMoveType()] [p2.getType()];
      double damageDone = -0.2*(p1.getAttackStat()*basePower)/p2.getDefenceStat()*multiplier;
      p2.changeCurrentHP(0, damageDone);
   }

   /**
   * This method returns information about the Condition Move
   * in the form of a String
   * @return String Information about the Move
   */
   public String toString(){
      String damageMoveInfo = "Damage move\nMove Name: " + super.getMoveName() + "\nType: " + super.getMoveTypeName(super.getMoveType()) + "\nMove ID: " + super.getMoveID() + "\nBase Power: " + basePower; 
      return damageMoveInfo;
   }

}
