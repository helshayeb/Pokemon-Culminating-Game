/**
* Creates accounts that users can use to play the game
*/
public class User extends Person {

   /**
   * Amount of money the user has
   */
   private int money;

   /**
    * Mamimum number of items a user can have in their inventory 
    */
    private static int maxItems;

   /**
   * Current number of items a user has in their inventory
   */
   private int numItems;

   /**
   * A list of all the items the User has
   */
   private Item[] inventory;

   /**
   * This method is a constructor that initializes the fields of
   * the user when given its name, age, ID, and 
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public User (String n, int a, int i) {
      super(n, a, i, 0, pokedexReference.getLocationDex.getLocationList()[0]);
      money = 0;
      numItems = 0;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the amount of money the user has
   * @return Amount of money the user has
   */
   public int getMoney () {
      return money;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the maximum number of items the user can have
   * @return The maximum number of items the user can have
   */
   public static int getMaxItems () {
      return maxItems;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current number of items the user has
   * @return The current number of items the user has
   */
   public int getNumItems () {
      return numItems;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of items the user has
   * @return The list of items the user has
   */
   public Item[] getInventory () {
      return inventory;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the amount of money the user has
   * @param m New amount of money the user has
   */
   public void setMoney (int m) {
      money = m;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the maximum number of items the user can have
   * @param m New maximum number of items the user can have
   */
   public static void setMaxItems (int mI) {
      maxItems = mI;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the current number of items the user has
   * @param nI The new number of items the user has
   */
   public void setNumItems (int nI) {
      numItems = nI;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the list of items the user has
   * @return The new list of items the user has
   */
   public void setInventory (Item[] inv) {
      inventory = inv;
   }

   /**
   * Simulates catching a Pokemon and adding it to the User’s team
   * @param Poke Pokemon object that user wants to catch
   * @return True if the catch was successful and false if Pokemon 
   * is already in the team or numPokemon is equal to maxPokemon
   * 
   */
   public boolean catchPokemon (Pokemon poke) {
      if (Poke.getFoundIn().equals(currentLocation) && numPokemon < maxPokemon) {
        this.newPokemon(poke);
        return true;
      } else {
        return false;
      }
   }

   /**
   * Simulates buying an item and adding it to the user’s inventory
   * @param it Item object that user wants to add to their inventory
   * @return True if the item was added successfully and false if 
   * insufficient money, the current location does not have a pokestop,
   * or numItems is equal to maxItems
   */
   public boolean buyItem (Item it) {
      if (money > it.getPrice() && numItems < maxItems && currentLocation instanceof City && ((City) currentLocation).getHasStore()) {
         inventory[numItems] = new Item (it.getItemTypeName(), it.getName(), it.getID(), it.getPrice(), it.getModifier());
         numItems++;
         money -= it.getPrice();
         return true;
      } else {
         return false;
      }
   }

   public boolean releasePokemon (Pokemon poke) {
      
   }


}