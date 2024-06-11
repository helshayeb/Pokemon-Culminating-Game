import java.io.*;
public class PokemonDex{

  private int numPokemonData;
  private Pokemon pokemonList[];

  public int getNumPokemonData() {
      return numPokemonData;
   }
   public void setNumPokemonData(int num) {
      numPokemonData = num;
   }
  
public boolean readPokemon (String fileName) {
    try {
      BufferedReader in = new BufferedReader (new FileReader (fileName));
      numPokemonData = in.readLine();
      pokemonList = new pokemonList[numPokemonData];
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

  public Pokemon searchPokemonByName (String name) {
    for (int i = 0; i < numPokemonData; i++) {
      if ((pokemonList[i].getName()).equals(name)) {
        return pokemonList[i];
      }
    }
  }

  public Pokemon searchPokemonById (int id) {
   return searchPokemonById (id, numPokemonData-1, 0);
}
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
}

  

  
  

  
