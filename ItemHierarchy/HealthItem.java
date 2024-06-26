package ItemHierarchy;

import Pokemon.*;

/**
* Class Name: HealthItem
* Author: Hassan Elshayeb
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates health items that can heal pokemon
*/
public class HealthItem extends Item {

/**
* This method is a constructor that initializes the fields of
* the health item when given its type, name, id, price, and modifier
* @param type The type of item this item falls under, retrieved from the ItemDex
* @param name The name of the item, retrieved from the ItemDex
* @param idNum The ID of the item, retrieved from the ItemDex
* @param priceNum The price of the item, retrieved from the ItemDex
* @param mod The modifier of the item, retrieved from the ItemDex
*/
public HealthItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

/**
* Allows a pokemon to use a health item
* @param p The pokemon the health item's effect will be applied to
*/
public void useItem(Pokemon p) {
  if (p.getCurrentHP() + this.getModifier() <= p.getMaxHPStat()) {
    p.changeCurrentHP(0, this.getModifier());
}
  else {
    p.changeCurrentHP(0, this.getModifier()); 
  }
}
}
