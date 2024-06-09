import java.io.*;
import java.util.ArrayList;

public class LocationDex {
    ArrayList<Location> locDex;

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
                    locDex.add(new City(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()),Boolean.parseBoolean(br.readLine()),Boolean.parseBoolean(br.readLine())));

                } else if(type.equals("route")||type.equals("r")){
                    String region = br.readLine();
                    String name = br.readLine();
                    int id = Integer.parseInt(br.readLine());
                    int routeNum = Integer.parseInt(br.readLine());
                    br.readLine();
                    int[] list= {Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())};
                    locDex.add(new Route(region, name, id, routeNum, list));
                } else {
                    return false;
                }
            }
            return true;
        } catch(IOException iox){
            System.out.println("File Not Found");
            return false;
        } catch(ArrayIndexOutOfBoundsException aioobx){
            System.out.println("Wrong Number of Elements");
            return false;
        }
    }

//    search by id & name

    public void addCity(String type, String name, int id, boolean pokeCenter, boolean store){
        locDex.add(new City(type, name, id,pokeCenter, store));
    }

    public void addCity(int id, boolean pokeCenter, boolean store){
        locDex.add(new City(id, pokeCenter,store));
    }

    public void addRoute(String type, String name, int routeNum, int id,int[] pokes){
        locDex.add(new Route(type,name,routeNum,id,pokes));
    }

    public void addRoute(String type, String name, int routeNum, int id){
        locDex.add(new Route(type, name, routeNum, id));
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
            bw.write(locDex.size()); /*Number of Location*/
            for (int i = 0; i < locDex.size(); i++) {
                if(locDex.get(i) instanceof City)/*If it is city or not*/{
                    City temp = (City)(locDex.get(i));
                    bw.write("City\n"+ temp.getRegionType()+"\n"+ temp.getName()+"\n"+ temp.getLoactionID() +"\n"+temp.getHasStore() +"\n"+temp.getHasPokeCentre()+"\n");
                } else if(locDex.get(i) instanceof Route)/*If it is route or not*/{
                    Route tempp = (Route)locDex.get(i);
                    bw.write("Route\n" +"\n"+tempp.getRegionType()+"\n"+ tempp.getName()+"\n"+ tempp.getLoactionID() + "\n"+ tempp.getRouteNum() + "\n"+tempp.getNumPokemon());
                    for (int j = 0; j < tempp.getNumPokemon(); j++) {
                        bw.write(tempp.getPokemonInLocation()[i]+"\n");
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

    public String toString(){
        return locDex.toString();
    }
}

