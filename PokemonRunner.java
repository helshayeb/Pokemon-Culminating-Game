
import java.util.*;
import Pokemon.*;
import ItemHierarchy.*;
import LocationHierarchy.*;
import MoveHierarchy.Move;
import PersonHierarchy.Person;
import PokeDex.*;
/**
* This class makes it so the user can interact with everything 
* in the Pokemon game
*/
public class PokemonRunner {
   public static void main (String [] args){
      
      //Declare constants that correspond to the file names of each database
      final String ITEM_FILE = "ItemList.txt";
      final String LOCATION_FILE = "LocationList.txt";
      final String MOVE_FILE = "MoveList.txt";
      final String POKEMON_FILE = "PokemonList.txt";
      final String NPC_FILE = "NPCList.txt";
      final String USER_FILE = "UserList.txt";
      
      // Declare Scanner
      Scanner sc = new Scanner (System.in);
      
      // Create Dex Objects (databases)
      LocationDex lD = new LocationDex ();
      PokemonDex pD = new PokemonDex ();
      ItemDex iD = new ItemDex ();
      MoveDex mD = new MoveDex ();
      UserDatabase uD = new UserDatabase ();
      PokeDex gameDatabase = new PokeDex (iD, pD, lD, mD);
      
      // Read in text files
      lD.readLocations(LOCATION_FILE);
      iD.readItems(ITEM_FILE);
      mD.readMoves(MOVE_FILE);
      pD.readPokemon(POKEMON_FILE);
      uD.readNPCs(NPC_FILE, gameDatabase);
      uD.readUsers(USER_FILE, gameDatabase);
      
      // Create central dex/database
      
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
            
            if (select1 == 1) { // User chooses to go to the Pokedex
               System.out.println("Enter the number corresponding to what you want to do in the Pokedex: ");
               System.out.println("1) Add an object to the database.");
               System.out.println("2) Search for a Pokemon.");
               System.out.println("3) Search for an Item.");
               System.out.println("4) Search for a move.");
               System.out.println("5) Search for a Location.");
               System.out.println("6) Sort the Pokemon database by different factors.");
               System.out.println("7) Save the game for future uses (added data will be lost otherwise).");
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
                  while (select3 < 0 || select3 > 4) {
                     System.out.print("That is not a possible option. Try again: ");
                     select3 = sc.nextInt();
                  }
                  System.out.println();
               
                  if(select3 == 1){ // User chooses to add a Pokemon
                     sc.nextLine();
                     System.out.println("Enter the name of the Pokemon: ");
                     String name = sc.nextLine();
                     
                     System.out.println("Enter the type of the Pokemon: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                     int type = sc.nextInt();
                     while (type < 0 || type > 8) {
                        System.out.print("That is not a possible option. Enter a number from 0 to 8: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                        type = sc.nextInt();
                     }
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
                     String m1 = sc.nextLine();
                     while (mD.searchMoveByName(m1) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m1 = sc.nextLine();
                     }
                     System.out.println("Enter the 2nd move name of the Pokemon: ");
                     String m2 = sc.nextLine();
                     while (mD.searchMoveByName(m2) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m2 = sc.nextLine();
                     }
                     System.out.println("Enter the 3rd move name of the Pokemon: ");
                     String m3 = sc.nextLine();
                     while (mD.searchMoveByName(m3) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m3 = sc.nextLine();
                     }
                     System.out.println("Enter the 4th move name of the Pokemon: ");
                     String m4 = sc.nextLine();
                     while (mD.searchMoveByName(m4) == null) {
                        System.out.print("That is not a possible option. Enter a valid Move name: ");
                        m4 = sc.nextLine();
                     }
                     System.out.println("Enter the name of the Location the Pokemon can be found in: ");
                     String loca = sc.nextLine();
                     while (lD.searchLocationByName(loca) == null) {
                        System.out.print("That is not a possible option. Enter a valid Location name: ");
                        loca = sc.nextLine();
                     }
                  
                     pD.addPokemon(name, type, hps, atk, def, spd, m1, m2, m3, m4, loca);
                  }else if (select3 == 2){ // User chooses to add an Item
                     sc.nextLine();
                     System.out.println("Enter the type of the Item: Attack, Defence, Health, or Speed");
                     String type = sc.nextLine();
                     while (!(type.equalsIgnoreCase("attack") || type.equalsIgnoreCase("defence") || type.equalsIgnoreCase("health") || type.equalsIgnoreCase("speed"))) {
                        System.out.print("That is not a possible option. Enter Attack, Defence, Health, or Speed");
                        type = sc.nextLine();
                     }
                     
                     System.out.println("Enter the name of the Item: ");
                     String name = sc.nextLine();
                  
                     System.out.println("Enter the price of the item: ");
                     int price = sc.nextInt();
                     System.out.println("Enter the modifier: ");
                     double modifier = sc.nextDouble();
                  
                     iD.addItems(type, name, price, modifier);
                  
                  }else if (select3 == 3){ // User chooses to add a Location
                     sc.nextLine();
                     System.out.println("Enter the type of Location you want to add: City or Route");
                     String type = sc.nextLine();
                     while (!(type.equalsIgnoreCase("city") || type.equalsIgnoreCase("Route"))) {
                        System.out.print("That is not a possible option. Enter City or Route");
                        type = sc.nextLine();
                     }
                  
                     if(type.equalsIgnoreCase("city")){
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
                           pkc = false;
                        }else{
                           pkc = true;
                        }
                        System.out.println("Does the city have a Store? (0 for no, 1 for yes)");
                        boolean str;
                        int choice2 = sc.nextInt();
                        while (!(choice2 == 0 || choice2 == 1)) {
                           System.out.print("That is not a possible option. Enter 0 or 1");
                           choice2 = sc.nextInt();
                        }
                        if(choice2 == 0){
                           str = false;
                        }else{
                           str = true;
                        }
                        lD.addCity(type, name, pkc, str);
                     
                     } else{
                        System.out.println("Enter the Location name of the Route: ");
                        String name = sc.nextLine();
                        System.out.println("Enter the number of the Route:");
                        int routeNum = sc.nextInt();
                        System.out.println("How many Pokemon do you want to be found in your Route (0-10)? ");
                        int foundSize = sc.nextInt();
                        while (foundSize < 0 || foundSize > 10) {
                           System.out.print("That is not a possible option. Enter a number from 0 to 10: ");
                           foundSize = sc.nextInt();
                        }
                        System.out.println("Enter the Ids of Pokemon found in the Route");
                        int[] pokeInLoca = new int[10];
                        for(int i = 0; i < foundSize; i++){
                           System.out.println("Enter the ID of Pokemon #" + i+1 + ": ");
                           pokeInLoca[i] = sc.nextInt();
                        }
                        // Remind kelvin to get his program together ffs
                        lD.addRoute(type, name, routeNum, gameDatabase.getLocationDex().getNumLocationsData(), pokeInLoca);

                     }
                     
                  
                  }else if (select3 == 4){ //User chooses to add a Move
                     sc.nextLine();
                     System.out.println("Enter the kind of Move you wish to add: Damage, Status, or Condition");
                     String objectID = sc.nextLine();
                     while (!(objectID.equalsIgnoreCase("damage")) || (objectID.equalsIgnoreCase("Status")) || (objectID.equalsIgnoreCase("Condition"))) {
                        System.out.print("That is not a possible option. Enter Damage, Status, or Condition");
                        objectID = sc.nextLine();
                     }
                     
                     System.out.println("Enter the name of the Move: ");
                     String moveName = sc.nextLine();
                     
                     System.out.println("Enter the type of the Move: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                     int type = sc.nextInt();
                     while (type < 0 || type > 8) {
                        System.out.print("That is not a possible option. Enter a number from 0 to 8: \n0 = Normal \n1 = Flying \n2 = Poison \n3 = Ground \n4 = Fire \n5 = Water \n6 = Grass \n7 = Electric \n8 = Psychic");
                        type = sc.nextInt();
                     }

                     if(objectID.equalsIgnoreCase("damage")){
                        System.out.println("Enter the base power of the move: ");
                        int basePower = sc.nextInt();
                        mD.addDamageMove(moveName, type, basePower);
                     }else if(objectID.equalsIgnoreCase("status")){
                        System.out.println("Enter the HP modifier of the move: ");
                        double hpMod = sc.nextDouble();
                        System.out.println("Enter the attack modifier of the move: ");
                        double atkMod = sc.nextDouble();
                        System.out.println("Enter the defence modifier of the move: ");
                        double defMod = sc.nextDouble();
                        System.out.println("Enter the speed modifier of the move: ");
                        double spdMod = sc.nextDouble();
                        System.out.println("Enter the recipient Pokemon of the Move: 0 (itself) or 1 (opposing Pokemon)");
                        int recipient = sc.nextInt();
                        while (!(recipient == 0 || recipient == 1)) {
                           System.out.print("That is not a possible option. Enter the recipient Pokemon of the Move: 0 (itself) or 1 (opposing Pokemon)");
                           recipient = sc.nextInt();
                        }
                        mD.addStatusMove(moveName, type, hpMod, atkMod, defMod, spdMod, recipient);
                     }else{
                        System.out.println("Enter the ID of the Condition the move will apply: 0 (Burn), 1 (Paralysis), or 2 (Poison)");
                        int conditionAppliedID = sc.nextInt();
                        while (!(conditionAppliedID == 0 || conditionAppliedID == 1 || conditionAppliedID == 2)) {
                           System.out.print("That is not a possible option. Enter the ID of the Condition the move will apply: 0 (Burn), 1 (Paralysis), or 2 (Poison)");
                           conditionAppliedID = sc.nextInt();
                        }
                        mD.addConditionMove(moveName, type, conditionAppliedID);       
                     }
                  }else if(select2 == 2){ // user chooses to search for a Pokemon
                     System.out.println("Enter the number corresponding to how you want to seach for a Pokemon: ");
                     System.out.println("1) The Pokemon's ID.");
                     System.out.println("2) The Pokemon's Name.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 2) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     sc.nextLine();
                     Pokemon result;
                     if(select3 == 1){
                        System.out.println("Enter the Pokemon's ID: ");
                        int id = sc.nextInt();
   
                        result = pD.searchPokemonById(id);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Pokemon: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Pokemon not found");
                        }
                     }else if(select3 == 2){
                        System.out.println("Enter the Pokemon's Name: ");
                        String name = sc.nextLine();
   
                        result = pD.searchPokemonByName(name);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Pokemon: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Pokemon not found");
                        }
                     }
                  }else if (select2 == 3){ // User searches for an Item
                     System.out.println("Enter the number corresponding to how you want to seach for an Item: ");
                     System.out.println("1) The Item's ID.");
                     System.out.println("2) The Item's Name.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 2) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     sc.nextLine();
                     Item result;
                     if(select3 == 1){
                        System.out.println("Enter the Item's ID: ");
                        int id = sc.nextInt();
   
                        result = iD.searchItemById(id);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Item: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Item not found");
                        }
                     }else if(select3 == 2){
                        System.out.println("Enter the Item's Name: ");
                        String name = sc.nextLine();
   
                        result = iD.searchItemByName(name);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Item: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Item not found");
                        }
                     }
                  }else if (select2 == 4){ // User searches for a Move
                     System.out.println("Enter the number corresponding to how you want to seach for a Move: ");
                     System.out.println("1) The Move's ID.");
                     System.out.println("2) The Move's Name.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 2) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     sc.nextLine();
                     Move result;
                     if(select3 == 1){
                        System.out.println("Enter the Move's ID: ");
                        int id = sc.nextInt();
   
                        result = mD.searchMoveByID(id);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Move: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Move not found");
                        }
                     }else if(select3 == 2){
                        System.out.println("Enter the Move's Name: ");
                        String name = sc.nextLine();
   
                        result = mD.searchMoveByName(name);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Move: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Move not found");
                        }
                     }
                  }else if (select2 == 5){ // User searches for a Location
                     System.out.println("Enter the number corresponding to how you want to seach for a Location: ");
                     System.out.println("1) The Location's ID.");
                     System.out.println("2) The Location's Name.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 2) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     sc.nextLine();
                     Location result;
                     if(select3 == 1){
                        System.out.println("Enter the Location's ID: ");
                        int id = sc.nextInt();
   
                        result = lD.searchLocationByID(id);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Location: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Location not found");
                        }
                     }else if(select3 == 2){
                        System.out.println("Enter the Location's Name: ");
                        String name = sc.nextLine();
   
                        result = lD.searchLocationByName(name);
                        if(result != null){
                           System.out.println("Found! Here is the information about that Location: ");
                           System.out.println(result);
                        }else{
                           System.out.println("Location not found");
                        }
                     }
                  }else if(select2 == 6){ // User chooses to sort PokemonDex
                     System.out.println("Enter the number corresponding to how you want to sort the Pokemon database: ");
                     System.out.println("1) Sort by HP stat.");
                     System.out.println("2) Sort by Attack stat.");
                     System.out.println("3) Sort by ID.");
                     System.out.println("4) Sort by Type and ID.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 4) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     if(select3 == 1){
                        pD.sortByHpStat();
                     }else if(select3 == 2){
                        pD.sortByAtkStat();
                     }else if(select3 ==3){
                        pD.sortPokemonByID();
                     }else if(select3 == 4){
                        pD.sortPokemonByTypeAndID();
                     }
                     System.out.println("Done!");
                  }else if(select2 == 7){ // User chooses to save the game
                     System.out.println("Enter the number corresponding to what you want to save: ");
                     System.out.println("1) Save the Item database.");
                     System.out.println("2) Save the Location database.");
                     System.out.println("3) Save the Move database.");
                     System.out.println("4) Save the Pokemon database.");
                     System.out.println("5) Save the entire game.");
                     System.out.println("0) Exit.");
                     select3 = sc.nextInt();
                     while (select3 < 0 || select3 > 5) {
                        System.out.print("That is not a possible option. Try again: ");
                        select3 = sc.nextInt();
                     }
                     if(select3 == 1){
                        iD.saveItems(ITEM_FILE);
                     }else if(select3 == 2){
                        lD.saveLocations(LOCATION_FILE);
                     }else if(select3 ==3){
                        mD.saveMoves(MOVE_FILE);
                     }else if(select3 == 4){
                        pD.savePokemon(POKEMON_FILE);
                     }else if(select3 == 5){
                        iD.saveItems(ITEM_FILE);
                        lD.saveLocations(LOCATION_FILE);
                        mD.saveMoves(MOVE_FILE);
                        pD.savePokemon(POKEMON_FILE);
                     }
                     System.out.println("Done!");
                  }
               }else if(select1 == 2){
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
                     if (uD.addUser(name, age)) {
                        System.out.println("User has been successfully added.");
                     } else {
                        System.out.println("Too many users. Please remove a user before adding another user.");
                     }
                  
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
                     if (uD.removeUser(name)) {
                        System.out.println("User has been successfully removed.");
                     } else {
                        System.out.println("User not found.");
                     }
                  }
               
                  if (select2 == 3) {
                     select3 = -1;
                     while (select3 != 0) {
                        int account;
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
                        select3 = sc.nextInt();
                     
                        while (select3 < 0 || select3 > 8) {
                           System.out.print("That is not a possible option. Try again: ");
                           account = sc.nextInt();
                        }
                     
                        if (select3 == 1) {
                           Pokemon p;
                           String name;
                           sc.nextLine();
                           System.out.println("What Pokemon do you want to catch? ");
                           name = sc.nextLine();
                           p = gameDatabase.getPokemonDex().searchPokemonByName(name);
                        
                           while (p == null) {
                              System.out.print("Pokemon not found. Try again:");
                              name = sc.nextLine();
                              p = gameDatabase.getPokemonDex().searchPokemonByName(name);
                           }
                        
                           if (uD.catchPokemon(account, p)) {
                              System.out.println("Pokemon caught successfully.");
                           } else {
                              System.out.println("Something went wrong. Please check if you fit the following requirements: ");
                              System.out.println("Correct Location");
                              System.out.println("Less than 6 Pokemon in your team");
                              System.out.println("Pokemon is already in your team");
                           }
                        }
                     
                        if (select3 == 2) {
                           Pokemon p;
                           String name;
                           sc.nextLine();
                           System.out.println("What Pokemon do you want to release? ");
                           name = sc.nextLine();
                           p = gameDatabase.getPokemonDex().searchPokemonByName(name);
                        
                           while (p == null) {
                              System.out.print("Pokemon not found. Try again: ");
                              name = sc.nextLine();
                              p = gameDatabase.getPokemonDex().searchPokemonByName(name);
                           }
                        
                           if (uD.releasePokemon(account, p.getName())) {
                              System.out.println("Pokemon successfully released.");
                           } else {
                              System.out.println("Pokemon could not br released. Please check if you fit the following requirements: ");
                              System.out.println("Pokemon is in your team.");
                              System.out.println("You have at least 1 Pokemon in your team.");
                           }
                        }
                     
                        if (select3 == 3) {
                           sc.nextLine();
                           String name;
                           Item i;
                        
                           System.out.print("Enter the name of the item you want to buy: ");
                           name = sc.nextLine();
                           i = gameDatabase.getItemDex().searchItemByName(name);
                        
                           while (i == null) {
                              System.out.print("Item not found. Try again: ");
                              name = sc.nextLine();
                              i = gameDatabase.getItemDex().searchItemByName(name);
                           }
                        
                           if (uD.buyItem(account, i)) {
                              System.out.println("Item bought successfully.");
                           } else {
                              System.out.println("Item was not bought. Please check if you fit the following requirements: ");
                              System.out.println("Enough money");
                              System.out.println("In a city with a PokeStop");
                              System.out.println("Too many items");
                           }
                        }
                     
                        if (select3 == 4) {
                           String p_name, i_name;
                           sc.nextLine();
                           System.out.print("Enter the name of the Pokemon you want to give the item to: ");
                           p_name = sc.nextLine();
                           System.out.print("Enter the name of the Item you are giving to the Pokemon: ");
                           i_name = sc.nextLine();
                        
                           if (uD.giveItem(account, p_name, i_name)) {
                              System.out.println("Item was given successfully.");
                           } else {
                              System.out.println("Item was not given successfully. Please check that the Pokemon and Item are in your team and inventory.");
                           }
                        }
                     
                        if (select3 == 5) {
                           sc.nextLine();
                           String name;
                           Location loc;
                        
                           System.out.print("Enter the name of the location you want to move to: ");
                           name = sc.nextLine();
                           loc = gameDatabase.getLocationDex().searchLocationByName(name);
                        
                           while (loc == null) {
                              System.out.print("Location not found. Try again: ");
                              name = sc.nextLine();
                              loc = gameDatabase.getLocationDex().searchLocationByName(name);
                           }
                        
                           uD.moveTo(account, loc);
                           System.out.print("Moved to new location successfully.");
                        }
                     
                        if (select3 == 6) {
                           if (uD.healTeam(account)) {
                              System.out.print("Team was healed successfully");
                           } else {
                              System.out.print("Team was not healed. Make sure you are in a city with a PokeCentre");
                           }
                        }
                     
                        if (select3 == 7) {
                           sc.nextLine();
                           int personId;
                           String type;
                           System.out.println("Enter the type of person you want to you want to see the team of: ");
                           type = sc.nextLine();
                           System.out.println("Enter the ID of the person: ");
                           personId = sc.nextInt();
                           uD.displayPokemon(personId, type);
                        }
                     
                        if (select3 == 8) {
                           sc.nextLine();
                           String otherName;
                           Person p;
                           System.out.print("Enter the name of the user you want to battle: ");
                           otherName = sc.nextLine();
                           p = uD.battleTrainer(account, otherName);
                           System.out.println(p.getName() + " is the winner!");
                        }
                     }
                  }
                  if (select2 == 4) {
                     System.out.println("Select an option: ");
                     System.out.println("1) Search Person by Name.");
                     System.out.println("2) Search User by ID.");
                     System.out.println("3) Search NPC by ID.");
                     select3 = sc.nextInt();

                     if (select3 == 1) {
                        sc.nextLine();
                        String name;
                        System.out.println("Enter the name of the Person you want to find: ");
                        name = sc.nextLine();
                        System.out.println(uD.searchPersonByName(name));
                     }

                     if (select3 == 2) {
                        int id;
                        System.out.println("Enter the ID of the User you want to find: ");
                        id = sc.nextInt();
                        System.out.println(uD.searchUserById(id));
                     }

                     if (select3 == 3) {
                        int id;
                        System.out.println("Enter the ID of the NPC you want to find: ");
                        id = sc.nextInt();
                        System.out.println(uD.searchNPCById(id));
                     }
                  }
               }
            }
         } 
         System.out.print("See you next time!");
      } 
      catch (InputMismatchException ime) {
         System.out.println("Please provide proper input.");
      }
   }
}
