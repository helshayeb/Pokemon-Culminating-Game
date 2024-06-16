package PokeDex;

import LocationHierarchy.*;
import java.io.*;
import java.util.*;

public class LocationDex {
   /**
   * The number of locations data stored in the LocationDex.
   */
   int numLocationsData;
   /**
   * Maximum size of the locList array.
   */
   int MAX_SIZE = 10;
   /**
   * An array to store Location objects.
   */
   Location[] locList = new Location[PokeDex.MAX_SIZE];
   /**
   * Constructor for LocationDex class.
   * Initializes numLocationsData to 0.
   */
   public LocationDex () {
      numLocationsData = 0;
   }

   /**
   * Accessor method for numLocationsData.
   * @return The number of locations data.
   */
   public int getNumLocationsData() {
      return numLocationsData;
   }

  /**
   * Accessor method for locList.
   * @return The array of Location objects.
   */
   public Location[] getLocList() {
      return locList;
   }
   
   /**
    * Reads location data from a file and populates the locList array.
    * @param fileName The name of the file to read from.
    * @return true if the file was successfully loaded, false otherwise.
    */
   public boolean readLocations(String fileName){
      try{
         BufferedReader br = new BufferedReader(new FileReader(fileName));
         int numLoca = Integer.parseInt(br.readLine());
         for (int i = 0; i < numLoca; i++) {
            br.readLine();
            br.readLine();
            String type = br.readLine().toLowerCase();
            if (type.equals("city") || type.equals("c")) {
               locList[i] = new City(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()),Boolean.parseBoolean(br.readLine()),Boolean.parseBoolean(br.readLine()));
               numLocationsData++;
            } else if(type.equals("route")||type.equals("r")){
               String region = br.readLine();
               String name = br.readLine();
               int id = Integer.parseInt(br.readLine());
               int routeNum = Integer.parseInt(br.readLine());
               int len = Integer.parseInt(br.readLine());
               String[] list = new String[len];
               for (int j = 0; j < len; j++) {
                  list[j] = br.readLine();
               }
               locList[i] = new Route(region, name, id, routeNum, list);
               numLocationsData++;
            } else {
               return false;
            }
         }
         return true;
      } catch(IOException iox){
         System.out.println("File Not Found");
         return false;
      } catch(ArrayIndexOutOfBoundsException aioobx){
         System.out.println("Location is full");
         return false;
      }
   }

   
  /**
   * Wrapper method for searching a location by its ID.
   * @param id The ID of the location to search.
   * @return The Location object if found, otherwise null.
   */
   public Location searchLocationByID(int id){
      int left = 0;
      int right = numLocationsData-1;
      return searchLocationByID(locList, id, left, right);
   }
  /**
   * Method to search for a location by its ID using recursive binary search.
   * @param locList The array of Location objects.
   * @param id The ID of the location to search.
   * @param left The left index for binary search.
   * @param right The right index for binary search.
   * @return The Location object if found, otherwise null.
   */
   public Location searchLocationByID(Location[] locList, int id, int left, int right){
      int mid = left+(right-left)/2;
      if(left>right){
         return null;
      }
      if(locList[mid].getLocationID() == id){
         return locList[mid];
      }else if(locList[mid].getLocationID() > id){
         return searchLocationByID(locList, id, left, mid-1);
      }else{
         return searchLocationByID(locList, id, mid+1, right);
      }
   }
   /**
   * Searches for a location by its name.
   * @param name The name of the location to search.
   * @return The Location object if found, otherwise null.
   */
   public Location searchLocationByName(String name){
      for(int i = 0; i < numLocationsData; i++){
         if(locList[i].getName().equalsIgnoreCase(name)){
            return locList[i];
         }
      }
      return null;
   }
  /**
   * Method to add a city to locList.
   * @param type The type of the city.
   * @param name The name of the city.
   * @param pokeCenter Whether the city has a Pokémon Center.
   * @param store Whether the city has a Poké Mart.
   */
   public void addCity(String type, String name, boolean pokeCenter, boolean store){
      locList[numLocationsData] = new City(type, name, numLocationsData ,pokeCenter, store);
      numLocationsData++;
   }
  /**
   * Method to add a city to locList.
   * @param pokeCenter Whether the city has a Pokémon Center.
   * @param store Whether the city has a Poké Mart.
   */
   public void addCity( boolean pokeCenter, boolean store){
      locList[numLocationsData] = new City(numLocationsData, pokeCenter,store);
      numLocationsData++;
   }
  /**
   * Method to add a route to locList.
   * @param type The type of the route.
   * @param name The name of the route.
   * @param routeNum The route number.
   * @param id The ID of the route.
   * @param pokes An array of Pokémon on the route.
   */
   public void addRoute(String type, String name, int routeNum, int id, String[] pokes){
      if(!duplicateRouteNum(routeNum)){
         locList[numLocationsData] = new Route(type,name,routeNum, numLocationsData,pokes);
         numLocationsData++;
      }
   }
  /**
   * Method to add a route to locList.
   * @param type The type of the route.
   * @param name The name of the route.
   * @param routeNum The route number.
   */
   public void addRoute(String type, String name, int routeNum){
      if(!duplicateRouteNum(routeNum)){
         locList[numLocationsData] = new Route(type, name, routeNum, numLocationsData);
         numLocationsData++;
      }
   }
   /**
   * Checks if there is a duplicate route number.
   * @param rNum The route number to check for duplication.
   * @return true if there is a duplicate, otherwise false.
   */
   private boolean duplicateRouteNum(int rNum){
      for(int i = 0; i < numLocationsData; i++){
         if(locList[i] instanceof Route){
            if(((Route)(locList[i])).getRouteNum() == rNum)
               return true;
         } 
      }
      return false;
   }

    /**
    * Saves location data from locList array to a file.
    * @param fileName The name of the file to save to.
    * @return true if the data was successfully saved, false otherwise.
    */
   public boolean saveLocations(String fileName){
      try{
         File file = new File(fileName);
         file.createNewFile();
         BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
         bw.write(locList.length); /*Number of Location*/
         bw.newLine();
         for (int i = 0; i < locList.length; i++) {
            bw.newLine();
            bw.newLine();
            if(locList[i] instanceof City)/*If it is city or not*/{
               City temp = (City)(locList[i]);
               bw.write("City");
               bw.newLine();
               bw.write(temp.getRegionType());
               bw.newLine();
               bw.write(temp.getName());
               bw.newLine();
               bw.write(temp.getLocationID() + "");
               bw.newLine();
               bw.write(temp.getHasPokeStop() + "");
               bw.newLine();
               bw.write(temp.getHasPokeCentre() + "");
               bw.newLine();
            } else if(locList[i] instanceof Route)/*If it is route or not*/{
               Route tempp = (Route)locList[i];
               bw.write("Route");
               bw.newLine();
               bw.write(tempp.getRegionType());
               bw.newLine();
               bw.write(tempp.getName());
               bw.newLine();
               bw.write(tempp.getLocationID() + "");
               bw.newLine();
               bw.write(tempp.getRouteNum() + "");
               bw.newLine();
               bw.write(tempp.getNumPokemon() + "");
               bw.newLine();
               for (int j = 0; j < tempp.getNumPokemon(); j++) {
                  bw.write(tempp.getPokemonInLocation()[i]);
                  bw.newLine();
               }
            }
         }
         return true;
      }catch(IOException iox){
         System.out.println("File Not Found");
         return false;
      } catch(Exception x){
         System.out.println("Some other error occurred");
         return false;
      }
   }
   
   /**
    * Adds a Pokemon to an existing location when a new Pokemon is created
    * @param loc Location object of where the Pokemon will be
    * @param p_name Name of the Pokemon
    */
   public void addPokemonToLocation (Route loc, String p_name) {
      int index = -1;
      for (int i = 0; i < numLocationsData; i++) {
         if (loc == locList[i]) {
            index = i;
         }
      }
      ((Route)locList[index]).getPokemonInLocation()[((Route)locList[index]).getNumPokemon()] = p_name;
      ((Route)locList[index]).setNumPokemon(((Route)locList[index]).getNumPokemon() + 1);
   }
 }
