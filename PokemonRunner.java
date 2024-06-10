import java.util.Scanner;
import java.io.*;

public class Main{
   public static void main( String[] args){
      System.out.println("Welcome to Pokemons");
      int first = crossRoad("1. PokeDex\n2. User Database", 2);
      if(first == 1){
         int second = crossRoad("1. PokemonDex\n2. LocationDex\n3. ItemDex\n4. MoveDex", 4);
      } else if(first == 2){
         
      } else if(first == 0){
         
      }
   }
   
   public static int crossRoad(String options, int optionNum){
      Scanner sc = new Scanner(System.in);
      System.out.println(options);
      System.out.print("Choose options: ");
      boolean valid = false;
      try{
         int choice = Integar.parseInt(sc.nextline);
         if( choice <= optionNum && choice >= 0){
            return choice;
         }
      } catch(Exception x){
         System.out.println("Invalid Input, Try again");
         return crossRoad(options, optionNum, exiting);
      }
   }
}
