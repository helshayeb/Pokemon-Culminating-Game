package ItemHierarchy;

import PokeDex.*;
import Pokemon.*;

/**
* Creates attack items that can increase a pokemon's attack stat
*/
public class AttackItem extends Item {

    /**
    * This method is a constructor that initializes the fields of
    * the attack item when given its type, name, id, price, and modifier
    * @param type The type of item this item falls under, retrieved from the ItemDex
    * @param name The name of the item, retrieved from the ItemDex
    * @param idNum The ID of the item, retrieved from the ItemDex
    * @param priceNum The price of the item, retrieved from the ItemDex
    * @param mod The modifier of the item, retrieved from the ItemDex
    */
    public AttackItem(String type, String name, int idNum, int priceNum, double mod) {
        super(type, name, idNum, priceNum, mod);
      }

    /**
    * Allows a pokemon to use an attack item
    * @param p The pokemon the attack item's effect will be applied to
    */
    public void useItem(Pokemon p) {
      p.changeAttackStat(this.modifier); //Multiplies the pokemon's attack stat by the item's modifier
    }
}
