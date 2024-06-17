package LocationHierarchy;
/**
* Class Name: City
* Author: Kelvin Kim
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates Routes that can be travelled to
*/
public class Route extends Location {
    /**
    * An array of pokemon names in the Location
    */
    String[] pokemonInLocation;
    /**
    * The number of the Pokemons in the Array
    */
    int numPokemon = 0;
    /**
    * The unique Identification number of the Route
    */
    int routeNum;

    /**
     * Constructs a new Route object with specified type, name, id, pokes(list of pokemon).
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param routeNum The route's number.
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon names
     */
    public Route(String type, String name, int id, int routeNum, String[] pokes){
        super(type, name, id);
        pokemonInLocation = pokes;
        this.routeNum = routeNum;
    }

    /**
     * Constructs a new Route object with specified type, name, id.
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param routeNum The route's number.
     * @param id The unique identifier for the location.
     */
    public Route(String type, String name, int routeNum, int id){
        super(type, name, id);
        pokemonInLocation = new String[200];
        this.routeNum = routeNum;
    }

    /**
     * Constructs a new Route object with specified id, route number, and list pof Pokemon names.
     * 
     * @param id The unique identifier for the location.
     * @param routeNum The route's number.
     * @param pokes The list of pokemon ids
     */
    public Route(int id, int routeNum, String[] pokes){
        super(id);
        pokemonInLocation = pokes;
        this.routeNum = routeNum;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     * 
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public String[] getPokemonInLocation() {
        return pokemonInLocation;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     * 
     */
    public int getNumPokemon(){
        return numPokemon;
    }

    /**
     * Accesses routeNum.
     * 
     */
    public int getRouteNum() {
        return routeNum;
    }

    // Mutators (Setters)
    /**
     * Changes pokemonInLocation.
     * 
     */
    public void setPokemonInLocation(String[] pokemonInLocation) {
        this.pokemonInLocation = pokemonInLocation;
    }
    
    /**
     * Changes numPokemon.
     * 
     */
    public void setNumPokemon (int num) {
      numPokemon = num;
    }

    /**
     * Changes routeNum.
     * 
     */
    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }

    /**
     * This method returns information about the Route
     * in the form of a String
     * @return String Information about the Route
     */
    public String toString(){
        String str = super.toString();
        str += ("\nRoute Number: "+ routeNum);
        str += ("\nPokemon IDs: ");
        for(int i = 0; i< pokemonInLocation.length; i++){
            str+= pokemonInLocation[i]+", ";
        }
        return str;
    }
    
}
