package PokeDex;

import Pokemon.*;
import LocationHierarchy.*;
import java.io.*;
import MoveHierarchy.*;

/**
* Creates a PokeDex which can be accessed and used to 
* manipulate Pokemon
*/
public class PokemonDex{

  /**
 	* Amount of Pokemon in the database
	*/
   private int numPokemonData;

  /**
 	* Array of Pokemon
	*/
   private Pokemon[] pokemonList;

  /**
	* This method is a constructor that initializes the fields of
	* the MoveDex class
 	*/
   public PokemonDex () {
      numPokemonData = 0;
   }
  
  /**
  * This method is an accessor that returns the number of pokemon
  * @return numPokemonData the number of pokemon
  */
   public int getNumPokemonData() {
      return numPokemonData;
   }
   
   /**
   * This method is a mutator that changes the number of pokemon
   * @param num The new number of pokemon
   */
   public void setNumPokemonData(int num) {
      numPokemonData = num;
   }

/**
  * This method is an accessor that returns the list of pokemon
  * @return pokemonList the list of pokemon
  */
   public Pokemon[] getPokemonList () {
      return pokemonList;
   }

  /**
 	* This method uses BufferedReader to read in information from a text file given
        * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
   public boolean readPokemon (String fileName, PokeDex pD) {
      try {
         BufferedReader in = new BufferedReader (new FileReader (fileName));
         numPokemonData = Integer.parseInt(in.readLine());
         pokemonList = new Pokemon[numPokemonData];
         String name;
         int type, id;
         double hp, attack, defence, speed;
         Move move1, move2, move3, move4;
         Location foundIn;
         for (int i = 0; i < numPokemonData; i++) {
            System.out.println(i);
            name = in.readLine();
            type = Integer.parseInt(in.readLine());
            id = Integer.parseInt(in.readLine());
            hp = Double.parseDouble(in.readLine());
            attack = Double.parseDouble(in.readLine());
            defence = Double.parseDouble(in.readLine());
            speed = Double.parseDouble(in.readLine());
            move1 = pD.getMoveDex().searchMoveByID(Integer.parseInt(in.readLine()));
            move2 = pD.getMoveDex().searchMoveByID(Integer.parseInt(in.readLine()));
            move3 = pD.getMoveDex().searchMoveByID(Integer.parseInt(in.readLine()));
            move4 = pD.getMoveDex().searchMoveByID(Integer.parseInt(in.readLine()));
            foundIn = pD.getLocationDex().searchLocationByID(Integer.parseInt(in.readLine()));
            in.readLine();
         
            pokemonList[i] = new Pokemon (name, type, id, hp, attack, defence, speed, move1, move2, move3, move4, foundIn);
         }
         in.close();
      }
      catch (IOException iox) {
         System.out.println("Error accessing file");
         return false;
      }
      return true;
   }

  /**
 	* This method uses BufferedWriter to write information from pokemonList to the given
        * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
   public boolean savePokemon (String fileName) {
      try {
         BufferedWriter out = new BufferedWriter (new FileWriter (fileName));
         out.write(numPokemonData);
         for (int i = 0; i < numPokemonData; i++) {
            out.write(pokemonList[i].getName());
            out.write(pokemonList[i].getType());
            out.write(pokemonList[i].getID());
            out.write(String.format("%2.f", pokemonList[i].getMaxHPStat()));
            out.write(String.format("%2.f",pokemonList[i].getAttackStat()));
            out.write(String.format("%2.f",pokemonList[i].getDefenceStat()));
            out.write(String.format("%2.f",pokemonList[i].getSpeedStat()));
            out.write(pokemonList[i].getMoveList()[0].getMoveID());
            out.write(pokemonList[i].getMoveList()[1].getMoveID());
            out.write(pokemonList[i].getMoveList()[2].getMoveID());
            out.write(pokemonList[i].getMoveList()[3].getMoveID());
            out.write(pokemonList[i].getFoundIn().getLocationID());
         }
         out.close();
      }
      catch (IOException iox) {
         System.out.println("Error accessing file");
         return false;
      }
      return true;
   }

  /**
 	* This method uses sequential search to search for a Pokemon given
	* @param name Name of the Pokemon being searched for
	* @return Pokemon if successful, null if not
	*/
   public Pokemon searchPokemonByName (String name) {
      for (int i = 0; i < numPokemonData; i++) {
         if ((pokemonList[i].getName()).equals(name)) {
            return pokemonList[i];
         }
      }
      return null;
   }

  /**
 	* This method is a wrapper method used to search for a Pokemon given
	* @param id ID of the pokemon being searched for
	* @return Pokemon if successful, null if not
	*/
   public Pokemon searchPokemonById (int id) {
   System.out.println(numPokemonData);
      return searchPokemonById (id, numPokemonData-1, 0);
   }

  /**
 	* This method uses recursive binary search to search for a pokemon given
	* @param id ID of the Move being searched
 	* @param top Top bound
 	* @param bot Bottom bound
	* @return Pokemon if successful, null if not
	*/
   public Pokemon searchPokemonById (int id, int top, int bot) {
      int middle = (top + bot) / 2;
      if (top < bot) {

         return null;
      }
      if (pokemonList[middle].getID() == id) {
         return pokemonList[middle];

      } else if (pokemonList[middle].getID() > id) {
         return searchPokemonById(id, middle - 1, bot);

      } else {
         return searchPokemonById(id, top, middle + 1);
      }
   }

  /**
 	* This method uses two sequential search algorithms to search for all pokemon with the given
	* @param location Location of the Pokemon being searched
 	* @param type Type of the pokemon being searched 
	* @return Pokemon[] storing all pokemon in the given location with the given type
	*/
   public Pokemon[] searchPokemonByLocationAndType (String location, int type, LocationDex lD) {
      int count = 0;
      Pokemon list[];
      for (int i = 0; i < numPokemonData; i++) {
         if (pokemonList[i].getFoundIn() == lD.searchLocationByName(location) && pokemonList[i].getType() == type) {
            count ++;
         }
      }
      list = new Pokemon[count];
      count = 0;
      for (int i = 0; i < numPokemonData; i++) {
         if (pokemonList[i].getFoundIn() == lD.searchLocationByName(location) && pokemonList[i].getType() == type) {
            list[count] = pokemonList[i];
            count ++;
         }
      }
      return list;
   }

/**
 	* This method is a wrapper method used to sort a list of Pokemon by their Hp stat
	*/
   public void sortByHpStat () {
      this.sortByHpStat(numPokemonData, false);
   }

  /**
   * This method uses recursive bubble sort to sort a list of pokemon by their HP stat
   * with the
   * @param numChecks The number of checks
   * @param sorted Stores if the program is sorted or not
   */
   public void sortByHpStat (int numChecks, boolean sorted) {
      Pokemon temp;
      if (numChecks > 0 || !sorted)
         sorted = true;
      for (int i = 1; i < numPokemonData - 1; i++) {
         if (pokemonList[i].getMaxHPStat() > pokemonList[i - 1].getMaxHPStat()) {
            sorted = false;
            temp = pokemonList[i];
            pokemonList[i] = pokemonList[i - 1];
            pokemonList[i - 1] = temp;
         }
      }
      this.sortByHpStat(numChecks + 1, sorted);
   }

/**
 	* This method is a wrapper method used to sort a list of Pokemon by their attack stat
	*/
   public void sortByAtkStat () {
      this.sortByAtkStat(1);
   }

  /**
   * This method uses recursive insertion sort to sort a list of pokemon by their attack stat
   * with the
   * @param index The index of the array the sort is on
   */
   public void sortByAtkStat (int index) {
      if (index < numPokemonData) {
         int i = index;
         Pokemon p_save = pokemonList[i];
         double atk_save = pokemonList[i].getAttackStat();
         while (index > 0 && atk_save > pokemonList[i - 1].getAttackStat()) {
            pokemonList[i] = pokemonList[i - 1];
            i--;
         }
         pokemonList[i] = p_save;
         this.sortByAtkStat(index + 1);
      }
   }

/**
 	* This method is a wrapper method used to sort a list of Pokemon by their ID
	*/
   public void sortPokemonByID  () {
      this.sortByAtkStat(0);
   }

/**
   * This method uses recursive selection sort to sort a list of pokemon by their attack stat
   * with the
   * @param index The index of the array the sort is on
   */
   public void sortPokemonByID (int start) {
      if (start < numPokemonData) {
         int biggest = pokemonList[start].getID();
         int index = start;
         int save;
         Pokemon temp;
         for (int i = start; i < numPokemonData; i++) {
            save = pokemonList[i].getID();
            if (save > biggest) {
               biggest = save;
               index = i;
            }
         }
         temp = pokemonList[start];
         pokemonList[start] = pokemonList[index];
         pokemonList[index] = temp;
         this.sortPokemonByID(start + 1);
      }
   }

/**
 	* This method uses recursive bubble sort to sort pokemon by their type, and then their ID
	*/
   public void sortPokemonByTypeAndID  () {
      Pokemon temp;
      boolean sorted = false;
      for (int i = 0; i < numPokemonData-1 && !sorted; i++) {
         sorted = true;
         for (int d = 0; d < numPokemonData-1-i; d++) {
            int next = d+1;
            if (pokemonList[next].getType() < pokemonList[d].getType()) {
               temp = pokemonList[d];
               pokemonList[d] = pokemonList[next];
               pokemonList[next] = temp;
               sorted = false;
            }
            else if (pokemonList[next].getType() == pokemonList[d].getType()) {
               if (pokemonList[next].getID() < pokemonList[d].getID()) {
                  temp = pokemonList[d];
                  pokemonList[d] = pokemonList[next];
                  pokemonList[next] = temp;
                  sorted = false;
               }
            }
         }
      }
   }

/**
 	* This method adds a Pokemon to the list of Pokemon when given
	* @param name Name of the Pokemon 
 	* @param type Type of the Pokemon
  * @param hp HP stat of the Pokemon
  * @param attack Attack stat of the Pokemon
  * @param defence Defence stat of the Pokemon
  * @param speed Speed stat of the Pokemon
  * @param moveName1 Name of the Pokemon's first move
  * @param moveName2 Name of the Pokemon's second move
  * @param moveName3 Name of the Pokemon's third move
  * @param moveName4 Name of the Pokemon's fourth move
  * @param loca Name of the Pokemon's location
	* @return true if successful, false if not
	*/
   public boolean addPokemon (String name, int type, double hp, double attack, double defence, double speed, String moveName1, String moveName2, String moveName3, String moveName4, String loca, PokeDex pD) {
      Move move1 = pD.getMoveDex().searchMoveByName(moveName1);
      Move move2 = pD.getMoveDex().searchMoveByName(moveName2);
      Move move3 = pD.getMoveDex().searchMoveByName(moveName3);
      Move move4 = pD.getMoveDex().searchMoveByName(moveName4);
      Location foundIn = pD.getLocationDex().searchLocationByName(loca);
      pokemonList[numPokemonData] = new Pokemon (name, type, numPokemonData, hp, attack, defence, speed, move1, move2, move3, move4, foundIn);
      return true;
   }
}
