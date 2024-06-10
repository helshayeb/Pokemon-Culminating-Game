/**
* Creates accounts that users can use to play the game
*/
import java.util.*;
public class User extends Person {


   /**
   * Amount of money the user has
   */
   private int money;

   /**
    * Mamimum number of items a user can have in their inventory 
    */
    private static int maxItems;

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
      super(n, a, i, 0, pokedexReference.getLocationDex.getLocationList()[0]);
      money = 0;
      numItems = 0;
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
   * the maximum number of items the user can have
   * @return The maximum number of items the user can have
   */
   public static int getMaxItems () {
      return maxItems;
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
   * the maximum number of items the user can have
   * @param m New maximum number of items the user can have
   */
   public static void setMaxItems (int mI) {
      maxItems = mI;
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
   * is already in the team or numPokemon is equal to maxPokemon
   * 
   */
   public boolean catchPokemon (Pokemon poke) {
      if (Poke.getFoundIn().equals(currentLocation) && numPokemon < maxPokemon) {
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
      if (money > it.getPrice() && numItems < maxItems && currentLocation instanceof City && ((City) currentLocation).getHasPokeStop()) {
         inventory[numItems] = new Item (it.getItemTypeName(), it.getName(), it.getID(), it.getPrice(), it.getModifier());
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
      if (numPokemon <= 0) {
         return false;
      } else {
         int index = -1;
         for (int i = 0; i < numPokemon; i++) {
            if (poke.getID() == teamList[i].getId()) {
               index = teamList[i].getId();
            }
         }
         if (index == -1) {
            return false;
         } else {
            for (int i = index; i < numPokemon; i++) {
               teamList[i] = teamList[i+1];
            }
            numPokemon--;
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
      int challenger_pokemon, defender_pokemon, challenger_pokemon_left, defender_pokemon_left;
      Scanner sc = new Scanner (System.in);
      Pokemon dead;

      challenger_pokemon_left = numPokemon;
      defender_pokemon_left = other.numPokemon;

      for (int i = 0; i < numPokemon; i++) {
         if (teamList[i].getCurrentHP() == 0) {
            challenger_pokemon_left--;
         }
      }

      for (int i = 0; i < other.numPokemon; i++) {
         if (other.teamList[i].getCurrentHP() == 0) {
            defender_pokemon_left--;
         }
      }

      try {
         System.out.println("Enter a pokemon (1-" + numPokemon + "): ");
         challenger_pokemon = sc.nextInt() - 1;

         while (teamList[challenger_pokemon].getCurrentHP() == 0 || challenger_pokemon < 0 || challenger_pokemon > numPokemon - 1) {
            if (teamList[challenger_pokemon].getCurrentHP() == 0 ) {
               System.out.print("That Pokemon is dead. Please select another: ");
            }
            else {
               System.out.print("That was not in the specified range. Please try another number: ");
            }
            challenger_pokemon = sc.nextInt() - 1;
            System.out.println();
         }
         
         defender_pokemon = ((int)Math.random() * (other.numPokemon));

         while (teamList[defender_pokemon].getCurrentHP == 0) {
            defender_pokemon = ((int)Math.random() * (other.numPokemon));
         }
         
         winner = this.arena(teamList[challenger_pokemon], other.teamList[defender_pokemon]);

         while (challenger_pokemon_left > 0 && defender_pokemon_left > 0) {
            if (winner = teamList[challenger_pokemon]) {
               defender_pokemon_left--;
               if (defender_pokemon_left > 0) {
                  defender_pokemon = ((int)Math.random() * (other.numPokemon));
                  while (teamList[defender_pokemon].getCurrentHP == 0) {
                     defender_pokemon = ((int)Math.random() * (other.numPokemon));
                  }
                  winner = this.arena(teamList[challenger_pokemon], other.teamList[defender_pokemon]);
               }
            } 
            else {
               challenger_pokemon_left--;
               System.out.println("Enter a pokemon (1-" + numPokemon + "): ");
               challenger_pokemon = sc.nextInt() - 1;

               if (challenger_pokemon_left > 0) {
                  System.out.println("Enter a pokemon (1-" + numPokemon + "): ");
                  challenger_pokemon = sc.nextInt();
                  while (teamList[challenger_pokemon].getCurrentHP() == 0 || challenger_pokemon < 0 || challenger_pokemon > numPokemon - 1) {
                     if (teamList[challenger_pokemon].getCurrentHP() == 0 ) {
                        System.out.print("That Pokemon is dead. Please select another: ");
                     }
                     else {
                        System.out.print("That was not in the specified range. Please try another number: ");
                     }
                     challenger_pokemon = sc.nextInt() - 1;
                     System.out.println();
                  }
                  winner = this.arena(teamList[challenger_pokemon], other.teamList[defender_pokemon]);
               }
            }

            for (int i = 0; i < numPokemon; i++) {
               teamList[i].resetPokemon(teamList[i].getID());
            }

            for (int i = 0; i < other.numPokemon; i++) {
               other.teamList[i].resetPokemon(other.teamList[i].getID());
            }

            if (challenger_pokemon_left == 0) {
               return other;
            } else {
               return this;
            }
         }
      catch (InputMismatchException ime) {
         for (int i = 0; i < numPokemon; i++) {
            teamList[i].resetPokemon(teamList[i].getID());
         }

         for (int i = 0; i < other.numPokemon; i++) {
            other.teamList[i].resetPokemon(other.teamList[i].getID());
         }

         return null;
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
      Pokemon winner;
      while (challenger.getCurrentHP() == 0) {
         if (cCondition != null) {
            cCondition.apply(challenger);
         }

         if (dCondition != null) {
            dCondition.apply(defender);
         }

         if (challenger.getCurrentHP() == 0) {
            return defender;
         } 
         else if (challenger.getCurrentHP() == 0) {
            return challenger;
         } 
         else {
            if (challenger.getSpeedStat() > defender.getSpeedStat()) {
               this.userTurn();
               if (challenger.getCurrentHP() == 0) {
                  return defender;
               } 
               else if (challenger.getCurrentHP() == 0) {
                  return challenger;  
               } 
               else {
                  this.computerTurn();
                  if (challenger.getCurrentHP() == 0) {
                     return defender;
                  } 
                  else if (challenger.getCurrentHP() == 0) {
                     return challenger; 
                  }
               }
            }
         }
         return winner;
      }
   }

}