public abstract class Item {
  private String itemName; //name of item
  private int id; //id of item
  private int price; //price of item
  private double modifier; //scale of the items effect, higher modifier means the item will have a greater
  private String itemTypeName; //type of item, determines which subclass the item belongs to
  // constructs the item
  public Item (String type, String name, int idNum, int priceNum, double mod) {
    itemName = name;
    id = idNum;
    price = priceNum;
    modifier = mod;
  }

  //abstract method to apply the item's effects on a pokemon
  public abstract void useItem (Pokemon p);

  //all accessors and mutators
  public String getItemName () {
    return itemName;
  }
  public void setItemName (String name) {
    itemName = name;
  }
  
  public int getId () {
    return id;
  }
  public void setId (int n) {
    id = n;
  }
  
  public int getPrice () {
    return price;
  }
  public void setPrice (int n) {
    price = n;
  }
  
  public double getModifier () {
    return modifier;
  }
  public void setModifier (double d) {
    modifier = d;
  }
  
  public String getItemTypeName () {
    return itemTypeName;
  }
  public void setItemTypeName (String name) {
    itemTypeName = n;
  }
  
}
