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
                     sc.nextLine();
                     System.out.println("Enter the name of the Pokemon: ");
                     String name = sc.nextLine();
                     
                     System.out.println("Enter the type of the Pokemon: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                     int type = sc.nextInt();
                     while (type < 0 || type > 8) {
                        System.out.print("That is not a possible option. Enter a number from 0 to 8: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                        type = sc.nextInt();
                     }
                     //yum yum code so good code so good!! 
                     //i am losing my sanity help
                     System.out.println("Enter the max HP stat of the Pokemon: ");
                     double hps = sc.nextDouble();
                     System.out.println("Enter the attack stat of the Pokemon: ");
                     double atk = sc.nextDouble();
                     System.out.println("Enter the defence stat of the Pokemon: ");
                     double def = sc.nextDouble();
                     System.out.println("Enter the speed stat of the Pokemon: ");
                     double spd = sc.nextDouble();
                     sc.nextLine();
                     System.out.println("Enter the 1st move name of the Pokemon: ");
                     String m1 = sc.nextLine()searchMoveByName(String name)
                     while (mD.searchMoveByName(m1) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m1 = sc.nextLine();
                     }
                     System.out.println("Enter the 2nd move name of the Pokemon: ");
                     String m2 = sc.nextLine()searchMoveByName(String name)
                     while (mD.searchMoveByName(m2) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m2 = sc.nextLine();
                     }
                     System.out.println("Enter the 3rd move name of the Pokemon: ");
                     String m3 = sc.nextLine()searchMoveByName(String name)
                     while (mD.searchMoveByName(m3) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m3 = sc.nextLine();
                     }
                     System.out.println("Enter the 4th move name of the Pokemon: ");
                     String m4 = sc.nextLine()searchMoveByName(String name)
                     while (mD.searchMoveByName(m4) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m4 = sc.nextLine();
                     }
                     System.out.println("Enter the name of the Location the Pokemon can be found in: ");
                     String loca = sc.nextLine();
                     while (searchLocationByName(loca) == null) {
                        System.out.print("That is not a possible option. Enter a valid Location name: ");
                        loca = sc.nextLine();
                     }

                     pD.addPokemon(name, type, hps, atk, def, spd, m1, m2, m3, m4, loca);
                  }else if (select3 == 2){
                     sc.nextLine();
                     System.out.println("Enter the type of the Item: Attack, Defence, Health, or Speed");
                     String type = sc.nextLine();
                     while (!(type.equalsIgnoreCase("attack") || type.equalsIgnoreCase("defence") || type.equalsIgnoreCase("health") || type.equalsIgnoreCase("speed"))) {
                        System.out.print("That is not a possible option. Enter Attack, Defence, Health, or Speed");
                        type = sc.nextInt();
                     }
                     
                     System.out.println("Enter the name of the Item: ");
                     String name = sc.nextLine();

                     System.out.println("Enter the price of the item: ");
                     int price = sc.nextInt();
                     System.out.println("Enter the modifier: ");
                     double modifier = sc.nextDouble();

                     iD.addItems(type, name, price, modifier);
                  }else if (select3 == 3){
                     sc.nextLine();
                     System.out.println("Enter the type of Location you want to add: City or Route");
                     String type = sc.nextLine();
                     while (!(type.equalsIgnoreCase("city") || type.equalsIgnoreCase("Route")) {
                        System.out.print("That is not a possible option. Enter City or Route");
                        type = sc.nextLine();
                     }

                     if(type.equalsIgnoreCase(city)){
                        System.out.println("Enter the name of the City: ");
                        String name = sc.nextLine();
                        System.out.println("Does the city have a Pokecenter? (0 for no, 1 for yes)");
                        boolean pkc;
                        int choice1 = sc.nextInt();
                        while (!(choice1 == 0 || choice1 == 1)) {
                        System.out.print("That is not a possible option. Enter 0 or 1");
                        choice1 = sc.nextInt();
                        }
                        if(choice1 == 0){
                           pkc == false;
                        }else{
                           pkc == true;
                        }
                        System.out.println("Does the city have a Store? (0 for no, 1 for yes)");
                        boolean str;
                        int choice2 = sc.nextInt();
                        while (!(choice2 == 0 || choice2 == 1)) {
                        System.out.print("That is not a possible option. Enter 0 or 1");
                        choice2 = sc.nextInt();
                        }
                        if(choice2 == 0){
                           str == false;
                        }else{
                           str == true;
                        }
                        lD.addCity(type, name, pkc, str);

                     }else{
                        System.out.println("Enter the Location name of the Route: ");
                        String name = sc.nextLine();
                        System.out.println("Enter the number of the Route:");
                        int routeNum = sc.nextInt();
                        System.out.println("Enter the Ids of 6 Pokemon found in the Route");
                        boolean str;
                        int choice2 = sc.nextInt();
                        while (!(choice2 == 0 || choice2 == 1)) {
                        System.out.print("That is not a possible option. Enter 0 or 1");
                        choice2 = sc.nextInt();
                        }
                        if(choice2 == 0){
                           str == false;
                        }else{
                           str == true;
                        }
                        lD.addCity(type, name, pkc, str);
                        
                     System.out.println("Enter the type of the Pokemon: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                     int type = sc.nextInt();
                     while (type < 0 || type > 8) {
                        System.out.print("That is not a possible option. Enter a number from 0 to 8: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                        type = sc.nextInt();
                     }
                     //yum yum code so good code so good!! 
                     //i am losing my sanity help
                     System.out.println("Enter the max HP stat of the Pokemon: ");
                     double hps = sc.nextDouble();
                     System.out.println("Enter the attack stat of the Pokemon: ");
                     double atk = sc.nextDouble();
                     System.out.println("Enter the defence stat of the Pokemon: ");
                     double def = sc.nextDouble();
                     System.out.println("Enter the speed stat of the Pokemon: ");
                     double spd = sc.nextDouble();
                  }

               
               
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
