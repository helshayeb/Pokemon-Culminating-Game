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
   * Maximum number of users in the program
   */
   private static final int MAX_USERS = 200;
    
   /**
   * Maximum and total number of NPCS in the program
   */
   private static final int MAX_NPCS = 15;

   /**
   * Maximum and total number of NPCS in the program
   */
   private static final int MAX_NPCS = 15;

   /**
   * List of all Users in the program
   */
   private User[] userList;

   /**
   * List of all NPCs in the program
   */
   private NPC[] npcList;

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
   * the maximum number of users possible the list can contain
   * @return Maximum number of objects possible in the userList array
   */
   public static int getMaxUsers () {
     return MAX_USERS;
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
      if (numUsers < MAX_USERS) {
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
      User u = this.searchUserByID(id);
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
      User u1 = this.searchUserByID(id);
      User u2 = this.searchUserByName(name);
      if (u2 == null) {
         return null;
      } else {
         return u1.battleTrainer(u2);
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
      User u = this.searchUserByID(id);
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
      User u = this.searchUserByID(id);
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
      User u = this.searchUserByID(id);
      return u.catchPokemon(P);
   }

   /**
   * This method reads in all the existing users at
   * the start of the Program
   * @param fileName Name of the textfile
   * @return True the file was read correctly and false otherwise
   */
   public boolean readUsers (String fileName) {
      try {
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         numUsers = in.readLine();
         userList = new User[PokeDex.MAX_SIZE];
         String userName;
         int id, money, numPoke, numIt;
         int[] pokeList = new int [Person.getMaxPokemon()];
         int[] item = new int [PokeDex.MAX_SIZE];
         
         for (int i = 0; i < numUsers; i++) {
            userName = (in.readLine());
            id = (Integer.parseInt(in.readLine()));
            money = (Integer.parseInt(in.readLine()));
            numPoke = (Integer.parseInt(in.readLine()));
            numIt = (Integer.parseInt(in.readLine()));

            for (int i = 0; i < numPoke; i++) {
               pokeList[i] = newPokemon(searchPokemonById(Integer.parseInt(in.readLine())));
            }
            for (int i = 0; i < numIt; i++) {
               item[i] = searchPokemonById(Integer.parseInt(in.readLine()));
            }
         }
         in.close();
         }
      }
      catch (IOException iox) {
         System.out.println("Error accessing file");
         return false;
      }
      return true;
   }

}
