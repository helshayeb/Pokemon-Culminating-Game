package ItemHierarchy;

import Pokemon.*;
/**
* Creates items that can be held by users and pokemon to affect a pokemon's stats and the outcome of a battle
*/
public abstract class Item {
  
  /**
   * Name of the item
   */
  private String itemName; 
  
  /**
   * ID of the item
   */
  private int id; 
  
  /**
   * Price of item
   */
  private int price; 
  
  /**
   * Scale of the item's effect
   */
  private double modifier; 

  /**
   * Name of the type of item
   */
  private String itemTypeName; 

  /**
   * This method is a constructor that initializes the fields of
   * the item when given its type, name, id, price, and modifier
   * @param type The type of item this item falls under, retrieved from the ItemDex
   * @param name The name of the item, retrieved from the ItemDex
   * @param idNum The ID of the item, retrieved from the ItemDex
   * @param priceNum The price of the item, retrieved from the ItemDex
   * @param mod The modifier of the item, retrieved from the ItemDex
   */
  public Item (String type, String name, int idNum, int priceNum, double mod) {
    itemName = name;
    id = idNum;
    price = priceNum;
    modifier = mod;
  }

  /**
  * This method is an abstract method that allows a pokemon to use an item
  * @param p The pokemon the item's effect will be applied to
  */
  public abstract void useItem (Pokemon p);

  /**
  * This method is a mutator that allows other classes to access the name of the item
  * @return The name of the item
  */
  public String getItemName () {
    return itemName;
  }

  /**
  * This method is a mutator that allows other classes to change the id of the item
  * @param name The name of the item
  */
  public void setItemName (String name) {
    itemName = name;
  }

  /**
  * This method is a mutator that allows other classes to access the id of the item
  * @return The id of the item
  */
  public int getId () {
    return id;
  }
  
  /**
  * This method is a mutator that allows other classes to change the id of the item
  * @param i The id of the item
  */
  public void setId (int i) {
    id = i;
  }

  /**
  * This method is a mutator that allows other classes to access the price of the item
  * @return The price of the item
  */
  public int getPrice () {
    return price;
  }
  
  /**
  * This method is a mutator that allows other classes to change the price of the item
  * @param p The price of the item
  */
  public void setPrice (int p) {
    price = p;
  }

  /**
  * This method is a mutator that allows other classes to access the modifier of the item
  * @return The modifier of the item
  */
  public double getModifier () {
    return modifier;
  }
  
  /**
  * This method is a mutator that allows other classes to change the modifier of the item
  * @param m The modifier of the item
  */
  public void setModifier (double m) {
    modifier = d;
  }

  /**
  * This method is a mutator that allows other classes to access the name of the type of the item
  * @return The name of the type of the item
  */
  public String getItemTypeName () {
    return itemTypeName;
  }
  
  /**
  * This method is a mutator that allows other classes to change the name of the type of the item
  * @param name The name of the type of the item
  */
  public void setItemTypeName (String name) {
    itemTypeName = name;
  }

  /**
  * This method is a toString which prints out all of the item's information
  * @param name The name of the type of the item
  */
  public String toString () {
    return String.format("Item Name: %s%nThis item is a %s%nID: %d%nPrice: %f%nItem's effect: %f%n", itemName, itemTypeName, price, modifier);
  }
  
  
}
