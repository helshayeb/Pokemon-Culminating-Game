package PersonHierarchy;

import java.util.*;
import PersonHierarchy.*;
import ConditionHierarchy.*;
import ItemHierarchy.*;
import LocationHierarchy.*;
import MoveHierarchy.*;
import Pokemon.*;
import PokeDex.*;

/**
* Creates accounts that users can use to play the game
*/
public class User extends Person {


   /**
   * Amount of money the user has
   */
   private int money;

   /**
   * Current number of items a user has in their inventory
   */
   private int numItems;

   /**
   * A list of all the items the User has
   */
   private Item[] inventory;

   /**
   * This method is a constructor that initializes the fields of
   * the user when given its name, age, ID, and 
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   */
   public User (String n, int a, int i) {
      super(n, a, i);
      money = 0;
      numItems = 0;
   }

   /**
   * This method is a constructor that initializes the fields of
   * the person when given all the non-static fields
   * @param n The name of the person the user inputted
   * @param a The age of the person the user inputted
   * @param i The ID of the person, retrieved from the user database
   * @param numP The number of Pokemon in the user's team
   * @param team The Pokemon objects in the user's team
   * @param loc The user's current location
   * @param m How much money the user has
   * @param numI The number of Items in the user's inventory
   * @param team The Item objects in the user's inventory
   */
   public User (String n, int a, int i, int numP, Pokemon[] team, Location loc, int m, int numI, Item[] inv) {
      super(n, a, i, numP, team, loc);
      money = m;
      numItems = numI;
      inventory = inv;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the amount of money the user has
   * @return Amount of money the user has
   */
   public int getMoney () {
      return money;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the current number of items the user has
   * @return The current number of items the user has
   */
   public int getNumItems () {
      return numItems;
   }

   /**
   * This method is an accessor that allows other classes to access
   * the list of items the user has
   * @return The list of items the user has
   */
   public Item[] getInventory () {
      return inventory;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the amount of money the user has
   * @param m New amount of money the user has
   */
   public void setMoney (int m) {
      money = m;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the current number of items the user has
   * @param nI The new number of items the user has
   */
   public void setNumItems (int nI) {
      numItems = nI;
   }

   /**
   * This method is a mutator that allows other classes to change
   * the list of items the user has
   * @return The new list of items the user has
   */
   public void setInventory (Item[] inv) {
      inventory = inv;
   }

   /**
   * Simulates catching a Pokemon and adding it to the User’s team
   * @param Poke Pokemon object that user wants to catch
   * @return True if the catch was successful and false if Pokemon 
   * is already in the team or numPokemon is equal to MAX_POKEMON
   */
   public boolean catchPokemon (Pokemon poke) {
      int numPoke = this.getNumPokemon();
      boolean inTeam = false;
      for (int i = 0; i < numPoke; i++) {
         if (poke == this.getTeamList()[i]) {
            inTeam = true;
         }
      }
      if (poke.getFoundIn().equals(this.getCurrentLocation()) && numPoke < getMaxPokemon() && !(inTeam)) {
         this.newPokemon(poke);
         return true;
      } else {
         return false;
      }
   }

   /**
   * Simulates buying an item and adding it to the user’s inventory
   * @param it Item object that user wants to add to their inventory
   * @return True if the item was added successfully and false if 
   * insufficient money, the current location does not have a pokestop,
   * or numItems is equal to maxItems
   */
   public boolean buyItem (Item it) {
      Location curLoc = this.getCurrentLocation();
      if (money > it.getPrice() && numItems < PokeDex.MAX_SIZE && curLoc instanceof City && ((City)curLoc).getHasPokeStop()) {
         if (it instanceof AttackItem) {
            inventory[numItems] = new AttackItem (it.getItemTypeName(), it.getItemName(), it.getId(), it.getPrice(), it.getModifier());
         } else if (it instanceof DefenceItem) {
            inventory[numItems] = new DefenceItem (it.getItemTypeName(), it.getItemName(), it.getId(), it.getPrice(), it.getModifier());
         } else if (it instanceof HealthItem) {
            inventory[numItems] = new HealthItem (it.getItemTypeName(), it.getItemName(), it.getId(), it.getPrice(), it.getModifier());
         } else {
            inventory[numItems] = new SpeedItem (it.getItemTypeName(), it.getItemName(), it.getId(), it.getPrice(), it.getModifier());
         }
         numItems++;
         money -= it.getPrice();
         return true;
      } else {
         return false;
      }
   }

   /**
   * Simulates letting go of a Pokemon into the wild
   * @param it Item object that user wants to add to their inventory
   * @return True if the Pokemon was successfully released and false if 
   * Pokemon is not found in the team and the team has at no Pokemon
   */
   public boolean releasePokemon (Pokemon poke) {
      int numPoke = this.getNumPokemon(); 
      Pokemon[] team = this.getTeamList();
      if (numPoke <= 0) {
         return false;
      } else {
         int index = -1;
         for (int i = 0; i < numPoke; i++) {
            if (poke == team[i]) {
               index = i;
            }
         }
         if (index == -1) {
            return false;
         } else {
            for (int i = index; i+1 < numPoke; i++) {
               team[i] = team[i+1];
            }
            this.setNumPokemon(numPoke - 1);
            return true;
         }
      }
   }

   /**
   * A method that continuously has Pokemon keep attacking each other
   * in a 1 on 1 format until one player runs out of Pokemon.
   * @param other Person that the user is battling
   * @return Person object of the winner of the battle. Returns null if
   * an incorrect input was taken in
   */
   public Person battleTrainer (Person other) {
      int chal_num_poke = this.getNumPokemon();
      int def_num_poke = other.getNumPokemon();
      Pokemon[] chal_team = this.getTeamList();
      Pokemon[] def_team = other.getTeamList();
      int challenger_pokemon, defender_pokemon, challenger_pokemon_left, defender_pokemon_left;
      Scanner sc = new Scanner (System.in);
      Pokemon winner;
      Person p_winner = null;
   
      challenger_pokemon_left = chal_num_poke;
      defender_pokemon_left = def_num_poke;
   
      for (int i = 0; i < chal_num_poke; i++) {
         if (chal_team[i].getCurrentHP() == 0) {
            challenger_pokemon_left--;
         }
      }
   
      for (int i = 0; i < def_num_poke; i++) {
         if (def_team[i].getCurrentHP() == 0) {
            defender_pokemon_left--;
         }
      }
      if (challenger_pokemon_left == 0 && defender_pokemon_left == 0) {
         System.out.println("Neither team has enough Pokemon to battle");
         return null;
      }
      else if (challenger_pokemon_left == 0) {
         System.out.println("Challenger does not have enough Pokemon to battle");
         p_winner = other;
         return p_winner;
      }
      else if (defender_pokemon_left == 0) {
         System.out.println("Defender does not have enough Pokemon to battle");
         p_winner = this;
         return p_winner;
      }
      else {
      try {
         System.out.println("Enter a pokemon (1-" + chal_num_poke + "): ");
         challenger_pokemon = sc.nextInt() - 1;
      
         while (chal_team[challenger_pokemon].getCurrentHP() == 0 || challenger_pokemon < 0 || challenger_pokemon > chal_num_poke - 1) {
            if (chal_team[challenger_pokemon].getCurrentHP() == 0 ) {
               System.out.print("That Pokemon is dead. Please select another: ");
            }
            else {
               System.out.print("That was not in the specified range. Please try another number: ");
            }
            challenger_pokemon = sc.nextInt() - 1;
            System.out.println();
         }
         
         defender_pokemon = ((int)Math.random() * (def_num_poke));
      
         while (chal_team[defender_pokemon].getCurrentHP() == 0) {
            defender_pokemon = ((int)Math.random() * (def_num_poke));
         }
         
         winner = this.arena(chal_team[challenger_pokemon], def_team[defender_pokemon]);
      
         while (challenger_pokemon_left > 0 && defender_pokemon_left > 0) {
            if (winner == chal_team[challenger_pokemon]) {
               defender_pokemon_left--;
               if (defender_pokemon_left > 0) {
                  defender_pokemon = ((int)Math.random() * (def_num_poke));
                  while (def_team[defender_pokemon].getCurrentHP() == 0) {
                     defender_pokemon = ((int)Math.random() * (def_num_poke));
                  }
                  winner = this.arena(chal_team[challenger_pokemon], def_team[defender_pokemon]);
               }
            } 
            else {
               challenger_pokemon_left--;
               if (challenger_pokemon_left > 0) {
                  System.out.println("Enter a pokemon (1-" + chal_num_poke + "): ");
                  challenger_pokemon = sc.nextInt() - 1;
                  while (chal_team[challenger_pokemon].getCurrentHP() == 0 || challenger_pokemon < 0 || challenger_pokemon > chal_num_poke - 1) {
                     if (chal_team[challenger_pokemon].getCurrentHP() == 0 ) {
                        System.out.print("That Pokemon is dead. Please select another: ");
                     }
                     else {
                        System.out.print("That was not in the specified range. Please try another number: ");
                     }
                     challenger_pokemon = sc.nextInt() - 1;
                     System.out.println();
                  }
                  winner = this.arena(chal_team[challenger_pokemon], def_team[defender_pokemon]);
               }
            }
         
            for (int i = 0; i < chal_num_poke; i++) {
               this.resetPokemon(chal_team[i].getID());
            }
         
            for (int i = 0; i < def_num_poke; i++) {
               other.resetPokemon(def_team[i].getID());
               other.moveTo(other.getPokedexReference().getLocationDex().getLocList()[11]);
               other.healTeam();
            }
         
            if (challenger_pokemon_left == 0) {
               p_winner = other;
            } else {
               p_winner = this;
            }
         }
         return p_winner;
      }
      catch (InputMismatchException ime) {
         for (int i = 0; i < chal_num_poke; i++) {
            this.resetPokemon(def_team[i].getID());
            this.moveTo(this.getPokedexReference().getLocationDex().getLocList()[11]);
            this.healTeam();
         }
      
         for (int i = 0; i < def_num_poke; i++) {
            other.resetPokemon(def_team[i].getID());
            other.moveTo(other.getPokedexReference().getLocationDex().getLocList()[11]);
            other.healTeam();
         }
      
         return null;
      }
      }
   }

   /** 
   * A method that enacts the 1 on 1 between two Pokemon (taken in 
   * through the parameter) in a battle
   * @param challenger Pokemon object of the user who initiated the battle
   * @param defender Pokemon object of the user who was challenged
   * @return Pokemon object of the Pokemon that is left standing
   */
   public Pokemon arena (Pokemon challenger, Pokemon defender) {
      Condition cCondition = challenger.getCurrentCondition();
      Condition dCondition =  defender.getCurrentCondition();
      Pokemon winner = null;
      while (challenger.getCurrentHP() > 0 && defender.getCurrentHP() > 0) {
         System.out.println(challenger.getName() + " has " + challenger.getCurrentHP() + " HP.");
         System.out.println(defender.getName() + " has " + defender.getCurrentHP() + " HP.");
         if (cCondition != null) {
            challenger.applyCondition();
         }
      
         if (dCondition != null) {
            defender.applyCondition();
         }
      
         if (challenger.getCurrentHP() == 0) {
            winner = defender;
         } 
         else if (defender.getCurrentHP() == 0) {
            winner = challenger;
         } 
         else {
            if (challenger.getSpeedStat() > defender.getSpeedStat()) {
               this.userTurn(challenger, defender);
               if (challenger.getCurrentHP() <= 0) {
                  winner = defender;
               } 
               else if (challenger.getCurrentHP() <= 0) {
                  winner = challenger;  
               } 
               else {
                  System.out.println(challenger.getName() + " has " + challenger.getCurrentHP() + " HP.");
                  System.out.println(defender.getName() + " has " + defender.getCurrentHP() + " HP.");
                  this.computerTurn(defender, challenger);
                  if (challenger.getCurrentHP() <= 0) {
                     winner = defender;
                  } 
                  else if (defender.getCurrentHP() <= 0) {
                     winner = challenger; 
                  }
               }
            } else {
               this.computerTurn(defender, challenger);
               if (challenger.getCurrentHP() <= 0) {
                  winner = defender;
               } 
               else if (defender.getCurrentHP() <= 0) {
                  winner = challenger; 
               } else {
                  System.out.println(challenger.getName() + " has " + challenger.getCurrentHP() + " HP.");
                  System.out.println(defender.getName() + " has " + defender.getCurrentHP() + " HP.");
                  this.userTurn(challenger, defender);
                  if (challenger.getCurrentHP() <= 0) {
                     winner = defender;
                  } 
                  else if (defender.getCurrentHP() <= 0) {
                     winner = challenger;  
                  } 
               }
            }
         }
      }
      return winner;
   }

   /** 
   * A method that enacts the user who initiated the battle’s turn
   * @param challenger Pokemon object of the user who initiated the battle
   * @param defender Pokemon object of the user who was challenged
   */
   public void userTurn (Pokemon challenger, Pokemon defender) {
      Scanner sc = new Scanner (System.in);
      int select;
      try {
         System.out.println("Choose an option: ");
         System.out.println("1) " + challenger.getMoveList()[0].getMoveName());
         System.out.println("2) " + challenger.getMoveList()[1].getMoveName());
         System.out.println("3) " + challenger.getMoveList()[2].getMoveName());
         System.out.println("4) " + challenger.getMoveList()[3].getMoveName());
         System.out.println("5) Use Item");
         select = sc.nextInt();
      
         while (select < 1 || select > 5) {
            System.out.print("That is not an option. Try again: ");
            select = sc.nextInt();
         }
      
         switch (select) {
            case 1:
               challenger.attack(defender, challenger.getMoveList()[0]);
               break;
            case 2:
               challenger.attack(defender, challenger.getMoveList()[1]);
               break;
            case 3:
               challenger.attack(defender, challenger.getMoveList()[2]);
               break;
            case 4:
               challenger.attack(defender, challenger.getMoveList()[3]);
               break;
            case 5:
               if (challenger.getItemHolding() == null) {
                  System.out.println("There is no item. Try again.");
                  this.userTurn(challenger, defender);
               } else {
                  challenger.consumeItem(challenger.getItemHolding());
               }
               break;
            default:
               System.out.print("Error");
         }
      } catch (InputMismatchException ime) {
         System.out.println("Please provide proper input.");
         this.userTurn(challenger, defender);
      }
   }

   /** 
   * A method that enacts the turn of the Person who was challenged 
   * @param challenger Pokemon object of the user who was challenged 
   * @param defender Pokemon object of the user who initiated the battle
   */
   public void computerTurn (Pokemon attacker, Pokemon defender) {
      int select;
      select = ((int) (Math.random() * (5) + 1));
      switch (select) {
         case 1:
            System.out.println(attacker.getName() + " used " + attacker.getMoveList()[0]);
            attacker.attack(defender, attacker.getMoveList()[0]);
            break;
         case 2:
            System.out.println(attacker.getName() + " used " + attacker.getMoveList()[1]);
            attacker.attack(defender, attacker.getMoveList()[1]);
            break;
         case 3:
            System.out.println(attacker.getName() + " used " + attacker.getMoveList()[2]);
            attacker.attack(defender, attacker.getMoveList()[2]);
            break;
         case 4:
            System.out.println(attacker.getName() + " used " + attacker.getMoveList()[3]);
            attacker.attack(defender, attacker.getMoveList()[3]);
            break;
         case 5:
            if (attacker.getItemHolding() == null) {
               System.out.println(attacker.getName() + " used their item.");
               this.computerTurn(attacker, defender);
            }
            else {
               attacker.consumeItem(attacker.getItemHolding());
            }
            break;
         default:
            System.out.print("Error");
      }
   } 

   /**
    * This method returns the Item object with the same 
    * name as the String in the parameter
    * @param name The name of the Item
    * @return The Item object corresponding to the name given, null if not found
    */
   public Item searchItemByNameInTeam(String name) {
      Item i_temp = null;
      for (int i = 0; i < this.getNumPokemon(); i++) {
         if (name.equals(inventory[i].getItemName())){
            i_temp = inventory[i];
         }
      }
      return i_temp;
   }

   /**
   * This method makes it so User objects can be printed
   * @return String of the User object
   */
   public String toString () {
      int numPoke = this.getNumPokemon();
      String s = "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nID: " + this.getPersonID() + "\nNumber of Pokemon: " + numPoke + "\n";
      for (int i = 0; i < numPoke; i++) {
         s += this.getTeamList()[i] + "\n";
      }
      s += "Number of Items: " + numItems + "\n";
      for (int i = 0; i < numItems; i++) {
         s += inventory[i] + "\n\n";
      }
      s += "Current Location: " + this.getCurrentLocation().getName();
      return s;
   }
}
