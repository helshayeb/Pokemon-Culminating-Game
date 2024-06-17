package PersonHierarchy;

import LocationHierarchy.*;
import Pokemon.Pokemon;

/**
* Class Name: NPC
* Author: Carlos Kau
* Date: June 14th 2024
* School: A. Y. Jackson SS
* A type of Person object that users can battle 
*/
public class NPC extends Person {
   /**
   * This method is a constructor that initializes the fields of
   * the person when given its name, age, and ID
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public NPC (String n, int a, int i) {
      super(n, a, i, 0, null, pokedexReference.getLocationDex().getLocList()[0]);
   }

   /**
   * This method is a constructor that initializes the fields of
   * the person when given all its non-static fields
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public NPC (String n, int a, int i, int numP, Pokemon[] team, Location loc) {
      super(n, a, i, numP, team, loc);
   }

   /**
   * This method makes it so NPC objects can be printed
   * @return String of the NPC object
   */
   public String toString () {
	  int numPoke = this.getNumPokemon();
      String s = "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nID: " + this.getPersonID() + "\nNumber of Pokemon: " + numPoke + "\n";
      for (int i = 0; i < numPoke; i++) {
         s += this.getTeamList()[i] + "\n";
      }
      s += this.getCurrentLocation().getName();
      return s;
   }


}
