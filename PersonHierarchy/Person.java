package PersonHierarchy;

import ItemHierarchy.*;
import LocationHierarchy.*;
import Pokemon.*;
import PokeDex.*;

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
   private final static int MAX_POKEMON = 6; 
   
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
   protected static PokeDex pokedexReference;
   
   /**
   * This method is a constructor that initializes the fields of
   * the person when given its name, age, and ID
   * @param n The name of the person the user inputed
   * @param a The age of the person the user inputed
   * @param i The ID of the person, retrieved from the user database
   */
   public Person (String n, int a, int i) {
      name = n;
      age = a;
      personID = i;
      numPokemon = 0;
      currentLocation = pokedexReference.getLocationDex().getLocList()[0];
   }

   /**
   * This method is a constructor that initializes the fields of
   * the person when given all the non-static fields
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   * @param numP The number of Pokemon in the user's team
   * @param team The Pokemon objects in the user's team
   * @param loc The user's current location
   */
   public Person (String n, int a, int i, int numP, Pokemon[] team, Location loc) {
      name = n;
      age = a;
      personID = i;
      numPokemon = numP;
      teamList = team;
      currentLocation = loc;
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
   public static int getMaxPokemon () {
      return MAX_POKEMON;
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
   public static PokeDex getPokedexReference () {
      return pokedexReference;
   }
   
   /**
   * This method is a mutator that allows other classes to change
   * the name of the Person
   * @param n Name of the Person
   */
   public void setName (String n) {
      name = n;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the age of the Person
   * @param a Age of the Person
   */
   public void setAge (int a) {
      age = a;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the ID of the Person
   * @param i ID of the Person
   */
   public void setPersonID (int i) {
      personID = i;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the current number of Pokemon a person has
   * @param n new number of Pokemon a person can has
   */
   public void setNumPokemon (int n) {
      numPokemon = n;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the list of Pokemon in the person's team
   * @param list new list of Pokemon in a person team
   */
   public void setTeamList (Pokemon[] list) {
      teamList = list;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the current Location a person is in
   * @param cL new location of the person
   */
   public void setCurrentLocation (Location cL) {
      currentLocation = cL;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the Pokedex object each person has
   * @param pR new Pokedex object each person will have
   */
   public static void setPokedexReference (PokeDex pR) {
      pokedexReference = pR;
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
      Pokemon p_temp = this.searchPokemonByNameInTeam(poke);
      int numIt = ((User)this).getNumItems();
      Item[] inv = ((User)this).getInventory();
      if (p_temp == null) {
         return false;
      } 
      else {
         if (this instanceof NPC) {
            Item i_temp = pokedexReference.getItemDex().searchItemByName(it);
            p_temp.setItemHolding(i_temp);
            return true;
         } else {
            int index = -1;
            for (int i = 0; i < numIt; i++) {
               if (inv[i].getItemName() == it) {
                  index = i;
               }
            }
            if (index == -1) {
               return false;
            } else {
               Item i_temp = inv[index];
               p_temp.setItemHolding(i_temp);
               for (int i = index; i < numIt; i++) {
                  inv[i] = inv[i+1];
               }
               ((User)this).setNumItems(((User)this).getNumItems() - 1);
               return true;
            }
         }
      }
   }

   /**
    * Adds a Pokemon that is passed in through the parameter
    * to the user’s team
    * @param pokeID The Id of the Pokemon that is being added
    */
   public void newPokemon (Pokemon poke) {
      teamList[numPokemon] = new Pokemon (poke.getName(), poke.getType(), poke.getID(), poke.getMaxHPStat(), poke.getAttackStat(), poke.getDefenceStat(), poke.getSpeedStat(), poke.getMoveList()[0], poke.getMoveList()[1], poke.getMoveList()[2], poke.getMoveList()[3], poke.getFoundIn());
      numPokemon++;
   }

   /**
    * Resets all the stats for the Pokemon whose ID is passed
    * in through the parameter after a battle
    * @param pokeID The Id of the Pokemon that is being reset
    */
   public void resetPokemon (int pokeID) {
      Pokemon p_temp = pokedexReference.getPokemonDex().searchPokemonById(pokeID);
      int index = p_temp.getID(); 
      int save = -1;
      for (int i = 0; i < numPokemon; i++) {
         if (index == teamList[i].getID()) {
            save = i;
         }
      }
      teamList[save] = new Pokemon (p_temp.getName(), p_temp.getType(), p_temp.getID(), p_temp.getMaxHPStat(), p_temp.getAttackStat(), p_temp.getDefenceStat(), p_temp.getSpeedStat(), p_temp.getMoveList()[0], p_temp.getMoveList()[1], p_temp.getMoveList()[2], p_temp.getMoveList()[3], p_temp.getFoundIn());
      teamList[save].changeCurrentHP(-1, 0);
      numPokemon++;
   }

   /**
    * This method heals the person's entire team after a battle
    */
   public boolean healTeam () {
      if (this.currentLocation instanceof City) {
         if (((City)this.currentLocation).getHasPokeCentre()) {
            for (int i = 0; i < numPokemon; i++) {
               teamList[i].changeCurrentHP(1, 0);
            }
            return true;
         } else {
            return false;
         } 
      }
      else {
         return false;
      }
   }

   /**
    * This method prints out a person's entire team
    */
   public void displayPokemon () {
      for (int i = 0; i < numPokemon; i++) {
         System.out.println(teamList[i]);
         System.out.println();
      }
   }

   /**
    * This method returns the Pokemon object with the same 
    * name as the String in the parameter
    * @param name The name of the Pokemon
    * @return The Pokemon object corresponding to the name given, null if not found
    */
   public Pokemon searchPokemonByNameInTeam(String name) {
      Pokemon p_temp = null;
      for (int i = 0; i < numPokemon; i++) {
         if (name.equals(teamList[i].getName())){
            p_temp = teamList[i];
         }
      }
      return p_temp;
   }
}
