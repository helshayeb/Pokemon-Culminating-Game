package ItemHierarchy;

import Pokemon.*;

/**
* Class Name: SpeedItem
* Author: Hassan Elshayeb
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates speed items that can increase a pokemon's defence stat
*/
public class SpeedItem extends Item {

   /**
    * This method is a constructor that initializes the fields of
    * the speed item when given its type, name, id, price, and modifier
    * @param type The type of item this item falls under, retrieved from the ItemDex
    * @param name The name of the item, retrieved from the ItemDex
    * @param idNum The ID of the item, retrieved from the ItemDex
    * @param priceNum The price of the item, retrieved from the ItemDex
    * @param mod The modifier of the item, retrieved from the ItemDex
    */ 
    public SpeedItem(String type, String name, int idNum, int priceNum, double mod) {
        super(type, name, idNum, priceNum, mod);
      }

     /**
    * Allows a pokemon to use a speed item
    * @param p The pokemon the speed item's effect will be applied to
    */
    public void useItem(Pokemon p) {
      p.changeSpdStat(this.getModifier()); //Multiplies the pokemon's speed stat by the item's modifier
    }
}
