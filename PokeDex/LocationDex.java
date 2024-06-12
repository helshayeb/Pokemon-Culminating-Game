import java.io.*;
import java.util.*;

public class LocationDex {
    int numLocationsData;
    int MAX_SIZE = 10;
    Location[] locDex;
    
    public LocationDex () {
        numLocationsData = 0;
    }
    
    /**
     *
     * @param fileName
     * @return boolean: if the file was successfully loaded
     */
    public boolean readLocations(String fileName){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < Integer.parseInt(br.readLine()); i++) {

                String type = br.readLine().toLowerCase();
                if (type.equals("city") || type.equals("c")) {
                    locDex[i] = new City(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()),Boolean.parseBoolean(br.readLine()),Boolean.parseBoolean(br.readLine()));
                    numData++;
                } else if(type.equals("route")||type.equals("r")){
                    String region = br.readLine();
                    String name = br.readLine();
                    int id = Integer.parseInt(br.readLine());
                    int routeNum = Integer.parseInt(br.readLine());
                    br.readLine();
                    int[] list= {Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())};
                    locDex[i] = new Route(region, name, id, routeNum, list);
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

    public Location searchLocationByID(int id){
        int left = 0;
        int right = numData-1;
        return searchLocationByID(locDex, id, left, right);
    }

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
//KELVIN ITSA ME DAVID PLEASE CHANGE THIS TO RETURNING LOCATION OR NULL 
    public Location searchLocationByName(String name){
        for(int i = 0; i < numData; i++){
            if(locDex[i].getName().equalsIgnoreCase(name)){
                return locDex[i];
            }
        }
        return null;
    }


//   missing search by id & name

    /**
     *
     * @param type
     * @param name
     * @param id
     * @param pokeCenter
     * @param store
     */
    public void addCity(String type, String name, int id, boolean pokeCenter, boolean store){
        locDex[numData] = new City(type, name, id,pokeCenter, store);
        numData++;
    }

    public void addCity(int id, boolean pokeCenter, boolean store){
        locDex[numData] = new City(id, pokeCenter,store);
        numData++;
    }

    public void addRoute(String type, String name, int routeNum, int id,int[] pokes){
        locDex[numData] = new Route(type,name,routeNum,id,pokes);
        numData++;
    }

    public void addRoute(String type, String name, int routeNum, int id){
        locDex[numData] = new Route(type, name, routeNum, id);
        numData++;
    }

    /**
     *
     * @param fileName
     * @return if it is successfully saved
     */
    public boolean saveLocations(String fileName){
        try{
            File file = new File(fileName);
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(locDex.length); /*Number of Location*/
            for (int i = 0; i < locDex.length; i++) {
                if(locDex[i] instanceof City)/*If it is city or not*/{
                    City temp = (City)(locDex[i]);
                    bw.write("City\n"+ temp.getRegionType()+"\n"+ temp.getName()+"\n"+ temp.getLoactionID() +"\n"+temp.getHasStore() +"\n"+temp.getHasPokeCentre()+"\n");
                } else if(locDex[i] instanceof Route)/*If it is route or not*/{
                    Route tempp = (Route)locDex[i];
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
        return locDex.toString();
    }
}
