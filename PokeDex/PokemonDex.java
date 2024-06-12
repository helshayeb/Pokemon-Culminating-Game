import java.io.*;

/**
 * Represents a database of Pokémon with various operations such as reading from file, saving to file, searching by name or ID, and searching by location and type.
 */
public class PokemonDex{

  private int numPokemonData; // Stores the number of Pokémon
  private Pokemon[] pokemonList; // Array to store Pokémon

  /**
   * Constructs a PokemonDex object with initial number of Pokémon set to 0.
   */
  public PokemonDex () {
    numPokemonData = 0;
  }

  /**
   * Retrieves the number of Pokémon stored in the PokemonDex.
   * 
   * @return The number of Pokémon.
   */
  public int getNumPokemonData() {
      return numPokemonData;
   }
   
   /**
    * Sets the number of Pokémon in the PokemonDex.
    * 
    * @param num The number of Pokémon to set.
    */
   public void setNumPokemonData(int num) {
      numPokemonData = num;
   }

  /**
   * Retrieves the list of Pokémon stored in the PokemonDex.
   * 
   * @return The array of Pokemon objects.
   */
  public Pokemon[] getPokemonList () {
    return pokemonList;
  }
  
  /**
   * Reads Pokémon data from a file and populates the PokemonDex.
   * 
   * @param fileName The name of the file to read from.
   * @return True if reading operation is successful, false otherwise.
   */
public boolean readPokemon (String fileName) {
    try {
      BufferedReader in = new BufferedReader (new FileReader (fileName));
      numPokemonData = Integer.parseInt(in.readLine()); // Read number of Pokémon
      pokemonList = new pokemonList[numPokemonData]; // Initialize pokemonList array
      String name = in.readLine();
      int type, id;
      double hp, attack, defence, speed;
      int move1, move2, move3, move4;
      int foundIn;

      for (int i = 0; i < numPokemonData; i++) {
        name = in.readLine();
        type = Integer.parseInt(in.readLine());
        id = Integer.parseInt(in.readLine());
        hp = Double.parseDouble(in.readLine());
        attack = Double.parseDouble(in.readLine());
        defence = Double.parseDouble(in.readLine());
        speed = Double.parseDouble(in.readLine());
        move1 = searchMoveByID(Integer.parseInt(in.readLine()));
        move2 = searchMoveByID(Integer.parseInt(in.readLine()));
        move3 = searchMoveByID(Integer.parseInt(in.readLine()));
        move4 = searchMoveByID(Integer.parseInt(in.readLine()));
        foundIn = searchLocationById(Integer.parseInt(in.readLine()));
        
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
   * Saves the Pokémon in the PokemonDex to a file.
   * 
   * @param fileName The name of the file to save to.
   * @return True if saving operation is successful, false otherwise.
   */
  public boolean savePokemon (String fileName) {
    try {
      BufferedWriter out = new BufferedWriter (new FileWriter (fileName));
      out.write(numPokemonData);

      for (int i = 0; i < numPokemonData; i++) {
        out.write(pokemonList[i].getName());
        out.write(pokemonList[i].getType());
        out.write(pokemonList[i].getId());
        out.write(pokemonList[i].getHp());
        out.write(pokemonList[i].getAttack());
        out.write(pokemonList[i].getDefence());
        out.write(pokemonList[i].getSpeed());
        out.write(pokemonList[i].getMoveList()[0].getMoveId());
        out.write(pokemonList[i].getMoveList()[1].getMoveId());
        out.write(pokemonList[i].getMoveList()[2].getMoveId());
        out.write(pokemonList[i].getMoveList()[3].getMoveId());
        out.write(pokemonList[i].getFoundIn().getLocationId();
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
   * Searches for a Pokémon by its name.
   * 
   * @param name The name of the Pokémon to search for.
   * @return The Pokemon object if found, null otherwise.
   */
  public Pokemon searchPokemonByName (String name) {
    for (int i = 0; i < numPokemonData; i++) {
      if ((pokemonList[i].getName()).equals(name)) {
        return pokemonList[i];
      }
    }
  }

  /**
   * Searches for a Pokémon by its ID.
   * 
   * @param id The ID of the Pokémon to search for.
   * @return The Pokemon object if found, null otherwise.
   */
  public Pokemon searchPokemonById (int id) {
   return searchPokemonById (id, numPokemonData-1, 0);
}
  
/**
 * Searches for a Pokémon by its ID within a specified range.
 * 
 * @param id  The ID of the Pokémon to search for.
 * @param top The upper bound index for the search range.
 * @param bot The lower bound index for the search range.
 * @return The Pokemon object if found, null otherwise.
 */
public Pokemon searchPokemonById (int id, int top, int bot) {
   int middle = (top + bot) / 2;
   if (pokemonList[middle] == id) {
      return pokemonList[middle];
   } else if (pokemonList[middle] < id) {
      searchPokemonById(id, middle - 1, bot);
   } else {
      searchPokemonById(id, top, middle + 1);
   }
}

/**
 * Searches for Pokémon by location and type.
 * 
 * @param location The location to search for Pokémon.
 * @param type The type of Pokémon to search for.
 * @return An array of Pokémon found in the specified location and of the specified type.
 */
public Pokemon[] searchPokemonByLocationAndType (String location, int type) {
    int count;
    Pokemon list[];
    for (int i = 0; i < numPokemonData; i++) {
      if (pokemonList[i].getFoundIn() == searchLocationByName(location) && pokemonList[i].getType() == type) {
        count ++;
      }
    }
    list = new list[count];
    count = 0;
    for (int i = 0; i < numPokemonData; i++) {
      if (pokemonList[i].getFoundIn() == searchLocationByName(location) && pokemonList[i].getType() == type) {
        list[count] = pokemonList[i];
        count ++;
      }
    }
    return list;
  }



/**
 * Sorts the Pokémon in the PokemonDex by their maximum HP stat in descending order.
 */
public void sortByHpStat() {
    this.sortByHpStat(numPokemonData, false);
}

/**
 * Sorts the Pokémon in the PokemonDex by their maximum HP stat in descending order.
 * 
 * @param numChecks The number of checks performed during the sorting process.
 * @param sorted    A boolean flag indicating whether the list is already sorted.
 */
public void sortByHpStat(int numChecks, boolean sorted) {
    Pokemon temp;
    if (numChecks > 0 || !sorted) {
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
}

/**
 * Sorts the Pokémon in the PokemonDex by their attack stat in descending order.
 */
public void sortByAtkStat() {
    this.sortByAtkStat(1);
}

/**
 * Sorts the Pokémon in the PokemonDex by their attack stat in descending order.
 * 
 * @param index The starting index for the sorting.
 */
public void sortByAtkStat(int index) {
    if (index < numPokemonData) {
        int i = index;
        Pokemon p_save = pokemonList[i];
        int atk_save = pokemonList[i].getAttackStat();
        while (index > 0 && atk_save > pokemonList[i - 1].getAttackStat()) {
            pokemonList[i] = pokemonList[i - 1];
            i--;
        }
        pokemonList[i] = p_save;
        this.sortByAtkStat(index + 1);
    }
}

/**
 * Sorts the Pokémon in the PokemonDex by their ID in descending order.
 */
public void sortPokemonByID() {
    this.sortByAtkStat(0);
}

/**
 * Sorts the Pokémon in the PokemonDex by their ID in descending order.
 * 
 * @param start The starting index for the sorting.
 */
public void sortPokemonByID(int start) {
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
 * Sorts the Pokémon in the PokemonDex by their type and ID in ascending order.
 */
public void sortPokemonByTypeAndID() {
    Pokemon temp;
    boolean sorted;
    for (int i = 0; i < numPokemonData - 1 && !sorted; i++) {
        sorted = true;
        for (int d = 0; d < numPokemonData - 1 - i; d++) {
            int next = d + 1;
            if (pokemonList[next].getType() < pokemonList[d].getType()) {
                temp = pokemonList[d];
                pokemonList[d] = pokemonList[next];
                pokemonList[next] = temp;
                sorted = false;
            } else if (pokemonList[next].getType() == pokemonList[d].getType()) {
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
 * Adds a new Pokémon to the PokemonDex.
 * 
 * @param name     The name of the Pokémon.
 * @param type     The type of the Pokémon.
 * @param hp       The HP (health points) of the Pokémon.
 * @param attack   The attack stat of the Pokémon.
 * @param defence  The defense stat of the Pokémon.
 * @param speed    The speed stat of the Pokémon.
 * @param moveName1 The name of the first move of the Pokémon.
 * @param moveName2 The name of the second move of the Pokémon.
 * @param moveName3 The name of the third move of the Pokémon.
 * @param moveName4 The name of the fourth move of the Pokémon.
 * @param loca     The location where the Pokémon is found.
 * @return True if addition is successful, false otherwise.
 */
public boolean addPokemon(String name, int type, double hp, double attack, double defence, double speed, String moveName1, String moveName2, String moveName3, String moveName4, String loca) {
    PokeDex pd;
    Move move1 = searchMoveByName(moveName1);
    Move move2 = searchMoveByName(moveName2);
    Move move3 = searchMoveByName(moveName3);
    Move move4 = searchMoveByName(moveName4);
    Location foundIn = searchLocationByName(loca);
    pokemonList[numPokemonData] = new Pokemon(name, type, numPokemonData, hp, attack, defence, speed, move1, move2, move3, move4, foundIn);
    return true;
}
}

  
  

  

  
  

  
