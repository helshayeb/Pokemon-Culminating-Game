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
   


}