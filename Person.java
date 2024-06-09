/**
* Creates accounts that users can use and creates characters in the game users can battle
*/
public class Person {
   
   /**
   * Name of the person
   */
   private String name;
   
   /**
   * Age of the person
   */
   private int age;
   
   /**
   * ID of the person
   */
   private int personID; 
   
   /**
   * The maximum number of Pokemon each person can have in their team
   */
   private static int maxPokemon; 
   
   /**
   * The current number of Pokemon each person has in their team
   */
   private int numPokemon;
   
   /**
   * The list of all the Pokemon the person has in their team
   */
   private Pokemon[] teamList;
   
   /**
   * The current location the user is in
   */
   private Location currentLocation;
   
   /**
   * The database of the game each person can refer to
   */
   private static Pokedex pokedexReference
   
   /**
   * This method is a constructor that initializes the fields of
   * the person when given its name, age, and ID
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public Person (String n, int a, int i) {
      name = n;
      age = a
      personID = i;
      numPokemon = 0;
      currentLocation = pokedexReference.getLocationDex.getLocationList()[0];
   }
   
   /**
   * This method is an accessor that allows other classes to access
   * the name of the Person
   * @return Name of the Person
   */
   public String getName () {
      return name;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the age of the Person
   * @return Age of the Person
   */
   public int getAge () {
      return age;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the ID of the Person
   * @return ID of the Person
   */
   public int getPersonID () {
      return personID;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the maximum number of Pokemon a player can have
   * @return The maximum number of Pokemon a player can have
   */
   public int getMaxPokemon () {
      return maxPokemon;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current number of Pokemon a player has
   * @return The current number of Pokemon a player has
   */
   public int getNumPokemon () {
      return numPokemon;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of Pokemon is the person's team
   * @return The current list of Pokemon in the person's team
   */
   public Pokemon[] getTeamList () {
      return teamList;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current location the person is in
   * @return The current location the person is in
   */
   public Location getCurrentLocation () {
      return currentLocation;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the Pokedex
   * @return The Pokedex object each person has
   */
   public int getPokedexReference () {
      return pokedexReference;
   }

   /**
    * This method gives an item whose name is passed through
    * the parameter to a Pokemon whose name is passed through
    * the parameter.
    * @param poke The name of the Pokemon
    * @param it The name of the Item
    * @return True if the item was successfully given and false otherwise
    */
   public boolean giveItem (String poke, String it) {
      for ()
      Pokemon p_temp = this.searchPokemonByNameInTeam(poke);
      if (this instanceof NPC) {
         Item i_temp = pokedexReference.getItemDex.searchItemByName(it);
         p_temp.setItemHolding(i_temp);
      } else {
         Item i_temp = this.searchItemByNameInTeam(it);
         if (i_temp == null) {
            return false;
         } else {
            p_temp.setItemHolding(i_temp);
         }
      }
   }
}
