/**
 * Abstract class representing an item with a name, ID, price, modifier, and type name.
 */
public abstract class Item {
  /**
   * The name of the item.
   */
  private String itemName;

  /**
   * The unique identifier for the item.
   */
  private int id;

  /**
   * The price of the item.
   */
  private int price;

  /**
   * The modifier value associated with the item.
   */
  private double modifier;

  /**
   * The type name of the item.
   */
  private String itemTypeName;

  /**
   * Constructs an Item with the specified type, name, ID, price, and modifier.
   *
   * @param type the type name of the item
   * @param name the name of the item
   * @param idNum the ID number of the item
   * @param priceNum the price of the item
   * @param mod the modifier value of the item
   */
  public Item(String type, String name, int idNum, int priceNum, double mod) {
    itemName = name;
    id = idNum;
    price = priceNum;
    modifier = mod;
    itemTypeName = type;
  }

  /**
   * Uses the item on the specified Pokemon.
   *
   * @param p the Pokemon to use the item on
   */
  public abstract void useItem(Pokemon p);

  /**
   * Returns the name of the item.
   *
   * @return the item name
   */
  public String getItemName() {
    return itemName;
  }

  /**
   * Sets the name of the item.
   *
   * @param name the new name of the item
   */
  public void setItemName(String name) {
    itemName = name;
  }

  /**
   * Returns the ID of the item.
   *
   * @return the item ID
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the ID of the item.
   *
   * @param n the new ID of the item
   */
  public void setId(int n) {
    id = n;
  }

  /**
   * Returns the price of the item.
   *
   * @return the item price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Sets the price of the item.
   *
   * @param n the new price of the item
   */
  public void setPrice(int n) {
    price = n;
  }

  /**
   * Returns the modifier of the item.
   *
   * @return the item modifier
   */
  public double getModifier() {
    return modifier;
  }

  /**
   * Sets the modifier of the item.
   *
   * @param d the new modifier of the item
   */
  public void setModifier(double d) {
    modifier = d;
  }

  /**
   * Returns the type name of the item.
   *
   * @return the item type name
   */
  public String getItemTypeName() {
    return itemTypeName;
  }

  /**
   * Sets the type name of the item.
   *
   * @param name the new type name of the item
   */
  public void setItemTypeName(String name) {
    itemTypeName = name;
  }
}
