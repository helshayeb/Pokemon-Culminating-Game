import java.util.Scanner;

public class Main{
   public static void main( String[] args){
      System.out.println("Welcome to Pokemons");
      Scanner sc = new Scanner(System.in);
      boolean pass = false;
      while(!pass){
         System.out.println("1. PokeDex\n2. User Database");
         System.out.print("Choose An Option: ");
         String input = sc.nextLine();
         if(input.equals("1")){
            pass = true;
            System.out.println("uwwwwwwuunnnnn");
         } else if(input.equals("2")){
            pass = true;
            System.out.println("tooooooowwwww");
         } else{
            System.out.println("Invalid Input, Try again");
         }
      }
      
   }
}
