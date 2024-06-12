/**
* This class makes it so the user can interact with everything 
* in the Pokemon game
*/
import java.io.*;
import java.util.*;
public class PokemonRunner {
   public static void main (String [] args){
      
      // Declare Scanner
      Scanner sc = new Scanner (System.in);
      
      // Create Dex Objects (databases)
      LocationDex lD = new LocationDex ();
      PokemonDex pD = new PokemonDex ();
      ItemDex iD = new ItemDex ();
      MoveDex mD = new MoveDex ();
      UserDatabase uD = new UserDatabase ();
      
      // Read in text files
      lD.readLocations("LocationList.txt");
      iD.readItems("ItemList.txt");
      mD.readMoves("MoveList.txt");
      pD.readPokemon("PokemonList.txt");
      uD.readNPCs("NPCList.txt");
      uD.readUsers("UserList.txt");
      
      // Create central dex/database
      Pokedex gameDatabase = new Pokedex (iD, pD, lD, mD);
      
      try {
         int select1 = -1;
         int select2;
         int select3;
         while (select1 != 0) {
            System.out.println("Welcome to the world of Pokemon! Please select what you would like to do.");
            System.out.println("1) Go to the Pokedex for information.");
            System.out.println("2) Go to the UserDatabase to select an account to play as.");
            System.out.println("0) Exit.");
            select1 = sc.nextInt();
            System.out.println();
         
            while (select1 < 0 || select1 > 2) {
               System.out.print("That is not a possible option. Try again: ");
               select1 = sc.nextInt();
            }
            
            System.out.println();
            
            if (select1 == 1) {
               System.out.println("Enter the number corresponding to what you want to search for: ");
               System.out.println("1) Add an object to the database.");
               System.out.println("2) Search for a Pokemon.");
               System.out.println("3) Search for an Item.");
               System.out.println("4) Search for a move.");
               System.out.println("5) Search for a Location.");
               System.out.println("6) Sort the Pokemon database by different factors.");
               System.out.println("7) Save the current database for future uses.");
               System.out.println("0) Exit.");
               select2 = sc.nextInt();
               System.out.println();
               
               while (select2 < 0 || select2 > 7) {
                  System.out.print("That is not a possible option. Try again: ");
                  select2 = sc.nextInt();
               }
               
               System.out.println();

               if(select2 == 1){

                  System.out.println("Enter the number corresponding to what object you want to add: ");
                  System.out.println("1) Add a Pokemon.");
                  System.out.println("2) Add an Item.");
                  System.out.println("3) Add a Location.");
                  System.out.println("4) Add a Move.");
                  System.out.println("0) Exit.");
                  select3 = sc.nextInt();
                  System.out.println();

                  if(select3 == 1){
                     System.out.println("Enter the name of the Pokemon");
                     String name = sc.nextLine();
                     System.out.println("Enter the type of the Pokemon: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                     int type = sc.nextInt();
                     while (type < 0 || type > 8) {
                        System.out.print("That is not a possible option. Enter a number from 0 to 8: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                        type = sc.nextInt();
                     }
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                     System.out.println("Enter the ");
                  

               
               
            }
            
            else {
               System.out.println("Enter the number corresponding to what you want to search for: ");
               System.out.println("1) Add an account.");
               System.out.println("2) Delete an account.");
               System.out.println("3) Play in an account");
               System.out.println("4) Search for a Person.");
               System.out.println("0) Exit.");
               select2 = sc.nextInt();
               System.out.println();
               
               while (select2 < 0 || select2 > 4) {
                  System.out.print("That is not a possible option. Try again: ");
                  select2 = sc.nextInt();
               }
               
               System.out.println();
               
               if (select2 == 1) {
                  // Filter
                  sc.nextLine();
                  
                  // Create variables
                  String name;
                  int age;
                  
                  // Ask for input
                  System.out.print("Enter the name of the account: ");
                  name = sc.nextLine();
                  System.out.print("Enter your age: ");
                  age = sc.nextInt();
                  
                  // Call addUser method and output error message if errors occurs
                  if (addUser(name, age)) {
                     System.out.println("User has been successfully added.");
                  } else {
                     System.out.println("Too many users. Please remove a user before adding another user.");
                  }
               
               
               if (select2 == 2) {
                  // Filter
                  sc.nextLine();
                  
                  // Create variables
                  String name;
                  
                  // Ask for input
                  System.out.print("Enter the name of the account you want removed: ");
                  name = sc.nextLine();
                  
                  // Call removeUser method and output error message if errors occurs
                  if (removeUser(name)) {
                     System.out.println("User has been successfully removed.");
                  } else {
                     System.out.println("User not found.");
                  }
               }
               
               if (select2 == 3) {
                  int account, select3;
                  int numUsers = uD.getNumUsers();
                  System.out.println("Enter account: ");
                  for (int i = 0; i < numUsers; i++) {
                     System.out.println((i+1) + ") " + uD.getUserList()[i].getName());
                  }
                  account = sc.nextInt();
                  
                  while (account < 1 || account > numUsers) {
                     System.out.print("That is not a possible option. Try again: ");
                     account = sc.nextInt();
                  }
                  
                  System.out.println("Select an option:");
                  System.out.println("1) Catch a Pokemon.");
                  System.out.println("2) Release a Pokemon.");
                  System.out.println("3) Buy an item.");
                  System.out.println("4) Give an item to a Pokemon");
                  System.out.println("5) Move to a new Location.");
                  System.out.println("6) Heal your team");
                  System.out.println("7) Display a person's team.");
                  System.out.println("8) Battle someone.");
                  System.out.println("0) Exit.");
               }
            }
         }
      } catch (InputMismatchException ime) {
         System.out.println("Please provide proper input.");
      }
   }
}
