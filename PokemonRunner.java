import java.util.Scanner;
import java.io.*;

public class PokemonRunner{
   public static void main( String[] args){
      boolean play = true; boolean goPageTwo= true; boolean goPageThree = true; boolean goPageFour= true;
      System.out.println("Welcome to Pokemons");
      while(play){
         goPageTwo = true;
         int first = crossRoad("Home\n1. PokeDex\n2. User Database", 2);
         if(first == 1){
            while(goPageTwo){
               goPageThree = true;
               int second = crossRoad("1. PokemonDex\n2. LocationDex\n3. ItemDex\n4. MoveDex\n0. Back to Home", 4);
               if (second == 1){
                  while(goPageThree){
                     int third = crossRoad("1. Method1\n2. Method2\n3. Method3\n0. Back",3);
                     if(third == 1){
                     
                     } else if(third == 2){
                        
                     } else if(third == 3){
                     
                     }else if(third == 0){
                        System.out.println("Back\n\n");
                        goPageThree = false;
                     }
                  }
               }else if(second == 2){
                  while(goPageThree){
                     int third = crossRoad("1. Method1\n2. Method2\n3. Method3\n0. Back",3);
                     if(third == 1){
                     
                     } else if(third == 2){
                        
                     } else if(third == 3){
                     
                     }else if(third == 0){
                        System.out.println("Back\n\n");
                        goPageThree = false;
                     }
                  }
               }else if(second == 3){
                  while(goPageThree){
                     int third = crossRoad("1. Method1\n2. Method2\n3. Method3\n0. Back",3);
                     if(third == 1){
                     
                     } else if(third == 2){
                        
                     } else if(third == 3){
                     
                     }else if(third == 0){
                        System.out.println("Back\n\n");
                        goPageThree = false;
                     }
                  }
               }else if(second == 4){
                  while(goPageThree){
                     int third = crossRoad("1. Method1\n2. Method2\n3. Method3\n0. Back",3);
                     if(third == 1){
                     
                     } else if(third == 2){
                        
                     } else if(third == 3){
                     
                     } else if(third == 0){
                        System.out.println("Back\n\n");
                        goPageThree = false;
                     }
                  }
               } else if(second == 0){
                  System.out.println("Back\n\n");
                  goPageTwo = false;
               }
            }
            
         } else if(first == 2){
            while(goPageTwo){
               int second = crossRoad("<User Database>\n1. user1\n2. user2\n3. user3\n0. Back to Home",3);
               if (second == 1){
               
               }else if(second == 2){
               
               }else if(second == 3){
               
               } else if(second == 0){
                  System.out.println("Back\n\n");
                  goPageTwo = false;
               }
            } 
            
         } else if(first == 0){
            play = false;
            System.out.println("");
         }
         
      }
   }
   
   /**
   *
   *
   *
   */
   public static int crossRoad(String options, int optionNum){
      Scanner sc = new Scanner(System.in);
      System.out.println("\n"+ options);
      System.out.print("Choose options: ");
      boolean valid = false;
      try{
         int choice = Integer.parseInt(sc.nextLine());
         if( choice <= optionNum && choice >= 0){
            return choice;
         }else{
            System.out.println("\n****** Try again ******\n");
            return crossRoad(options, optionNum);
         }
      } catch(Exception x){
         System.out.println("\n******Invalid Input, Try again******\n");
         return crossRoad(options, optionNum);
      }
     
   }
}
