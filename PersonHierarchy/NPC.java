public class NPC extends Person {
   /**
   * This method is a constructor that initializes the fields of
   * the person when given its name, age, and ID
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public NPC (String n, int a, int i) {
      super(n, a, i, 0, pokedexReference.getLocationDex.getLocationList()[0]);
   }

   /**
   * This method is a constructor that initializes the fields of
   * the person when given all its non-static fields
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public NPC (String n, int a, int i, int numP, Pokemon[] team, Location loc) {
      super(n, a, i, numP, loc);
   }


}