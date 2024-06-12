/**
* A list of all the users and NPCs, making it so users can interact with the game
*/
import java.io.*;
import java.util.*;
public class UserDatabase {

   /**
   * Number of users in the program
   */
   private int numUsers;

   /**
   * Maximum and total number of NPCS in the program
   */
   private int MAX_NPCS = 15;

   /**
   * List of all Users in the program
   */
   private User[] userList;

   /**
   * List of all NPCs in the program
   */
   private NPC[] npcList;

   /**
   * This method is a constrcutor that creates a UserDatabase
   * object with no fields filled in
   */
   public UserDatabase () {
    numUsers = 0;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the number of users in the list
   * @return Number of objects in the userList array
   */
   public int getNumUsers () {
     return numUsers;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the maximum number of NPCs possible the list can contain
   * @return Maximum number of objects possible in the npcList array
   */
   public static int getMaxNpcs () {
     return MAX_NPCS;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of users
   * @return The list of users
   */
   public User[] getUserList () {
     return userList;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of NPCs
   * @return The list of NPCs
   */
   public NPC[] getNpcList () {
     return npcList;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the number of users in the program
   * @param num New number of users in the program
   */
   public void setNumUsers (int num) {
     numUsers = num;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the list of users in the program
   * @param list New list of users in the program
   */
   public void setUserList (User[] list) {
     userList = list;
   }

   /**
   * This method allows the user interacting with the program
   * to create an account (User object) to play in
   * @param name The user's name
   * @param age How old the user is
   * @return True if user was added successfully and false 
   * if there are too many users
   */
   public boolean addUser(String name, int age) {
      if (numUsers < MAX_SIZE) {
         userList[numUsers] = new User (name, age, numUsers);
         numUsers++;
         return true;
      } else {
         return false;
      }
   }

   /**
   * This method allows the user interacting with the program
   * to remove an account (User object) from the user list
   * @param name The user's name
   * @return True if user was removed successfully and false 
   * if there are no users or if the user was not found
   */
   public boolean removeUser(String name) {
      User u = this.searchPersonByName(name);
      if (u != null) {
         for (int i = u; u < numUsers; i++) {
            userList[i] = userList[1+i];
         }
         numUsers--;
         return true;
      } else {
         return false;
      }
   }

   /**
   * This method calls giveItem in People to give the item 
   * to the specified Pokemon if possible
   * @param id The user's ID
   * @param p_name The Pokemon's name
   * @param i_name The Item's name
   * @return True if the item was given successfully and false if
   * the Pokemon or Item was not found
   */
   public boolean addItem (int id, String p_name, String i_name) {
      User u = this.searchPersonByID(id);
      return u.(p_name, i_name,);
   }

   /**
   * This method calls battleTrainer in User to simulate a battle
   * between two People
   * @param id The challenging user's ID
   * @param name The person that was challenged
   * @return The winner of the battle, null if user couldn't be found
   * or if a mistake occurs
   */
   public Person battleTrainer (int id, String name) {
      final int MONEY_FROM_WIN = 500;
      Person winner;
      User u1 = this.searchPersonByID(id);
      Person u2 = this.searchPersonByName(name);
      if (u2 == null) {
         return null;
      } else {
         winner = u1.battleTrainer(u2);
         if (winner == u1) {
            u1.setMoney(u1.getMoney() + MONEY_FROM_WIN);
         }
         return winner;
      }
   }

   /**
   * This method Calls releasePokemon in User to remove a 
   * Pokemon from the user's team
   * @param id The user's ID
   * @param name The Pokemon being released 
   * @return The winner of the battle, null if user couldn't be found
   * or if a mistake occurs
   */
   public boolean releasePokemon (int id, String name) {
      User u = this.searchPersonByID(id);
      Pokemon p = u.searchPokemonByNameInTeam(name);
      if (p == null) {
        return false;
      } else {
        return u.releasePokemon(p);
      }
   }
   
   /**
   * This method calls releasePokemon in User to remove a 
   * Pokemon from the user's team
   * @param id The user's ID
   * @param it The Item object being bought
   * @return True if the item was bought successfully and
   * false if the user does not have enough money, if they
   * reached the max item limit, or if they aren't in a city
   * with a PokeStop
   */
   public boolean buyItem (int id, Item it) {
      User u = this.searchPersonByID(id);
      return u.buyItem(it);
   }

   /**
   * This method calls catchPokemon in User to simulate catching a 
   * Pokemon and adding it to the user's team
   * @param id The user's ID
   * @param it The Pokemon object being caught
   * @return True if the Pokemon was caught successfully
   * and false if the user's team is full or if the Pokemon is 
   * already on the User's team
   */
   public boolean catchPokemon (int id, Pokemon p) {
      User u = this.searchPersonByID(id);
      return u.catchPokemon(P);
   }

   /**
   * This method reads in all the existing users at
   * the start of the program
   * @param fileName Name of the textfile
   * @param pD Pokedex reference for methods
   * @return True the file was read correctly and false otherwise
   */
   public boolean readUsers (String fileName, PokeDex pD) {
      try {
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         numUsers = in.readLine();
         userList = new User[MAX_SIZE]];
         String userName;
         int id, money, age, numPoke, numIt, pokeID, itemID, curLocID;
         Pokemon[] team; 
         Location curLoc;
         for (int i = 0; i < numItemData; i++) {
            in.readLine();
            userName = in.readLine();
            id = Integer.parseInt(in.readLine());
            age = Integer.parseInt(in.readLine());
            money = Integer.parseInt(in.readLine());
            numPoke = Integer.parseInt(in.readLine());
            numIt = Integer.parseInt(in.readLine());
            curLocID = Integer.parseInt(in.readLine());
            
            curLoc = searchLocationById(curLocID);

            team = new Pokemon [Person.getMaxPokemon()];
            for (int j = 0; j < numPoke; j++) {
                pokeID = Integer.parseInt(in.readLine());
                team[j] = pD.searchPokemonById();
            }

            inv = new Item [MAX_SIZE];
            for (int j = 0; j < numIt; j++) {
                itemID = Integer.parseInt(in.readLine());
                inv[j] = pD.searchItemById();
            }

            userList[i] = new User (name, age, i, numPoke, team, curLoc, money, numIt, inv);
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
   * This method reads in all the existing NPCs at
   * the start of the program
   * @param fileName Name of the textfile
   * @param pD Pokedex reference for methods
   * @return True the file was read correctly and false otherwise
   */
   public boolean readNPCs (String fileName, PokeDex pD) {
      try {
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         MAX_NPCS = in.readLine();
         npcList = new User[MAX_SIZE];
         String userName;
         int id, age, numPoke, pokeID, itemID, curLocID;
         Pokemon[] team; 
         Item[] inv;
         Location curLoc;
         for (int i = 0; i < numItemData; i++) {
            in.readLine();
            userName = in.readLine();
            id = Integer.parseInt(in.readLine());
            age = Integer.parseInt(in.readLine());
            numPoke = Integer.parseInt(in.readLine());
            curLocID = Integer.parseInt(in.readLine());

            curLoc = searchLocationById(curLocID);

            team = new Pokemon [Person.getMaxPokemon()];
            for (int j = 0; j < numPoke; j++) {
                pokeID = Integer.parseInt(in.readLine());
                team[j] = pD.searchPokemonById();
            }
            npcList[i] = new NPC (name, age, i, numPoke, team, curLoc);

            inv = new Item [MAX_SIZE];
            for (int j = 0; j < numPoke; j++) {
                itemID = Integer.parseInt(in.readLine());
                npcList[i].giveItem(team[j], itemID);
            }
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
   * This method writes all the existing users to a
   * text file
   * @param fileName Name of the textfile
   * @return True the file was written correctly and false otherwise
   */
   public boolean saveUsers (String fileName) {
    try {
       BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
       out.write(numUsers);
       out.newLine();
       for (int i = 0; i < numUsers; i++) {
        out.newLine();
        out.write(userList[i].getName());
        out.newLine();
        out.write(i + "");
        out.newLine();
        out.write(userList[i].getAge() + "");
        out.newLine();
        out.write(userList[i].getMoney() + "");
        out.newLine();
        out.write(userList[i].getNumPokemon() + "");
        out.newLine();
        out.write(userList[i].getNumItems() + "");
        out.newLine();
        out.write(userList[i].getCurrentLocation().getLocationID() + "");
        out.newLine();
        for (int j = 0; j < getNumPokemon(); j++) {
            out.write(userList[i].getTeamList()[j].getID() + "");
            out.newLine();
        }
        for (int j = 0; j < getNumItems(); j++) {
            out.write(userList[i].getInventory()[j].getId() + "");
            out.newLine();
        }
       }
       out.close();
    } catch (IOException iox) {
        System.out.println("Error accessing file");
        return false;
    }
    return true;
   }

   /**
   * This method calls healTeam in Person and simulates
   * healing the user's team
   * @param id The user's ID
   */
   public void healTeam (int id) {
      User u = this.searchPersonByID(id);
      u.healTeam();
   }

   /**
   * This method calls finds the Person object corresponding 
   * with the
   * @param id The user's ID
   */
   private Person searchPersonByName (String name) {
        int index = -1;
        for (int i = 0; i < numUsers && index == -1; i++) {
            if (name.equals(userList[i].getName())) {
                index = i;
            }
        }
        if (index != -1) {
            return userList[i];
        } else {
            for (int i = 0; i < MAX_NPCS && index == -1; i++) {
                if (name.equals(npcList[i].getName())) {
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        }
        return npcList[i];
   } 

   private Person searchPersonById (int id) {
        int index = -1;
        for (int i = 0; i < numUsers && index == -1; i++) {
            if (id == userList.getID()) {
                index = i;
            }
        }
        if (index != -1) {
            return userList[i];
        } else {
            for (int i = 0; i < MAX_NPCS && index == -1; i++) {
                if (id == npcList.getID()) {
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        }
        return npcList[i];
   } 
}