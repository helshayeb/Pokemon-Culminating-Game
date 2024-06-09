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
   * ID of the person kys
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
   * the person when given its 
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
   
   public
}
