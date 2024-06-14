package ItemHierarchy;

import Pokemon.*;

/**
* Creates defence items that can increase a pokemon's defence stat
*/
public class DefenceItem extends Item {

    /**
    * This method is a constructor that initializes the fields of
    * the defence item when given its type, name, id, price, and modifier
    * @param type The type of item this item falls under, retrieved from the ItemDex
    * @param name The name of the item, retrieved from the ItemDex
    * @param idNum The ID of the item, retrieved from the ItemDex
    * @param priceNum The price of the item, retrieved from the ItemDex
    * @param mod The modifier of the item, retrieved from the ItemDex
    */
    public DefenceItem(String type, String name, int idNum, int priceNum, double mod) {
        super(type, name, idNum, priceNum, mod);
      }

    /**
    * Allows a pokemon to use a defence item
    * @param p The pokemon the defence item's effect will be applied to
    */
    public void useItem(Pokemon p) {
      p.changeDefStat(this.getModifier()); //Multiplies the pokemon's defence stat by the item's modifier
    }
}
