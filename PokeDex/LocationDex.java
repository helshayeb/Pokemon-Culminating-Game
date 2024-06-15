import java.io.*;
import java.util.*;

public class LocationDex {
    int numLocationsData;
    int MAX_SIZE = 10;
    Location[] locList;
    
    public LocationDex () {
        numLocationsData = 0;
    }

    // Accessor method for numLocationsData
   public int getNumLocationsData() {
      return numLocationsData;
   }

   // Accessor method for locList
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
            for (int i = 0; i < Integer.parseInt(br.readLine()); i++) {

                String type = br.readLine().toLowerCase();
                if (type.equals("city") || type.equals("c")) {
                    locList[i] = new City(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()),Boolean.parseBoolean(br.readLine()),Boolean.parseBoolean(br.readLine()));
                    numData++;
                } else if(type.equals("route")||type.equals("r")){
                    String region = br.readLine();
                    String name = br.readLine();
                    int id = Integer.parseInt(br.readLine());
                    int routeNum = Integer.parseInt(br.readLine());
                    br.readLine();
                    int[] list= {Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())};
                    locList[i] = new Route(region, name, id, routeNum, list);
                    numData++;
                } else {
                    return false;
                }
                br.readLine();
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

   //Wrapper method
    public Location searchLocationByID(int id){
        int left = 0;
        int right = numData-1;
        return searchLocationByID(locList, id, left, right);
    }
   // Method to search for a location by its ID using recursive binary search
    public Location searchLocationByID(Location[] locList, int id, int left, int right){
        int mid = left+(right-left)/2;
        if(left>right){
            return null;
        }
        if(locList[mid].getLoactionID() == id){
            return locList[mid];
        }else if(locList[mid].getLoactionID() > id){
        return searchLocationByID(locList, id, left, mid-1);
    }else{
        return searchLocationByID(locList, id, mid+1, right);
    }
}

    public Location searchLocationByName(String name){
        for(int i = 0; i < numData; i++){
            if(locList[i].getName().equalsIgnoreCase(name)){
                return locList[i];
            }
        }
        return null;
    }
   // Method to add a city to locList
    public void addCity(String type, String name, boolean pokeCenter, boolean store){
        locList[numData] = new City(type, name, numData ,pokeCenter, store);
        numData++;
    }
   // Method to add a city to locList
    public void addCity( boolean pokeCenter, boolean store){
        locList[numData] = new City(numData, pokeCenter,store);
        numData++;
    }
   // Method to add a route to locList
    public void addRoute(String type, String name, int routeNum, int id,int[] pokes){
        if(!duplicateRouteNum){
            locList[numData] = new Route(type,name,routeNum, numData,pokes);
            numData++;
        }
    }
   // Method to add a route to locList
    public void addRoute(String type, String name, int routeNum){
        if(!duplicateRouteNum){
            locList[numData] = new Route(type, name, routeNum, numData);
        numData++;
    }
    }

    private boolean duplicateRouteNum(int rNum){
        for(int i = 0; i < numData; i++){
            if(locList[i] instanceof Route){
                if((Route)(locList).getRouteNum() == rNum)
                    return true;
            } 
        }
        return false
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
            for (int i = 0; i < locList.length; i++) {
                if(locList[i] instanceof City)/*If it is city or not*/{
                    City temp = (City)(locList[i]);
                    bw.write("City\n"+ temp.getRegionType()+"\n"+ temp.getName()+"\n"+ temp.getLoactionID() +"\n"+temp.getHasStore() +"\n"+temp.getHasPokeCentre()+"\n");
                } else if(locList[i] instanceof Route)/*If it is route or not*/{
                    Route tempp = (Route)locList[i];
                    bw.write("Route\n" +"\n"+tempp.getRegionType()+"\n"+ tempp.getName()+"\n"+ tempp.getLoactionID() + "\n"+ tempp.getRouteNum() + "\n"+tempp.getNumPokemon());
                    for (int j = 0; j < tempp.getNumPokemon(); j++) {
                        bw.write(tempp.getPokemonInLocation()[i]+"\n");
                    }
                }
                bw.write("\n");
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

    public String toString(){
        return locList.toString();
    }
}
